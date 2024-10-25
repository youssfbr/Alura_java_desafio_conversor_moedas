package com.github.youssfbr.conversor.aplicacao;

import com.github.youssfbr.conversor.utils.Converter;

public class Principal {
    public static void main(String[] args) {

        final Converter converter = new Converter();
        System.out.println("\n" + converter.getConverter("BRL"));
    }
}
