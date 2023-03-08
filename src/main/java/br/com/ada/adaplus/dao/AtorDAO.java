package br.com.ada.adaplus.dao;

import br.com.ada.adaplus.model.Ator;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AtorDAO {
    private static List<Ator> atores = new ArrayList<>();
    private static int proximoId = 1;

    public void adicionar(Ator ator) {
        ator.setId(proximoId++);
        atores.add(ator);
    }

    public void atualizar(Ator ator) {
        for (int i = 0; i < atores.size(); i++) {
            Ator a = atores.get(i);
            if (a.getId() == ator.getId()) {
                atores.set(i, ator);
                break;
            }
        }
    }

    public void remover(int id) {
        atores.removeIf(a -> a.getId() == id);
    }

    public Ator buscarPorId(int id) {
        return atores.stream()
                .filter(a -> a.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Ator> buscarAtor() {
        return atores;
    }

}
