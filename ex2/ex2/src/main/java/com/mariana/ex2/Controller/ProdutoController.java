package com.mariana.ex2.Controller;

import com.mariana.ex2.Model.ProdutoModel;
import com.mariana.ex2.Service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoModel> criarProduto(@RequestBody ProdutoModel produtoModel){
        ProdutoModel request = produtoService.criarProduto(produtoModel);

        URI uri = URI.create("/produtos/" + request.getId());
        return ResponseEntity.created(uri).body(request);
    }

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> listarProdutos(){
        List<ProdutoModel> request = produtoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoModel> buscarIdProduto(@PathVariable Long id){
        Optional<ProdutoModel> request = produtoService.buscarIdProduto(id);

        if(request.isPresent()){
            return ResponseEntity.ok(request.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}