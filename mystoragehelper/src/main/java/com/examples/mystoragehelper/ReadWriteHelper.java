package com.examples.mystoragehelper;

import android.content.Context;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import static android.content.Context.MODE_PRIVATE;




public class ReadWriteHelper {

    public static void writeFile(Context context,String fileName,String fileContent){

        try{
            FileOutputStream fileout = context.openFileOutput(fileName + ".txt", MODE_PRIVATE);
            OutputStreamWriter outputWriter=new OutputStreamWriter(fileout);
            outputWriter.write(fileContent);
            outputWriter.close();

            //display file saved message
            Toast.makeText(context, "File saved successfully!",
                    Toast.LENGTH_SHORT).show();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String readFile(Context context,String fileName) {
        String s = "";
        try {
            FileInputStream fileIn = context.openFileInput(fileName + ".txt");
            InputStreamReader InputRead = new InputStreamReader(fileIn);

            char[] inputBuffer = new char[100];

            int charRead;

            while ((charRead = InputRead.read(inputBuffer)) > 0) {
                // char to string conversion
                String readstring = String.copyValueOf(inputBuffer, 0, charRead);
                s += readstring;
            }
            InputRead.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

        return s;
    }
}
