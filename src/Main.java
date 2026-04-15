    package javaapplication5;

    import java.util.Scanner;

    public class Main {

        public static void main(String[] args) {
            // DECLARACAO DE ARRAYS E MATRIZES
            String[] arrayNomeHospede = new String[100];
            int[] arrayNumReserva = new int[100];
            int[] arrayNumQuarto = new int[100];
            boolean[] arrayQuartoOcupacao = new boolean[100];
            String[] produtos = {"Agua", "Refrigerante", "Suco", "Chocolate"};
            double[] precos = {5.0, 7.0, 6.0, 8.0};
            double valorDiaria = 150.0;
            int[][] frigobar = new int[100][produtos.length];

            // DECLARACAO DE VARIAVEIS
            int opc, cont = 0, i;
            String nomeHospede;
            int opccont, numReserva, numQuarto, totalHospedes = 0;
            String linha = "==================================================";
            String linhaMenor = "--------------------------------------------------";

            // CRIACAO DO SCANNER
            Scanner scan = new Scanner(System.in);
            do {
                System.out.println(linha);
                System.out.println("               HOTEL PATIXAR");
                System.out.println(linha);
                System.out.println("Selecione uma opcao:");
                System.out.println(linhaMenor);
                System.out.println("[1] Reserva de quartos");
                System.out.println("[2] Cancelar reserva");
                System.out.println("[3] Listar reservas");
                System.out.println("[4] Consultar hospede");
                System.out.println("[5] Editar hospede");
                System.out.println("[6] Registrar frigobar");
                System.out.println("[7] Check-out (Encerrar hospedagem)");
                System.out.println("[8] Sair");
                System.out.println(linhaMenor);
                while (!scan.hasNextInt()) {
                    System.out.println("Entrada invalida. Digite um numero: ");
                    scan.nextLine();
                }
                opc = scan.nextInt();
                scan.nextLine();
                while (opc < 1 || opc > 8) {
                    System.out.println("Opcao invalida. Digite novamente: ");
                    while (!scan.hasNextInt()) {
                        System.out.println("Entrada invalida. Digite um numero: ");
                        scan.nextLine();
                    }
                    opc = scan.nextInt();
                    scan.nextLine();
                }

                switch (opc) {
                    case 1:
                        if (totalHospedes == 100) {
                            System.out.println("Nao ha mais espaco para cadastrar hospedes.");
                        } else {
                            do {
                                System.out.println(linha);
                                System.out.println("             RESERVA DE QUARTOS");
                                System.out.println(linha);

                                System.out.println("Digite o numero do quarto: ");
                                while (!scan.hasNextInt()) {
                                    System.out.println("Entrada invalida. Digite um numero de quarto: ");
                                    scan.nextLine();
                                }
                                numQuarto = scan.nextInt();
                                scan.nextLine();

                                while (numQuarto < 1 || numQuarto > 100) {
                                    System.out.println("Numero de quarto invalido. Digite novamente: ");
                                    while (!scan.hasNextInt()) {
                                        System.out.println("Entrada invalida. Digite um numero de quarto: ");
                                        scan.nextLine();
                                    }
                                    numQuarto = scan.nextInt();
                                    scan.nextLine();
                                }

                                boolean adicionarMesmoQuarto = false;
                                while (arrayQuartoOcupacao[numQuarto - 1] && !adicionarMesmoQuarto) {
                                    System.out.println("Quarto ja ocupado.");
                                    System.out.println("Deseja cadastrar mais um hospede nesse quarto? [1] - Sim | [2] - Nao ");
                                    while (!scan.hasNextInt()) {
                                        System.out.println("Entrada invalida. Digite 1 ou 2: ");
                                        scan.nextLine();
                                    }
                                    opccont = scan.nextInt();
                                    scan.nextLine();

                                    while (opccont != 1 && opccont != 2) {
                                        System.out.println("Opcao invalida. Digite novamente: ");
                                        while (!scan.hasNextInt()) {
                                            System.out.println("Entrada invalida. Digite 1 ou 2: ");
                                            scan.nextLine();
                                        }
                                        opccont = scan.nextInt();
                                        scan.nextLine();
                                    }

                                    if (opccont == 1) {
                                        adicionarMesmoQuarto = true;
                                    } else {
                                        System.out.println("Digite outro numero do quarto: ");
                                        while (!scan.hasNextInt()) {
                                            System.out.println("Entrada invalida. Digite um numero de quarto: ");
                                            scan.nextLine();
                                        }
                                        numQuarto = scan.nextInt();
                                        scan.nextLine();

                                        while (numQuarto < 1 || numQuarto > 100) {
                                            System.out.println("Numero de quarto invalido. Digite novamente: ");
                                            while (!scan.hasNextInt()) {
                                                System.out.println("Entrada invalida. Digite um numero de quarto: ");
                                                scan.nextLine();
                                            }
                                            numQuarto = scan.nextInt();
                                            scan.nextLine();
                                        }
                                    }
                                }

                                if (arrayQuartoOcupacao[numQuarto - 1]) {
                                    numReserva = 0;
                                    for (i = 0; i < arrayNomeHospede.length; i++) {
                                        if (arrayNomeHospede[i] != null && arrayNumQuarto[i] == numQuarto) {
                                            numReserva = arrayNumReserva[i];
                                            break;
                                        }
                                    }
                                    System.out.println("Reserva existente do quarto: " + numReserva);
                                } else {
                                    System.out.println("Digite o numero da reserva: ");
                                    while (!scan.hasNextInt()) {
                                        System.out.println("Entrada invalida. Digite um numero de reserva: ");
                                        scan.nextLine();
                                    }
                                    numReserva = scan.nextInt();
                                    scan.nextLine();

                                    boolean reservaExistente = true;
                                    while (reservaExistente) {
                                        reservaExistente = false;
                                        for (i = 0; i < arrayNumReserva.length; i++) {
                                            if (arrayNomeHospede[i] != null && arrayNumReserva[i] == numReserva) {
                                                reservaExistente = true;
                                            }
                                        }
                                        if (reservaExistente) {
                                            System.out.println("Reserva ja cadastrada! Digite outro numero: ");
                                            while (!scan.hasNextInt()) {
                                                System.out.println("Entrada invalida. Digite um numero de reserva: ");
                                                scan.nextLine();
                                            }
                                            numReserva = scan.nextInt();
                                            scan.nextLine();
                                        }
                                    }
                                }

                                do {
                                    System.out.println("Digite o nome do hospede: ");
                                    nomeHospede = scan.nextLine();

                                    int indiceLivre = -1;
                                    for (i = 0; i < arrayNomeHospede.length; i++) {
                                        if (arrayNomeHospede[i] == null) {
                                            indiceLivre = i;
                                            break;
                                        }
                                    }

                                    if (indiceLivre == -1) {
                                        System.out.println("Nao ha mais espaco para cadastrar hospedes.");
                                        opccont = 2;
                                    } else {
                                        arrayNomeHospede[indiceLivre] = nomeHospede;
                                        arrayNumReserva[indiceLivre] = numReserva;
                                        arrayNumQuarto[indiceLivre] = numQuarto;
                                        totalHospedes++;

                                        System.out.println(linhaMenor);
                                        System.out.println("Deseja cadastrar mais um hospede no mesmo quarto? [1] - Sim | [2] - Nao ");
                                        while (!scan.hasNextInt()) {
                                            System.out.println("Entrada invalida. Digite 1 ou 2: ");
                                            scan.nextLine();
                                        }
                                        opccont = scan.nextInt();
                                        scan.nextLine();

                                        while (opccont != 1 && opccont != 2) {
                                            System.out.println("Opcao invalida. Digite novamente: ");
                                            while (!scan.hasNextInt()) {
                                                System.out.println("Entrada invalida. Digite 1 ou 2: ");
                                                scan.nextLine();
                                            }
                                            opccont = scan.nextInt();
                                            scan.nextLine();
                                        }
                                    }
                                } while (opccont == 1 && totalHospedes < 100);

                                arrayQuartoOcupacao[numQuarto - 1] = true;
                                System.out.println(linhaMenor);
                                System.out.println("Reserva realizada com sucesso!");
                                System.out.println("Deseja cadastrar mais um quarto? [1] - Sim | [2] - Nao ");
                                while (!scan.hasNextInt()) {
                                    System.out.println("Entrada invalida. Digite 1 ou 2: ");
                                    scan.nextLine();
                                }
                                cont = scan.nextInt();
                                scan.nextLine();

                                while (cont != 1 && cont != 2) {
                                    System.out.println("Opcao invalida. Digite novamente: ");
                                    while (!scan.hasNextInt()) {
                                        System.out.println("Entrada invalida. Digite 1 ou 2: ");
                                        scan.nextLine();
                                    }
                                    cont = scan.nextInt();
                                    scan.nextLine();
                                }
                            } while (cont == 1 && totalHospedes < 100);
                        }

                        System.out.println("Pressione Enter para voltar ao menu...");
                        scan.nextLine();
                        break;

                    case 2:
                        System.out.println(linha);
                        System.out.println("              CANCELAR RESERVA");
                        System.out.println(linha);
                        System.out.println("Digite o numero do quarto: ");
                        while (!scan.hasNextInt()) {
                            System.out.println("Entrada invalida. Digite um numero de quarto: ");
                            scan.nextLine();
                        }
                        numQuarto = scan.nextInt();
                        scan.nextLine();

                        while (numQuarto < 1 || numQuarto > 100) {
                            System.out.println("Numero de quarto invalido. Digite novamente: ");
                            while (!scan.hasNextInt()) {
                                System.out.println("Entrada invalida. Digite um numero de quarto: ");
                                scan.nextLine();
                            }
                            numQuarto = scan.nextInt();
                            scan.nextLine();
                        }

                        if (!arrayQuartoOcupacao[numQuarto - 1]) {
                            System.out.println("Quarto nao encontrado ou desocupado.");
                        } else {
                            System.out.println(linhaMenor);
                            System.out.println("Hospedes removidos do quarto " + numQuarto + ":");
                            for (i = 0; i < arrayNomeHospede.length; i++) {
                                if (arrayNomeHospede[i] != null && arrayNumQuarto[i] == numQuarto) {
                                    System.out.println("- " + arrayNomeHospede[i] + " | Reserva: " + arrayNumReserva[i]);
                                    arrayNomeHospede[i] = null;
                                    arrayNumReserva[i] = 0;
                                    arrayNumQuarto[i] = 0;
                                    totalHospedes--;
                                }
                            }
                            arrayQuartoOcupacao[numQuarto - 1] = false;
                            for (i = 0; i < produtos.length; i++) {
                                frigobar[numQuarto - 1][i] = 0;
                            }
                            System.out.println(linhaMenor);
                            System.out.println("Reserva cancelada com sucesso!");
                        }

                        System.out.println("Pressione Enter para voltar ao menu...");
                        scan.nextLine();
                        break;

                    case 3:
                        System.out.println(linha);
                        System.out.println("               LISTAR RESERVAS");
                        System.out.println(linha);
                        if (totalHospedes == 0) {
                            System.out.println("Nenhum quarto ocupado.");
                        } else {
                            for (int q = 1; q <= 100; q++) {
                                if (arrayQuartoOcupacao[q - 1]) {
                                    int quantidadeHospedes = 0;
                                    String nomes = "";
                                    int reservaQuarto = 0;

                                    for (i = 0; i < arrayNomeHospede.length; i++) {
                                        if (arrayNomeHospede[i] != null && arrayNumQuarto[i] == q) {
                                            quantidadeHospedes++;
                                            if (quantidadeHospedes == 1) {
                                                nomes = arrayNomeHospede[i];
                                            } else {
                                                nomes = nomes + " | " + arrayNomeHospede[i];
                                            }
                                            reservaQuarto = arrayNumReserva[i];
                                        }
                                    }

                                    System.out.println(linhaMenor);
                                    if (quantidadeHospedes == 1) {
                                        System.out.println("Quarto: " + q + " | Hospede: " + nomes + " | Reserva: " + reservaQuarto);
                                    } else {
                                        System.out.println("Quarto: " + q + " | Hospedes: " + nomes + " | Reserva: " + reservaQuarto);
                                    }
                                }
                            }
                            System.out.println(linhaMenor);
                        }

                        System.out.println("Pressione Enter para voltar ao menu...");
                        scan.nextLine();
                        break;

                    case 4:
                        System.out.println(linha);
                        System.out.println("              CONSULTAR HOSPEDE");
                        System.out.println(linha);
                        System.out.println("Digite o numero do quarto: ");
                        while (!scan.hasNextInt()) {
                            System.out.println("Entrada invalida. Digite um numero de quarto: ");
                            scan.nextLine();
                        }
                        numQuarto = scan.nextInt();
                        scan.nextLine();

                        while (numQuarto < 1 || numQuarto > 100) {
                            System.out.println("Numero de quarto invalido. Digite novamente: ");
                            while (!scan.hasNextInt()) {
                                System.out.println("Entrada invalida. Digite um numero de quarto: ");
                                scan.nextLine();
                            }
                            numQuarto = scan.nextInt();
                            scan.nextLine();
                        }

                        if (!arrayQuartoOcupacao[numQuarto - 1]) {
                            System.out.println("Quarto nao encontrado ou desocupado.");
                        } else {
                            System.out.println(linhaMenor);
                            System.out.println("Hospedes do quarto " + numQuarto + ":");
                            for (i = 0; i < arrayNomeHospede.length; i++) {
                                if (arrayNomeHospede[i] != null && arrayNumQuarto[i] == numQuarto) {
                                    System.out.println("- " + arrayNomeHospede[i] + " | Reserva: " + arrayNumReserva[i]);
                                }
                            }
                            System.out.println(linhaMenor);
                        }

                        System.out.println("Pressione Enter para voltar ao menu...");
                        scan.nextLine();
                        break;

                    case 5:
                        System.out.println(linha);
                        System.out.println("                EDITAR HOSPEDE");
                        System.out.println(linha);
                        System.out.println("Digite o numero do quarto: ");
                        while (!scan.hasNextInt()) {
                            System.out.println("Entrada invalida. Digite um numero de quarto: ");
                            scan.nextLine();
                        }
                        numQuarto = scan.nextInt();
                        scan.nextLine();

                        while (numQuarto < 1 || numQuarto > 100) {
                            System.out.println("Numero de quarto invalido. Digite novamente: ");
                            while (!scan.hasNextInt()) {
                                System.out.println("Entrada invalida. Digite um numero de quarto: ");
                                scan.nextLine();
                            }
                            numQuarto = scan.nextInt();
                            scan.nextLine();
                        }

                        if (!arrayQuartoOcupacao[numQuarto - 1]) {
                            System.out.println("Quarto nao encontrado ou desocupado.");
                        } else {
                            System.out.println(linhaMenor);
                            System.out.println("Hospedes do quarto " + numQuarto + ":");
                            int opcHospede = 1;
                            for (i = 0; i < arrayNomeHospede.length; i++) {
                                if (arrayNomeHospede[i] != null && arrayNumQuarto[i] == numQuarto) {
                                    System.out.println("[" + opcHospede + "] " + arrayNomeHospede[i] + " | Reserva: " + arrayNumReserva[i]);
                                    opcHospede++;
                                }
                            }

                            System.out.println("Digite o numero do hospede que deseja editar (ou 0 para cancelar): ");
                            while (!scan.hasNextInt()) {
                                System.out.println("Entrada invalida. Digite um numero: ");
                                scan.nextLine();
                            }
                            int indiceEscolhido = scan.nextInt();
                            scan.nextLine();

                            if (indiceEscolhido == 0) {
                                System.out.println("Edicao cancelada.");
                            } else {
                                int contador = 0;
                                int indiceReal = -1;

                                for (i = 0; i < arrayNomeHospede.length; i++) {
                                    if (arrayNomeHospede[i] != null && arrayNumQuarto[i] == numQuarto) {
                                        contador++;
                                        if (contador == indiceEscolhido) {
                                            indiceReal = i;
                                            break;
                                        }
                                    }
                                }

                                if (indiceReal == -1) {
                                    System.out.println("Hospede invalido.");
                                } else {
                                    System.out.println("Editando: " + arrayNomeHospede[indiceReal] + " | Reserva: " + arrayNumReserva[indiceReal]);
                                    System.out.println("O que deseja editar?");
                                    System.out.println("[1] Nome");
                                    System.out.println("[2] Numero de reserva");
                                    System.out.println("[3] Nao alterar");
                                    while (!scan.hasNextInt()) {
                                        System.out.println("Entrada invalida. Digite 1, 2 ou 3: ");
                                        scan.nextLine();
                                    }
                                    opccont = scan.nextInt();
                                    scan.nextLine();

                                    while (opccont < 1 || opccont > 3) {
                                        System.out.println("Opcao invalida. Digite novamente: ");
                                        while (!scan.hasNextInt()) {
                                            System.out.println("Entrada invalida. Digite 1, 2 ou 3: ");
                                            scan.nextLine();
                                        }
                                        opccont = scan.nextInt();
                                        scan.nextLine();
                                    }

                                    if (opccont == 1) {
                                        System.out.println("Digite o novo nome: ");
                                        arrayNomeHospede[indiceReal] = scan.nextLine();
                                        System.out.println("Nome alterado com sucesso!");
                                    } else if (opccont == 2) {
                                        System.out.println("Digite o novo numero de reserva: ");
                                        while (!scan.hasNextInt()) {
                                            System.out.println("Entrada invalida. Digite um numero de reserva: ");
                                            scan.nextLine();
                                        }
                                        numReserva = scan.nextInt();
                                        scan.nextLine();

                                        boolean reservaExistente = true;
                                        while (reservaExistente) {
                                            reservaExistente = false;
                                            for (i = 0; i < arrayNumReserva.length; i++) {
                                                if (arrayNomeHospede[i] != null && arrayNumQuarto[i] != numQuarto && arrayNumReserva[i] == numReserva) {
                                                    reservaExistente = true;
                                                }
                                            }
                                            if (reservaExistente) {
                                                System.out.println("Reserva ja cadastrada! Digite outro numero: ");
                                                while (!scan.hasNextInt()) {
                                                    System.out.println("Entrada invalida. Digite um numero de reserva: ");
                                                    scan.nextLine();
                                                }
                                                numReserva = scan.nextInt();
                                                scan.nextLine();
                                            }
                                        }

                                        for (i = 0; i < arrayNomeHospede.length; i++) {
                                            if (arrayNomeHospede[i] != null && arrayNumQuarto[i] == numQuarto) {
                                                arrayNumReserva[i] = numReserva;
                                            }
                                        }
                                        System.out.println("Reserva alterada com sucesso!");
                                    } else {
                                        System.out.println("Nenhuma alteracao realizada.");
                                    }
                                }
                            }
                        }

                        System.out.println("Pressione Enter para voltar ao menu...");
                        scan.nextLine();
                        break;

                    case 6:
                        System.out.println(linha);
                        System.out.println("                   FRIGOBAR");
                        System.out.println(linha);
                        System.out.println("[1] Registrar consumo");
                        System.out.println("[2] Consultar consumo do quarto");
                        while (!scan.hasNextInt()) {
                            System.out.println("Entrada invalida. Digite 1 ou 2: ");
                            scan.nextLine();
                        }
                        opccont = scan.nextInt();
                        scan.nextLine();

                        while (opccont != 1 && opccont != 2) {
                            System.out.println("Opcao invalida. Digite novamente: ");
                            while (!scan.hasNextInt()) {
                                System.out.println("Entrada invalida. Digite 1 ou 2: ");
                                scan.nextLine();
                            }
                            opccont = scan.nextInt();
                            scan.nextLine();
                        }

                        System.out.println("Digite o numero do quarto: ");
                        while (!scan.hasNextInt()) {
                            System.out.println("Entrada invalida. Digite um numero de quarto: ");
                            scan.nextLine();
                        }
                        numQuarto = scan.nextInt();
                        scan.nextLine();

                        while (numQuarto < 1 || numQuarto > 100) {
                            System.out.println("Numero de quarto invalido. Digite novamente: ");
                            while (!scan.hasNextInt()) {
                                System.out.println("Entrada invalida. Digite um numero de quarto: ");
                                scan.nextLine();
                            }
                            numQuarto = scan.nextInt();
                            scan.nextLine();
                        }

                        if (!arrayQuartoOcupacao[numQuarto - 1]) {
                            System.out.println("Quarto nao encontrado ou desocupado.");
                        } else if (opccont == 1) {
                            System.out.println(linhaMenor);
                            System.out.println("Produtos disponiveis:");
                            for (i = 0; i < produtos.length; i++) {
                                System.out.println("[" + (i + 1) + "] " + produtos[i] + " - R$ " + precos[i]);
                            }

                            System.out.println("Digite o numero do produto: ");
                            while (!scan.hasNextInt()) {
                                System.out.println("Entrada invalida. Digite um numero de produto: ");
                                scan.nextLine();
                            }
                            int numProduto = scan.nextInt();
                            scan.nextLine();

                            while (numProduto < 1 || numProduto > produtos.length) {
                                System.out.println("Produto invalido. Digite novamente: ");
                                while (!scan.hasNextInt()) {
                                    System.out.println("Entrada invalida. Digite um numero de produto: ");
                                    scan.nextLine();
                                }
                                numProduto = scan.nextInt();
                                scan.nextLine();
                            }

                            System.out.println("Digite a quantidade: ");
                            while (!scan.hasNextInt()) {
                                System.out.println("Entrada invalida. Digite uma quantidade: ");
                                scan.nextLine();
                            }
                            int quantidade = scan.nextInt();
                            scan.nextLine();

                            while (quantidade <= 0) {
                                System.out.println("Quantidade invalida. Digite novamente: ");
                                while (!scan.hasNextInt()) {
                                    System.out.println("Entrada invalida. Digite uma quantidade: ");
                                    scan.nextLine();
                                }
                                quantidade = scan.nextInt();
                                scan.nextLine();
                            }

                            frigobar[numQuarto - 1][numProduto - 1] += quantidade;
                            System.out.println(linhaMenor);
                            System.out.println("Consumo registrado com sucesso!");
                        } else {
                            double totalFrigobar = 0;
                            System.out.println(linhaMenor);
                            System.out.println("Consumo do quarto " + numQuarto + ":");
                            for (i = 0; i < produtos.length; i++) {
                                System.out.println(produtos[i] + ": " + frigobar[numQuarto - 1][i]);
                                totalFrigobar += frigobar[numQuarto - 1][i] * precos[i];
                            }
                            System.out.println(linhaMenor);
                            System.out.println("Valor total consumido: R$ " + totalFrigobar);
                        }

                        System.out.println("Pressione Enter para voltar ao menu...");
                        scan.nextLine();
                        break;

                    case 7:
                        System.out.println(linha);
                        System.out.println("        CHECK-OUT (ENCERRAMENTO HOSPEDAGEM)");
                        System.out.println(linha);
                        System.out.println("Digite o numero do quarto: ");
                        while (!scan.hasNextInt()) {
                            System.out.println("Entrada invalida. Digite um numero de quarto: ");
                            scan.nextLine();
                        }
                        numQuarto = scan.nextInt();
                        scan.nextLine();

                        while (numQuarto < 1 || numQuarto > 100) {
                            System.out.println("Numero de quarto invalido. Digite novamente: ");
                            while (!scan.hasNextInt()) {
                                System.out.println("Entrada invalida. Digite um numero de quarto: ");
                                scan.nextLine();
                            }
                            numQuarto = scan.nextInt();
                            scan.nextLine();
                        }

                        if (!arrayQuartoOcupacao[numQuarto - 1]) {
                            System.out.println("Quarto nao encontrado ou desocupado.");
                        } else {
                            System.out.println("Digite a quantidade de diarias: ");
                            while (!scan.hasNextInt()) {
                                System.out.println("Entrada invalida. Digite a quantidade de diarias: ");
                                scan.nextLine();
                            }
                            int numDiarias = scan.nextInt();
                            scan.nextLine();

                            while (numDiarias <= 0) {
                                System.out.println("Quantidade de diarias invalida. Digite novamente: ");
                                while (!scan.hasNextInt()) {
                                    System.out.println("Entrada invalida. Digite a quantidade de diarias: ");
                                    scan.nextLine();
                                }
                                numDiarias = scan.nextInt();
                                scan.nextLine();
                            }

                            double totalDiarias = numDiarias * valorDiaria;
                            double totalFrigobar = 0;
                            for (i = 0; i < produtos.length; i++) {
                                totalFrigobar += frigobar[numQuarto - 1][i] * precos[i];
                            }
                            double totalGeral = totalDiarias + totalFrigobar;

                            System.out.println(linha);
                            System.out.println("             RESUMO DO CHECK-OUT");
                            System.out.println(linha);
                            System.out.println("Numero do quarto: " + numQuarto);
                            System.out.println("Hospedes:");
                            for (i = 0; i < arrayNomeHospede.length; i++) {
                                if (arrayNomeHospede[i] != null && arrayNumQuarto[i] == numQuarto) {
                                    System.out.println("- " + arrayNomeHospede[i] + " | Reserva: " + arrayNumReserva[i]);
                                }
                            }
                            System.out.println(linhaMenor);
                            System.out.println("Total de diarias: " + numDiarias + " x R$ " + valorDiaria + " = R$ " + totalDiarias);
                            System.out.println("Total do frigobar: R$ " + totalFrigobar);
                            System.out.println("Valor total a pagar: R$ " + totalGeral);
                            System.out.println(linha);

                            for (i = 0; i < arrayNomeHospede.length; i++) {
                                if (arrayNomeHospede[i] != null && arrayNumQuarto[i] == numQuarto) {
                                    arrayNomeHospede[i] = null;
                                    arrayNumReserva[i] = 0;
                                    arrayNumQuarto[i] = 0;
                                    totalHospedes--;
                                }
                            }
                            arrayQuartoOcupacao[numQuarto - 1] = false;
                            for (i = 0; i < produtos.length; i++) {
                                frigobar[numQuarto - 1][i] = 0;
                            }

                            System.out.println(linhaMenor);
                            System.out.println("Check-out realizado com sucesso! Quarto liberado.");
                        }

                        System.out.println("Pressione Enter para voltar ao menu...");
                        scan.nextLine();
                        break;

                    default:
                        System.out.println("Sistema finalizado.");
                        break;
                }
            } while (opc != 8);
        }
    }
