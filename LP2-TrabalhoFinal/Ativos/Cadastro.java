package Ativos;
import java.util.Scanner;
import java.util.ArrayList;
import Utilitarios.Usuario;
import Utilitarios.ItemDoacao;

public class Cadastro{

   public static Usuario cadastroUser(Scanner input){
      System.out.println("Insira um nome: ");
      String nome = input.nextLine();
      System.out.println("Insira um ID: ");
      String cpf = input.nextLine();
      Usuario user = new Usuario(nome, cpf);
      return user;
   }

   public static boolean checaCPF(ArrayList<Usuario> arrDoador, String cpf){
      boolean flagA = true;
      for(Usuario e : arrDoador){
        if(e.getCpf().contentEquals(cpf)){
          System.out.println("\nID inválido, tente novamente.\n");
          flagA = false;
          break;
        }
      }
      if(flagA){
         System.out.println("\nSucesso.\n");
         return flagA;
      }
      return false;
   }

   public static ItemDoacao cadastrarDoacao(Scanner in){
      String tipoaux = "";
      String descaux = "";
      String estado = "null";
      String foto = "pic.png";

      int menuD = 0;
      Double pontuacao = 0.0;

      System.out.println("Qual item");
      System.out.println("1-roupa\n2-alimentos nao pereciveis\n3-eletrodomesticos\n4-dinheiro\n5-brinquedo\n6-cobertas\n7-remedios\n8-utensilios domesticos\n9-Outro\n0-Sair\n");
      menuD = in.nextInt();
      switch (menuD){
        case 1:
          tipoaux = "Roupa";
          pontuacao += 3;
          System.out.println("Insira uma descricao");
          in.nextLine();
          descaux = in.nextLine();
          System.out.println("1-Novo\n2-Usado");
          Integer menuE = in.nextInt();
          in.nextLine();
          switch (menuE){
            case 1:
              estado = "NOVO";
              break;
            case 2:
              estado = "USADO";
              break;
            default:
              System.out.println("Entrada inválida.");
          }
          break;
        case 2:
          pontuacao += 2;
          tipoaux = "Alimento nao perecivel";
          System.out.println("Insira uma descricao");
          in.nextLine();
          descaux = in.nextLine();
          estado = "NOVO";
          break;
        case 3:
          tipoaux = "Eletrodomestico";
          pontuacao += 5;
          System.out.println("Insira uma descricao");
          in.nextLine();
          descaux = in.nextLine();
          System.out.println("1-Novo\n2-Usado");     
          menuE = in.nextInt();
          in.nextLine();
          switch (menuE){
              case 1:
              estado = "NOVO";
              break;
            case 2:
              estado = "USADO";
              break;
            default:
              System.out.println("Entrada inválida.");
          }
          break;
        case 4:
        pontuacao++;
          tipoaux = "Dinheiro";
          System.out.println("Insira uma descricao");
          in.nextLine();
          descaux = in.nextLine();
          break;
        case 5:
          tipoaux = "Brinquedo";
          pontuacao += 2;
          System.out.println("Insira uma descricao");
          in.nextLine();
          descaux = in.nextLine();
          System.out.println("1-Novo\n2-Usado");
          menuE = in.nextInt();
          in.nextLine();
          switch (menuE){
              case 1:
              estado = "NOVO";
              break;
            case 2:
              estado = "USADO";
              break;
            default:
              System.out.println("Entrada inválida.");
          }
          break;
        case 6:
          tipoaux = "Cobertas";
          pontuacao += 4;
          System.out.println("Insira uma descricao");
          in.nextLine();
          descaux = in.nextLine();
          System.out.println("1-Novo\n2-Usado");      
          menuE = in.nextInt();
          in.nextLine();
          switch (menuE){
              case 1:
              estado = "NOVO";
              break;
            case 2:
              estado = "USADO";
              break;
            default:
              System.out.println("Entrada inválida.");
          }
          break;
        case 7:
          tipoaux = "Remedios";
          pontuacao++;
          System.out.println("Insira uma descricao");
          in.nextLine();
          descaux = in.nextLine();
          break;
        case 8:
          tipoaux = "Utensilios domesticos";
          pontuacao++;
          System.out.println("Insira uma descricao");
          in.nextLine();
          descaux = in.nextLine();
          System.out.println("1-Novo\n2-Usado");
          menuE = in.nextInt();
          in.nextLine();
          switch (menuE){
            case 1:
              estado = "NOVO";
              break;
            case 2:
              estado = "USADO";
              break;
            default:
              System.out.println("Entrada inválida.");
          }
          break;
        case 9:
          System.out.println("Digite o nome do objeto a ser doado: ");
          tipoaux = in.nextLine();
          in.nextLine();
          System.out.println("Insira uma descricao");
          descaux = in.nextLine();
          System.out.println("1-Novo\n2-Usado");
          menuE = in.nextInt();
          in.nextLine();
          pontuacao++;

          switch (menuE){
            case 1:
              estado = "NOVO";
              break;
            case 2:
              estado = "USADO";
              break;
            default:
              System.out.println("Entrada inválida.");
          }
          break;
        case 0:
          break;
        default:
          System.out.println("Entrada invalida.");
      }
      ItemDoacao doacAUX = new ItemDoacao(tipoaux, estado, descaux, foto, null);
      doacAUX.setPontuacao(pontuacao);

      return doacAUX;
   }

}