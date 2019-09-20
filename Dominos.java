import java.lang.*;


public class Dominos
{


    /**
     * Constructor for objects of class Dominos
     */
    public Dominos()
    {
        
    }
    
    public int solve(int x1, int y1, int x2, int y2) {
        if (x1 == x2 && y1 == y2) {
            return 0;
        }
        if(y1 == y2) { //if our points are lined up horizontally
            return Math.abs(x1 - x2);
        }
        if (x1 == x2) { // if our points are lined up vertically
            if (y1 < y2) { //if our source is BELLOW our dest
                if (y1 % 2 == x1 % 2) { //if y1 and x1 are both even OR both odd we can go up
                    return 1 + solve(x1, y1 + 1, x2, y2);
                }
                else //y1 and x1 aren't both even or both odd so we must move to the side
                {
                    return 1 + solve(x1 + 1, y1, x2, y2);
                }
            }
            else //we must go down
            {
                if(y1 % 2 != x1 % 2) { // in order to move down, even/odd cannot match
                    return 1 + solve(x1 , y1 - 1, x2, y2);
                }
                else // even / odd do match so we must move side
                {
                    return 1 + solve(x1 + 1, y1, x2, y2);
                }
            }
        }
        if (y1 < y2) { // our source is BELLOW our destination
            if (x1 < x2) { //our source is bellow AND to the left of our dest
                if (y1 % 2 == x1 % 2) { // even odd must match for us to be able to go UP
                    return 1 + solve(x1, y1 + 1, x2, y2);
                }
                else // even / odd of x1, y1 don't match so to be able to go up we must first go to the side
                {
                    return 1 + solve(x1 + 1, y1, x2, y2);
                }
            }
            else // our source is bellow AND to the right of our destf
            {
                if (y1 % 2 == x1 % 2) { // even odd must match for us to be able to go UP
                    return 1 + solve(x1, y1 + 1, x2, y2);
                }
                else // even / odd of x1, y1 don't match so to be able to go up we must first go to the side
                {
                    return 1 + solve(x1 - 1, y1, x2, y2);
                }
            }
        }
        else // our source is ABOVE our dest
        {
            if (x1 < x2) { //our source is above AND to the left of our dest
                if (y1 % 2 != x1 % 2) { // even odd must NOT match for us to be able to go DOWN
                    return 1 + solve(x1, y1 - 1, x2, y2); // move source down one
                }
                else // even / odd of x1, y1 do match so to be able to go DOWN we must first go to the side
                {
                    return 1 + solve(x1 + 1, y1, x2, y2); // move source to the right by one
                }
            }
            else // our source is ABOVE AND to the right of our dest
            {
                if (y1 % 2 != x1 % 2) { // even odd must NOT match for us to be able to go DOWN
                    return 1 + solve(x1, y1 - 1, x2, y2); // move source DOWN by one
                }
                else // even / odd of x1, y1 don't match so to be able to go up we must first go to the side
                {
                    return 1 + solve(x1 - 1, y1, x2, y2);
                }
            }            
        }
    }
    
    public static void main(String[] args){
        Dominos problem = new Dominos();
        System.out.println(problem.solve(2, 2, 3, 2) + "\n");
        System.out.println(problem.solve(2, 12, 2, 3) + "\n");
        System.out.println(problem.solve(1, 9, 5, 5) + "\n");
        System.out.println(problem.solve(7, 8, 4, 2) + "\n");
        System.out.println(problem.solve(9, 7, 3, 6) + "\n");
        System.out.println(problem.solve(1, 1, 8, 4));
        
    }

}
