package br.senai.sp.jandira.model;

import java.util.Scanner;

public class Venda {
    Scanner teclado = new Scanner(System.in);

    public double valorEntrada;

    public boolean realizarVenda(Veiculo objVeiculo, Cliente objCliente){

        if (objCliente.dinheiroDisponivel >= objVeiculo.preco){

            System.out.println("-------------------- Parabéns -------------------");
            System.out.println("Olá " + objCliente.nome);
            System.out.println("Você acaba de adquirir um " + objVeiculo.modelo);
            System.out.println("No valor de " + objVeiculo.preco);
            System.out.println("-------------------------------------------------");

            return true;


        } else {
            System.out.println("Vamos realizar um financiamento!");
            return false;
        }
    }

    public boolean avaliarFormaPagamento(Cliente cliente, Veiculo veiculo){

        System.out.println("=========================================");
        System.out.println("Bem vindo a área de financiamento!");
        System.out.println("1- À vista");
        System.out.println("2- Financiamento");
        System.out.println("=========================================");

        int formaPagamento = teclado.nextInt();
        teclado.nextLine();

        if (formaPagamento == 1){
            return true;
        } else {
            return false;
        }
    }

    public boolean realizarFinanciamento(Cliente cliente, Veiculo veiculo){
        System.out.println("============= Financiamento ===============");
        System.out.println("Informe o valor da entrada: ");
        double valorEntrada = teclado.nextDouble();
        System.out.println("Informe quantas parcelas: ");
        int parcelas = teclado.nextInt();
        teclado.nextLine();

        if (valorEntrada <= cliente.dinheiroDisponivel && valorEntrada > 0){
            double valorFinanciado = veiculo.preco - valorEntrada;
            double valorParcelas = valorFinanciado / parcelas;
            System.out.println("O valor das parcelas será de: " + valorParcelas);
            return true;
        }
        return false;
    }
}
