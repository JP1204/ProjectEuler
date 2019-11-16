import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem13 {
    public static void main(String args[]) throws FileNotFoundException {
        // find the first ten digits of a one-hundred 50 digit numbers
        // import the file
        String currentPath = System.getProperty("user.dir");
        File file = new File(currentPath + "/src/problem13_series.txt");
        Scanner scan = new Scanner(file);

        ArrayList<String> numbers = new ArrayList<>();
        while(scan.hasNextLine()){
            String num = scan.nextLine();
            numbers.add(num);
            // System.out.println(num);
        }

        int numLength = 50;
        int carry = 0;
        int value = 0;
        int sum;
        StringBuilder sum_str = new StringBuilder("");
        // System.out.println(sum_str.toString() + " this is the stringbuilder");
        for(int i = numLength-1; i >= 0; i--) {
            sum = 0;
            for (int j = 0; j < numbers.size(); j++) {
                // System.out.println(Character.getNumericValue(numbers.get(j).charAt(i)));
                sum += Character.getNumericValue(numbers.get(j).charAt(i));
            }
            sum += carry;
            carry = sum / 10;
            value = sum % 10;

            char c = (char) (value+'0');
            if(i < 10)
                sum_str.append(c);
        }

        System.out.println("carry: " + carry);
        System.out.println("first 10 digits are " + sum_str.toString());
    }
}
