# note
--

## one >> eureka配置高可用之后，为什么eureka-client的defaultZone要写高可用的eureka多个地址，明明写一个eureka注册中心地址，多个eureka注册中心都可以发现服务的。

> 答：你比如说你只写了一个8051这个端口的eureka服务，高可用的eureka有8051,8052,8053三个注册中心，项目里虽然只写8051的eureka注册中心，实际8052,8053也都有这个服务，
但是如果8051这个注册中心挂了呢？那怎么去找8052,8053这两个注册中心呢？所以是最好把高可用的eureka所有的注册中心地址都写给defaultZone里面。
高可用只是所有eureka-server共用，但是，挂了一个服务注册中心之后可以去找另外一个服务注册中心。所以保证高可用注册中心，那么必须得保证两点：
（1）根据配置文件的不同端口号以及相互指定其它地址（高可用中除了自己的eureka-server地址）。然后根据不同的配置文件启动不同eureka-server注册中心(用jar包的方式启动)。
（2）eureka-client服务的配置文件得eureka.client.service-url.defaultZone:多个eureka地址。


## two >> 根据不同的配置文件启动jar包

>java -jar xxx.jar --spring.profiles.active = 配置文件的标识

> 那么什么是配置文件的标识呢？

> application-{profile}.properties中的{profile}

> application-{profile}.yml中的{profile}


> 如何实现，同一个jar包启动服务但是端口号想要和配置文件不一样 ?
 答：java -jar xxx.jar --server.port = 你想要启动的端口号


