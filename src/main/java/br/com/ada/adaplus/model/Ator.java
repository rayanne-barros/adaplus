package br.com.ada.adaplus.model;

public class Ator {
    private Integer id;
    private String nome;
    private Integer idade;
    private String nacionalidade;
    private String imagem;

    public Ator() {

    }

    public Ator(Integer id,String nome, Integer idade, String nacionalidade, String imagem) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.nacionalidade = nacionalidade;
        this.imagem = imagem;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}
