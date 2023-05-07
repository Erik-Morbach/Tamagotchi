import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;

/**
 * Define um frame
 *
 * @author Erik
 * @version 1.0.0
 */
public class Frame
{
    /**
     * Array com as linhas do frame
     */
    private ArrayList<String> data;

    // Metodos de acesso para a data
    public ArrayList<String> getData() { return this.data; }
    public void setData(ArrayList<String> data) { this.data = data; }

    /**
     * Carrega o frame baseado em um arquivo .txt
     *
     * @param file Arquivo .txt com a definicao do frame
     * @return Boolean se o arquivo foi carregado com sucesso
     */
    public boolean loadFromFile(File file){
        if(!(file.exists() && file.isFile())) return false; // Arquivo errado
        this.data = new ArrayList<String>();
        try{
            InputStream is = new FileInputStream(file); // Gera uma Stream para ler o arquivo

            String currentLine = ""; // Linha atual
            while(is.available()!=0){ // Le ate nao haver mais nenhum char no arquivo
                char c = (char)is.read(); // Le o proximo caracter
                if(c=='\n') { // Caso for um fim de linha adiciona na data do frame
                    this.data.add(currentLine);
                    currentLine = ""; // Reseta a linha
                    continue;
                }
                currentLine += c;
            }
            is.close();
        } catch(Exception e){
            return false;
        }
        return true;
    }
}
