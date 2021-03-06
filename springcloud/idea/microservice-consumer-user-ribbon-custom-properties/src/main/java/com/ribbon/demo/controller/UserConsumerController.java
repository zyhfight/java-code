package com.ribbon.demo.controller;

import com.ribbon.demo.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Copyright: Copyright (c) 2018
 *
 * @Description: 该类的功能描述
 * @version: v1.0.0
 * @author: zyh
 * @date: 2018-8-29
 * <p>
 * Modification History:
 * Date         Author          Version            Description
 * ---------------------------------------------------------*
 * 2018-8-29     zyh           v1.0.0               修改原因
 */
@RestController
public class UserConsumerController {

    private static final Logger logger = LoggerFactory.getLogger(UserConsumerController.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return restTemplate.getForObject("http://microservice-provider-user/" + id,User.class);
    }

    @GetMapping("log-user-instance")
    public void logUserInstance(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider-user");
        logger.info("{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
    }


}
