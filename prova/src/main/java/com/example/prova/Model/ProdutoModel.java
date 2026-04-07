package com.example.prova.Model;


import com.example.prova.Enum.ProdutoEnum;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ProdutoModel {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    private int id;
    private String nome;
    private String descricao;
    private double preco;
    private ProdutoEnum StatusProduto;

    public ProdutoModel(){
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public ProdutoEnum getStatusProduto() {
        return StatusProduto;
    }

    public void setStatusProduto(ProdutoEnum statusProduto) {
        this.StatusProduto = statusProduto;
    }
}
