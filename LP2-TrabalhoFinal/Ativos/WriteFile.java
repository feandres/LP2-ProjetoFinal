package Ativos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import Utilitarios.ItemDoacao;
import Utilitarios.Usuario;

public class WriteFile {

   public static void writeRelatorio(ArrayList<Usuario> pilhaDoadores, ArrayList<ItemDoacao> pilhaDoacoes, ArrayList<ItemDoacao> doacoesEmitidas){
      try{
         BufferedWriter arquivoRanking = new BufferedWriter(new FileWriter("files/RelatorioDoacoes.html"));
         arquivoRanking.write("<link href=style.css rel=stylesheet type=text/css>");
         arquivoRanking.write("<div class=Titulo2><h3>RANKING</h3></div>");
         String Nome = "Nome Doador";
         String Cpf = "ID ";
         String Pontos = "Pontuacao";
         Integer contador = 1;
         arquivoRanking.write("<table><tr><th>Ranking</th><th>"+Nome+"</th><th>"+Cpf+"</th><th>"+Pontos+"</th></tr>");
         for(Usuario i : pilhaDoadores){
           if(!i.getCpf().equals("0")){
             arquivoRanking.write("</tr><tr><td>" + contador +" </td><td> "+i.getNome()+" </td><td>" +i.getCpf() + "</td>" + "</td><td>" +i.getPontuacao() + "</td></tr>");
             contador ++;
           }
         }
         arquivoRanking.write("</table>");
         arquivoRanking.write("<div class=Titulo2><h3>DOACOES EM ABERTO</h3></div>");
         arquivoRanking.write("<table><tr><th>"+"Doacao"+"</th><th>"+"Estado"+"</th><th>"+"Descricao"+"</th><th>" + "Doador"+"</th><th></tr>");
         for(ItemDoacao i : pilhaDoacoes){
              arquivoRanking.write("</tr><tr><td> "+i.getNome()+" </td><td>" +i.getEstado() + "</td>" + "</td><td>" +i.getDescricao() + "</td><td>" + i.getUser().getNome()+"</td></tr>");
         }
         arquivoRanking.write("</table>");
         arquivoRanking.write("<div class=Titulo2><h3>DOACOES EMITIDAS</h3></div>");
         arquivoRanking.write("<table><tr><th>"+"Doacao"+"</th><th>"+"Estado"+"</th><th>"+"Descricao"+"</th><th>" + "Doador"+"</th><th></tr>");
         for(ItemDoacao i : doacoesEmitidas){
             arquivoRanking.write("</tr><tr><td> "+i.getNome()+" </td><td>" +i.getEstado() + "</td>" + "</td><td>" +i.getDescricao() + "</td><td>" + i.getUser().getNome()+"</td></tr>");
         }
         arquivoRanking.write("</table>");
         arquivoRanking.close();
      }catch(IOException e){
         System.out.println("Nao é possivel ler");
      }catch(NullPointerException n){
         System.out.println("Nao é possivel ler");
      }
   }
   
   public static void writeBinFiles(ArrayList<Usuario> pilhaDoadores, ArrayList<ItemDoacao> pilhaDoacoes, ArrayList<ItemDoacao> doacoesEmitidas){
      
      try{
         File makeDir = new File("files");
         if(!makeDir.exists()){
           makeDir.mkdir();
         }
   
         ObjectOutputStream doadoresfile = new ObjectOutputStream(new FileOutputStream("files/doadores.bin"));
         doadoresfile.writeObject(pilhaDoadores);
   
         ObjectOutputStream doacAbertasfile = new ObjectOutputStream(new FileOutputStream("files/doacoesabertas.bin"));
         doacAbertasfile.writeObject(pilhaDoacoes);
   
         ObjectOutputStream doaEmitfile = new ObjectOutputStream(new FileOutputStream("files/doacoesemitidas.bin"));
         doaEmitfile.writeObject(doacoesEmitidas);
   
         doaEmitfile.close();
         doadoresfile.close();
         doacAbertasfile.close();
      }catch(IOException e){
         System.out.println("Nao é possivel ler");
      }catch(NullPointerException n){
         System.out.println("Nao é possivel ler");
      }
   }

   public static void redeemBinFiles(ArrayList<Usuario> pilhaDoadores, ArrayList<ItemDoacao> pilhaDoacoes, ArrayList<ItemDoacao> doacoesEmitidas){
      File checkDir = new File("files");
      try {  
         if(checkDir.exists()){
           File checkFile1 = new File("files/doadores.bin");
           if(checkFile1.exists()){
             FileInputStream arDoadores = new FileInputStream("files/doadores.bin");
             ObjectInputStream fiDoadores = new ObjectInputStream(arDoadores);
             pilhaDoadores = (ArrayList) fiDoadores.readObject();
             boolean flagA = false;
             for(Usuario e : pilhaDoadores){
               if(e.getNome().contentEquals("Anonimo")){
                 flagA = true;
               }
             }
             if(!flagA){
               Usuario userAnon = new Usuario("Anonimo", "0");
               pilhaDoadores.add(userAnon);
             }
             fiDoadores.close();
           }

           File checkFile2 = new File("files/doacoesemitidas.bin");
           if(checkFile2.exists()){
             FileInputStream arDoacoesEmi = new FileInputStream("files/doacoesemitidas.bin");
             ObjectInputStream doaEmitidasFile = new ObjectInputStream(arDoacoesEmi);
             doacoesEmitidas = (ArrayList) doaEmitidasFile.readObject();
             arDoacoesEmi.close();
           }

           File checkFile3 = new File("files/doacoesabertas.bin");
           if(checkFile3.exists()){
             FileInputStream arDoaAbertas = new FileInputStream("files/doacoesemitidas.bin");
             ObjectInputStream doAbertasFile = new ObjectInputStream(arDoaAbertas);
             pilhaDoacoes = (ArrayList) doAbertasFile.readObject();
             arDoaAbertas.close();
           }
         }
      }catch (IOException i){
         i.printStackTrace();
      }catch (ClassNotFoundException c){
         System.out.println("Class not found");
         c.printStackTrace();
      }
   }
}


