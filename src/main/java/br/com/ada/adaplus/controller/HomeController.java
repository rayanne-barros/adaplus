package br.com.ada.adaplus.controller;

import br.com.ada.adaplus.dao.FilmeDAO;
import br.com.ada.adaplus.dao.NoticiaDAO;
import br.com.ada.adaplus.model.Filme;
import br.com.ada.adaplus.model.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class HomeController {
    @Autowired
    private FilmeDAO filmeDAO;

    @Autowired
    private NoticiaDAO noticiaDAO;
    @GetMapping
    public String listar(Model model) {
        List<Filme> filmesLista = filmeDAO.buscarMaisLikes();
        List<Noticia> noticiasLista = noticiaDAO.buscarTodos();
        model.addAttribute("filmes", filmesLista);
        model.addAttribute("noticias", noticiasLista);
        return "listar";
    }
}
