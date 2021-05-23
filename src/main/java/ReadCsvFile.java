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


                String line_new="";
                int number_of_dcotes = 0;
                for(int i=0; i<line.length();i++){
                    if(Character.compare(line.charAt(i), '\"') == 0){
                        number_of_dcotes++;
                        line_new = line_new + line.charAt(i);

                    }else if((Character.compare(line.charAt(i), ',') == 0) && (number_of_dcotes%2 == 1)){
                        line_new = line_new + ";";

                    }else{
                        line_new = line_new + line.charAt(i);
                    }
                }


                String[] attributes = line_new.split(",");
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

        String title = metadata[0].replaceAll(";",",");
        String company = metadata[1].replaceAll(";",",");
        String location = metadata[2];
        String type = metadata[3];
        String level = metadata[4];
        String year = metadata[5];
        String country = metadata[6];
        String skills = metadata[7].replaceAll(";",",");


        // create and return Pyramid of this metadata
        return new JobDetails(title, company, location, type, level, year, country, skills);
    }

}
