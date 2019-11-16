
public class Problem12 {
    public static void main(String args[]){
        // find the first triangle number with over
        // 500 divisors

        // skip the first 1000 triangle numbers (sure it's not the answer)
        int triangleNum = 0;
        for(int i = 0; i < 10000; i++) {
            triangleNum += i;
        }

        for(int i = 10000; findNumDivisors(triangleNum) < 500; i++){
            System.out.println(triangleNum);
            triangleNum += i;
        }

        System.out.println("The first triangle number with over 500 divisors is " + triangleNum);

    }

    private static int findNumDivisors(int triangleNum){
        int numDivisors = 0;
        for(int i = 1; i < Math.sqrt(triangleNum); i++){
            if(triangleNum % i == 0){
                numDivisors += 2;
            }
        }
        return numDivisors;
    }
}
