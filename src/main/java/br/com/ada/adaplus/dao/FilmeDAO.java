package br.com.ada.adaplus.dao;

import br.com.ada.adaplus.model.Filme;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class FilmeDAO {

    private static ObjectMapper objectMapper = new ObjectMapper();
    private static List<Filme> filmes = new ArrayList<>();
    private static int proximoId = 1;

    static {
        try {
            filmes = objectMapper.readValue(
                    new File("src/main/java/br/com/ada/adaplus/database/filmes.json"),
                    new TypeReference<>() {});
            if (filmes.size() >0) proximoId = filmes.get(filmes.size() -1).getId() + 1;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void adicionar (Filme filme) {
        filme.setId(proximoId++);
        filmes.add(filme);
        salvar();
    }

    public void atualizar(Filme filme) {
        for (int i = 0; i < filmes.size(); i++) {
            Filme f = filmes.get(i);
            if (f.getId() == filme.getId()) {
                filmes.set(i, filme);
                break;
            }
        }
        salvar();
    }

    public void remover(int id) {
        filmes.removeIf(p -> p.getId() == id);
        salvar();
    }

    public Filme buscarPorId(int id) {
        return filmes.stream()
                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Filme> buscarTodos() {
        return filmes;
    }

    public void favoritar(int id){
        filmes.stream()
                .filter(filme -> filme.getId() == id)
                .forEach(filmeResponse -> filmeResponse.setFavorito(true));
        salvar();
    }
    public void desfavoritar(int id){
        filmes.stream()
                .filter(filme -> filme.getId() == id)
                .forEach(filmeResponse -> filmeResponse.setFavorito(false));
        salvar();
    }
    public void like(int id){
        filmes.stream()
                .filter(filme -> filme.getId() == id)
                .forEach(filmeResponse -> filmeResponse.setLike(filmeResponse.getLike() + 1));
        salvar();
    }
    public void deslike(int id){
        filmes.stream()
                .filter(filme -> filme.getId() == id)
                .forEach(filmeResponse -> filmeResponse.setDeslike(filmeResponse.getDeslike() + 1));
        salvar();
    }

    public List<Filme> buscarMaisLikes() {
        return filmes.stream()
                .sorted(Comparator.comparingInt(Filme::getLike).reversed())
                .limit(4).collect(Collectors.toList());
    }

    public void salvar () {
        try {
            objectMapper.writeValue(
                    new File("src/main/java/br/com/ada/adaplus/database/filmes.json"),
                    filmes);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
