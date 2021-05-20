// this class use to store value of jobs in object.

public class JobDetails {
    private String title;
    private String company;
    private String location;
    private String type;
    private String level;
    private String year;
    private String country;
    private String skills;

    public JobDetails(String title, String company, String location, String type, String level, String year, String country, String skills) {
        this.title = title;
        this.company = company;
        this.location = location;
        this.type = type;
        this.year = year;
        this.level = level;
        this.country = country;
        this.skills = skills;
    }

    @Override
    public String toString() {
        return  "title=" + this.title + ", country=" + this.country + ", yeatExp=" + year + ", company=" + company;
    }


    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }

    public void setCompany(String company){
        this.company = company;
    }
    public String getCompany(){
        return this.company;
    }

    public void setLocation(String location){
        this.location = location;
    }
    public String getLocation(){
        return this.location;
    }

    public void setType(String type){
        this.type = type;
    }
    public String getType(){
        return this.type;
    }

    public void setLevel(String level){
        this.level = level;
    }
    public String getLevel(){
        return this.level;
    }

    public void setYear(String yearExp){
        this.year = yearExp;
    }
    public String getYear(){
        return this.year;
    }

    public void setCountry(String country){
        this.country = country;
    }
    public String getCountry(){
        return this.country;
    }

    public void setSkills(String skills){
        this.skills = skills;
    }
    public String getSkills(){
        return this.skills;
    }
}
