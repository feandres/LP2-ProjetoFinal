import java.util.ArrayList;
import java.util.Scanner;
import Utilitarios.Usuario;
import Utilitarios.ItemDoacao;
import java.io.File;
import java.io.IOException;
import Ativos.BaixaDoacao;
import Ativos.Cadastro;
import Ativos.ReadFile;
import Ativos.WriteFile;
import Ativos.listagem;
import Ativos.rankingSort;
import java.awt.Desktop;  


class Main {
  public static void main(String[] args) throws IOException{
    
    Scanner in = new Scanner(System.in);

    int menu = 0;


    ArrayList<ItemDoacao> pilhaDoacoes = new ArrayList<>();
    ArrayList<Usuario> pilhaDoadores = new ArrayList<>();
    ArrayList<ItemDoacao> doacoesEmitidas = new ArrayList<>();

    File checkFile1 = new File("files/doadores.bin");
    if(ReadFile.readBinFileDoador(checkFile1) != null){
      pilhaDoadores = (ArrayList<Usuario>) ReadFile.readBinFileDoador(checkFile1);
    }
  
    File checkFile2 = new File("files/doacoesabertas.bin");
    if(ReadFile.readBinFileDoacaoAbertas(checkFile2) != null){
      pilhaDoacoes = (ArrayList<ItemDoacao>) ReadFile.readBinFileDoacaoAbertas(checkFile2);
    } 

    File checkFile3 = new File("files/doacoesemitidas.bin");
    if(ReadFile.readBinFileDoacaoEmitidas(checkFile3) != null){
      doacoesEmitidas = (ArrayList<ItemDoacao>) ReadFile.readBinFileDoacaoEmitidas(checkFile3);
    }
    
    System.out.println("\nMenu");
    
    do{

      System.out.println("\n1-registrar o usuario\n2-registrar doacao\n3-Exibir ranking\n4-Montar doacao\n5-Exibir doacoes em aberto\n6-Exibir doacoes emitidas\n7-Gerar relatorio\n8-Exibir usuarios\n9-Salvar dados e sair");

      menu = in.nextInt();
      in.nextLine();
      switch (menu){
        case 1:
           //Registrar Usuario
            Usuario user = Cadastro.cadastroUser(in);
            if(Cadastro.checaCPF(pilhaDoadores, user.getCpf())){
              pilhaDoadores.add(user);
            }
          break;
        case 2:
            //Registra doacao
          ItemDoacao doaux = Cadastro.cadastrarDoacao(in);
          System.out.println("\nInsira o ID do doador ou escreva '0' para doacao anonima");
          String cpf = in.nextLine();

          for(Usuario i : pilhaDoadores){
            if(i.getCpf().contentEquals(cpf)){
              i.somaPont(doaux.getPontuacao());
              doaux.setUser(i);
              pilhaDoacoes.add(doaux);
              break;
            }
          }
          break;
        case 3:
            //Imprime ranking no cmd 
            rankingSort.ranking(pilhaDoadores);
          break;
        case 4:
          //Emite doacao
            BaixaDoacao.emitirDoacao(pilhaDoacoes, doacoesEmitidas, in);
          break;
        case 5:
        //listagem doacoes abertas
          listagem.listagemDoacoes(pilhaDoacoes);
          break;
        case 6:
          //Listagem doacoes emitidas
            listagem.listagemDoacoes(doacoesEmitidas);
          break;
        case 7:
        //Gera relatorio
            WriteFile.writeRelatorio(pilhaDoadores, pilhaDoacoes, doacoesEmitidas);
            File relat = new File("files/RelatorioDoacoes.html");
            ReadFile.readHTML(relat);
          break;
        case 8:
        //Listagem usuarios
            listagem.listagemDoadores(pilhaDoadores);
          break;
        case 9:
        //Sair + gerar ficharios em binario
            WriteFile.writeBinFiles(pilhaDoadores, pilhaDoacoes, doacoesEmitidas);
          break;
        default:
          System.out.println("Entrada invalida.");
      }
    }while(menu!=9);
    in.close();
  }
}