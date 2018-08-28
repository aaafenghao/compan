http://localhost:8090/index

WebHook是当某个事件发生时，通过发送http post请求的方式来通知信息接收方。Webhook来监测你在Github.com上的各种事件，最常见的莫过于push事件

Payload URL ：触发后回调的URL
Content type ：数据格式，两种一般使用json
Secret ：用作给POST的body加密的字符串。采用HMAC算法
events ：触发的事件列表。
events事件类型	描述
push	仓库有push时触发。默认事件
create	当有分支或标签被创建时触发
delete	当有分支或标签被删除时触发
svn也有类似的hook机制，每次提交后会触发post-commit脚本，我们可以在这里写一些post请求

http://localhost:8090/refresh

curl -v -X POST "http://localhost:8002/actuator/refresh"