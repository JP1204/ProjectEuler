import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem18 {
    public static void main(String args[]) throws FileNotFoundException {
        // find largest path from top to bottom of a pyramid
        // get triangle into dynamic array list
        File triangle_txt = new File(System.getProperty("user.dir") + "/src/triangle.txt/");
        Scanner scan = new Scanner(triangle_txt);
        ArrayList<ArrayList<Integer>> triangle = new ArrayList<>();

        while(scan.hasNextLine()){
            ArrayList<Integer> row = new ArrayList<>();
            String numbers = scan.nextLine();
            String [] arrayOfNum = numbers.split(" ");
        System.out.println(numbers);
            for(int i = 0; i < arrayOfNum.length; i++){
                row.add(Integer.valueOf(arrayOfNum[i]));
            }

            triangle.add(row);
        }

        int baseSize = triangle.get(triangle.size()-1).size();
        // dynamic programming to find largest path
        int [][] largestPath = new int [baseSize][baseSize];
        largestPath[0][0] = 59;     // path has to have the tip

        // calculate largest path from current number to the top
        for(int currentRow = 1, rowSize = 2; currentRow < triangle.size(); currentRow++, rowSize++){
            for(int i = 0; i < rowSize; i++){
                Integer topNum;
                Integer topLeftNum;
                Integer num = triangle.get(currentRow).get(i);

                if(i == 0){
                    topNum = largestPath[currentRow-1][i];
                    largestPath[currentRow][i] = num + topNum;
                }
                else if(i == (rowSize-1)){
                    topLeftNum = largestPath[currentRow-1][i-1];
                    largestPath[currentRow][i] = num + topLeftNum;
                }
                else{
                    topNum = largestPath[currentRow-1][i];
                    topLeftNum = largestPath[currentRow-1][i-1];
                    largestPath[currentRow][i] = num + Math.max(topNum, topLeftNum);
                }
            }
        }

        for(int currentRow = 0, rowSize = 1; currentRow < triangle.size(); currentRow++, rowSize++){
            for(int j = 0; j < rowSize; j++){
                System.out.print(largestPath[currentRow][j] + " ");
            }
            System.out.println();
        }

        int maxPath = 0;
        for(int i = 0; i < baseSize; i++){
            int baseRow = triangle.size()-1;
            maxPath = Math.max(maxPath, largestPath[baseRow][i]);
        }
        System.out.println("The largest path is " + maxPath);
    }
}
