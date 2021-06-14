import java.xeger;

public class Check {

    public static void main(String[] args) {

        String regex = "(^[({]{1})([-])([0-9ABCDEFabcdef]{8})([-]{1})([0-9ABCDEFabcdef]{4})([-]{1})(([12345]){1}([0-9ABCDEFabcdef]{3})([-]{1})([0123]{1}([0-9ABCDEFabcdef]{4}))([-]{1})([0-9ABCDEFabcdef]{12})([)}]{1}$)";
        Xeger generator = new Xeger(regex);
        String result = generator.generate();
        assert result.matches(regex);
        System.out.println(result);
    }
}