package Ativos;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import Utilitarios.ItemDoacao;
import Utilitarios.Usuario;
import java.awt.Desktop;  

public class ReadFile {
    
  public static ArrayList<Usuario> readBinFileDoador(File checkFile1){
    File checkDir = new File("files");
    try {  
      if(checkDir.exists()){
        if(checkFile1.exists()){
          ArrayList<Usuario> useraux = new ArrayList<>();
          FileInputStream arDoadores = new FileInputStream("files/doadores.bin");
          ObjectInputStream fiDoadores = new ObjectInputStream(arDoadores);
          useraux = (ArrayList) fiDoadores.readObject();
          boolean flagA = false;
          for(Usuario e : useraux){
            if(e.getNome().contentEquals("Anonimo")){
              flagA = true;
            }
          }
          if(!flagA){
            Usuario userAnon = new Usuario("Anonimo", "0");
            useraux.add(userAnon);
          }
          fiDoadores.close();
          return useraux;
        }
      }
    }catch (IOException i){
      i.printStackTrace();
    }catch (ClassNotFoundException c){
      System.out.println("Class not found");
      c.printStackTrace();
    }
    return null;
  }


  public static ArrayList<ItemDoacao> readBinFileDoacaoAbertas(File checkFile2){
    File checkDir = new File("files");
    try {  
      if(checkDir.exists()){
        if(checkFile2.exists()){
          ArrayList<ItemDoacao> doacoesaux = new ArrayList<>();
          FileInputStream arDoacoesEmi = new FileInputStream("files/doacoesabertas.bin");
          ObjectInputStream doaEmitidasFile = new ObjectInputStream(arDoacoesEmi);
          doacoesaux = (ArrayList) doaEmitidasFile.readObject();
          arDoacoesEmi.close();
          return doacoesaux;
        }
      }
    }catch (IOException i){
      i.printStackTrace();
    }catch (ClassNotFoundException c){
      System.out.println("Class not found");
      c.printStackTrace();
    }
    return null;
  }

  public static ArrayList<ItemDoacao> readBinFileDoacaoEmitidas(File checkFile2){
    File checkDir = new File("files");
    try {  
      if(checkDir.exists()){
        if(checkFile2.exists()){
          ArrayList<ItemDoacao> doacoesaux = new ArrayList<>();
          FileInputStream arDoacoesEmi = new FileInputStream("files/doacoesemitidas.bin");
          ObjectInputStream doaEmitidasFile = new ObjectInputStream(arDoacoesEmi);
          doacoesaux = (ArrayList) doaEmitidasFile.readObject();
          arDoacoesEmi.close();
          return doacoesaux;
        }
      }
    }catch (IOException i){
      i.printStackTrace();
    }catch (ClassNotFoundException c){
      System.out.println("Class not found");
      c.printStackTrace();
    }
    return null;
  }


  
   public static void readHTML(File relat){
     try{
      Desktop desktop = Desktop.getDesktop();  
      if(Desktop.isDesktopSupported()){
        if(relat.exists()){    
          desktop.open(relat);             
        }  
      }else{
        System.out.println("Nao suportado");
      } 
   }catch(NullPointerException n){
     System.out.println("Nao é possivel ler");
   }catch(Exception e){
     e.printStackTrace(); 
   }
  } 
}
