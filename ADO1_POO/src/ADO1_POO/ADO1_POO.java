package ADO1_POO;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author bruga
 */
public class ADO1_POO {

    public static void main(String[] args) {

        // nome do arquivo
        String nomeDoArquivo1 = "regioes.txt";
        String nomeDoArquivo2 = "pib.txt";

        String nome;
        String[] estados = new String[5];
        double[] pibEstados = new double[5];
        int cont = 0;

        // linha temporaria
        String linha = null;

        //Faz a leitura dos estados e popula o vetor de estados
        try {
            FileReader fileReader = new FileReader(nomeDoArquivo1);

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // loop por cada linha do arquivo
            while ((linha = bufferedReader.readLine()) != null) {

                //Pega o nome do estado             
                if (cont == 0) {
                    estados[cont] = linha;
                    cont++;
                } else if (linha.equals("")) {
                    estados[cont] = linha = bufferedReader.readLine();
                    cont++;
                }

            }

            // feche o arquivo
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + nomeDoArquivo1 + "'");
        } catch (IOException ex) {
            System.out.println("Erro lendo o arquivo '" + nomeDoArquivo1 + "'");
        }

        //  Abertura de arquivo e loop de leitura para o arquivo 2
        try {
            FileReader fileReader = new FileReader(nomeDoArquivo2);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            // loop por cada linha do arquivo
            while ((linha = bufferedReader.readLine()) != null) {

                //verifica se a linha contem o caracter de separacao ;
                if (linha.contains(";")) {

                    //Pega o nome do estado
                    nome = linha.substring(0, linha.indexOf(';'));
                    //Pega o restante
                    linha = linha.substring(linha.indexOf(';') + 1, linha.length());

                    try {
                        //Tenta converter a parte para double caso consiga soma ao valor do pib 
                        Double valor = Double.valueOf(linha).doubleValue();

                        if (nome.equals("Rondônia") || nome.equals("Acre") || nome.equals("Amazonas") || nome.equals("Roraima")
                                || nome.equals("Pará") || nome.equals("Amapá") || nome.equals("Tocantins")) {

                            for (int i = 0; i < estados.length; i++) {

                                String estadoLocal = "Norte";

                                if (estados[i].equalsIgnoreCase(estadoLocal)) {
                                    pibEstados[i] += valor;
                                }

                            }
                        }

                        if (nome.equals("Maranhão") || nome.equals("Piauí") || nome.equals("Ceará") || nome.equals("Rio Grande do Norte")
                                || nome.equals("Paraíba") || nome.equals("Pernambuco") || nome.equals("Alagoas")
                                || nome.equals("Sergipe") || nome.equals("Bahia")) {

                            for (int i = 0; i < estados.length; i++) {

                                String estadoLocal = "Nordeste";

                                if (estados[i].equalsIgnoreCase(estadoLocal)) {
                                    pibEstados[i] += valor;
                                }

                            }
                        }

                        if (nome.equals("Minas Gerais") || nome.equals("Espírito Santo") || nome.equals("Rio de Janeiro")
                                || nome.equals("São Paulo")) {

                            for (int i = 0; i < estados.length; i++) {

                                String estadoLocal = "Sudeste";

                                if (estados[i].equalsIgnoreCase(estadoLocal)) {
                                    pibEstados[i] += valor;
                                }
                            }
                        }

                        if (nome.equals("Paraná") || nome.equals("Santa Catarina") || nome.equals("Rio Grande do Sul")) {
                            // System.out.println(valor);
                            for (int i = 0; i < estados.length; i++) {

                                String estadoLocal = "Sul";

                                if (estados[i].equalsIgnoreCase(estadoLocal)) {
                                    pibEstados[i] += valor;
                                }
                            }
                        }

                        if (nome.equals("Mato Grosso do Sul") || nome.equals("Mato Grosso") || nome.equals("Goiás")
                                || nome.equals("Distrito Federal")) {

                            for (int i = 0; i < estados.length; i++) {

                                String estadoLocal = "Centro-Oeste";

                                if (estados[i].equalsIgnoreCase(estadoLocal)) {
                                    pibEstados[i] += valor;
                                }
                            }
                        }
                    } catch (NumberFormatException nfe) {
                    }
                }
            }

            // feche o arquivo
            bufferedReader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Arquivo inexistente: '" + nomeDoArquivo2 + "'");
        } catch (IOException ex) {
            System.out.println("Erro lendo o arquivo '" + nomeDoArquivo2 + "'");
        }

        //Gera arquivo Saida
        String arquivoDeSaida = "saida.txt";

        try {

            FileWriter fileWriter = new FileWriter(arquivoDeSaida);

            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            for (int j = 0; j < estados.length; j++) {
                bufferedWriter.write("pib da regiao " + estados[j] + " = " + pibEstados[j]);
                bufferedWriter.newLine();
            }

            // feche o arquivo
            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println("Erro de escrita em '" + arquivoDeSaida + "'");
        }

        //Imprime do Texto com o percentual
        double total = 0;
        for (int i = 0; i < estados.length; i++) {
            total += pibEstados[i];
        }

        double umPorcento = 100 / total;
        double vetorP[] = new double[5];

        for (int i = 0; i < estados.length; i++) {
            double porcen = 0;
            vetorP[i] = pibEstados[i] * umPorcento;
            System.out.printf(" O PIB da região %s: %f%% \n", estados[i], vetorP[i]);
        }

    }

}
