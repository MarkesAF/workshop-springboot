package com.marques.projeto.entities;

import com.marques.projeto.entities.pk.PedidoItemPK;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tb_pedido_item")
public class PedidoItem {
    @EmbeddedId
    private PedidoItemPK id;
    private Integer quantity;
    private Double price;

    public PedidoItem(){
    }

    public PedidoItem(Pedido pedido, Produto produto,Integer quantity, Double price){
        id.setPedido(pedido);
        id.setProduto(produto);
        this.quantity = quantity;
        this.price = price;
    }

    public Pedido getPedido(){
        return id.getPedido();
    }
    public void setPedido(Pedido pedido){
        id.setPedido(pedido);
    }
    public Produto getProduto(){
        return id.getProduto();
    }
    public void setProduto(Produto produto){
        id.setProduto(produto);
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PedidoItem that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
