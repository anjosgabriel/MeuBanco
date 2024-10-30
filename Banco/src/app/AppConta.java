package app;

import java.util.Locale;
import java.util.Scanner;

import entities.Corrente;


public class AppConta {
	

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner leia = new Scanner (System.in);
		double valor = 0.00;
		char op;
		int selecao;
		int niver;
		
	
		Corrente c1 = new Corrente (1,"111.111.111-11");
		
		
		System.out.println("Osasbank\nBanco de uma conta so");
		
		System.out.println("Selecione uma conta\n\n1 - Poupanca\n2 - Corrente");
		selecao = leia.nextInt();
		
		if(selecao==2) {
		
		c1.ativar();
		System.out.println("Saldo inicial conta R$"+c1.getSaldo());
		
		for(int x=1; x<=2;x++) {
			
			System.out.println("Movimento:"+x);
			System.out.print("\nDigite o valor R$");
			valor = leia.nextDouble();
			if(valor < 0) {
			System.out.println("digite um valor valido");
			System.out.println("Movimento:"+x);
			System.out.print("\nDigite o valor R$");
			valor = leia.nextDouble();
			}else {
		
			System.out.print("\nD-debito ou C-credito:");
			op = leia.next().toUpperCase().charAt(0);
			if(op=='D') {
				if(c1.getSaldo() < valor) {
					System.out.println("\nNao e possivel debitar um valor maior que o saldo");
				}else {
					c1.debito(valor);
				}
			
			
		}
		else if (op=='C') {
			c1.credito(valor);
		}
			System.out.println("\nSalario atual R$"+c1.getSaldo());
		
			}
		}
		System.out.println("Deseja solicitar cheques? (S/N): ");

    	char resposta = leia.next().toUpperCase().charAt(0);

    	if (resposta == 'S') {

    	    System.out.println("Quantos cheques voce deseja solicitar? (Limite: 3): ");

    	    int quantidadeCheques = leia.nextInt();

    	    if (quantidadeCheques > 0 && quantidadeCheques <= 3) { 

    	        double valorTotalCheques = quantidadeCheques * 30.00; 

    	        if (valorTotalCheques <= c1.getSaldo()) { 

    	            c1.debito(valorTotalCheques); 

    	            System.out.println("Cheques solicitados com sucesso! Saldo atual: " + c1.getSaldo());

    	        } else {

    	            System.out.println("Saldo insuficiente para solicitar os cheques!");

    	        }

    	    	} else {

    	    		System.out.println("Quantidade de cheques invalida!");

    	    	}

    			}
    			
    			else{
    				System.out.println("Sessao finalizada!");
    			}
		
		}
		
	}
}