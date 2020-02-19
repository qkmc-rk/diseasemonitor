/*
Navicat MySQL Data Transfer

Source Server         : ali-mysql
Source Server Version : 50728
Source Host           : 134.175.28.113:3306
Source Database       : animal-disease-monitor

Target Server Type    : MYSQL
Target Server Version : 50728
File Encoding         : 65001

Date: 2020-02-19 14:26:38
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `commodity_id` int(11) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `status` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of collection
-- ----------------------------
INSERT INTO `collection` VALUES ('1', '1', '1', '2131', '1');
INSERT INTO `collection` VALUES ('2', '1', '2', '23213', '1');
INSERT INTO `collection` VALUES ('3', '1', '3', '1581658844721', '1');
INSERT INTO `collection` VALUES ('4', '1', '4', '1581663084867', '1');

-- ----------------------------
-- Table structure for commodity
-- ----------------------------
DROP TABLE IF EXISTS `commodity`;
CREATE TABLE `commodity` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `disease_id` int(11) DEFAULT NULL COMMENT '商品名',
  `name` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '疫苗种类',
  `sampling_instruction` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '采样说明',
  `deletection_instruction` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '检测说明',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `user_id` int(11) DEFAULT NULL COMMENT '创建人',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '‘1’上架，‘0’下架',
  `logo` int(11) DEFAULT NULL,
  `tag` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标签',
  `type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '0一般商品，1套餐',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of commodity
-- ----------------------------
INSERT INTO `commodity` VALUES ('1', '1', '非洲猪瘟抗体', '采集猪的血清或抗凝血，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于疫病的诊断、疫情监测以及配合非洲猪瘟根除计划的实施。', '211313', '23213213', '1', '1', '1', '[\"快速检测\",\"物流快递\"]', '0');
INSERT INTO `commodity` VALUES ('2', '1', '非洲猪瘟病毒核酸（PCR）', '采集猪的脾、淋巴结、肾、扁桃体、肝、肺等组织，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中非洲猪瘟病毒的定性检测，可对样品中是否存在非洲猪瘟病毒进行分析。', '2332432', '3424', '1', '1', '1', '[\"快速检测\",\"物流快递\"]', '0');
INSERT INTO `commodity` VALUES ('3', '2', '口蹄疫病毒亚洲I型抗体（液相）', '采集离心得到猪血清，低温（置冰盒）尽快送至实验室进行检测。', '口蹄疫是由口蹄疫病毒引起的偶蹄动物共患的急性、热性、高度接触性传染病。有7个血清型：O型、A型、C型、亚洲Ⅰ型。抗体检测主要应用于疫病初步诊断、血清学分型及流行病学调查。', '123112', '12313', '1', '1', '1', '[\"快速检测\",\"物流快递\"]', '0');
INSERT INTO `commodity` VALUES ('4', '2', '猪口蹄疫病毒A型抗体', '采集离心得到猪血清，低温（置冰盒）尽快送至实验室进行检测。', '口蹄疫是由口蹄疫病毒引起的偶蹄动物共患的急性、热性、高度接触性传染病。有7个血清型：O型、A型、C型、亚洲Ⅰ型。抗体检测主要应用于疫病初步诊断、血清学分型及流行病学调查。', '2121421', '12213123', '1', '1', '1', '[]', '0');
INSERT INTO `commodity` VALUES ('5', '3', '猪伪狂犬病毒（gE）抗体', '采集离心得到猪血清，低温（置冰盒）尽快送至实验室进行检测。', '主要用于猪群野毒感染的初步诊断和流行病学调查。', '12213', '1232', '1', '1', '1', '[\"快速检测\",\"物流快递\"]', '0');
INSERT INTO `commodity` VALUES ('6', '3', '猪伪狂犬病毒（gB）抗体', '采集离心得到猪血清，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于非免疫动物抗体的检测以及面以后抗体水平的检测。', '1213', '21323', '1', '1', '1', '[]', '0');
INSERT INTO `commodity` VALUES ('7', '4', '猪繁殖与呼吸综合征病毒抗体-感染预警', '采集离心得到猪血清，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于猪繁殖与呼吸综合征的感染预警分析。', '1231321', '123213', '1', '1', '1', '[\"快速检测\",\"物流快递\"]', '0');
INSERT INTO `commodity` VALUES ('8', '4', '猪繁殖与呼吸综合征病毒抗体', '采集离心得到猪血清，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于猪繁殖与呼吸综合征疫病初步诊断、血清学分型及流行病学调查。', '1213123', '12213', '1', '1', '1', '[\"快速检测\"]', '0');
INSERT INTO `commodity` VALUES ('9', '5', '猪瘟病毒抗体', '采集猪血清，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于猪瘟的免疫效果评估、疫病辅助诊断和疫病风险预警分析等。', null, null, '1', '1', '12', '[\"快速检测\"]', '0');
INSERT INTO `commodity` VALUES ('10', '5', '猪瘟病毒核酸（PCR）-通检', '采集猪的扁桃体、脾、肾和回肠末端等组织，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪瘟病毒的定性检测，可对样品中是否存在猪瘟病毒进行分析。', null, null, '1', '1', '10', '[\"快速检测\",\"物流快递\"]', '0');
INSERT INTO `commodity` VALUES ('11', '6', '猪圆环病毒2型抗体', '采集猪血清，低温（置冰盒）尽快送至实验室进行检测。', '监测猪群中猪圆环病毒2型的感染状态、疫苗免疫效果及仔猪体内母源抗体等。', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\"]', '0');
INSERT INTO `commodity` VALUES ('12', '6', '猪圆环病毒2型核酸（PCR）', '采集血清、肺、淋巴结、脾、肾等组织样品，每份样品最好单独放在1个容器内，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪圆环病毒2型的定性检测，可对样品中是否存在该病毒进行分析。', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\",\"其他\"]', '0');
INSERT INTO `commodity` VALUES ('13', '7', '猪流感病毒抗体（HI)', '采集猪的鼻粘膜拭子，仔猪也可采集咽粘膜拭子。对于发病猪，应在发热期采取样品，同时也可采集死亡猪和急性发病期剖杀猪的肺组织，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于A型流感病毒亚型的鉴定和抗原变异的分析，不适用于猪流感的早期诊断。', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\"]', '0');
INSERT INTO `commodity` VALUES ('14', '7', '猪流感病毒核酸（RT-PCR）', '采集猪的鼻粘膜拭子，仔猪也可采集咽粘膜拭子。对于发病猪，应在发热期采取样品，同时也可采集死亡猪和急性发病期剖杀猪的肺组织，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪流感病毒的定性检测，可对样品中是否存在该病毒进行分析。', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\"]', '0');
INSERT INTO `commodity` VALUES ('15', '8', '猪轮状病毒核酸（RealTime-PCR）', '采集腹泻急性期的小肠（5~10cm）或新鲜粪便（5~10g），低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪轮状病毒的准确定性检测，可对样品中是否存在该病毒进行分析。', null, null, '1', '1', '11', '[\"快速检测\",\"物流快递\"]', '0');
INSERT INTO `commodity` VALUES ('16', '9', '猪传染性胃肠炎病毒抗体', '采集猪血清，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于猪群感染状态的监测以及疫苗免疫效果的评估。', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\"]', '0');
INSERT INTO `commodity` VALUES ('17', '10', '猪细小病毒抗体（HI）', '采集流产胎儿，木乃伊胎肝、肾、肺、淋巴结组织，母猪取子宫、胎盘、阴道分泌物等，低温（置冰盒）尽快送至实验室进行检测。最好选择70日龄以下胎儿、木乃伊胎用于检测。', '主要应用于检查组织提取物中的病毒抗原，适合快速大量的诊断。', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\"]', '0');
INSERT INTO `commodity` VALUES ('18', '11', '猪丹毒丝菌核酸（PCR）', '采集猪的血清或抗凝血，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪丹毒丝菌的定性检测，可对样品中是否存在该细菌进行分析。', null, null, '1', '1', '1', '[]', '0');
INSERT INTO `commodity` VALUES ('19', '12', '猪链球菌敏感药物筛选', '采集猪的鼻咽拭子、扁桃体拭子置于灭菌的PBS保护液或适当的培养基中；采集血清、关节液、脑脊液和心、肝、脾、肺、淋巴结、脑等剖检可见病变的组织样品，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于致病菌猪链球菌对应敏感药物的筛选。', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\"]', '0');
INSERT INTO `commodity` VALUES ('20', '13', '猪水泡病病毒核酸（Realtime-PCR)', '采集的样品主要是口腔、蹄冠上的水泡上皮组织、水泡液、血液、口腔分泌液和组织。采集后立即冷藏送检或置于含抗生素的PBS缓冲液中4℃环境下保藏。编号并做好记录。1）水泡液及水泡皮：只有当水泡完整时才能采集到水泡液，用75%酒精轻轻消毒水泡表皮，尽量去掉污物，用灭菌生理盐水擦去酒精，然后用无菌注射器穿刺水泡吸取水泡液，置于含抗生素的PBS缓冲液灭菌瓶中。水泡液采取后，将水泡皮以无菌术剪下，放入含抗生素的PBS缓冲液中；2）口腔分泌物和咽喉拭子：用拭子采取口腔分泌物或将拭子深入口腔内来回刮3~5次，拭子一并放入盛有1.0mL含抗生素的PBS缓冲液中。也可用食道探杯刮取咽喉液体，放入加有抗生素的PBS中。3）血液：用真空采血管或无菌注射器直接采取至无菌EP管中，密封编号。4）肌肉或组织脏器：无菌采集待检样品，装入一次性塑料袋或其他灭菌容器。', '主要应用于样品中猪水泡病病毒的定性检测，可对样品中是否存在猪水泡病病毒进行分析。', null, null, '1', '1', '1', '[]', '0');
INSERT INTO `commodity` VALUES ('21', '14', '日本乙型脑炎病毒核酸（RT-PCR）', '濒死动物、扑杀动物或流产胎儿取脑组织，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中乙型脑炎病毒的定性检测，可对样品中是否存在该病毒进行分析。', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\"]', '0');
INSERT INTO `commodity` VALUES ('22', '15', '猪组织切片检测与分析', '采集相关病原侵害组织，低温（置冰盒）尽快送至实验室进行检测。', '用于组织病理变化观察及疾病诊断。石蜡固定。', null, null, '1', '1', '1', '[\"快速检测\"]', '0');
INSERT INTO `commodity` VALUES ('23', null, '日本乙型脑炎病毒核酸（RT-PCR）+猪组织切片检测与分析', '1、采集相关病原侵害组织，低温（置冰盒）尽快送至实验室进行检测。', '1、用于组织病理变化观察及疾病诊断。石蜡固定。', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\",\"套餐\"]', '1');
INSERT INTO `commodity` VALUES ('24', null, '猪细小病毒抗体（HI）+猪丹毒丝菌核酸（PCR）', '1、采集猪的鼻咽拭子、扁桃体拭子置于灭菌的PBS保护液或适当的培养基中；采集血清、关节液、脑脊液和心、肝、脾、肺、淋巴结、脑等剖检可见病变的组织样品，低温（置冰盒）尽快送至实验室进行检测。', '1、主要应用于样品中猪丹毒丝菌的定性检测，可对样品中是否存在该细菌进行分析。', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\",\"套餐\"]', '1');
INSERT INTO `commodity` VALUES ('25', '1', '非洲猪瘟病毒核酸（Realtime-PCR）', '采集猪的脾、淋巴结、肾、扁桃体、肝、肺等组织，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中非洲猪瘟病毒的最为准确的定性检测，可对样品中是否存在非洲猪瘟病毒进行分析。', null, null, '1', '1', '1', null, null);
INSERT INTO `commodity` VALUES ('26', '2', '口蹄疫病毒O型抗体', '采集离心得到猪血清，低温（置冰盒）尽快送至实验室进行检测。', '口蹄疫是由口蹄疫病毒引起的偶蹄动物共患的急性、热性、高度接触性传染病。有7个血清型：O型、A型、C型、亚洲Ⅰ型。抗体检测主要应用于疫病初步诊断、血清学分型及流行病学调查。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('27', '2', '口蹄疫病毒I型抗体', '采集离心得到猪血清，低温（置冰盒）尽快送至实验室进行检测。', '口蹄疫是由口蹄疫病毒引起的偶蹄动物共患的急性、热性、高度接触性传染病。有7个血清型：O型、A型、C型、亚洲Ⅰ型。抗体检测主要应用于疫病初步诊断、血清学分型及流行病学调查。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('28', '2', '口蹄疫病毒抗体-野毒感染', '采集离心得到猪血清，低温（置冰盒）尽快送至实验室进行检测。', '野毒感染，一般可解释为自然环境中存在的致病病毒,病毒抗体检测主要应用于疫病初步诊断、血清学分型及流行病学调查。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('29', '2', '口蹄疫病毒核酸（RT-PCR）', '水泡液采集：典型临床发病动物水泡液用灭菌注射器洗出后装入样品保存管，加适量抗生素冷藏保存；水泡皮采集：用0.04mol/L PBS清洗水泡表面，然后用灭菌手术剪刀剪取水泡皮，2~5g为宜。采集到的水泡皮装入样品保存管，加50%甘油-PBS保存液，冷冻保存；组织样品采集：采集病灶周围破溃组织2~5g，装入样品保存管，加50%甘油-PBS冷冻保存；临床表现健康但需做检测的动物，可在屠宰时采集淋巴结、脊髓、扁桃体、心脏肌肉。样品低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪口蹄疫病毒的精准定性检测，可对样品中是否存在该病毒进行检测分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('30', '2', '口蹄疫病毒核酸（Realtime-PCR）', '水泡液采集：典型临床发病动物水泡液用灭菌注射器洗出后装入样品保存管，加适量抗生素冷藏保存；水泡皮采集：用0.04mol/L PBS清洗水泡表面，然后用灭菌手术剪刀剪取水泡皮，2~5g为宜。采集到的水泡皮装入样品保存管，加50%甘油-PBS保存液，冷冻保存；组织样品采集：采集病灶周围破溃组织2~5g，装入样品保存管，加50%甘油-PBS冷冻保存；临床表现健康但需做检测的动物，可在屠宰时采集淋巴结、脊髓、扁桃体、心脏肌肉。样品低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪口蹄疫病毒的精准定性检测，可对样品中是否存在该病毒进行检测分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('31', '3', '猪伪狂犬病毒抗原（免疫组化）', '采集脑组织（应含有三叉神经节）、肺脏、扁桃体等组织，低温（置冰盒）尽快送至实验室进行检测。', '适用于伪狂犬病病理变化的观察及疫病初步诊断。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('32', '3', '猪伪狂犬病毒核酸（PCR）-通检', '采集脑组织（应含有三叉神经节）、肺脏、扁桃体等组织，低温（置冰盒）尽快送至实验室进行检测', '主要应用于样品中猪伪狂犬病毒的定性检测，可对样品中是否存在该病毒进行检测分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('33', '3', '猪伪狂犬病毒核酸（Realtime-PCR）-通检', '采集脑组织（应含有三叉神经节）、肺脏、扁桃体等组织，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪伪狂犬病毒的准确定性检测，可对样品中是否存在该病毒进行检测分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('34', '4', '猪繁殖与呼吸综合征病毒抗原（免疫组化）', '采集血清、肺、淋巴结、扁桃体、脑等剖检可见病变的组织样品，每块组织单独放在1个容器内，低温（置冰盒）尽快送至实验室进行检测。', '适用于猪繁殖与呼吸综合征病理变化的观察及疫病诊断。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('35', '4', '猪繁殖与呼吸综合征病毒核酸（RT-PCR）-通检', '采集血清、肺、淋巴结、扁桃体、脑等剖检可见病变的组织样品，每块组织单独放在1个容器内，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪繁殖与呼吸综合征病毒的定性检测，可对样品中是否存在该病毒进行检测分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('36', '4', '猪繁殖与呼吸综合征病毒核酸（Realtime-PCR）-通检', '采集血清、肺、淋巴结、扁桃体、脑等剖检可见病变的组织样品，每块组织单独放在1个容器内，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪繁殖与呼吸综合征病毒的准确定性定量检测，可对样品中是否存在该病毒进行检测分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('37', '4', '猪繁殖与呼吸综合征病毒NSP2基因测序与分析', '采集血清、肺、淋巴结、扁桃体、脑等剖检可见病变的组织样品，每块组织单独放在1个容器内，低温（置冰盒）尽快送至实验室进行检测。', '适用于感染病毒遗传进化的分析，对蓝耳病病毒高变基因区域NSP2基因进行测序，鉴定病毒分型。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('38', '4', '猪繁殖与呼吸综合征病毒GP5基因测序与分析', '采集血清、肺、淋巴结、扁桃体、脑等剖检可见病变的组织样品，每块组织单独放在1个容器内，低温（置冰盒）尽快送至实验室进行检测。', '适用于感染病毒遗传进化的分析对蓝耳病病毒高变基因区域GP5基因进行测序，鉴定病毒分型。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('39', '5', '猪瘟病毒核酸（Realtime-PCR）-通检', '采集猪的扁桃体、脾、肾和回肠末端等组织，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪瘟病毒的准确定性检测，可对样品中是否存在猪瘟病毒进行分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('40', '5', '猪瘟病毒核酸（RT-PCR）-野毒株', '采集猪的扁桃体、脾、肾和回肠末端等组织，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪瘟病毒野毒株的定性检测，可对样品中是否存在该病毒进行检测分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('41', '5', '猪瘟病毒E2基因测序与分析', '采集猪的扁桃体、脾、肾和回肠末端等组织，低温（置冰盒）尽快送至实验室进行检测。', '适用于感染病毒遗传进化的分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('42', '6', '猪圆环病毒2型核酸（Realtime-PCR）', '采集血清、肺、淋巴结、脾、肾等组织样品，每份样品最好单独放在1个容器内，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪圆环病毒2型的准确定性荧光定量pcr检测，可对样品中是否存在该病毒进行分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('43', '6', '猪圆环病毒2型核酸（基因测序）', '采集血清、肺、淋巴结、脾、肾等组织样品，每份样品最好单独放在1个容器内，低温（置冰盒）尽快送至实验室进行检测。', '适用于感染病毒遗传进化的分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('44', '6', '猪圆环病毒3型抗体', '监测猪群中猪圆环病毒2型的感染状态、疫苗免疫效果及仔猪体内母源抗体。', '采集猪血清，低温（置冰盒）尽快送至实验室进行检测。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('45', '6', '猪圆环病毒3型核酸（PCR）', '采集血清、肺、淋巴结、脾、肾等组织样品，每份样品最好单独放在1个容器内，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪圆环病毒2型的定性检测，可对样品中是否存在该病毒进行分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('46', '6', '猪圆环病毒3型核酸（Realtime-PCR）', '采集血清、肺、淋巴结、脾、肾等组织样品，每份样品最好单独放在1个容器内，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪圆环病毒2型的准确定性检测，可对样品中是否存在该病毒进行分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('47', '6', '猪圆环病毒3型核酸（基因测序）', '采集血清、肺、淋巴结、脾、肾等组织样品，每份样品最好单独放在1个容器内，低温（置冰盒）尽快送至实验室进行检测。', '适用于感染病毒遗传进化的分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('48', '7', '猪流感病毒核酸（Realtime-PCR）', '采集猪的鼻粘膜拭子，仔猪也可采集咽粘膜拭子。对于发病猪，应在发热期采取样品，同时也可采集死亡猪和急性发病期剖杀猪的肺组织，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪流感病毒的准确定性检测，可对样品中是否存在该病毒进行分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('49', '7', '猪流感病毒分离与鉴定', '采集猪的鼻粘膜拭子，仔猪也可采集咽粘膜拭子。对于发病猪，应在发热期采取样品，同时也可采集死亡猪和急性发病期剖杀猪的肺组织，低温（置冰盒）尽快送至实验室进行检测。', '适用于猪流感病毒分型鉴定的分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('50', '8', '猪轮状病毒核酸（RT-PCR）', '采集腹泻急性期的小肠（5~10cm）或新鲜粪便（5~10g），低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪轮状病毒的定性检测，可对样品中是否存在该病毒进行分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('51', '8', '猪轮状病毒抗原（胶体金）', '采集新鲜粪便，进行现场检测，或低温（置冰盒）尽快送至实验室进行检测。', '胶体金技术具有方便快捷、特异敏感、稳定性强、不需要特殊设备和试剂、结果判断直观等优点, 因而特别适合于广大基层检验人员以及大批量检测和大面积普查等。可应用于轮状病毒疫病的快速诊断。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('53', '9', '猪传染性胃肠炎病毒核酸（RT-PCR）', '采集病猪肛拭子、粪、肠内容物或空肠、回肠段、肠系膜淋巴结为病料，活体猪也可采集扁桃体为病理，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪传染性胃肠炎病毒的定性检测，可对样品中是否存在该病毒进行分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('54', '9', '猪传染性胃肠炎病毒核酸（Realtime-PCR）', '采集病猪肛拭子、粪、肠内容物或空肠、回肠段、肠系膜淋巴结为病料，活体猪也可采集扁桃体为病理，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪传染性胃肠炎病毒的准确定性荧光定量PCR检测，可对样品中是否存在该病毒进行分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('55', '9', '猪传染性胃肠炎病毒抗原（胶体金）', '采集病猪肛拭子、粪、肠内容物或空肠、回肠段、肠系膜淋巴结为病料，活体猪也可采集扁桃体为病理，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于传染性胃炎疫病的快速诊断。胶体金技术具有方便快捷、特异敏感、稳定性强、不需要特殊设备和试剂、结果判断直观等优点。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('56', '10', '猪细小病毒核酸（PCR）', '采集流产胎儿，木乃伊胎肝、肾、肺、淋巴结组织，母猪取子宫、胎盘、阴道分泌物等，低温（置冰盒）尽快送至实验室进行检测。最好选择70日龄以下胎儿、木乃伊胎用于检测。', '主要应用于样品中猪细小病毒的定性检测，可对样品中是否存在该病毒进行分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('57', '10', '猪细小病毒核酸（Realtime-PCR）', '采集流产胎儿，木乃伊胎肝、肾、肺、淋巴结组织，母猪取子宫、胎盘、阴道分泌物等，低温（置冰盒）尽快送至实验室进行检测。最好选择70日龄以下胎儿、木乃伊胎用于检测。', '主要应用于样品中猪细小病毒的准确定性检测，可对样品中是否存在该病毒进行分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('58', '11', '猪丹毒丝菌分离与鉴定', '采集猪的血清或抗凝血，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中丹毒丝菌的分离培养，检测猪只是否携带对应病菌。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('59', '12', '猪链球菌核酸（PCR）', '采集猪的鼻咽拭子、扁桃体拭子置于灭菌的PBS保护液或适当的培养基中；采集血清、关节液、脑脊液和心、肝、脾、肺、淋巴结、脑等剖检可见病变的组织样品，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪链球菌的定性检测，可对样品中是否存在该细菌进行分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('60', '12', '猪链球菌Ⅱ型核酸（Realtime-PCR）', '采集猪的鼻咽拭子、扁桃体拭子置于灭菌的PBS保护液或适当的培养基中；采集血清、关节液、脑脊液和心、肝、脾、肺、淋巴结、脑等剖检可见病变的组织样品，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪链球菌二型的定性检测，可对样品中是否存在该细菌进行分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('61', '12', '猪链球菌分离与鉴定', '采集猪的鼻咽拭子、扁桃体拭子置于灭菌的PBS保护液或适当的培养基中；采集血清、关节液、脑脊液和心、肝、脾、肺、淋巴结、脑等剖检可见病变的组织样品，低温（置冰盒）尽快送至实验室进行检测。', '主要应用于样品中猪链球菌的分离培养，看猪只是否携带对应病菌。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('62', '13', '猪塞尼卡谷病毒（RT-PCR）', '采集的样品主要是口腔、蹄冠上的水泡上皮组织、水泡液、血液、口腔分泌液和组织。采集后立即冷藏送检或置于含抗生素的PBS缓冲液中4℃环境下保藏。编号并做好记录。1）水泡液及水泡皮：只有当水泡完整时才能采集到水泡液，用75%酒精轻轻消毒水泡表皮，尽量去掉污物，用灭菌生理盐水擦去酒精，然后用无菌注射器穿刺水泡吸取水泡液，置于含抗生素的PBS缓冲液灭菌瓶中。水泡液采取后，将水泡皮以无菌术剪下，放入含抗生素的PBS缓冲液中；2）口腔分泌物和咽喉拭子：用拭子采取口腔分泌物或将拭子深入口腔内来回刮3~5次，拭子一并放入盛有1.0mL含抗生素的PBS缓冲液中。也可用食道探杯刮取咽喉液体，放入加有抗生素的PBS中。3）血液：用真空采血管或无菌注射器直接采取至无菌EP管中，密封编号。4）肌肉或组织脏器：无菌采集待检样品，装入一次性塑料袋或其他灭菌容器。', '主要应用于样品中猪水泡病塞尼卡谷病毒RNA序列反转录后的定性检测，可对样品中是否存在猪水泡病病毒进行分析。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('63', '13', '猪水泡病病毒抗体', '采集的样品主要是口腔、蹄冠上的水泡上皮组织、水泡液、血液、口腔分泌液和组织。采集后立即冷藏送检或置于含抗生素的PBS缓冲液中4℃环境下保藏。编号并做好记录。1）水泡液及水泡皮：只有当水泡完整时才能采集到水泡液，用75%酒精轻轻消毒水泡表皮，尽量去掉污物，用灭菌生理盐水擦去酒精，然后用无菌注射器穿刺水泡吸取水泡液，置于含抗生素的PBS缓冲液灭菌瓶中。水泡液采取后，将水泡皮以无菌术剪下，放入含抗生素的PBS缓冲液中；2）口腔分泌物和咽喉拭子：用拭子采取口腔分泌物或将拭子深入口腔内来回刮3~5次，拭子一并放入盛有1.0mL含抗生素的PBS缓冲液中。也可用食道探杯刮取咽喉液体，放入加有抗生素的PBS中。3）血液：用真空采血管或无菌注射器直接采取至无菌EP管中，密封编号。4）肌肉或组织脏器：无菌采集待检样品，装入一次性塑料袋或其他灭菌容器。', '主要应用于检查组织提取物中的病毒抗原，适合快速大量的诊断。', null, null, null, null, null, null, null);
INSERT INTO `commodity` VALUES ('64', '14', '猪组织切片检测与分析-HE', '采集相关病原侵害组织，低温（置冰盒）尽快送至实验室进行检测。', '用于组织病理变化观察及疾病诊断。HE固定。', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for disease_type
-- ----------------------------
DROP TABLE IF EXISTS `disease_type`;
CREATE TABLE `disease_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of disease_type
-- ----------------------------
INSERT INTO `disease_type` VALUES ('1', '非洲猪瘟', '1');
INSERT INTO `disease_type` VALUES ('2', '猪口蹄疫', '1');
INSERT INTO `disease_type` VALUES ('3', '猪伪狂犬病', '1');
INSERT INTO `disease_type` VALUES ('4', '猪繁殖与呼吸综合征（蓝耳病）', '1');
INSERT INTO `disease_type` VALUES ('5', '猪瘟', '1');
INSERT INTO `disease_type` VALUES ('6', '猪圆环病毒病', '1');
INSERT INTO `disease_type` VALUES ('7', '猪流感', '1');
INSERT INTO `disease_type` VALUES ('8', '猪轮状病毒', '1');
INSERT INTO `disease_type` VALUES ('9', '猪传染性胃肠炎', '1');
INSERT INTO `disease_type` VALUES ('10', '猪细小病毒', '1');
INSERT INTO `disease_type` VALUES ('11', '猪丹毒', '1');
INSERT INTO `disease_type` VALUES ('12', '猪链球菌病', '1');
INSERT INTO `disease_type` VALUES ('13', '猪水泡病', '1');
INSERT INTO `disease_type` VALUES ('14', '猪乙脑病', '1');
INSERT INTO `disease_type` VALUES ('15', '病理学检测项目', '1');

-- ----------------------------
-- Table structure for laboratory
-- ----------------------------
DROP TABLE IF EXISTS `laboratory`;
CREATE TABLE `laboratory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `laboratory` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '实验室',
  `company` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '归属公司',
  `location` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区域',
  `address` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详细地址',
  `contact_num` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '联系电话',
  `intro` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '简介',
  `logo` int(11) DEFAULT NULL COMMENT '实验室logo',
  `business_license` int(11) DEFAULT NULL COMMENT '营业执照',
  `receiver` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货人',
  `receiver_address` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收件人地址',
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收件人手机号',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `user_id` int(11) DEFAULT NULL COMMENT '创建人',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '1正常，0删除',
  `province` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '省',
  `city` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '市',
  `district` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区',
  `longitude_and_latitude` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '经纬度',
  `tag` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of laboratory
-- ----------------------------
INSERT INTO `laboratory` VALUES ('1', 'x1检测实验室', 'x1公司', '成都市-武侯区', '腾讯大厦b座', '028-823632326', '实验室主要从事。。', '1', '2', '张三', '腾讯大厦b座', '18227177667', '34343', '342432', '1', '1', '四川省', '成都市', '武侯区', '104.06,30.67', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `laboratory` VALUES ('2', 'x2检测实验室2', 'x2公司', '成都市-青羊区', '腾讯大厦b座', '028-823632327', '实验室主要从事。。', '1', '4', '李四', '腾讯大厦b座', '18227177667', '34343', '342432', '2', '1', '四川省', '成都市', '青羊区', '105.06,33.67', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `laboratory` VALUES ('3', 'x3检测实验室3', 'x3公司', '成都市-高新区', '腾讯大厦b座', '028-823632327', '实验室主要从事。。', '1', '4', '李四', '腾讯大厦b座', '18227177667', '34343', '342432', '2', '1', '四川省', '成都市', '高新区', '113.06,37.67', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `laboratory` VALUES ('4', 'x4检测实验室4', 'x4公司', '成都市-天府新区', '腾讯大厦b座', '028-823632327', '实验室主要从事。。', '1', '4', '李四', '腾讯大厦b座', '18227177667', '34343', '342432', '2', '1', '四川省', '成都市', '天府新区', '128.06,36.67', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `laboratory` VALUES ('5', 'x5检测实验室5', 'x5公司', '成都市-金牛区', '腾讯大厦b座', '028-823632327', '实验室主要从事。。', '1', '4', '李四', '腾讯大厦b座', '18227177667', '34343', '342432', '2', '1', '四川省', '成都市', '金牛区', '113.06,28.67', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `laboratory` VALUES ('6', 'x6检测实验室6', 'x6公司', '成都市-青白江区', '腾讯大厦b座', '028-823632327', '实验室主要从事。。', '1', '4', '李四', '腾讯大厦b座', '18227177667', '34343', '342432', '2', '1', '四川省', '成都市', '青白江区', '124.06,39.67', '[\"快速检测\",\"物流快递\"]');

-- ----------------------------
-- Table structure for mobile_address
-- ----------------------------
DROP TABLE IF EXISTS `mobile_address`;
CREATE TABLE `mobile_address` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收件人姓名',
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '手机号',
  `location` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所在地区',
  `user_id` int(11) DEFAULT NULL COMMENT '创建人',
  `address` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详细地址',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '''1''正常，''0''删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of mobile_address
-- ----------------------------
INSERT INTO `mobile_address` VALUES ('1', '张四', '18227177661', '成都市', '1', 'xx街', '0');
INSERT INTO `mobile_address` VALUES ('2', '李四', '13227177661', '成都市', '1', 'xxx街', '1');
INSERT INTO `mobile_address` VALUES ('3', '王五', '18227177611', '成都市', '1', 'xx街', '1');

-- ----------------------------
-- Table structure for mobile_user
-- ----------------------------
DROP TABLE IF EXISTS `mobile_user`;
CREATE TABLE `mobile_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `openid` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信的用户唯一标识',
  `wechat` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信名',
  `nickname` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '微信昵称',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `phone` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电话',
  `company` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公司',
  `location` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所在区域',
  `address` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '详细地址',
  `taxpayer_identity_num` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '纳税人识别号',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '更新时间',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '‘0’删除，‘1’正常',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of mobile_user
-- ----------------------------
INSERT INTO `mobile_user` VALUES ('1', '12345', null, null, '张三', '18227177661', '必谦', '武侯区', '腾讯大厦', 'qqq', null, null, null);
INSERT INTO `mobile_user` VALUES ('3', 'oB9o449MaJLP-6HmsfwgvQDOz3jA', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `mobile_user` VALUES ('4', 'oB9o448q46bzeUgoZpIHmZuYlx8g', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `mobile_user` VALUES ('5', 'oB9o44xlyREzqZN5aNJtYhgh3mVk', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `mobile_user` VALUES ('6', 'o9OKL5bdRw4bhARbLLDpgXcBE_Pk', null, null, '谭强', '', '', '', '', '', null, null, null);
INSERT INTO `mobile_user` VALUES ('7', 'o9OKL5Sm01vUbSrGuOLCnBitZ6d8', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `mobile_user` VALUES ('8', 'o9OKL5TRu6IPhFK4jMaXT93bb6-8', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `mobile_user` VALUES ('9', 'o9OKL5Ra3GfZeFnRfdNMOAybcxrE', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `mobile_user` VALUES ('10', 'o9OKL5UXEkHp5dosl9ZiST7KUqKA', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `mobile_user` VALUES ('11', 'o9OKL5dwrlVJ_Jc_KBtYaTyKvLxc', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `mobile_user` VALUES ('12', 'o9OKL5Q7P_l4MMl_TLHxdX2EN3So', null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `logistics_num` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '运单号',
  `logistics` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '快递',
  `sample_ids` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '采样图片id',
  `buyer_id` int(11) NOT NULL COMMENT '购买人id',
  `payed` float(20,2) NOT NULL DEFAULT '0.00' COMMENT '已付款',
  `payable` float(20,2) NOT NULL DEFAULT '0.00' COMMENT '应付款',
  `pay_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '付款方式',
  `update_time` bigint(20) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `status` varchar(1) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '1' COMMENT '订单状态，1待付款，2待寄送，3运输中，4检测中，5已完成，0已取消',
  `laboratory_id` int(11) DEFAULT NULL COMMENT '实验室id',
  `instruction` varchar(250) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `pay_time` bigint(20) DEFAULT NULL COMMENT '付款时间',
  `report` varchar(30) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '报告',
  `order_sn` varchar(128) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '订单编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('1', '12345', '韵达', '[1,10]', '1', '0.00', '160.00', null, '1581999527', '1581999527', '0', '1', '采集血液', null, null, '20200218479012');
INSERT INTO `order` VALUES ('2', null, null, '[1,10]', '1', '0.00', '1100.00', null, '1581999528', '1581999528', '1', '3', '采集血液', null, null, '20200218487530');
INSERT INTO `order` VALUES ('3', null, null, '[51,52,53]', '6', '0.00', '90.00', null, '1582082981', '1582082981', '1', '1', '', null, null, '20200219086848');
INSERT INTO `order` VALUES ('4', null, null, '[51,52,53]', '6', '0.00', '240.00', null, '1582082981', '1582082981', '2', '3', '', null, null, '20200219504913');
INSERT INTO `order` VALUES ('5', null, null, '[]', '6', '0.00', '70.00', null, '1582086055', '1582086055', '3', '1', '', null, null, '20200219834871');
INSERT INTO `order` VALUES ('6', null, null, '[]', '6', '0.00', '63.00', null, '1582086055', '1582086055', '1', '2', '', null, null, '20200219551426');
INSERT INTO `order` VALUES ('7', null, null, '[]', '6', '0.00', '65.00', null, '1582086055', '1582086055', '1', '3', '', null, null, '20200219710745');
INSERT INTO `order` VALUES ('8', null, null, '[]', '6', '0.00', '77.00', null, '1582088008', '1582088008', '1', '4', '', null, null, '20200219666642');
INSERT INTO `order` VALUES ('9', null, null, '[]', '7', '0.00', '90.00', null, '1582090793', '1582090793', '1', '1', '', null, null, '20200219787648');
INSERT INTO `order` VALUES ('10', null, null, '[]', '7', '0.00', '50.00', null, '1582090793', '1582090793', '1', '2', '', null, null, '20200219686033');
INSERT INTO `order` VALUES ('11', null, null, '[]', '7', '0.00', '0.00', null, '1582090793', '1582090793', '1', '3', '', null, null, '20200219799099');

-- ----------------------------
-- Table structure for order_record
-- ----------------------------
DROP TABLE IF EXISTS `order_record`;
CREATE TABLE `order_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `time` bigint(20) NOT NULL COMMENT '操作时间',
  `type` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '操作类型，0创建，1付款，2寄出样品，4确认收样，5订单完成',
  `order_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of order_record
-- ----------------------------
INSERT INTO `order_record` VALUES ('1', '1581928374', '1', '3');
INSERT INTO `order_record` VALUES ('2', '1581928374', '1', '4');
INSERT INTO `order_record` VALUES ('3', '1581999527', '1', '1');
INSERT INTO `order_record` VALUES ('4', '1581999527', '1', '2');
INSERT INTO `order_record` VALUES ('5', '1582082981', '1', '3');
INSERT INTO `order_record` VALUES ('6', '1582082981', '1', '4');
INSERT INTO `order_record` VALUES ('7', '1582086055', '1', '5');
INSERT INTO `order_record` VALUES ('8', '1582086055', '1', '6');
INSERT INTO `order_record` VALUES ('9', '1582086055', '1', '7');
INSERT INTO `order_record` VALUES ('10', '1582088008', '1', '8');
INSERT INTO `order_record` VALUES ('11', '1582090793', '1', '9');
INSERT INTO `order_record` VALUES ('12', '1582090793', '1', '10');
INSERT INTO `order_record` VALUES ('13', '1582090793', '1', '11');

-- ----------------------------
-- Table structure for order_son
-- ----------------------------
DROP TABLE IF EXISTS `order_son`;
CREATE TABLE `order_son` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_id` int(11) DEFAULT NULL,
  `count` int(11) DEFAULT NULL,
  `buy_id` int(11) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `status` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `payable` float(20,1) DEFAULT NULL,
  `order_id` int(11) DEFAULT NULL,
  `repertory_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of order_son
-- ----------------------------
INSERT INTO `order_son` VALUES ('1', '15', '2', '6', '233', '213231', '1', '100.0', '1', '15');
INSERT INTO `order_son` VALUES ('2', '3', '1', '6', '221', '213', '1', '100.0', '2', '2');
INSERT INTO `order_son` VALUES ('3', '15', '1', '6', '21312', '21313', '1', '100.0', '3', '2');
INSERT INTO `order_son` VALUES ('4', '15', '1', '6', '213', '123', '1', '100.0', '4', '15');
INSERT INTO `order_son` VALUES ('5', '2', '1', '6', '213', '2131', '1', '100.0', '5', '2');
INSERT INTO `order_son` VALUES ('6', '2', '1', '6', '2131', '312', '1', '110.0', '6', '2');
INSERT INTO `order_son` VALUES ('7', '2', '1', '6', '1231', '13143', '1', '120.0', '7', '2');
INSERT INTO `order_son` VALUES ('8', '3', '1', '6', '21314', '21313', '1', '130.0', '8', '3');
INSERT INTO `order_son` VALUES ('9', '3', '1', '6', '253', '3565', '1', '130.0', '9', '3');
INSERT INTO `order_son` VALUES ('10', '4', '1', '6', '1431', '1231', '1', '110.0', '10', '4');
INSERT INTO `order_son` VALUES ('11', '4', '1', '6', '12132321', '1423432', '1', '123.0', '11', '4');
INSERT INTO `order_son` VALUES ('12', '1', '2', '1', '1581928374', '1581928374', '1', '90.0', '3', '1');
INSERT INTO `order_son` VALUES ('13', '2', '5', '1', '1581928374', '1581928374', '1', '175.0', '3', '8');
INSERT INTO `order_son` VALUES ('14', '23', '3', '1', '1581928374', '1581928374', '1', '720.0', '4', '23');
INSERT INTO `order_son` VALUES ('15', '1', '2', '1', '1581999527', '1581999527', '1', '90.0', '1', '1');
INSERT INTO `order_son` VALUES ('16', '2', '2', '1', '1581999527', '1581999527', '1', '70.0', '11', '8');
INSERT INTO `order_son` VALUES ('17', '1', '20', '1', '1581999527', '1581999527', '1', '1100.0', '5', '3');
INSERT INTO `order_son` VALUES ('18', '1', '2', '6', '1582082981', '1582082981', '1', '90.0', '3', '1');
INSERT INTO `order_son` VALUES ('19', '1', '2', '6', '1582082981', '1582082981', '1', '110.0', '4', '3');
INSERT INTO `order_son` VALUES ('20', '2', '2', '6', '1582082981', '1582082981', '1', '130.0', '4', '10');
INSERT INTO `order_son` VALUES ('21', '2', '2', '6', '1582086055', '1582086055', '1', '70.0', '5', '8');
INSERT INTO `order_son` VALUES ('22', '2', '1', '6', '1582086055', '1582086055', '1', '63.0', '6', '9');
INSERT INTO `order_son` VALUES ('23', '2', '1', '6', '1582086055', '1582086055', '1', '65.0', '7', '10');
INSERT INTO `order_son` VALUES ('24', '2', '1', '6', '1582088008', '1582088008', '1', '77.0', '8', '11');
INSERT INTO `order_son` VALUES ('25', '1', '2', '7', '1582090793', '1582090793', '1', '90.0', '9', '1');
INSERT INTO `order_son` VALUES ('26', '1', '1', '7', '1582090793', '1582090793', '1', '50.0', '10', '2');
INSERT INTO `order_son` VALUES ('27', '23', '0', '7', '1582090793', '1582090793', '1', '0.0', '10', '23');
INSERT INTO `order_son` VALUES ('28', '1', '0', '7', '1582090793', '1582090793', '1', '0.0', '11', '3');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT 'url地址',
  `permission` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '权限',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '权限名',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '/user/list', 'user:list', '查询用户');
INSERT INTO `permission` VALUES ('2', '/user/add', 'user:add', '添加用户');
INSERT INTO `permission` VALUES ('3', '/user/delete', 'user:delete', '删除用户');

-- ----------------------------
-- Table structure for pic
-- ----------------------------
DROP TABLE IF EXISTS `pic`;
CREATE TABLE `pic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '图片地址',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `upload_user` int(11) DEFAULT NULL,
  `upload_user_type` varchar(10) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '‘0’为mobile端，‘1’为web端',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of pic
-- ----------------------------
INSERT INTO `pic` VALUES ('1', '2020-02/5cd4a12b-b7d3-42ab-adcf-9f59b5f59c2f.jpg', '1581931312', '1581931312', '1', '0');
INSERT INTO `pic` VALUES ('10', '2020-02/1df4f3c1-eb4f-4885-a4ec-0dbea668eec2.jpg', '1581931318', '1581931318', '1', '0');
INSERT INTO `pic` VALUES ('11', '2020-02/34f1b5fb-3a46-414e-9522-de99f5b85919.jpg', '1581931322', '1581931322', '1', '0');
INSERT INTO `pic` VALUES ('12', '2020-02/a9eb7cc0-5963-45d4-bfbc-4df90ee41798.jpg', '1581931329', '1581931329', '1', '0');
INSERT INTO `pic` VALUES ('17', '2020-02/ea9d278b-c669-4088-8b4a-c233489a6b9c.jpg', '1582011498', '1582011498', '1', '0');
INSERT INTO `pic` VALUES ('18', '2020-02/f51cab21-5ccd-4a69-840e-e1df11f1acfe.jpg', '1582011711', '1582011711', '6', '0');
INSERT INTO `pic` VALUES ('19', '2020-02/11e667d8-62d9-4b65-8328-03baaa982efe.jpg', '1582012440', '1582012440', '1', '0');
INSERT INTO `pic` VALUES ('20', '2020-02/bb8374b4-711e-4647-a189-ef64011fb16b.jpg', '1582012930', '1582012930', '6', '0');
INSERT INTO `pic` VALUES ('21', '2020-02/321cb925-032f-4a43-b85f-f58f789c7378.jpg', '1582013123', '1582013123', '6', '0');
INSERT INTO `pic` VALUES ('22', '2020-02/710c5271-ff39-49e5-934d-e5a3e2b0195d.jpg', '1582013422', '1582013422', '1', '0');
INSERT INTO `pic` VALUES ('23', '2020-02/e6efb495-4586-47cb-8241-043fe9bb1b64.jpg', '1582013653', '1582013653', '6', '0');
INSERT INTO `pic` VALUES ('24', '2020-02/ea6ea42b-02f7-4a9f-8f29-4191e92ee574.jpg', '1582014507', '1582014507', '6', '0');
INSERT INTO `pic` VALUES ('25', '2020-02/a94bfc0e-4d59-4505-ba60-a5490cb95642.jpg', '1582014764', '1582014764', '1', '0');
INSERT INTO `pic` VALUES ('26', '2020-02/8768b883-57ba-48ba-9eae-203c9a0860cc.jpg', '1582014777', '1582014777', '1', '0');
INSERT INTO `pic` VALUES ('27', '2020-02/4a32991a-2366-40dd-95b4-de34637452d9.jpg', '1582015206', '1582015206', '6', '0');
INSERT INTO `pic` VALUES ('28', '2020-02/3c71ec41-758c-4b69-b4dd-2c322d3fd126.jpg', '1582015260', '1582015260', '6', '0');
INSERT INTO `pic` VALUES ('29', '2020-02/65bd0620-4321-47ec-9565-174226cfd978.jpg', '1582015281', '1582015281', '6', '0');
INSERT INTO `pic` VALUES ('30', '2020-02/d4800372-2dd3-43a5-ad3c-e0f3c18501b7.jpg', '1582032203', '1582032203', '6', '0');
INSERT INTO `pic` VALUES ('31', '2020-02/ab05df71-70ce-4afc-9c31-9b958aeed4bd.jpg', '1582033019', '1582033019', '6', '0');
INSERT INTO `pic` VALUES ('32', '2020-02/fc22da08-1495-4b2c-ab04-d7c4a919c505.jpg', '1582033108', '1582033108', '6', '0');
INSERT INTO `pic` VALUES ('33', '2020-02/f2e5a947-d2bc-44aa-adca-d5ddd1ee7d30.jpg', '1582033191', '1582033191', '6', '0');
INSERT INTO `pic` VALUES ('34', '2020-02/92610c09-9c78-42a5-b022-dd5ecca0f1f7.jpg', '1582033279', '1582033279', '6', '0');
INSERT INTO `pic` VALUES ('35', '2020-02/a6960494-cc50-4ee0-b2e5-8d8c759d2f1c.jpg', '1582033302', '1582033302', '6', '0');
INSERT INTO `pic` VALUES ('36', '2020-02/ea5fc4b6-5a48-4153-a607-3ae80f361e7b.jpg', '1582033317', '1582033317', '6', '0');
INSERT INTO `pic` VALUES ('37', '2020-02/2873552c-93f6-45df-b9a0-cfbe57206e14.jpg', '1582033619', '1582033619', '6', '0');
INSERT INTO `pic` VALUES ('38', '2020-02/8af2627c-7aaf-4a3f-84c6-61de99d3abcc.jpg', '1582033628', '1582033628', '6', '0');
INSERT INTO `pic` VALUES ('39', '2020-02/6c586e7e-583b-4557-858c-8a4f38939c0c.jpg', '1582033636', '1582033636', '6', '0');
INSERT INTO `pic` VALUES ('40', '2020-02/243b3c5b-53d0-4cb2-91d0-793402f75d0d.jpg', '1582035728', '1582035728', '6', '0');
INSERT INTO `pic` VALUES ('41', '2020-02/7ed950f4-101a-422b-87c7-49c9865644f8.jpg', '1582035744', '1582035744', '6', '0');
INSERT INTO `pic` VALUES ('42', '2020-02/7d2ca57e-3497-4bc5-9678-0e66b07054e5.jpg', '1582035769', '1582035769', '6', '0');
INSERT INTO `pic` VALUES ('43', '2020-02/8bf6b8dc-d513-4dee-bd20-9edc36983586.jpg', '1582035993', '1582035993', '6', '0');
INSERT INTO `pic` VALUES ('44', '2020-02/cc259b7a-3940-4fa9-998c-2e39f9c19a19.jpg', '1582036016', '1582036016', '6', '0');
INSERT INTO `pic` VALUES ('45', '2020-02/2550e01c-d857-47f8-accf-b4b6af726229.jpg', '1582036027', '1582036027', '6', '0');
INSERT INTO `pic` VALUES ('46', '2020-02/21d3ec3a-5951-4d98-979c-07511c820938.jpg', '1582078258', '1582078258', '6', '0');
INSERT INTO `pic` VALUES ('47', '2020-02/1e71ab05-027b-47c2-83cf-dd29dbb4e6a5.jpg', '1582081349', '1582081349', '6', '0');
INSERT INTO `pic` VALUES ('48', '2020-02/b0b81781-d307-439b-9ecd-5ea4f19bf518.jpg', '1582081355', '1582081355', '6', '0');
INSERT INTO `pic` VALUES ('49', '2020-02/8760d0ee-0d83-4315-aa13-cf61451f871e.jpg', '1582081364', '1582081364', '6', '0');
INSERT INTO `pic` VALUES ('50', '2020-02/abe57141-3b3e-45cb-ab71-2f1ea8adbcd7.jpg', '1582081378', '1582081378', '6', '0');
INSERT INTO `pic` VALUES ('51', '2020-02/a76820dc-7e2c-479f-a79a-2f0df3dc228c.jpg', '1582082959', '1582082959', '6', '0');
INSERT INTO `pic` VALUES ('52', '2020-02/790dfc4c-7e4d-45e2-b192-b051cbef495b.jpg', '1582082964', '1582082964', '6', '0');
INSERT INTO `pic` VALUES ('53', '2020-02/33eaa610-ad7e-459b-ac30-fe8c60ff7f80.jpg', '1582082970', '1582082970', '6', '0');
INSERT INTO `pic` VALUES ('54', '2020-02/a2cedbd3-4d00-4c26-9e33-65b4b3d25d27.jpg', '1582083391', '1582083391', '6', '0');
INSERT INTO `pic` VALUES ('55', '2020-02/e996d33b-fada-494c-818f-076d5252296c.jpg', '1582083397', '1582083397', '6', '0');
INSERT INTO `pic` VALUES ('56', '2020-02/7ec81aa6-2aac-4073-ae22-2f8e418dac83.jpg', '1582083402', '1582083402', '6', '0');
INSERT INTO `pic` VALUES ('57', '2020-02/52af50e8-5f27-4d29-a0c4-2cffe8f72fb0.jpg', '1582083593', '1582083593', '6', '0');
INSERT INTO `pic` VALUES ('58', '2020-02/21476105-4a13-4bb3-b6ad-014b118e5622.jpg', '1582083597', '1582083597', '6', '0');
INSERT INTO `pic` VALUES ('59', '2020-02/70bd1be5-3e98-4609-ae01-31085a2918ad.jpg', '1582083602', '1582083602', '6', '0');
INSERT INTO `pic` VALUES ('60', '2020-02/ebb7d6e0-35b8-42e2-8623-7ea7dba261e4.jpg', '1582083658', '1582083658', '6', '0');
INSERT INTO `pic` VALUES ('61', '2020-02/cf689906-44dc-4107-8a07-2ab4cc9c4be8.jpg', '1582083662', '1582083662', '6', '0');
INSERT INTO `pic` VALUES ('62', '2020-02/e9fb42c2-fa72-4e4e-aa7c-9f09b6f01f91.jpg', '1582083667', '1582083667', '6', '0');

-- ----------------------------
-- Table structure for repertory
-- ----------------------------
DROP TABLE IF EXISTS `repertory`;
CREATE TABLE `repertory` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `laboratory_id` int(11) DEFAULT NULL COMMENT '实验室id',
  `disease_id` int(11) DEFAULT NULL COMMENT '商品名',
  `commodity_id` int(11) DEFAULT NULL,
  `price` float(20,0) DEFAULT NULL COMMENT '价格',
  `inventory` int(11) DEFAULT NULL COMMENT '存货',
  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
  `update_time` bigint(20) DEFAULT NULL COMMENT '修改时间',
  `user_id` int(11) DEFAULT NULL COMMENT '创建人',
  `status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '‘1’上架，‘0’下架',
  `logo` int(11) DEFAULT NULL,
  `tag` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '标签',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of repertory
-- ----------------------------
INSERT INTO `repertory` VALUES ('1', '1', '1', '1', '45', '991', '211313', '23213213', '1', '1', '1', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `repertory` VALUES ('2', '2', '1', '1', '50', '887', '2332432', '3424', '1', '1', '1', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `repertory` VALUES ('3', '3', '2', '1', '55', '77', '123112', '12313', '1', '1', '1', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `repertory` VALUES ('4', '2', '2', '3', '56', '200', '2121421', '12213123', '1', '1', '1', '[]');
INSERT INTO `repertory` VALUES ('5', '4', '3', '1', '60', '300', '12213', '1232', '1', '1', '1', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `repertory` VALUES ('6', '5', '3', '1', '30', '400', '1213', '21323', '1', '1', '1', '[]');
INSERT INTO `repertory` VALUES ('7', '6', '4', '1', '20', '110', '1231321', '123213', '1', '1', '1', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `repertory` VALUES ('8', '1', '4', '2', '35', '46', '1213123', '12213', '1', '1', '1', '[\"快速检测\"]');
INSERT INTO `repertory` VALUES ('9', '2', '5', '2', '63', '599', null, null, '1', '1', '12', '[\"快速检测\"]');
INSERT INTO `repertory` VALUES ('10', '3', '5', '2', '65', '497', null, null, '1', '1', '10', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `repertory` VALUES ('11', '4', '6', '2', '77', '299', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `repertory` VALUES ('12', '1', '6', '12', '66', '400', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\",\"其他\"]');
INSERT INTO `repertory` VALUES ('13', '1', '7', '13', '45', '255', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `repertory` VALUES ('14', '1', '7', '14', '47', '200', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `repertory` VALUES ('15', '1', '8', '15', '33', '320', null, null, '1', '1', '11', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `repertory` VALUES ('16', '1', '9', '16', '50', '111', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `repertory` VALUES ('17', '1', '10', '17', '52', '120', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `repertory` VALUES ('18', '1', '11', '18', '80', '99', null, null, '1', '1', '1', '[]');
INSERT INTO `repertory` VALUES ('19', '1', '12', '19', '75', '310', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `repertory` VALUES ('20', '1', '13', '20', '89', '333', null, null, '1', '1', '1', '[]');
INSERT INTO `repertory` VALUES ('21', '1', '14', '21', '128', '380', null, null, '1', '1', '1', '[\"快速检测\",\"物流快递\"]');
INSERT INTO `repertory` VALUES ('22', '2', '17', '22', '140', '230', null, null, '1', '1', '1', '[\"快速检测\"]');
INSERT INTO `repertory` VALUES ('23', '2', '17', '23', '240', '227', null, null, '1', '1', '1', '[\"快速检测\"]');

-- ----------------------------
-- Table structure for report
-- ----------------------------
DROP TABLE IF EXISTS `report`;
CREATE TABLE `report` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `url` varchar(200) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `upload_user` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of report
-- ----------------------------

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '角色名称',
  `memo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', 'admin', '管理员');
INSERT INTO `role` VALUES ('2', 'user', '用户');

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) NOT NULL,
  `permission_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '1');
INSERT INTO `role_permission` VALUES ('2', '1', '2');
INSERT INTO `role_permission` VALUES ('3', '1', '3');

-- ----------------------------
-- Table structure for shop_car
-- ----------------------------
DROP TABLE IF EXISTS `shop_car`;
CREATE TABLE `shop_car` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `repertory_id` int(11) DEFAULT NULL COMMENT '库存id',
  `num` int(10) DEFAULT NULL,
  `create_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  `status` varchar(10) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT '1' COMMENT '0取消，1正常，2下单',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=49 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of shop_car
-- ----------------------------
INSERT INTO `shop_car` VALUES ('9', '1', '3', '20', '1581670731', '1581759842', '2');
INSERT INTO `shop_car` VALUES ('10', '6', '8', '9', '1581759984', '1581943315', '0');
INSERT INTO `shop_car` VALUES ('11', '6', '23', '5', '1581760068', '1581943321', '0');
INSERT INTO `shop_car` VALUES ('12', '8', '1', '5', '1581826382', '1581826425', '1');
INSERT INTO `shop_car` VALUES ('13', '6', '15', '27', '1581839273', '1581839758', '0');
INSERT INTO `shop_car` VALUES ('14', '6', '9', '9', '1581839578', '1581943311', '0');
INSERT INTO `shop_car` VALUES ('18', '1', '23', '3', '1581842453', null, '2');
INSERT INTO `shop_car` VALUES ('19', '1', '8', '5', '1581843120', null, '2');
INSERT INTO `shop_car` VALUES ('20', '6', '15', '9', '1581845695', '1581857692', '0');
INSERT INTO `shop_car` VALUES ('21', '6', '2', '8', '1581847101', '1581857692', '0');
INSERT INTO `shop_car` VALUES ('22', '6', '4', '3', '1581856192', '1581857692', '0');
INSERT INTO `shop_car` VALUES ('23', '6', '15', '2', '1581857761', '1581921833', '0');
INSERT INTO `shop_car` VALUES ('24', '11', '13', '0', '1581858328', '1582088318', '1');
INSERT INTO `shop_car` VALUES ('25', '2', '1', '2', '1581858539', '1581859027', '1');
INSERT INTO `shop_car` VALUES ('26', '1', '1', '2', '1581859100', '1581859172', '2');
INSERT INTO `shop_car` VALUES ('27', '6', '2', '2', '1581860603', '1581921833', '0');
INSERT INTO `shop_car` VALUES ('28', '7', '1', '1', '1581903114', '1581903145', '0');
INSERT INTO `shop_car` VALUES ('29', '7', '1', '1', '1581918965', '1581921044', '0');
INSERT INTO `shop_car` VALUES ('30', '7', '2', '9', '1581918968', '1581941815', '0');
INSERT INTO `shop_car` VALUES ('31', '7', '3', '1', '1581918972', '1581921044', '0');
INSERT INTO `shop_car` VALUES ('32', '7', '5', '1', '1581918976', '1581921044', '0');
INSERT INTO `shop_car` VALUES ('33', '7', '6', '1', '1581918979', '1581921044', '0');
INSERT INTO `shop_car` VALUES ('34', '6', '1', '8', '1581921689', '1581929624', '0');
INSERT INTO `shop_car` VALUES ('35', '6', '20', '2', '1581922696', '1581922711', '0');
INSERT INTO `shop_car` VALUES ('36', '7', '1', '2', '1581923587', '1581958676', '2');
INSERT INTO `shop_car` VALUES ('37', '6', '3', '2', '1581923625', null, '2');
INSERT INTO `shop_car` VALUES ('38', '6', '10', '2', '1581943304', null, '2');
INSERT INTO `shop_car` VALUES ('39', '7', '2', '1', '1581958647', '1582011324', '2');
INSERT INTO `shop_car` VALUES ('40', '7', '3', '0', '1581958658', '1581958666', '2');
INSERT INTO `shop_car` VALUES ('41', '6', '1', '2', '1581989884', null, '2');
INSERT INTO `shop_car` VALUES ('42', '1', '1', '2', '1581997207', null, '2');
INSERT INTO `shop_car` VALUES ('43', '1', '8', '2', '1581997295', null, '2');
INSERT INTO `shop_car` VALUES ('44', '6', '8', '2', '1582083190', '1582086044', '2');
INSERT INTO `shop_car` VALUES ('45', '6', '9', '1', '1582086039', null, '2');
INSERT INTO `shop_car` VALUES ('46', '6', '10', '1', '1582086048', null, '2');
INSERT INTO `shop_car` VALUES ('47', '6', '11', '1', '1582088005', null, '2');
INSERT INTO `shop_car` VALUES ('48', '7', '23', '0', '1582090693', '1582090741', '2');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_name` varchar(100) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '用户名',
  `passwd` varchar(150) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '密码',
  `create_time` bigint(20) NOT NULL COMMENT '创建时间',
  `status` varchar(1) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '是否有效 1：有效  0：锁定',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', 'ddec7b4afd62f3431f59da2cda7fc6ed', '20200203135055', '1');
INSERT INTO `user` VALUES ('2', 'company', '2f9482500e4e4bddc9e4087a50d443e5', '20200203135128', '1');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '1', '1');
INSERT INTO `user_role` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for vacc_record
-- ----------------------------
DROP TABLE IF EXISTS `vacc_record`;
CREATE TABLE `vacc_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '日龄',
  `vacc_type` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '疫苗种类',
  `manufacturer` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '厂商',
  `order_id` int(11) DEFAULT NULL COMMENT '关联订单',
  `status` tinyint(1) DEFAULT '1' COMMENT '1正常',
  `create_time` bigint(20) DEFAULT NULL,
  `update_time` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC;

-- ----------------------------
-- Records of vacc_record
-- ----------------------------
INSERT INTO `vacc_record` VALUES ('1', 'test1', 'test1', 'test1', '3', '1', '1581928374', null);
INSERT INTO `vacc_record` VALUES ('2', 'test2', 'test2', 'test2', '3', '1', '1581928374', null);
INSERT INTO `vacc_record` VALUES ('3', 'test1', 'test1', 'test1', '4', '1', '1581928374', null);
INSERT INTO `vacc_record` VALUES ('4', 'test2', 'test2', 'test2', '4', '1', '1581928374', null);
INSERT INTO `vacc_record` VALUES ('5', '30', '肝炎疫苗', '疫苗常', '1', '1', '1581999527', null);
INSERT INTO `vacc_record` VALUES ('6', '30', '肝炎疫苗', '疫苗常', '2', '1', '1581999527', null);
INSERT INTO `vacc_record` VALUES ('7', '1', '2', '3', '3', '1', '1582082981', null);
INSERT INTO `vacc_record` VALUES ('8', '2', '3', '4', '3', '1', '1582082981', null);
INSERT INTO `vacc_record` VALUES ('9', '5', '6', '7', '3', '1', '1582082981', null);
INSERT INTO `vacc_record` VALUES ('10', '1', '2', '3', '4', '1', '1582082981', null);
INSERT INTO `vacc_record` VALUES ('11', '2', '3', '4', '4', '1', '1582082981', null);
INSERT INTO `vacc_record` VALUES ('12', '5', '6', '7', '4', '1', '1582082981', null);
