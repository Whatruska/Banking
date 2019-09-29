package main.webapp.Backend.Banking.Client;

public class ClientWithID extends Client {
    private int id;
    private Client client;

    public ClientWithID(int id, Client client) {
        this.id = id;
        this.client = client;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "ID : " + id + "\n" + client.toString();
    }
}
