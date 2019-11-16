import java.lang.reflect.Array;
import java.util.ArrayList;

public class Problem16 {
    public static void main(String args[]){
        ArrayList<Integer> num = new ArrayList<Integer>();
        num.add(2);

        for(int i = 1; i < 1000; i++){
            num = multByTwo(num);
            for(int j = 0; j < num.size(); j++){
                System.out.print(num.get(j));
            }
            System.out.println();
        }

        int sum = 0;
        for(int i = 0; i < num.size(); i++){
            sum += num.get(i);
        }

        System.out.println("The total sum of all the digits is " + sum);
    }

    private static ArrayList<Integer> multByTwo(ArrayList<Integer> num){
        int factor = 2;
        ArrayList<Integer> result = new ArrayList<>();

        Integer carry = 0;
        for(int i = num.size()-1; i >= 0; i--){
            Integer digit = num.get(i)*2+carry;
            result.add(0, digit%10);
            carry = digit/10;
        }

        if(carry > 0){
            result.add(0, carry);
        }

        return result;
    }
}
