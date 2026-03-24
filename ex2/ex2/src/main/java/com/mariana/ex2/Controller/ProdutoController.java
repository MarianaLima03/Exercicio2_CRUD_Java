package com.mariana.ex2.Controller;

import com.mariana.ex2.Model.ProdutoModel;
import com.mariana.ex2.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ProdutoModel criarProduto(@RequestBody ProdutoModel produtoModel){
        return produtoService.criarProduto(produtoModel);
    }

    @GetMapping
    public List<ProdutoModel> listarProdutos(){
        return produtoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> buscarIdProduto(@PathVariable Long id){
        return produtoService.buscarIdProduto(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
    }
}
