package com.example.prova.Controllers;


import com.example.prova.Model.ProdutoModel;
import com.example.prova.Services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> BuscarTodosProdutos(){
        List<ProdutoModel> requisicao = this.produtoService.buscarTodos();
        return ResponseEntity.ok().body(requisicao);
    }

    @GetMapping({"/{id}"})
    public Optional<ProdutoModel> BuscarProdutoPorId(@PathVariable Long id){
        return this.produtoService.buscarPorId(id);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<?> DeletarProduto(@PathVariable Long id) {
        this.produtoService.deletarPorId(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> CriarProdutos(@RequestBody ProdutoModel produtoModel){
        ProdutoModel request = produtoService.criarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri()
                .path("/{id}").buildAndExpand(request.getId())
                .toUri();

        return ResponseEntity.created(uri).body(request);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<ProdutoModel> AtualizarProdutoPorId(@PathVariable Long id, @RequestBody ProdutoModel produtoModel){
        ProdutoModel requisicao = this.produtoService.atualizarProduto(produtoModel, id);
        return ResponseEntity.ok().body(requisicao);
    }


}
