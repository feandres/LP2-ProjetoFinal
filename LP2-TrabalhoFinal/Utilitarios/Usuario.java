package Utilitarios;


public class Usuario implements Comparable< Usuario >, java.io.Serializable{
  protected String nome;
  protected String cpf;
  protected Double pontuacao;

  public Usuario(String nome, String cpf){
    this.nome = nome;
    this.cpf = cpf;
    this.pontuacao = 0.0;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getCpf() {
    return this.cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public void setPontuacao(Double pont){
    this.pontuacao = pont;
  }

  public void somaPont(Double pont){
    this.pontuacao = pont;
  }

  public Double getPontuacao(){
    return this.pontuacao;
  }
  @Override
    public int compareTo(Usuario o) {
        return this.getPontuacao().compareTo(o.getPontuacao());
    }

}
