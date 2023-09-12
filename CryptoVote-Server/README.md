# CryptoVote投票系统
- 我们在Android平台上实现了该匿名投票系统
## 分支
- Android分支是安卓平台代码
- Server分支是后台服务器代码
    - Server分支中`ruoyi-admin/src/test/java`下是测试文件；其中`EntireTest`是整个投票算法（包括同态加密、布隆过滤器以及协议）测试；
    - 其中获取的随机数进行了范围限定，不是真正的随机数
## TODO
- 将投票算法集成到服务器
- 进行安卓端和服务器端投票的共同调试