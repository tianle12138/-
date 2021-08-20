import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String org = scan.nextLine();
        String[] raw = org.split(" ");
        String type = raw[0];
        String var = raw[1];
        var = var.split(";")[0];
        String[] strs = var.split(",");
        int base = 1;
        if("int".equals(type)) base = 4;
        if("long".equals(type)) base = 8;
        int sum = 0;
        for (String str : strs) {
            if(str.contains("[")){
                sum += getNums(str);
            } else {
                sum ++;
            }
        }
        System.out.println(sum * base);
    }

    private static int getNums(String str) {

        String regex = "\\[(.*?)]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);
        int mul = 1;
        while (matcher.find()) {
            String s = matcher.group(1);
            mul *= Integer.parseInt(s);
        }
        return mul;
    }
}
