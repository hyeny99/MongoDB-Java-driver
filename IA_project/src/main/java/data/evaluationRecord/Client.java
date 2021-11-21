package data.evaluationRecord;

public class Client {
    private String name;
    private String ranking;
    private Integer items;

    public Client() {
    }

    public Client(String name, String ranking, Integer items) {
        this.name = name;
        this.ranking = ranking;
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRanking() {
        return ranking;
    }

    public void setRanking(String ranking) {
        this.ranking = ranking;
    }

    public Integer getItems() {
        return items;
    }

    public void setItems(Integer items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", ranking='" + ranking + '\'' +
                ", items=" + items +
                '}';
    }
}
