package Ativos;

import java.util.ArrayList;

import Utilitarios.ItemDoacao;
import Utilitarios.Usuario;

public class listagem {
   
   public static void listagemDoacoes(ArrayList<ItemDoacao> arrDoa){
      if(!arrDoa.isEmpty()){
         for(ItemDoacao i : arrDoa){
           System.out.println(i.getNome() + "\nEstado: " + i.getEstado() + "\nDescrição: " + i.getDescricao() + "\nNome doador: " + i.getUser().getNome() + "\n");
         }
       }else{
         System.out.println("\nAinda nao ha elementos aqui\n\n");
       }
   }

   public static void listagemDoadores(ArrayList<Usuario> pilhaDoadores){
      if(!pilhaDoadores.isEmpty()){
         for(Usuario i : pilhaDoadores){
           System.out.println(i.getNome() + "\nID: " + i.getCpf() + "\n");
         }
       }else{
         System.out.println("\nAinda nao ha elementos desse tipo\n\n");
       }
   }

}
