/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package primefactoroffactorial;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Naima
 */
public class PrimeFactorOfFactorial {
    ArrayList<Integer> _primeArray = new ArrayList<>();
    
     void Print(ArrayList<Integer> primeFactors){
        primeFactors.stream().forEach((factor)->{
            System.out.print(factor+", ");
        });
        System.out.println();
    }
     
    void Init(){
          InitPrimeFactorList();
    }
    
    void InitPrimeFactorList (){ 
        for(int i = 0; i < 100; i++){
            if(IsPrime(i))
                _primeArray.add(i);
        }
    }
    
    ArrayList<Integer> GetPrimeFactors(int n){
        ArrayList<Integer> primeFactors = new ArrayList<>(); 
        if(IsPrime(n) || n == 1){
            primeFactors.add(n);
            if(n != 1)
                primeFactors.add(1);
            return primeFactors;
        }
        int newN = n;
        while(!IsPrime(newN) && (newN > 1)){
            for (Integer num : _primeArray) {
                if(newN % num == 0){
                    primeFactors.add(num);
                    newN /= num;
                    break;
                }
            }
        }
        if(IsPrime(newN))
            primeFactors.add(newN);
        return primeFactors;
    }
    
    boolean IsPrime(int n){
        if(n <= 3)
            return n > 1;
        if(n % 2 == 0 || n % 3 == 0)
            return false;
        int root = (int)Math.floor(Math.sqrt(n));
        for(int i = 5; i <= root; i += 6){
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
        pf.Init();
        System.out.println("Enter a number between 1-100 to see it's prime factors");
        System.out.println("Enter out of range number to exit");
        int n = pf.Input();
        while(n >= 1 && n <= 100){
            pf.Print(pf.GetPrimeFactors(n));
            n = pf.Input();
        }
    }
    
}
