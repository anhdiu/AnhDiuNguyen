package busDriverManagementFile;

import busDriverManagement.BusDriverManagement;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class BusDriverManagentSaveFile {
    private static final String BusDriverManagent_Save_File = "busDriverManagement.txt";

    public static  void Write (List<BusDriverManagement> busDriverManagementList){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(BusDriverManagent_Save_File));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(busDriverManagementList);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }
    /*
    * read list busDriverManagementList from file
    * */
    public List< BusDriverManagement> read (){
        List<BusDriverManagement> busDriverManagementList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fis = new FileInputStream(new File(BusDriverManagent_Save_File));
            ois = new ObjectInputStream(fis);
            List<BusDriverManagement> BusDriverManagentSaveFile = (List<BusDriverManagement>) ois.readObject();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e){
            e.printStackTrace();

        } finally {
            closeStream ( fis);
            closeStream ( ois);
        }
        return busDriverManagementList;
    }

    /**
     * close input Stream
     * */
    private static void closeStream (InputStream is){
        if (is != null){
            try {
                is.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private static void closeStream ( OutputStream os){
        if (os != null){
            try {
                os.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
