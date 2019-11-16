import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Problem11 {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File(System.getProperty("user.dir") + "/src/problem11_grid.txt");
        Scanner scan = new Scanner(file);


        ArrayList<ArrayList<Integer>> grid = new ArrayList<>();
       //  int numRows =
        while(scan.hasNextLine()){
            ArrayList<Integer> row = new ArrayList<>();
            String s = scan.nextLine();
            String[] strs = s.split(" ");

            for(int i = 0; i < strs.length; i++){
                row.add(Integer.parseInt(strs[i]));
            }
            grid.add(row);
        }

        int numRows = grid.size();
        int numCols = grid.get(0).size();
        for(int i = 0; i < grid.size(); i++){
            for(int j = 0; j < grid.get(i).size(); j++){
                System.out.print(grid.get(i).get(j) + " ");
            }
            System.out.println();
        }

        long largestProduct = 0;
        // search up/down and left/right
        for(int i = 0; i < numRows-4; i++){

        }

    }
}
