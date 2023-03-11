package br.com.ada.adaplus.controller;

import br.com.ada.adaplus.dao.NoticiaDAO;
import br.com.ada.adaplus.model.Noticia;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/noticia")
public class NoticiaController {
    @Autowired
    private NoticiaDAO noticiaDAO;

    @GetMapping
    public String listar(Model model) {
        List<Noticia> listaNoticias = noticiaDAO.buscarTodos();
        model.addAttribute("noticias", listaNoticias);
        return "noticia_listar";
    }

    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("noticia", new Noticia());
        return "noticia_nova";
    }
    @PostMapping("/novo")
    public String adicionar(Noticia noticia) {
        noticiaDAO.adicionar(noticia);
        return "redirect:/";
    }
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable int id, Model model) {
        Noticia noticia = noticiaDAO.buscarPorId(id);
        model.addAttribute("noticia", noticia);
        return "noticia_editar";
    }

    @PostMapping("/editar")
    public String atualizar(Noticia noticia) {
        noticiaDAO.atualizar(noticia);
        return  "redirect:/noticia";
    }

    @GetMapping("/buscar/{id}")
    public String buscarNoticia(@PathVariable int id, Model model) {
        Noticia noticia = noticiaDAO.buscarPorId(id);
        model.addAttribute("noticia", noticia);
        return "noticia_buscar";
    }

    @GetMapping("/remover/{id}")
    public String remover(@PathVariable int id) {
        noticiaDAO.remover(id);
        return "redirect:/noticia";
    }


}
