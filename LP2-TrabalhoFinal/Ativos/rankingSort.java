package Ativos;

import java.util.ArrayList;
import java.util.Collections;
import Utilitarios.Usuario;

public class rankingSort {
 

   public static void ranking(ArrayList<Usuario> pilhaDoadores){
      Collections.sort(pilhaDoadores, Collections.reverseOrder());
      if(!pilhaDoadores.isEmpty()){
         for(Usuario i : pilhaDoadores){
            if(!i.getCpf().equals("0")){
               System.out.println(i.getNome() + "\nID:" + i.getCpf() + "\nPontuação:" + i.getPontuacao() + "\n");
            }
         }
      }else{
         System.out.println("\nAinda nao ha elementos aqui\n\n");
      }
   }
}
