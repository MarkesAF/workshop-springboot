package com.marques.projeto.enums;

import jakarta.persistence.criteria.Order;

public enum PedidoStatus {

    WAITING_PAYMENT(1),
    PAID(2),
    SHIPPED(3),
    DELIVERED(4),
    CANCEL(5);


    private int code;


    private PedidoStatus(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }

    public static PedidoStatus valueOf(int code){
        for(PedidoStatus value : PedidoStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Codigo do Status do Pedido inválido");
    }
}
