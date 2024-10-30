package org.example;

import org.example.dtos.Request;
import org.example.service.LoadBalancer;

import static org.example.constants.LoadBalancerConstants.NUMBER_OF_REQUESTS;
import static org.example.constants.LoadBalancerConstants.NUMBER_OF_SERVERS;

public class LoadBalancerApplication {

    public static void main(String[] args) {
        LoadBalancer loadBalancer = new LoadBalancer(NUMBER_OF_SERVERS);

        // Simulate handling a high volume of requests
        for (int i = 0; i < NUMBER_OF_REQUESTS; i++) {
            Request request = new Request(i);
            loadBalancer.handleRequest(request);
        }
    }
}





