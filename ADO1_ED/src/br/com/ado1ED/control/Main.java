package br.com.ado1ED.control;

import br.com.ado1ED.model.Carro;
import java.util.Scanner;

/**
 *
 * @author bruga
 */
public class Main {
    
   private static final ListaSimples listaCarros = new ListaSimples();

    public static void menu() {
        Scanner leitor = new Scanner(System.in);

        System.out.println("1- Inserir carro no inicio\n"
                + "2- Inserir carro no fim \n"
                + "3- Pesquisar carro pelo modelo\n"
                + "4- Imprimir lista de carros\n"
                + "5- Remover carro pelo modelo\n"
                + "6- Remover todos \n"
                + "0- Sair");        
        
        int opc = leitor.nextInt();

        switch (opc) {
            case 0:
                System.exit(opc);
                break;
            case 1:
                inserirCarroInicio();
                break;
            case 2:
                inserirCarroFim();
                break;
            case 3:
                buscarCarro();
                break;
            case 4:
                ImprimiLista();
                break;
            case 5:
                removeCarro();
                break;
            case 6:
                removeTodos();
                break;
            default:
                System.out.println("Opção inválida.");
        }

    }

    public static void inserirCarroInicio() {
        Scanner leitor = new Scanner(System.in);
        Carro car = new Carro();

        System.out.print("Entre com modelo: ");
        car.setModelo(leitor.next().toLowerCase());
        System.out.print("Entre com marca: ");
        car.setMarca(leitor.next().toLowerCase());
        System.out.print("Entre com o ano: ");
        car.setAno(leitor.nextInt());

        listaCarros.inserirPrimeiro(car);
    }

    public static void inserirCarroFim() {
        Scanner leitor = new Scanner(System.in);
        Carro car = new Carro();

        System.out.print("Entre com modelo: ");
        car.setModelo(leitor.next().toLowerCase());
        System.out.print("Entre com marca: ");
        car.setMarca(leitor.next().toLowerCase());
        System.out.print("Entre com o ano: ");
        car.setAno(leitor.nextInt());

        listaCarros.inserirUltimo(car);
    }

    public static void buscarCarro() {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe modelo do carro: ");
        System.out.println(listaCarros.pesquisarNo(leitor.next().toLowerCase()));
    }

    public static void ImprimiLista() {
        String msg = listaCarros.imprimirLista();
        System.out.println(msg);
    }

    public static void removeCarro() {
        Scanner leitor = new Scanner(System.in);

        System.out.print("Informe modelo a ser removido: ");
        listaCarros.removerNo(leitor.next());
    }

    public static void removeTodos() {
        listaCarros.apagaLista();
    }

    public static void main(String[] args) {

        while (true) {
            menu();
        }

    }

}
