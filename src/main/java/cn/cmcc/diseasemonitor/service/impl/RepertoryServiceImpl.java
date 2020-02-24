package cn.cmcc.diseasemonitor.service.impl;

import cn.cmcc.diseasemonitor.entity.Commodity;
import cn.cmcc.diseasemonitor.entity.DiseaseType;
import cn.cmcc.diseasemonitor.repository.CommodityRepository;
import cn.cmcc.diseasemonitor.repository.DiseaseTypeRepository;
import cn.cmcc.diseasemonitor.repository.LaboratoryRepository;
import cn.cmcc.diseasemonitor.service.UserService;
import cn.cmcc.diseasemonitor.vo.TestItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.cmcc.diseasemonitor.entity.Repertory;
import cn.cmcc.diseasemonitor.service.RepertoryService;
import cn.cmcc.diseasemonitor.repository.RepertoryRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class RepertoryServiceImpl implements RepertoryService {

	@Autowired
	private RepertoryRepository resp;
	@Autowired
	LaboratoryRepository laboratoryRepository;
	@Autowired
	DiseaseTypeRepository diseaseTypeRepository;
	@Autowired
	CommodityRepository commodityRepository;
	@Autowired
	UserService userService;

	@Override
	public List<TestItem> findAllOnSaleServe(String token) {
		List<TestItem> testItems = findAllRepertoriesByLabId(token);
		List<TestItem> onSales = new ArrayList<>();
		for (TestItem t :
				testItems) {
			if (t.getRepertory().getStatus().equals("1")){
				onSales.add(t);
			}
		}
		return onSales;
	}
	@Override
	public List<TestItem> findAllOffSaleServe(String token) {
		List<TestItem> testItems = findAllRepertoriesByLabId(token);
		List<TestItem> offSales = new ArrayList<>();
		for (TestItem t :
				testItems) {
			if (t.getRepertory().getStatus().equals("0")){
				offSales.add(t);
			}
		}
		return offSales;
	}

	@Override
	public TestItem findOneByRepertoryId(String token, Integer repertoryId) {
		// 暂且保留token, 以防止后面使用
		token = null;
		return findOneByRepertoryId(repertoryId);
	}

	@Override
	public Repertory modifyPriceAndInventory(Integer repertoryId, Double price, Integer inventory) {
		Repertory repertory = resp.findById(repertoryId).get();
		repertory.setPrice(price);
		repertory.setInventory(inventory);
		return resp.save(repertory);
	}

	@Override
	public Repertory changeRepertoryStatus(Integer repertoryId, String s) {
		Repertory repertory = resp.findById(repertoryId).get();
		repertory.setStatus(s);
		return resp.save(repertory);
	}

	private List<TestItem> findAllRepertoriesByLabId(String token){
		// 第一步找到用户
		Integer id = userService.findUserByToken(token).get().getId();
		// 第二步找到lab
		Integer labId = laboratoryRepository.findByUserId(id).get().getId();
		// 找到记录
		List<Repertory> repertories = resp.findAllByLaboratoryId(labId);
		List<TestItem> testItems = new ArrayList<>();
		//修改记录 /**
		/**
		 * 这是一种效率特别低的手段，这jpa我玩不转
		 */
		for (Repertory r :
				repertories) {
			TestItem testItem = getTestItemByRepertory(r);
			testItems.add(testItem);
		}
		return testItems;
	}

	private TestItem findOneByRepertoryId(Integer repertoryId){
		Repertory r = resp.findById(repertoryId).get();
		return getTestItemByRepertory(r);

	}
	private TestItem getTestItemByRepertory(Repertory r){
		Integer diseaseId = r.getDiseaseId();
		Integer commodityId = r.getCommodityId();
		DiseaseType diseaseType = diseaseTypeRepository.findById(diseaseId).get();
		Commodity commodity = commodityRepository.findById(commodityId).get();
		TestItem testItem = new TestItem();
		testItem.setRepertory(r);
		testItem.setCommodity(commodity);
		testItem.setDiseaseType(diseaseType);
		return testItem;
	}
}
