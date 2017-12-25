
package Controle;

import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Denis
 */

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jsoup.Jsoup;


public class Cep {
    
    private String cep;

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    private String endereco;
    private String bairro;
    private String estado;
    private String cidade;
 
    public Cep()
    {
    this.endereco = "";
    this.bairro = "";
    this.estado = "";
    this.cidade = "";
    
    
    }
    
    
   
    
    public Cep buscaCep(String cep) throws IOException{
    
     Cep insCep = new Cep();
     org.jsoup.nodes.Document documento = Jsoup.connect("http://www.qualocep.com/busca-cep/"+cep).userAgent("Mozilla").get();
        
       
        insCep.endereco = documento.getElementsByAttributeValue("itemprop", "streetAddress").text();
        insCep.estado = documento.getElementsByAttributeValue("itemprop","addressRegion").text();
        insCep.cidade = documento.getElementsByAttributeValue("itemprop","addressLocality").text();
        insCep.bairro = documento.getElementsByTag("td").get(2).text();
        
    
    return insCep;
    }
    
    
    public String getEndereco(){
        return this.endereco;
    }
    
    public String getBairro(){
        return this.bairro;
    }
    
    public String getCidade()
    {
    
    return this.cidade;
    }
    
    public String getEstado()
    {
    
    return this.estado;
    }
    
   /* public static void main(String [] args){
       
    
         
          new Thread(new Runnable(){

              @Override
              public void run() {
                  try {
                      // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                      System.out.println(Cep.buscaCep("01126001").getEndereco());
                  } catch (IOException ex) {
                      JOptionPane.showMessageDialog(null, "Erro ao buscar o Cep!" +ex);
                  }
              
              }
          
          
          }).start();
            
           
        }*/ 
}
