# xray-admin-service
xray后台管理服务，由[v2ray-web-manager](https://github.com/master-coder-ll/v2ray-web-manager)改造而来

[前端项目：xray-admin](https://github.com/fun90/xray-admin)

To-Do List
- [✔] 开发Xray Java API：增加/删除用户、查询流量统计
- [✔] 支持VMESS账号（后端）
- [] 支持VLESS账号（前后端）
- [✔] 流量统计查询
- [✔] 定时清理流量超标账号
- [✔] 定时清理过期账号
- [✔] 订阅地址：按客户端返回节点
- [✔] 热部署账号
- [...] 配置转换（Surge、Clash、Quantumult X、Shadowrocket、Loon）

## 下载
[Release](https://github.com/fun90/xray-admin-service/releases)

## 运行
注意：将YOUR_PATH改为自己的实际路径

java -jar /YOUR_PATH/xray-api-1.0.0.jar --spring.config.location=/YOUR_PATH/application.yaml