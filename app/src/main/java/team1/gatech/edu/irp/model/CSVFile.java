package team1.gatech.edu.irp.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/****************************************************************************************
 *    CSV FILE READER
 *    Notes: Reads in the CSV File separated by commas. Each line is a separate location
 ****************************************************************************************
 */

class CSVFile {
    private final InputStream inputStream;

    public CSVFile(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public List<String[]>  read(){
        List<String[]> resultList = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        try {
            String csvLine = reader.readLine();
            while (csvLine != null) {
                String[] row = csvLine.split(",");
                resultList.add(row);
                csvLine = reader.readLine();
            }
            inputStream.close();
        }
        catch (IOException ex) {
            throw new RuntimeException("Error in reading CSV file: "+ex);
        }
        return resultList;
    }


//    public List<String[]>  read(){
//        List<String[]> resultList = new ArrayList<>();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//        try {
//            String csvLine;
//            while ((csvLine = reader.readLine()) != null) {
//                String[] row = csvLine.split(",");
//                resultList.add(row);
//            }
//            inputStream.close();
//        }
//        catch (IOException ex) {
//            throw new RuntimeException("Error in reading CSV file: "+ex);
//        }
//        return resultList;
//    }


}
