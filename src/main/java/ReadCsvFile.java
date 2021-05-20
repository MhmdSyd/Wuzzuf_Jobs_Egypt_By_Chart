import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadCsvFile {
    // Define empty Constructor
    public ReadCsvFile(){}

    public List<JobDetails> readWazzufJobsFromCSV(String fileName){

        List<JobDetails> allJob = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))){
            // read the first line from the text file which will be head column
            String line = br.readLine();
            // loop until all lines are read
            if (line != null) {
                line = br.readLine(); // the first real data
            }
            while (line != null) {
                String[] attributes = line.split(",");
                JobDetails pyr = createJobDetails(attributes);
                allJob.add(pyr);
                line = br.readLine();
            }
        }catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return allJob;
    }

    public JobDetails createJobDetails(String[] metadata) {

        String title = metadata[0];
        String company = metadata[1];
        String location = metadata[2];
        String type = metadata[3];
        String level = metadata[4];
        String year = metadata[5];
        String country = metadata[6];
        String skills = metadata[7];


        // create and return Pyramid of this metadata
        return new JobDetails(title, company, location, type, level, year, country, skills);
    }

}
