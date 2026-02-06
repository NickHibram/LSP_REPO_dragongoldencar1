package org.howard.edu.lsp.assignment2;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/*• ProductID (integer)
• Name (string)
• Price (decimal number)
• Category (string)
 */
public class ETLPipeline {
    /**
 * Name: Nicholas Abram
 */

    public static void main(String[] args) {
        int count =0;
        int csvProductID;
        double csvPrice;
        String csvName;
        String csvCategory;
        String csvPriceRange;


        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("test.csv"));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("transformed_products.csv"))
            ){
            
            String file_line;
            if((file_line = bufferedReader.readLine()) == null){
                bufferedWriter.write("ProductID,Name,Price,Category,PriceRange");
            }
            while ((file_line = bufferedReader.readLine()) != null){
                // Everything Above is just to get the file read properly 
                //I am going to put the respective cols in an array
                if(count ==0){
                    bufferedWriter.write("ProductID,Name,Price,Category,PriceRange");
                    bufferedWriter.newLine();
                    count++;
                    continue;
                }
                String[] fieldFromCSVStrings = file_line.split(",");
                /*
                DATA CLEANING 
                    */
                // Ensuring there arent too many fields 
                if(fieldFromCSVStrings.length!=4){
                    continue;
                }


                csvName = fieldFromCSVStrings[1].trim();
                csvCategory = fieldFromCSVStrings[3].trim();

                // This block is to see if the productID and Price is a number if not skip this line
                try{
                    csvProductID = Integer.parseInt(fieldFromCSVStrings[0].trim());
                }
                catch (NumberFormatException e){
                    continue;
                }
                try{
                    csvPrice = Double.parseDouble(fieldFromCSVStrings[2].trim());
                }
                catch (NumberFormatException e){
                    continue;
                }

                /*
                DATA CLEANING ENDS
                */
                // Setting the products name to uppercase
                csvName = csvName.toUpperCase();
                
                
                //If "Electronics", 10% discount to the price.
                if(csvCategory.equals("Electronics")){
                    //System.out.println("Old Price: " + csvPrice);
                    csvPrice = csvPrice *0.90; 
                    csvPrice = Math.round(csvPrice * 100.0) / 100.0;
                    //System.out.println("New Price" + csvPrice);
                }
                   
                // if Discount Electronics Price is <500 make it Premium Electronics
                if(csvCategory.equals("Electronics")&& csvPrice>500){
                    csvCategory = "Premium Electronics";
                }
                
                // adding in Price Range
                if(csvPrice<=10){
                    csvPriceRange= "Low";
                }else if(csvPrice>10 && csvPrice<=100){
                    csvPriceRange = "Medium";
                }else if(csvPrice>100 && csvPrice<=500){
                    csvPriceRange = "High";
                }
                else{
                    csvPriceRange = "Premium";
                }


                String csvPriceFormatted = String.format("%.2f", csvPrice);
                bufferedWriter.write(csvProductID+","+csvName+ ","+ csvPriceFormatted+","+csvCategory+ ","+csvPriceRange);
                bufferedWriter.newLine();
                // System.out.println(Arrays.toString(fieldFromCSVStrings));
                // System.out.println(csvProductID+" "+csvName+ " "+ csvPrice+" "+csvCategory+ " "+csvPriceRange);
                count++;
            }
            System.out.println("Data Successfully Extracted");
        }catch (IOException e ){
            System.out.println("Error Reading/Writing File"+ e.getMessage());
        }
        
        



    }
}
