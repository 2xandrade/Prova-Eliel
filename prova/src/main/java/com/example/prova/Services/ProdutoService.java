package com.example.prova.Services;

import com.example.prova.Model.ProdutoModel;
import com.example.prova.Repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoModel> buscarTodos(){
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> buscarPorId(Long id){
        return produtoRepository.findById(id);
    }

    public void deletarPorId(Long id){
        produtoRepository.deleteById(id);
    }

    public ProdutoModel criarProduto(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    public ProdutoModel atualizarProduto(ProdutoModel produtoModel, Long id){
        ProdutoModel model = produtoRepository.findById(id).orElse(null);
        model.setNome(produtoModel.getNome());
        model.setDescricao(produtoModel.getDescricao());
        model.setPreco(produtoModel.getPreco());
        model.setStatusProduto(produtoModel.getStatusProduto());
        return produtoRepository.save(model);
    }

}
