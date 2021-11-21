package repository;

import data.generalData.SalesMan;

import static org.junit.jupiter.api.Assertions.*;

class ManagePersonalRepoTest {
    ManagePersonalRepo repo;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        repo = new ManagePersonalRepo();
    }

    @org.junit.jupiter.api.Test
    void createSalesMan() {
        SalesMan salesMan = new SalesMan(111, "Hyeny", "Jeon");
        repo.createSalesMan(salesMan);
    }

    @org.junit.jupiter.api.Test
    void readSalesMan() {
    }

    @org.junit.jupiter.api.Test
    void updateSalesMan() {
    }

    @org.junit.jupiter.api.Test
    void deleteSalesMan() {
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