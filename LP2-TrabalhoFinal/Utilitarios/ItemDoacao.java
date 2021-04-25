package Utilitarios;

public class ItemDoacao implements java.io.Serializable{
  private String nome;  
  private String estado;  
  private String descricao;
  private String foto;
  private Usuario user;
  private Double pontuacao;

  public ItemDoacao(String nome, String estado, String descricao, String foto, Usuario user){
    this.nome = nome;
    this.estado = estado;
    this.descricao = descricao;
    this.foto = foto;
    this.user = user;
    this.pontuacao = 0.0;
  }


  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEstado() {
    return this.estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getFoto() {
    return this.foto;
  }

  public void setFoto(String foto) {
    this.foto = foto;
  }

  public Usuario getUser(){
    return this.user;
  }

  public void setUser(Usuario user){
    this.user = user;
  }

  public Double getPontuacao(){
    return this.pontuacao;
  }

  public void setPontuacao(Double pont){
    this.pontuacao = pont;
  }
}