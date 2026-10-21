package br.com.suaempresa.restaurante.controller;

import br.com.suaempresa.restaurante.model.Produto;
import br.com.suaempresa.restaurante.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public String listarProdutos(Model model) {
        model.addAttribute("produtos", produtoService.listarTodos());
        return "produto/lista";
    }

    @GetMapping("/novo")
    public String formularioNovoProduto(Model model) {
        model.addAttribute("produto", new Produto());
        return "produto/formCadastro";
    }

    @GetMapping("/editar/{id}")
    public String formularioEditarProduto(@PathVariable Long id, Model model) {
        Produto produto = produtoService.buscarPorId(id);
        if (produto == null) {
            return "redirect:/produtos";
        }
        model.addAttribute("produto", produto);
        return "produto/formCadastro";
    }

    @PostMapping
    public String salvarProduto(@ModelAttribute Produto produto) {
        if (produto.getId() == null) {
            produtoService.cadastrar(produto);
        } else {
            produtoService.atualizar(produto.getId(), produto);
        }
        return "redirect:/produtos";
    }

    @GetMapping("/remover/{id}")
    public String deletarProduto(@PathVariable Long id) {
        produtoService.remover(id);
        return "redirect:/produtos";
    }
}
