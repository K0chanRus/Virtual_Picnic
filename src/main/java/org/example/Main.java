package org.example;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        String[] picnic_array = openFile();
        String maxNamePicnic = maxName(picnic_array);
        System.out.print("The word with the most letters: ");
        System.out.println(maxNamePicnic);
        HashMap<String, Integer> picnic = countPicnic(picnic_array);
        picnic.forEach((key, value) -> System.out.println(key + " :" + value));
    }

    public static String[] openFile(){
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("input.txt"))){
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] picnic_array = line.split(" ");
                ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(picnic_array));
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.remove("");
                }
                String[] array = arrayList.toArray(new String[0]);
                return array;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public  static String maxName(String[] array){
        int max = 0;
        String name = null;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length() > max){
                max = array[i].length();
                name = array[i];
            }
        }
        return name;
    }
    
    public static HashMap<String, Integer> countPicnic(String[] array){
        HashMap<String, Integer> picnic = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (picnic.containsKey(array[i])){
                int vale = picnic.get(array[i]) + 1;
                picnic.put(array[i], vale);
            } else {
                picnic.put(array[i], 1);
            }
        }
        return picnic;
    }
}