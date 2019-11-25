package com.victorze.atm;

import java.util.Scanner;

public class ATMScreen {

	private Scanner sc = new Scanner(System.in);

	public void showStartMenu() {
		System.out.println(" ------------------------ ");
		System.out.println("|     MENU PRINCIPAL     |");
		System.out.println("|     Banco Nacional     |");
		System.out.println("|                        |");
		System.out.println("|1. Inserte su tarjeta   |");
		System.out.println("|2. Salir                |");
		System.out.println(" ------------------------ ");
	}

	public void showMainMenu() {
		System.out.println(" ------------------------ ");
		System.out.println("|     Banco Nacional     |");
		System.out.println("|                        |");
		System.out.println("|1. Consultar saldo      |");
		System.out.println("|2. Depositar            |");
		System.out.println("|3. Retirar              |");
		System.out.println("|4. Salir                |");
		System.out.println(" ------------------------ ");
	}

	public int readOption() {
		System.out.print("Ingrese una opción: ");
		while (!sc.hasNextInt()) {
			System.out.println("La opción ingresada no es válida.");
			System.out.print("Ingrese una opción: ");
			sc.next();
		}
		return sc.nextInt();
	}

	public String readCardNumber() {
		System.out.print("Ingrese el número de tarjeta: ");
		return sc.next();
	}

	public String readPinCode() {
		System.out.print("Ingrese su clave: ");
		return sc.next();
	}

	public double readAmountDeposit() {
		System.out.print("Ingrese el monto a depositar: ");
		while (!sc.hasNextDouble()) {
			System.out.println("La opción ingresada no es válida.");
			System.out.print("Ingrese el monto a depositar: ");
			sc.next();
		}
		double amount = sc.nextDouble();
		if (amount <= 0) {
			System.out.println("El monto debe ser mayor que cero.");
			amount = readAmountDeposit();
		}
		return amount;
	}

	public double readAmountWithdrawal() {
		System.out.print("Ingrese el monto a retirar: ");
		while (!sc.hasNextDouble()) {
			System.out.println("La opción ingresada no es válida.");
			System.out.print("Ingrese el monto a retirar: ");
			sc.next();
		}
		double amount = sc.nextDouble();
		if (amount <= 0) {
			System.out.println("El monto debe ser mayor que cero.");
			amount = readAmountWithdrawal();
		}
		return amount;
	}

	public void seeBalance(double balance) {
		System.out.printf("Saldo: %.2f soles.%n", balance);
	}

	public void msgSuccessfullyAmount(double amount) {
		System.out.printf("Se depositó %.2f soles con éxito.%n", amount);
	}

	public void msgSuccessfullyWithdrawal(double amount) {
		System.out.printf("Ha retirado %.2f soles con éxito.%n", amount);
	}

	public void msgInsufficientFunds() {
		System.out.println("No tiene fondos suficientes.");
	}

	public void msgExitApp() {
		System.out.println("Programa finalizado.");
	}

	public void msgInvalidCard() {
		System.out.println("Número de tarjeta o clave inválido.");
	}

	public void pressEnterContinue() {
		sc = new Scanner(System.in);
		System.out.println("Presione enter para continuar...");
		sc.nextLine();
	}

	public void msgInvalidCode() {
		System.out.println("El código ingresado no es válido.");
	}
}
