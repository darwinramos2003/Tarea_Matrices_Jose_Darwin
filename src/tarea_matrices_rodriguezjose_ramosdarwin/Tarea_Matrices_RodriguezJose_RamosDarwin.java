/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea_matrices_rodriguezjose_ramosdarwin;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Darwin
 */
public class Tarea_Matrices_RodriguezJose_RamosDarwin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int exi = 1;
        while (exi == 1) {
            System.out.println("Bienvenido al menu: ");
            System.out.println("1. Battleship");
            System.out.println("2. Busca minas");
            System.out.println("3. Salir del programa");
            int opt = entrada.nextInt();

            switch (opt) {
                case 1: {
                    System.out.println("Elija el modo (1) jugador (2) jugadores: ");
                    int modo = entrada.nextInt();
                    if (modo == 1) {
                        int filas1, columnas1, filas2 = 0, columnas2 = 0;
                        int filas = 6;
                        int columnas = 5;
                        System.out.println("Tablero jugador: ");
                        char[][] tableroJug = Cuadradamatriz(filas, columnas);
                        char[][] tabCpu = cpu(filas, columnas);

                        boolean flag = true;
                        int hit1 = 0;
                        int hit2 = 0;

                        do {
                            if (flag) {
                                System.out.println("---Jugador 1, es tu turno---");

                                do {
                                    System.out.println("Ingrese la fila: ");
                                    filas1 = entrada.nextInt();
                                    System.out.println("Ingrese la columna: ");
                                    columnas1 = entrada.nextInt();
                                    if (filas1 > 6) {
                                        System.out.println("No hay mas de 6 filas");
                                    } else if (columnas1 > 5) {
                                        System.out.println("No hay mas de 5 columnas");
                                    } else if (filas1 < 0) {
                                        System.out.println("Solo hay entre 0-6 filas");
                                    } else if (columnas1 < 0) {
                                        System.out.println("Solo hay entre 0-5 columnas");
                                    }
                                } while (filas1 > 6 || columnas1 > 5 || filas1 < 0 || columnas1 < 0);
                                if (tabCpu[filas1][columnas1] == '*') {
                                    System.out.println("Uy, un barco ha sido dañado");
                                    hit1++;
                                    if (hit1 == 3) {
                                        System.out.println("Jugador 1 gana");
                                        flag = false;

                                    }

                                } else if (tabCpu[filas1][columnas1] == 'X') {
                                    System.out.println("Ya eligio esta posicion, repita");
                                } else {
                                    System.out.println("Bomba al agua");
                                }
                                tabCpu[filas1][columnas1] = 'X';
                                for (int i = 0; i < columnas; i++) {
                                    System.out.print("  " + i);
                                }
                                System.out.println();
                                for (int i = 0; i < filas; i++) {
                                    System.out.print(i);
                                    for (int j = 0; j < columnas; j++) {
                                        if (tabCpu[i][j] != '*') {
                                            System.out.print("[" + tabCpu[i][j] + "]");
                                        } else {
                                            System.out.print("[ ]");
                                        }
                                    }
                                    System.out.println();
                                }
                            }
                            if (flag) {
                                System.out.println("---Turno de la CPU---");

                                do {
                                    Random rand = new Random();
                                    int max = 5;
                                    int min = 0;

                                    for (int i = 0; i < filas; i++) {
                                        filas2 = rand.nextInt(max - min) + min;
                                    }
                                    for (int i = 0; i < filas; i++) {
                                        columnas2 = rand.nextInt(max - min) + min;
                                    }

                                    if (filas2 > 6) {
                                        System.out.println("No hay mas de 6 filas");
                                    } else if (columnas2 > 5) {
                                        System.out.println("No hay mas de 5 columnas");
                                    } else if (filas2 < 0) {
                                        System.out.println("Solo hay entre 0-6 filas");
                                    } else if (columnas2 < 0) {
                                        System.out.println("Solo hay entre 0-5 columnas");
                                    }
                                } while (filas2 > 6 || columnas2 > 5 || filas2 < 0 || columnas2 < 0);
                                if (tableroJug[filas2][columnas2] == '*') {
                                    System.out.println("Uy, un barco ha sido dañado");
                                    hit2++;
                                    if (hit2 == 3) {
                                        System.out.println("La CPU 2 gana");
                                        flag = false;

                                    }

                                } else if (tableroJug[filas2][columnas2] == 'X') {
                                    System.out.println("Ya eligio esta posicion, repita");
                                } else {
                                    System.out.println("Bomba al agua");
                                }
                                tableroJug[filas2][columnas2] = 'X';
                                for (int i = 0; i < columnas; i++) {
                                    System.out.print("  " + i);
                                }
                                System.out.println();
                                for (int i = 0; i < filas; i++) {
                                    System.out.print(i);
                                    for (int j = 0; j < columnas; j++) {
                                        if (tableroJug[i][j] != '*') {
                                            System.out.print("[" + tableroJug[i][j] + "]");
                                        } else {
                                            System.out.print("[ ]");
                                        }
                                    }
                                    System.out.println();
                                }
                            }

                        } while (flag);

                        System.out.println("...Volviendo al menu......");

                        break;
                    } else if (modo == 2) {

                        int filas = 6;
                        int columnas = 5;
                        int filas1, columnas1;
                        int filas2, columnas2;

                        System.out.println("---EMPIEZA EL JUEGO---");
                        char[][] tableroJug = Cuadradamatriz(filas, columnas);
                        char[][] tabJug2 = cpu(filas, columnas);

                        boolean bandera = true;
                        int hit1 = 0;
                        int hit2 = 0;

                        do {
                            if (bandera) {
                                System.out.println("---Jugador 1, es tu turno---");

                                do {
                                    System.out.println("Ingrese la fila: ");
                                    filas1 = entrada.nextInt();
                                    System.out.println("Ingrese la columna: ");
                                    columnas1 = entrada.nextInt();
                                    if (filas1 > 6) {
                                        System.out.println("No hay mas de 6 filas");
                                    } else if (columnas1 > 5) {
                                        System.out.println("No hay mas de 5 columnas");
                                    } else if (filas1 < 0) {
                                        System.out.println("Solo hay entre 0-6 filas");
                                    } else if (columnas1 < 0) {
                                        System.out.println("Solo hay entre 0-5 columnas");
                                    }
                                } while (filas1 > 6 || columnas1 > 5 || filas1 < 0 || columnas1 < 0);
                                if (tabJug2[filas1][columnas1] == '*') {
                                    System.out.println("Uy, un barco ha sido dañado");
                                    hit1++;
                                    if (hit1 == 3) {
                                        System.out.println("Jugador 1 gana");
                                        bandera = false;

                                    }

                                } else if (tabJug2[filas1][columnas1] == 'X') {
                                    System.out.println("Ya eligio esta posicion, repita");
                                } else {
                                    System.out.println("Bomba al agua");
                                }
                                tabJug2[filas1][columnas1] = 'X';
                                for (int i = 0; i < columnas; i++) {
                                    System.out.print("  " + i);
                                }
                                System.out.println();
                                for (int i = 0; i < filas; i++) {
                                    System.out.print(i);
                                    for (int j = 0; j < columnas; j++) {
                                        if (tabJug2[i][j] != '*') {
                                            System.out.print("[" + tabJug2[i][j] + "]");
                                        } else {
                                            System.out.print("[ ]");
                                        }
                                    }
                                    System.out.println();
                                }
                            }
                            if (bandera) {
                                System.out.println("---Jugador 2, es tu turno---");

                                do {
                                    System.out.println("Ingrese la fila: ");
                                    filas2 = entrada.nextInt();
                                    System.out.println("Ingrese la columna: ");
                                    columnas2 = entrada.nextInt();
                                    if (filas2 > 6) {
                                        System.out.println("No hay mas de 6 filas");
                                    } else if (columnas2 > 5) {
                                        System.out.println("No hay mas de 5 columnas");
                                    } else if (filas2 < 0) {
                                        System.out.println("Solo hay entre 0-6 filas");
                                    } else if (columnas2 < 0) {
                                        System.out.println("Solo hay entre 0-5 columnas");
                                    }
                                } while (filas2 > 6 || columnas2 > 5 || filas2 < 0 || columnas2 < 0);
                                if (tableroJug[filas2][columnas2] == '*') {
                                    System.out.println("Uy, un barco ha sido dañado");
                                    hit2++;
                                    if (hit2 == 3) {
                                        System.out.println("Jugador 2 gana");
                                        bandera = false;

                                    }

                                } else if (tableroJug[filas2][columnas2] == 'X') {
                                    System.out.println("Ya eligio esta posicion, repita");
                                } else {
                                    System.out.println("Bomba al agua");
                                }
                                tableroJug[filas2][columnas2] = 'X';
                                for (int i = 0; i < columnas; i++) {
                                    System.out.print("  " + i);
                                }
                                System.out.println();
                                for (int i = 0; i < filas; i++) {
                                    System.out.print(i);
                                    for (int j = 0; j < columnas; j++) {
                                        if (tableroJug[i][j] != '*') {
                                            System.out.print("[" + tableroJug[i][j] + "]");
                                        } else {
                                            System.out.print("[ ]");
                                        }
                                    }
                                    System.out.println();
                                }
                            }

                        } while (bandera);

                        System.out.println("...Volviendo al menu......");
                        break;
                        /*  boolean flag = true;
                        do {

                            System.out.println("Tablero jugador 1: ");
                            char[][] tableroJug1 = Cuadradamatriz(filas, columnas);

                            System.out.println("Jugador 1 ataca");
                            System.out.println("Ingrese la cordenada en x: ");
                            int x = entrada.nextInt();
                            System.out.println("Ingrese la coordenada en y: ");
                            int y = entrada.nextInt();
                            disparos1(tableroJug1, x, y, filas, columnas);
                            ImprimeMatriz(tableroJug1);

                            System.out.println("Tablero jugador 2:");
                            System.out.println("Jugador 2 ataca");
                            char[][] tabJug2 = cpu(filas, columnas);

                            System.out.println("Ingrese la cordenada en x: ");
                            int z = entrada.nextInt();
                            System.out.println("Ingrese la coordenada en y: ");
                            int w = entrada.nextInt();
                            disparos2(tabJug2, z, w, filas, columnas);
                            ImprimeMatriz2(tabJug2);

                            if (disparos1(tableroJug1, z, w, filas, columnas) == 1) {
                                System.out.println("Jugador 1 gana");
                                flag = false;
                            } else if (disparos2(tabJug2, z, w, filas, columnas) == 1) {
                                System.out.println("Jugador 2 gana");
                                flag = false;
                            }

                        } while (flag);
                        break;
                         */

                    } else {
                        System.out.println("Error");
                        break;
                    }
                }
                case 2: {
                    System.out.println("-----------------------------------------------");
                    System.out.println("M O D O   S I L E N C I O S O   A C T I V A D O");
                    System.out.println("-----------------------------------------------");
                    Scanner sc = new Scanner(System.in);
                    int filas = 6, filaus;
                    int columnas = 5, colus;
                    String[][] matriz = matrizcuadrada(filas, columnas);
                    boolean bandera = true;
                    do {
                        for (int i = 0; i < columnas; i++) {
                            System.out.print("  " + i);
                        }
                        System.out.println();
                        for (int i = 0; i < filas; i++) {
                            System.out.print(i);
                            for (int j = 0; j < columnas; j++) {
                                if (matriz[i][j] != "*") {
                                    System.out.print("[" + matriz[i][j] + "]");
                                } else {
                                    System.out.print("[ ]");
                                }
                            }
                            System.out.println();
                        }
                        do {
                            System.out.println("Ingrese la fila: ");
                            filaus = sc.nextInt();
                            System.out.println("Ingrese la columna: ");
                            colus = sc.nextInt();
                            if (filaus > 4) {
                                System.out.println("No hay mas de 4 filas");
                            } else if (colus > 4) {
                                System.out.println("No hay mas de 4 columnas");
                            } else if (filaus < 0) {
                                System.out.println("Solo hay entre 0-4 filas");
                            } else if (colus < 0) {
                                System.out.println("Solo hay entre 0-4 columnas");
                            }
                        } while (filaus > 4 || colus > 4 || filaus < 0 || colus < 0);
                        if (matriz[filaus][colus] == "*") {
                            System.out.println("BOOM");
                            bandera = false;
                        } else if (matriz[filaus][colus] == "X") {
                            System.out.println("Ya eligio esta posicion, repita");
                        } else {
                            System.out.println("Uff, no era una bomba");
                        }
                        matriz[filaus][colus] = "X";
                    } while (bandera);
                    System.out.println("Le diste a una bomba, perdio");

                }
                case 3: {
                    System.out.println("Saliendo....");
                    exi++;
                    break;
                }
                default: {
                    System.out.println("Opcion no valida");
                    System.out.println("Volviendo al menu.....");
                    break;
                }
            }

        }
    }

    public static String[][] matrizcuadrada(int filas, int columnas) {
        Scanner lea = new Scanner(System.in);
        String[][] matriz = new String[filas][columnas];
        int cont = 1;
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                matriz[i][j] = " ";

            }
        }
        matriz = bombas(matriz);
        return matriz;
    }

    public static String[][] bombas(String[][] totboom) {

        for (int i = 0; i < 5; i++) {
            Random bomba = new Random();
            int pos_i;
            int pos_j;
            do {
                int max = totboom.length - 1;
                pos_i = bomba.nextInt(max);
                pos_j = bomba.nextInt(max);
            } while (totboom[pos_i][pos_j].equals("*"));
            totboom[pos_i][pos_j] = "*";

        }

        return totboom;

    }

    public static char[][] Cuadradamatriz(int filas, int columnas) {

        char[][] matriz = new char[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                // System.out.println("Cordenada (" + i + "," + j + ")");
                if (i == 0 && j == 0) {
                    matriz[i][j] = '*';
                } else if (i == 1 && j == 0) {
                    matriz[i][j] = '*';
                } else if (i == 2 && j == 0) {
                    matriz[i][j] = '*';
                } else if (i == 1 && j == 2) {
                    matriz[i][j] = '*';
                } else if (i == 1 && j == 3) {
                    matriz[i][j] = '*';
                } else if (i == 3 && j == 4) {
                    matriz[i][j] = '*';
                } else if (i == 4 && j == 4) {
                    matriz[i][j] = '*';
                } else if (i == 5 && j == 4) {
                    matriz[i][j] = '*';
                } else {
                    matriz[i][j] = ' ';
                }

            }

        }

        return matriz;
    }

    public static int disparos1(char[][] matrizAct, int x, int y, int filas, int columnas) {
        int hit1 = 0;
        if (x >= 0 && x < filas && y >= 0 && y < columnas) {

            if (matrizAct[x][y] == '*') {
                matrizAct[x][y] = 'X';
                System.out.println("Uy, un barco ha sido dañado");
                hit1 = hit1 + 1;

            } else {
                matrizAct[x][y] = 'X';
                System.out.println("Bomba al agua");
            }
        } else {
            System.out.println("La coordenada esta afuera de los limites ");
        }

        return hit1;

    }

    public static int disparos2(char[][] matrizAct, int x, int y, int filas, int columnas) {
        int hit2 = 0;
        if (x >= 0 && x < filas && y >= 0 && y < columnas) {

            if (matrizAct[x][y] == '*') {
                matrizAct[x][y] = 'X';
                System.out.println("Uy, un barco ha sido dañado");
                hit2++;
            } else {
                matrizAct[x][y] = 'X';
                System.out.println("Bomba al agua");
            }
        } else {
            System.out.println("La coordenada esta afuera de los limites ");
        }

        return hit2;
    }

    public static char[][] cpu(int filas, int columnas) {
        char[][] matrizcpu = new char[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {

                if (i == 3 && j == 1) {
                    matrizcpu[i][j] = '*';
                } else if (i == 4 && j == 1) {
                    matrizcpu[i][j] = '*';
                } else if (i == 5 && j == 1) {
                    matrizcpu[i][j] = '*';
                } else if (i == 1 && j == 3) {
                    matrizcpu[i][j] = '*';
                } else if (i == 2 && j == 3) {
                    matrizcpu[i][j] = '*';
                } else if (i == 3 && j == 3) {
                    matrizcpu[i][j] = '*';
                } else if (i == 5 && j == 3) {
                    matrizcpu[i][j] = '*';
                } else if (i == 5 && j == 4) {
                    matrizcpu[i][j] = '*';
                } else {
                    matrizcpu[i][j] = ' ';
                }
            }

        }

        return matrizcpu;
    }

    public static char[][] ImprimeMatriz(char[][] tableroJug) {
        for (int i = 0; i < 6; i++) {
            System.out.print("   " + i);
        }
        System.out.println();
        for (int i = 0; i < tableroJug.length; i++) {
            System.out.print(i);
            for (int j = 0; j < tableroJug[i].length; j++) {

                System.out.print("| " + tableroJug[i][j] + " |");
            }
            System.out.println("");
        }
        return tableroJug;
    }

    public static char[][] ImprimeMatriz2(char[][] tabJug2) {

        for (int i = 0; i < 6; i++) {
            System.out.print("   " + i);
        }
        System.out.println();

        for (int i = 0; i < tabJug2.length; i++) {
            System.out.print(i);
            for (int j = 0; j < tabJug2[i].length; j++) {

                System.out.print("| " + tabJug2[i][j] + " |");
            }
            System.out.println("");
        }
        return tabJug2;
    }

}
