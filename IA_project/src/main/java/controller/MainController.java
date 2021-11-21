package controller;

import data.evaluationRecord.Client;
import data.evaluationRecord.OrdersEvaluation;
import data.evaluationRecord.Product;
import data.evaluationRecord.SocialPerformance;
import data.evaluationRecord.EvaluationRecord;
import data.generalData.SalesMan;
import repository.ManagePersonalRepo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class MainController {
    private ManagePersonalRepo repo;
    BufferedReader reader;
    Scanner intScanner;
    Scanner stringScanner;

    public MainController() {
        repo = new ManagePersonalRepo();

        reader = new BufferedReader(new InputStreamReader(System.in));
        intScanner = new Scanner(System.in);
        stringScanner = new Scanner(System.in);
    }


    public void userInterface() {
        /*********************************************
         * Enter a case number (1-4)
         * case number 1: insert a new salesman
         * case number 2: find a salesman by sid
         * case number 3: update a salesman info
         * case number 4: delete a salesman by sid
         * case number 5: insert a new evaluation record
         * case number 6: find an evaluation record by sid
         * case number 7: update an evaluation record
         * case number 8: delete an evaluation record by sid
         * case number 9: find all salesmen by an attribute and a key
         *
         * If you want to exit, please press -1
         *********************************************/

        System.out.println("/*********************************************\n" +
                "         * Enter a case number (1-4)\n" +
                "         * case number 1: insert a new salesman\n" +
                "         * case number 2: find a salesman by sid\n" +
                "         * case number 3: update a salesman info\n" +
                "         * case number 4: delete a salesman by sid\n" +
                "         * case number 5: insert a new evaluation record\n" +
                "         * case number 6: find an evaluation record by sid\n" +
                "         * case number 7: update an evaluation record\n" +
                "         * case number 8: delete an evaluation record by sid\n" +
                "         * case number 9: find all salesmen by an attribute and a key\n" +
                "         * \n" +
                "         * If you want to exit, please press -1\n" +
                "         *********************************************/");

        int sidMin = 1;
        int sidMax = 1000;

        while (true) {
            System.out.println("Enter a case number: ");
            int choice = intScanner.nextInt();

            switch (choice) {
                // insert a new salesman
                case 1: {
                    System.out.println("Enter a sid: ");
                    int sid = intScanner.nextInt();

                    System.out.println("Enter first name: ");
                    String firstName = stringScanner.nextLine();

                    System.out.println("Enter last name: ");
                    String lastName = stringScanner.nextLine();

                    SalesMan salesMan = new SalesMan(null, sid, firstName, lastName);
                    repo.createSalesMan(salesMan);
                    System.out.println("A salesman has been inserted successfully!");
                }
                break;

                // find a salesman by sid
                case 2: {
                    System.out.println("Enter a sid: ");
                    int sid = intScanner.nextInt();
                    SalesMan salesMan = repo.readSalesMan(sid);
                    System.out.println(salesMan.toString());
                }
                break;

                //update a salesman info
                case 3: {
                    System.out.println("Enter a sid: ");
                    int sid = intScanner.nextInt();

                    System.out.println("Enter first name: ");
                    String firstName = stringScanner.nextLine();

                    System.out.println("Enter last name: ");
                    String lastName = stringScanner.nextLine();

                    SalesMan salesMan = new SalesMan(sid, firstName, lastName);
                    repo.UpdateSalesMan(salesMan);

                    System.out.println("A salesman has been successfully updated!");

                }
                break;

                // delete a salesman by sid
                case 4: {
                    System.out.println("Enter a sid: ");
                    int sid = intScanner.nextInt();
                    repo.DeleteSalesMan(sid);

                    System.out.println("A salesman has been successfully deleted!");
                }
                break;

                //insert a new evaluation record
                case 5: {
                    EvaluationRecord ev = null;
                    OrdersEvaluation or = new OrdersEvaluation();
                    SocialPerformance sp = null;

                    System.out.println("Enter a sid: ");
                    int sid = intScanner.nextInt();
                    System.out.println("Enter a year: ");
                    int year = intScanner.nextInt();
                    System.out.println("/******* A) Orders Evaluation *******/");

                    while(true){
                        System.out.println("Enter a name of a product: ");
                        String product = stringScanner.nextLine();
                        if(product.equals(""))
                            break;

                        Product prod = new Product();
                        prod.setName(product);

                        while(true){
                            System.out.println("Enter a name of a client: ");
                            String client = stringScanner.nextLine();
                            if(client.equals(""))
                                break;
                            System.out.println("Enter a client ranking: ");
                            String ranking = stringScanner.nextLine();
                            System.out.println("Enter # of items: ");
                            int item = intScanner.nextInt();
                            Client cli = new Client(client, ranking, item);
                            prod.addClient(cli);
                        }

                        or.addProducts(prod);
                    }

                    System.out.println("/******* B) Performance Evaluation *******/");
                    System.out.println("Enter a value of Leadership Competence: ");
                    int lead = intScanner.nextInt();
                    System.out.println("Enter a value of Openness to Employee: ");
                    int open = intScanner.nextInt();
                    System.out.println("Enter a value of Social Behaviour to Employee: ");
                    int behaviour = intScanner.nextInt();
                    System.out.println("Enter a value of Attitude towards Client: ");
                    int att = intScanner.nextInt();
                    System.out.println("Enter a value of Communication skills: ");
                    int comm = intScanner.nextInt();
                    System.out.println("Enter a value of Integrity of Company: ");
                    int integrity = intScanner.nextInt();

                    sp = new SocialPerformance(lead, open, behaviour, att, comm, integrity);

                    ev = new EvaluationRecord(null, sid, year, or, sp);
                    repo.addPerformanceRecord(ev, sid);
                    System.out.println("An evaluation record has been inserted successfully!");

                }
                break;

                // find an evaluation record by sid
                case 6: {
                    System.out.println("Enter a sid: ");
                    int sid = intScanner.nextInt();
                    EvaluationRecord ev = repo.readEvaluationRecords(sid);
                    System.out.println(ev.toString());
                }
                break;

                // update an evaluation record
                case 7: {
                    EvaluationRecord ev = null;
                    OrdersEvaluation or = new OrdersEvaluation();
                    SocialPerformance sp = null;

                    System.out.println("Enter a sid: ");
                    int sid = intScanner.nextInt();
                    if(repo.readEvaluationRecords(sid) != null) {

                        System.out.println("Enter a year: ");
                        int year = intScanner.nextInt();
                        System.out.println("/******* A) Orders Evaluation *******/");

                        while (true) {
                            System.out.println("Enter a name of a product: ");
                            String product = stringScanner.nextLine();
                            if (product.equals(""))
                                break;

                            Product prod = new Product();
                            prod.setName(product);

                            while (true) {
                                System.out.println("Enter a name of a client: ");
                                String client = stringScanner.nextLine();
                                if (client.equals(""))
                                    break;
                                System.out.println("Enter a client ranking: ");
                                String ranking = stringScanner.nextLine();
                                System.out.println("Enter # of items: ");
                                int item = intScanner.nextInt();
                                Client cli = new Client(client, ranking, item);
                                prod.addClient(cli);
                            }

                            or.addProducts(prod);
                        }

                        System.out.println("/******* B) Performance Evaluation *******/");
                        System.out.println("Enter a value of Leadership Competence: ");
                        int lead = intScanner.nextInt();
                        System.out.println("Enter a value of Openness to Employee: ");
                        int open = intScanner.nextInt();
                        System.out.println("Enter a value of Social Behaviour to Employee: ");
                        int behaviour = intScanner.nextInt();
                        System.out.println("Enter a value of Attitude towards Client: ");
                        int att = intScanner.nextInt();
                        System.out.println("Enter a value of Communication skills: ");
                        int comm = intScanner.nextInt();
                        System.out.println("Enter a value of Integrity of Company: ");
                        int integrity = intScanner.nextInt();

                        sp = new SocialPerformance(lead, open, behaviour, att, comm, integrity);

                        ev = new EvaluationRecord(null, sid, year, or, sp);

                        repo.UpdateEvaluationRecord(ev);
                        System.out.println("The evaluation record has been updated successfully!");
                    }
                    else{
                        System.out.println("Invalid sid!");
                    }
                }
                break;

                case 8: {
                    System.out.println("Enter a sid: ");
                    int sid = intScanner.nextInt();
                    repo.DeleteEvaluationRecords(sid);
                    System.out.println("The evaluation record has been successfully deleted!");
                }
                break;

                case 9: {
                    System.out.println("Enter an attribute: ");
                    String att = stringScanner.nextLine();
                    System.out.println("Enter a key: ");
                    String key = stringScanner.nextLine();
                    List<SalesMan> list = repo.querySalesMan(att, key);
                    for(SalesMan salesMan: list){
                        System.out.println(salesMan.toString());
                    }

                }
                break;

                case -1: {
                    System.out.println("terminate the execution...");
                    return;
                }

            }


        }
    }
}
