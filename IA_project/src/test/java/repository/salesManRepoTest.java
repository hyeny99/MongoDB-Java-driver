package repository;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import data.generalData.SalesMan;
import org.bson.Document;

import static com.mongodb.client.model.Filters.eq;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class salesManRepoTest {
    private ManagePersonalRepo repo;
    private MongoClient mongoClient;
    private MongoDatabase mongodb;
    private MongoCollection<Document> salesmanColl;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        repo = new ManagePersonalRepo();
        mongoClient = new MongoClient("localhost", 27017);
        mongodb = mongoClient.getDatabase("SalesMenDB");
        salesmanColl = mongodb.getCollection("generalData");
    }
    @org.junit.jupiter.api.Test
    void insertSalesMan() {
        Document document = new Document();
        document.append("firstname", "Hyeny");
        document.append("lastname", "Jeon");
        document.append("sid", 21021);

        salesmanColl.insertOne(document);

        Document newDocs = salesmanColl.find().first();
        System.out.println("Printing the salesman object (JSON): " + newDocs);

        Integer sid = (Integer) newDocs.get("sid");
        assertEquals(21021, sid);

        salesmanColl.drop();
    }

    @org.junit.jupiter.api.Test
    void createSalesManPOJO(){
        SalesMan salesMan = new SalesMan(11111, "Susan", "Bae");

        //salesmanColl.insertOne(salesMan.toDocument());
        repo.createSalesMan(salesMan);
        Document newDocs = salesmanColl.find().first();
        System.out.println("Printing the salesman object (JSON): " + newDocs);

        // Assertion
        Integer sid = (Integer) newDocs.get("sid");
        assertEquals(11111, sid);

        salesmanColl.drop();

    }

    @org.junit.jupiter.api.Test
    void searchSalesMan() {
        Document document = new Document();
        document.append("firstname", "Hyeny");
        document.append("lastname", "Jeon");
        document.append("sid", 21021);

        salesmanColl.insertOne(document);

        Document newDocs = salesmanColl.find(eq("sid", document.get("sid"))).first();
        System.out.println("Printing the salesman object (JSON): " + newDocs);

        // Assertion
        Integer sid = (Integer) newDocs.get("sid");
        assertEquals(21021, sid);

        salesmanColl.drop();
    }

    @org.junit.jupiter.api.Test
    void readSalesManPOJO(){
        SalesMan salesMan = new SalesMan(11111, "Susan", "Bae");

        //salesmanColl.insertOne(salesMan.toDocument());
        repo.createSalesMan(salesMan);
        Document newDocs = salesmanColl.find(eq("sid", salesMan.getSid())).first();
        System.out.println("Printing the salesman object (JSON): " + newDocs);

        // Assertion
        Integer sid = (Integer) newDocs.get("sid");
        assertEquals(11111, sid);

        salesmanColl.drop();

    }

    @org.junit.jupiter.api.Test
    void editSalesMan() {
        Document document = new Document();
        document.append("firstname", "Hyeny");
        document.append("lastname", "Jeon");
        document.append("sid", 21021);

        salesmanColl.insertOne(document);

        Document newDocs = salesmanColl.find(eq("sid", document.get("sid"))).first();
        newDocs.append("firstname", "Hyewon");
        newDocs.append("lastname", "Jeon");
        newDocs.append("sid", document.get("sid"));

        System.out.println("Printing the salesman object (JSON): " + newDocs);

        // Assertion
        Integer sid = (Integer) newDocs.get("sid");
        assertEquals(21021, sid);
        String firstName = (String) newDocs.get("firstname");
        assertEquals("Hyewon", firstName);

        salesmanColl.drop();

    }

    @org.junit.jupiter.api.Test
    void updateSalesManPOJO(){
        SalesMan salesMan = new SalesMan(11111, "Susan", "Bae");

        //salesmanColl.insertOne(salesMan.toDocument());
        repo.createSalesMan(salesMan);
        Document newDocs = salesmanColl.find(eq("sid", salesMan.getSid())).first();
        salesMan.setLastname("Ful");
        repo.UpdateSalesMan(salesMan);
        newDocs = salesmanColl.find().first();

        System.out.println("Printing the salesman object (JSON): " + newDocs);

        // Assertion
        Integer sid = (Integer) newDocs.get("sid");
        assertEquals(11111, sid);

        String lastName = (String) newDocs.get("lastname");
        assertEquals("Ful", lastName);

        salesmanColl.drop();
    }

    @org.junit.jupiter.api.Test
    void removeSalesMan() {
        salesmanColl.drop();
        Long size = salesmanColl.countDocuments();
        assertEquals(0, size);
    }

    @org.junit.jupiter.api.Test
    void deleteSalesManPOJO(){
        SalesMan salesMan = new SalesMan(11111, "Susan", "Bae");

        repo.DeleteSalesMan(salesMan.getSid());
        Document newDocs = salesmanColl.find(eq("sid", salesMan.getSid())).first();
        System.out.println("Printing the salesman object (JSON): " + newDocs);

        assertEquals(null, newDocs);

    }

}
