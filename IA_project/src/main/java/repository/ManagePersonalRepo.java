package repository;

import com.mongodb.*;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import contract.ManagePersonal;
import data.evaluationRecord.EvaluationRecord;
import data.generalData.SalesMan;

import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class ManagePersonalRepo implements ManagePersonal {
    private MongoDatabase _db;
    private MongoCollection<SalesMan> salesManColl;
    private MongoCollection<EvaluationRecord> evaluationColl;

    public ManagePersonalRepo(){

        // POJO to BSON object(DB document)
        CodecRegistry pojoCodecRegistry = fromProviders(PojoCodecProvider.builder().automatic(true).build());
        CodecRegistry codecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), pojoCodecRegistry);
        MongoClientSettings clientSettings = MongoClientSettings.builder().applyConnectionString(new ConnectionString("mongodb://localhost:27017"))
                .codecRegistry(codecRegistry)
                .build();

        _db= MongoClients.create(clientSettings).getDatabase("SalesMenDB");

        salesManColl= _db.getCollection("generalData",SalesMan.class);
        evaluationColl= _db.getCollection("EvaluationRecords",EvaluationRecord.class);

    }
    @Override
    public void createSalesMan(SalesMan record) {
        salesManColl.insertOne(record);
    }

    @Override
    public SalesMan readSalesMan(int sid) {
       return salesManColl.find(eq("sid", sid)).first();
    }

    @Override
    public void UpdateSalesMan(SalesMan salesMan) {
//        SalesMan oldSalesMan = readSalesMan(salesMan.getId());
//        oldSalesMan.setId(salesMan.getId());
//        oldSalesMan.setFirstname(salesMan.getFirstname());
//        oldSalesMan.setLastname(salesMan.getLastname());
        salesManColl.replaceOne(eq("sid", salesMan.getSid()), salesMan);
    }

    @Override
    public void DeleteSalesMan(int sid) {
        salesManColl.deleteOne(eq("sid", sid));

    }

    @Override
    public void addPerformanceRecord(EvaluationRecord record, int sid) {
        record.setSid(sid);
        evaluationColl.insertOne(record);
    }

    @Override
    public EvaluationRecord readEvaluationRecords(int sid) {
        return evaluationColl.find(eq("sid", sid)).first();
    }

    @Override
    public void UpdateEvaluationRecord(EvaluationRecord evaluationRecord) {
        evaluationColl.replaceOne(eq("sid", evaluationRecord.getSid()), evaluationRecord);
    }

    @Override
    public void DeleteEvaluationRecords(int sid) {
        evaluationColl.deleteOne(eq("sid", sid));
    }

    @Override
    public List<SalesMan> querySalesMan(String attribute, String key) {
        List<SalesMan> salesmen = new ArrayList<>();
        Iterator<SalesMan> curser = salesManColl.find(eq(attribute, key)).iterator();
        while(curser.hasNext()){
            salesmen.add(curser.next());
        }
        return salesmen;
    }
}
