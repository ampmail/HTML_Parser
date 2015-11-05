package excel.test2;
/**
 * Created by anirudh on 20/10/14.
 */
public class Student {

    private String name;
    private String maths;
    private String science;
    private String english;

    public Student(){}

    public Student(String name, String maths, String science, String english) {
        this.name = name;
        this.maths = maths;
        this.science = science;
        this.english = english;
    }

    //getters and setter..

    @Override
    public String toString() {
        return name+ ": Maths "+maths+ " Science "+science+" English "+english;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMaths(String maths) {
        this.maths = maths;
    }

    public void setScience(String science) {
        this.science = science;
    }

    public void setEnglish(String english) {
        this.english = english;
    }
}
