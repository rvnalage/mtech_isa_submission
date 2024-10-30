package org.example.dtos;

import java.util.ArrayList;
import java.util.List;

public class Cluster {

    private final List<Customer> members = new ArrayList<>();

    public Cluster(Customer customer) {
        members.add(customer);
    }

    public List<Customer> getMembers() {
        return members;
    }
}
