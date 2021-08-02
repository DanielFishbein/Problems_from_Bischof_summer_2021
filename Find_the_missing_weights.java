import java.util.Arrays;

// By Daniel Fishbein 

public class Find_the_missing_weights {
    public static void main(String[] args){
        
        // Initial conditions
        int[] known_weights = {2,4,5,6,7};
        int[] unknown_weights = {7,5,9,16,14};
        int[] learned_weights = known_weights;
        int[] array_sums = new int[known_weights.length*unknown_weights.length*2];
        int count_learned = 1;

        // A loop to go through each of the known weights
        // This loop increases with size as more weights are descovered
        for (int sum_tracker = 0; sum_tracker < learned_weights.length; sum_tracker++){

            // A loop to go through each combination of weights based on the known weights
            for (int number_of_weights = sum_tracker + 1; number_of_weights <= learned_weights.length; number_of_weights++){
                
                // Recreating variables that will be used through each itteration of the known weights
                int[] current_weights = new int[number_of_weights];
                int current_sum = 0;
                
                // A loop to populate the currently used weights into an array and find the sum of those weights
                for (int populate = sum_tracker; populate < number_of_weights; populate++){
                    current_weights[populate] = learned_weights[populate];
                    current_sum = current_sum + learned_weights[populate];
                    }

                // A loop to check if the sum of weights beeing checked has already been found.
                // The is a small optimization since the algorithum does not need to go through 
                // combinations that it has already checked
                // Resetting the value of "broken" 
                boolean broken = false;
                for (int check_sum = 0; check_sum < count_learned; check_sum++){
                    // End the loop if the sum has already been used
                    if (array_sums[check_sum] == current_sum){
                        broken = true;
                        break;
                    }

                    // End the loop if all known combinations have been checked and add this new summ
                    if (check_sum == count_learned - 1){
                        array_sums[count_learned] = current_sum;
                        count_learned = count_learned + 1;
                        break;
                    }   
                }

                // If a new sum is found
                if (broken == false){

                    // Compare it to each of the unknown weights
                    for (int check_unknown = 0; check_unknown < unknown_weights.length; check_unknown++){
                        
                        // If an unknown weight is found
                        if (current_sum == unknown_weights[check_unknown]){
                            
                            // Create a new array of learned weights that is one longer than the previous itteration
                            int new_learned_weights[] = Arrays.copyOf(learned_weights, learned_weights.length + 1);
                            
                            // Add the now known weight to the end of this new array
                            new_learned_weights[learned_weights.length] = current_sum;
                            
                            // Rewrite the old array of learned weights with the updated array of known weights 
                            learned_weights = Arrays.copyOf(new_learned_weights, new_learned_weights.length);
                            
                            // End the loop
                            break;
                        }
                    }
                }
            }           
        }
        // Final print statments stating what was found
        System.out.println(Arrays.toString(array_sums) + " unique sums found");
        System.out.println(Arrays.toString(known_weights) + " known weights");
        System.out.println(Arrays.toString(unknown_weights) + " unknown weights");
        System.out.println(Arrays.toString(learned_weights) + " learned weights");

    }
}


