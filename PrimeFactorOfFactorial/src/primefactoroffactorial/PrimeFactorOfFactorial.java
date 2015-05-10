/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primefactoroffactorial;

import java.util.Scanner;

/**
 *
 * @author Naima
 */
public class PrimeFactorOfFactorial {
    
    boolean IsPrime(int n){
        if(n <= 3)
            return n > 1;
        if(n % 2 == 0 || n % 3 == 0)
            return false;
        int root = (int)Math.floor(Math.sqrt(n));
        for(int i = 5; i < root; i += 6){
            if(n % i == 0 || n % (i+2) == 0)
                return false;
        }
        return true;
    }
    
    int Input(){
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PrimeFactorOfFactorial pf = new PrimeFactorOfFactorial();
        System.out.println("Enter a number between 1-100 to see if it's prime or not");
        int n = pf.Input();
        String str = pf.IsPrime(n)? "Prime" : "Not Prime";
        System.out.println(str);
    }
    
}
