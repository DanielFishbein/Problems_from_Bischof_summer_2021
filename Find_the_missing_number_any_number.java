import java.math.BigInteger;


// By Daniel Fishbein
// 7/30/2021

/*
Problem: Given a list of all number from 1 -> N, in random order, but one is missing.  
Find the missing number.

Solution: Add all the given numbers together and minus it from the total sum of the numbers.
Whats left is the missing number.
*/ 

public class Find_the_missing_number_any_number {
    public static void main(String[] args){
        
        // Initial contitions
        BigInteger final_number = new BigInteger("2");
        final_number = final_number.pow(64);
        //BigInteger final_number = new BigInteger("100");
        
        BigInteger one_hundred = new BigInteger("100");
        
        BigInteger progress_total = final_number.divide(one_hundred);
        BigInteger sum_with_missing = new BigInteger("0");

        // Calculating the sum_expected_formula of all numbers
        BigInteger one = new BigInteger("1");
        BigInteger two = new BigInteger("2");
        BigInteger sum_expected_formula = (final_number.add(one)).multiply(final_number.divide(two));
        BigInteger missing_number = new BigInteger("132534");
        BigInteger i = new BigInteger("0");
        int progress = 0;


        // For loop through the numbers
        while(i.compareTo(final_number) == -1){
            i = i.add(one);
            
            // The missing number to skip
            if (missing_number.compareTo(i) == 0){
               continue;
            }

            // A Progress checker
            if ( i.remainder(progress_total).compareTo(one) == 0){
                progress = progress + 1;
                System.out.println(progress);
            }
            
            sum_with_missing = sum_with_missing.add(i);
            
            
        }
        // Final print statements in both decmal and hex format
        System.out.println("------------------------FINAL PRINT---------------------------");
        System.out.println(progress + " progress " + String.format("0x%x", progress));
        System.out.println(sum_with_missing + " sum_with_missing " + String.format("0x%x", sum_with_missing));
        System.out.println(sum_expected_formula + " hex sum_expected_formula " + String.format("0x%x", sum_expected_formula));
        System.out.println((sum_expected_formula.subtract(sum_with_missing)) + " calcualted missing number " + String.format("0x%x", sum_expected_formula.subtract(sum_with_missing)));
        System.out.println(missing_number + " expected missing number " + String.format("0x%x", missing_number));
    }
}   