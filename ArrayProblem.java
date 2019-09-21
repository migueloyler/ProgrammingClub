
import java.util.ArrayList;
import java.util.List;

/** 
*The following if a solution to a programming question from Daily Code Interview Questions. Uses Dynamic programming
*
*Good morning! Here's your coding interview problem for today.
*
*This problem was asked by Google.
*
*Given an array of integers, return a new array where each element in the new array is the number of smaller elements to the right of that element in the original input array.
*
*For example, given the array [3, 4, 9, 6, 1], return [1, 1, 2, 1, 0], since:
*
*There is 1 smaller element to the right of 3
*There is 1 smaller element to the right of 4
*There are 2 smaller elements to the right of 9
*There is 1 smaller element to the right of 6
*There are no smaller elements to the right of 1
 */

public class ArrayProblem
{

    /**
     * Constructor for objects of class ArrayProblem
     */
    public ArrayProblem()
    {
        
    }
    
    public ArrayList<Integer> solve(ArrayList<Integer> input, ArrayList<Integer> output, int arrIndex) {
        int nextElement = arrIndex + 1;
        int changeFlag = 0;
        if (arrIndex == input.size() - 1) { //check if we are at last element in the array
            output.set(arrIndex, 0); //if it is, then output must be zero on this index
        }
        while (nextElement < input.size()){
            if (input.get(arrIndex) > input.get(nextElement)) {
                if (output.get(nextElement) != null) { //check if we already have the answer in our solution / output table
                    //this is where dynamic programming magic happens
                    output.set(arrIndex, 1 + output.get(nextElement));
                    changeFlag = 1;
                    break; 
                }
                else
                {
                    int recursiveStep = solve(input, output, nextElement).get(nextElement);
                    output.set(arrIndex, recursiveStep + 1);
                    changeFlag = 1;
                    break;
                }
            }
            solve(input, output, nextElement);
            nextElement++;
        }
        if (changeFlag == 0) {
            output.set(arrIndex, 0);
        }
        return output;
    }
    
    public static void main(String[] args) {
        ArrayProblem problem = new ArrayProblem();
        ArrayList<Integer> input = new ArrayList<Integer>();
        input.add(3);
        input.add(4);
        input.add(9);
        input.add(6);
        input.add(1);
        ArrayList<Integer> output = new ArrayList<Integer>();
        for (int i = 0; i < input.size(); i++) {
            output.add(null);
        }
        ArrayList<Integer> solution = problem.solve(input, output, 0);
        for (int i = 0; i < solution.size(); i++) {
            System.out.println(solution.get(i));
        }
    }

}
