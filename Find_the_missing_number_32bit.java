// By Daniel Fishbein
// 7/30/2021

public class Find_the_missing_number_32bit {
    public static void main(String[] args){
        
        // Initial contitions
        long final_number = 1L << 32;
        long progress_total = final_number/100L;
        int progress = 0;
        long sum_with_missing = 0L;

        // Calculating the sum_expected_formula of all numbers
        long sum1 = final_number/2;
        long sum_expected_formula = (final_number+1)*sum1;
        int missing_number = 324532;

        // For loop through the numbers
        for (long i = final_number; i >= 1; i--){

            // The missing number to skip
            if (i == missing_number){
               continue;
            }

            // A Progress checker
            if (i % progress_total == 0){
                progress = progress + 1;
                System.out.println(progress);
            }
            
            sum_with_missing = sum_with_missing + i;
            
            
        }
        // Final print statements in both decmal and hex format
        System.out.println("------------------------FINAL PRINT---------------------------");
        System.out.println(progress + " progress " + String.format("0x%x", progress));
        System.out.println(sum_with_missing + " sum_with_missing " + String.format("0x%x", sum_with_missing));
        System.out.println(sum_expected_formula + " hex sum_expected_formula " + String.format("0x%x", sum_expected_formula));
        System.out.println((sum_expected_formula - sum_with_missing) + " calcualted missing number " + String.format("0x%x", sum_expected_formula - sum_with_missing));
        System.out.println(missing_number + " expected missing number " + String.format("0x%x", missing_number));
    }
}   