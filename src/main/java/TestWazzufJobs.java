import org.knowm.xchart.QuickChart;
import org.knowm.xchart.XYChart;
import tech.tablesaw.api.DoubleColumn;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;

import java.util.List;

public class TestWazzufJobs {

    //test method to sure that code it run well
    public void test(){
        ReadCsvFile file  = new ReadCsvFile();
        System.out.println("============Start to read CSV file============");
        System.out.println();

        List<JobDetails> jobDetailsList = file.readWazzufJobsFromCSV("I:\\ITI\\month I\\java\\Assignment\\Wazzuf_Egypt_Jobs\\resource\\Wuzzuf_Jobs.csv");
        System.out.println("============Finish to read Wazzuf _Jobs file and create list of job row============");
        System.out.println();

        //create object filter to can access method in filter class.
        JobsDataService filterJob = new JobsDataService();

        System.out.println("================Coded By MhmdSyd!==================");
        System.out.println();

        System.out.println("=====================Filter Jobs By Title==========================");
        System.out.println(filterJob.filterJobsByTitle(jobDetailsList));
        System.out.println();

        System.out.println("=====================Filter Jobs By Country==========================");
        System.out.println(filterJob.filterJobsByCountry(jobDetailsList));
        System.out.println();

        System.out.println("=====================Filter Jobs By Level==========================");
        System.out.println(filterJob.filterJobsByLevel(jobDetailsList));
        System.out.println();

        System.out.println("=====================Sorted Filter Jobs By YearsExp==========================");
        System.out.println(filterJob.filterJobsByYearsExp(jobDetailsList));
        System.out.println();

//        System.out.println("==================Sorted Filter Jobs By YearsExpj another way=================");
//        filterJob.filterJobsByYearsExp(jobDetailsList).forEach((key, value) -> System.out.println(key + " = " + value));
//        System.out.println();

        //create table of two column (filtered column and it's frequency.
        //create object form TableSaw Class.
        TableSaw table = new TableSaw();
        Table t;
        System.out.println("=====================Created Table==========================");
        //we create table from yearsExp column and it's frequency.
        t = table.createTable(filterJob.filterJobsByYearsExp(jobDetailsList),"filterJobsByTitle");
        //print table.
        System.out.println(t.print());

        System.out.println("=====================Display Chart==========================");
        //create chart object.
        XChart chat = new XChart();
        chat.createChart(filterJob.filterJobsByLevel(jobDetailsList),"filterJobsByYearsExp",20);

    }
}
