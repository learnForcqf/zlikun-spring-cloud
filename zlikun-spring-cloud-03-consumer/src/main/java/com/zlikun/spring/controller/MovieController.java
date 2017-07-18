package com.zlikun.spring.controller;

import com.zlikun.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @auther zlikun <zlikun-dev@hotmail.com>
 * @date 2017/7/17 10:11
 */
@RestController
public class MovieController {

    /**
     * RestTemplate 用于请求 REST API并解析其返回值
     */
    @Autowired
    private RestTemplate restTemplate ;

    @Autowired
    private DiscoveryClient discoveryClient ;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id) {
        return restTemplate.getForObject("http://localhost:8000/" + id ,User.class) ;
    }

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo() {
        return discoveryClient.getInstances("microservice-provider-user") ;
    }

}
