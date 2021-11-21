package data.evaluationRecord;


import data.evaluationRecord.Client;

import java.util.ArrayList;
import java.util.List;

public class Product {
    private String name;
    private List<Client> clients;

    public Product() {
        clients = new ArrayList<>();
    }

    public Product(String name, List<Client> clients) {
        this.name = name;
        this.clients = clients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void addClient(Client client){
        clients.add(client);
    }

    @Override
    public String toString() {
        return "Product" +
                "name='" + name + '\'' +
                ", clients=" + clients +
                "\n";
    }
}
