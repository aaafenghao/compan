http://localhost:8087/hystrix

http://localhost:8087/actuator/hystrix.stream

http://localhost:8087/hystrix.stream


turbine.appConfig ：配置Eureka中的serviceId列表，表明监控哪些服务
turbine.aggregator.clusterConfig ：指定聚合哪些集群，多个使用”,”分割，默认为default。可使用http://.../turbine.stream?cluster={clusterConfig之一}访问
turbine.clusterNameExpression ： 1. clusterNameExpression指定集群名称，默认表达式appName；此时：turbine.aggregator.clusterConfig需要配置想要监控的应用名称；2. 当clusterNameExpression: default时，turbine.aggregator.clusterConfig可以不写，因为默认就是default；3. 当clusterNameExpression: metadata[‘cluster’]时，假设想要监控的应用配置了eureka.instance.metadata-map.cluster: ABC，则需要配置，同时turbine.aggregator.clusterConfig: ABC


http://localhost:8088/turbine.stream
http://localhost:8088/hystrix
http://localhost:8088/turbine.stream