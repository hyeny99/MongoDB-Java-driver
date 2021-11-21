package contract;

import data.evaluationRecord.EvaluationRecord;
import data.generalData.SalesMan;

import java.util.List;

// implementation of CRUD
public interface ManagePersonal {

    public void createSalesMan( SalesMan record );//C
    public SalesMan readSalesMan( int sid );//R
    public void UpdateSalesMan( SalesMan salesMan);//U
    public void DeleteSalesMan( int sid);//D

    public void addPerformanceRecord(EvaluationRecord record , int sid );//C
    //public EvaluationRecord readEvaluationRecord( ObjectId _id );//R
    public EvaluationRecord readEvaluationRecords( int sid );//R
    public void UpdateEvaluationRecord(EvaluationRecord evaluationRecord);//U
    //public  void DeleteEvaluationRecord(ObjectId _id );//D
    public  void DeleteEvaluationRecords(int sid);//D
    public List<SalesMan> querySalesMan(String attribute , String key );
}
