package nonuser;

import abdullahalnuman.AppendableObjectOutputStream;

import java.io.*;

public class ReadAndWriteHelper {

    public static void write(Object obj, String filename){
        File f = new File(filename);
        FileOutputStream fos;
        ObjectOutputStream oos;
        try {
            if (f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(obj);
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static ObjectInputStream read(String filename){
        File f = new File(filename);
        try {
            if (f.exists()) {
                FileInputStream fis = new FileInputStream(f);
                return new ObjectInputStream(fis);
            }
        }
        catch (Exception e){

            e.printStackTrace();
        }
        return null;
    }
}
