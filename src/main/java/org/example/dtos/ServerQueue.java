package org.example.dtos;

public class ServerQueue {

    private final Integer serverId;

    public ServerQueue(Integer serverId) {
        this.serverId = serverId;
    }

    public void processRequest(Request request) {
        // Simulate request processing
        if (serverId == 0) {
            System.out.println("----------------------------------------");
        }
        System.out.println("Server : " + serverId + " is processing " + "Request No : " + request.getRequestId());
    }
}
