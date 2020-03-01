# diseasemonitor
diseasemonitor

# 2020 - 02 - 20
- 基础框架正在搭建
- mrruan: 增加数据库连接配置  完成所有entity编码工作 
- mrruan: 增加后台接口需要考虑的点，文档：doc/diseaseMonitor后台接口着手点.pdf
- mrruan: 增加七牛云配置 util与配置文件

- NadevXiang: 完成生成entity repository service

# 2020 - 02 - 21
- mrruan: 增加登录接口(未使用权限接口),使用redis存储token,过期时间15mins.

# 2020 - 02 - 22
- mrruan: 增加 LabSettingController, FileController

# 2020 - 02 - 23
- mrruan: 增加跨域支持
- mrruan: 增加错误登录三次以上需要验证码 根据IP判定

# 2020 - 02 - 25
- mrruan: 增加快递查询接口、修改密码接口、验证码不区分大小写、修复部分存在的BUGs.
# 2020 - 02 - 29
- Nadev： /order/detail 接口增加instruction，reports信息返回
- Nadev： 新增 /report/del /report/new /repertory/new /commondity/list接口

# 2020 - 03 - 01
- mrruan: 修改/user/info返回昵称
- mrruan: 不建议使用原先的/user/username修改昵称, 建议使用新接口/user/nickname,但原接口仍可使用
- mrruan: 返回用户的手机号码而不是实验室手机号码
- mrruan: 增加通过url删除report接口
- mrruan: FIX BUG 上传pdf url始终是1
