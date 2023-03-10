package br.com.ada.adaplus.model;

import java.time.LocalDateTime;

public class Filme {
    private Integer id;
    private String titulo;
    private String genero;
    private String duracao;
    private String sinopse;
   // private String imdb;
    private String imagem;
    private int like = 0;
     private int deslike = 0;
     private boolean favorito = false;

    public Filme() {

    }

    public Filme(Integer id, String titulo, String genero, String duracao, String sinopse,  String imagem, int like) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.duracao = duracao;
        this.sinopse = sinopse;
        this.imagem = imagem;
        this.like = like;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDuracao() {
        return duracao;
    }

    public void setDuracao(String duracao) {
        this.duracao = duracao;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }
  
    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDeslike() {
        return deslike;
    }

    public void setDeslike(int deslike) {
        this.deslike = deslike;
    }

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }
}
