package repository;

import com.mongodb.Mongo;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import data.generalData.SalesMan;
import org.bson.Document;

import static org.junit.jupiter.api.Assertions.*;

class EvaluationRepoTest {
    private ManagePersonalRepo repo;
    private MongoClient mongoClient;
    private MongoDatabase mongodb;
    private MongoCollection<Document> evaluationColl;


    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        repo = new ManagePersonalRepo();
        mongoClient = new MongoClient("localhost", 27017);
        mongodb = mongoClient.getDatabase("SalesMenDB");
        evaluationColl = mongodb.getCollection("EvaluationRecords");
    }
    
    @org.junit.jupiter.api.Test
    void addPerformanceRecord() {
    }

    @org.junit.jupiter.api.Test
    void readEvaluationRecords() {
    }

    @org.junit.jupiter.api.Test
    void updateEvaluationRecord() {
    }

    @org.junit.jupiter.api.Test
    void deleteEvaluationRecords() {
    }

    @org.junit.jupiter.api.Test
    void querySalesMan() {
    }
}