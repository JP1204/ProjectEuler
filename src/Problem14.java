public class Problem14 {
    public static void main(String args[]){
        // find the starting number under 1 million that produces the
        // longest collatz chain
        // use table to look up remaining chain length
        long startTime = System.nanoTime();
        int maxChain = 0;
        int startingNum = 1;
        collatzTable[1] = 1;    // ending one

        for(int i = 2; i < 1000000; i++){
            int chainLength = findCollatzLength(i);
            if(chainLength > maxChain){
                maxChain = chainLength;
                startingNum = i;
            }
        }

        for(int i = 2; i < 30; i++){
           // System.out.println(collatzTable[i]);
        }

        System.out.println("max chain is " + maxChain + " and starting num is " + startingNum);
        long endTime = System.nanoTime();
        System.out.println("elapsed time = " + (endTime-startTime));
    }

    private static int findCollatzLength(long num){
        if(num > 1000000 && num%2 ==0){
            int chainLength = 1 + findCollatzLength(num/2);
            return chainLength;
        }
        else if(num > 1000000){
            int chainLength = 1 + findCollatzLength(3*num+1);
            return chainLength;
        }
        else if(num < 1000000 && collatzTable[(int) num] != 0){
            int i = (int) num;
            return collatzTable[i];
        }
        else if(num%2 == 0){
            int chainLength = 1 + findCollatzLength(num/2);
            collatzTable[(int) num] = chainLength;
            return chainLength;
        }
        else{
            int chainLength = 1 + findCollatzLength(3*num+1);
            collatzTable[(int) num] = chainLength;
            return chainLength;
        }
    }

    private static int table_size = 1000001;
    private static int [] collatzTable = new int[table_size];
}
