package org.example.service;

import org.example.dtos.Request;
import org.example.dtos.ServerQueue;

import java.util.concurrent.atomic.AtomicInteger;

public class LoadBalancer {

    private final ServerQueue[] serverQueues;
    private final AtomicInteger currentIndex = new AtomicInteger(0);

    public LoadBalancer(int numServers) {
        serverQueues = new ServerQueue[numServers];
        for (int i = 0; i < numServers; i++) {
            serverQueues[i] = new ServerQueue(i);
        }
    }

    private ServerQueue getNextServer() {
        int index = currentIndex.getAndUpdate(i -> (i + 1) % serverQueues.length);
        return serverQueues[index];
    }

    public void handleRequest(Request request) {
        ServerQueue server = getNextServer();
        server.processRequest(request);
    }



}





