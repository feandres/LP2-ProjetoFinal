package Ativos;

import java.util.ArrayList;
import java.util.Scanner;
import Utilitarios.ItemDoacao;

public class BaixaDoacao {
   
   public static void emitirDoacao(ArrayList<ItemDoacao> pilhaDoacoes, ArrayList<ItemDoacao> doacoesEmitidas, Scanner in){

      if(!pilhaDoacoes.isEmpty()){
         System.out.println("\nQual tipo de doação para dar baixa?\n1-roupa\n2-alimentos nao pereciveis\n3-eletrodomesticos\n4-dinheiro\n5-brinquedo\n6-cobertas\n7-remedios\n8-utensilios domesticos\n9-Outro\n0-Sair\n");
         int menuB = in.nextInt();
         in.nextLine();          
         switch (menuB){
            case 1:
               if(!pilhaDoacoes.isEmpty()){
                  for(ItemDoacao i : pilhaDoacoes){
                     if(i.getNome().contentEquals("Roupa")){
                     doacoesEmitidas.add(i);
                     pilhaDoacoes.remove(i);
                     break;
                     }
                  }
               }else{
                  System.out.println("\nAinda nao ha elementos desse tipo\n\n");
               }
               break;
            case 2:
               if(!pilhaDoacoes.isEmpty()){
                  for(ItemDoacao i : pilhaDoacoes){
                     if(i.getNome().contentEquals("Alimento nao perecivel")){
                        doacoesEmitidas.add(i);
                        pilhaDoacoes.remove(i);
                        break;
                     }
                  }
               }else{
               System.out.println("\nAinda nao ha elementos desse tipo\n\n");
               }
               break;
            case 3:
               if(!pilhaDoacoes.isEmpty()){
                  for(ItemDoacao i : pilhaDoacoes){
                     if(i.getNome().contentEquals("Eletrodomestico")){
                        doacoesEmitidas.add(i);
                        pilhaDoacoes.remove(i);
                        break;
                     }
                  }              
               }else{
                  System.out.println("\nAinda nao ha elementos desse tipo\n\n");
               }
               break;
            case 4:
               if(!pilhaDoacoes.isEmpty()){
                  for(ItemDoacao i : pilhaDoacoes){
                     if(i.getNome().contentEquals("Dinheiro")){
                        doacoesEmitidas.add(i);
                        pilhaDoacoes.remove(i);
                        break;
                     }
                  }
               }else{
                  System.out.println("\nAinda nao ha elementos desse tipo\n\n");
               }
               break;
           case 5:
               if(!pilhaDoacoes.isEmpty()){
                  for(ItemDoacao i : pilhaDoacoes){
                     if(i.getNome().contentEquals("Brinquedo")){
                        doacoesEmitidas.add(i);
                        pilhaDoacoes.remove(i);
                        break;
                     }
                  }
               }else{
                  System.out.println("\nAinda nao ha elementos desse tipo\n\n");
               }
               break;
           case 6:
               if(!pilhaDoacoes.isEmpty()){
                  for(ItemDoacao i : pilhaDoacoes){
                     if(i.getNome().contentEquals("Cobertas")){
                        doacoesEmitidas.add(i);
                        pilhaDoacoes.remove(i);
                        break;
                     }
                  } 
               }else{
                  System.out.println("\nAinda nao ha elementos desse tipo\n\n");
               }
               break;
           case 7:
               if(!pilhaDoacoes.isEmpty()){
                  for(ItemDoacao i : pilhaDoacoes){
                     if(i.getNome().contentEquals("Remedios")){
                        doacoesEmitidas.add(i);
                        pilhaDoacoes.remove(i);
                        break;
                     }
                  }
               }else{
                  System.out.println("\nAinda nao ha elementos desse tipo\n\n");
               }
               break;
           case 8:
               if(!pilhaDoacoes.isEmpty()){
                  for(ItemDoacao i : pilhaDoacoes){
                     if(i.getNome().contentEquals("Utensilios domesticos")){
                        doacoesEmitidas.add(i);
                        pilhaDoacoes.remove(i);
                        break;
                     }
                   }
               }else{
                  System.out.println("\nAinda nao ha elementos desse tipo\n\n");
               }
               break;
            case 9:
               break;
            default:
               System.out.println("Entrada invalida");
            }
      }else{
         System.out.println("\nAinda nao ha elementos aqui\n\n");
      }
   }
}

