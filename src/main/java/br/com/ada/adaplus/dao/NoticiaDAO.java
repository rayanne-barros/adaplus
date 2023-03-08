package br.com.ada.adaplus.dao;

import br.com.ada.adaplus.model.Noticia;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NoticiaDAO {
    private static List<Noticia> noticias = new ArrayList<>();
    private static int proximoId = 1;

    public void adicionar(Noticia noticia) {
        noticia.setId(proximoId++);
        noticias.add(noticia);
    }

    public void atualizar(Noticia noticia) {
        for (int i = 0; i < noticias.size(); i++) {
            Noticia n = noticias.get(i);
            if (n.getId() == noticia.getId()) {
                noticias.set(i, noticia);
                break;
            }
        }
    }

    public void remover(int id) {
        noticias.removeIf(n -> n.getId() == id);
    }

    public Noticia buscarPorId(int id) {
        return noticias.stream()
                .filter(n -> n.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Noticia> buscarTodos() {
        return noticias;
    }

}
