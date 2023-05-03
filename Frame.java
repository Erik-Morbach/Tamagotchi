import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;

/**
 * Write a description of class Frame here.
 *
 * @author Erik
 * @version 1.0.0
 */
public class Frame
{
    private ArrayList<String> data;
    public ArrayList<String> getData() { return this.data; }
    public void setData(ArrayList<String> data) { this.data = data; }

    public boolean loadFromFile(File file){
        if(!(file.exists() && file.isFile())) return false;
        this.data = new ArrayList<String>();
        try{
            InputStream is = new FileInputStream(file);
            String currentLine = "";
            while(is.available()!=0){
                char c = (char)is.read();
                if(c=='\n') {
                    this.data.add(currentLine);
                    currentLine = "";
                    continue;
                }
                currentLine += c;
            }
            is.close();
        } catch(Exception e){
        }
        return true;
    }
}
