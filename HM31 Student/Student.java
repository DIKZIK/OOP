import java.util.Arrays;

public class Student {

    private String fio;
    private String initials;
    private String group;
    final int numberOfRating = 5;
    int[] rating = new int[numberOfRating];


    public Student(String fio, String initials, String group, int[] rating) {

        this.fio = fio;
        this.initials = initials;
        this.group = group;
        this.rating = rating;
    }

    public int getNumberOfRating() {

        return numberOfRating;
    }

    public String getFio() {

        return fio;
    }

    public int[] getRating() {

        return rating;
    }

    public String getGroup() {

        return group;
    }

    public String getInitials() {

        return initials;
    }

    public String getStudentInfo() {

        StringBuilder sb = new StringBuilder();
        sb.append(fio).append(" ").append(initials).append(" ").append(group).append(" ").append(Arrays.toString(rating));
        return sb.toString();
    }

}