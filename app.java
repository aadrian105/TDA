package pack;

import java.util.*;

public class app {
    
    Scanner s = new Scanner(System.in);
    
    int m, n;
    int[][] matriz;
    
    public app() {
        int opcion;
        System.out.println("Elija una opción");
        System.out.println("1");
        System.out.println("2");
        System.out.println("3");
        System.out.println("4");
        
        opcion = s.nextInt();
        
        switch (opcion) {
            case 1:
                Problema1();
                ImprimirMatriz();
                break;
            case 2:
                Problema2();
                ImprimirMatriz();
                break;
            case 3:
                Problema3();
                break;
            case 4:
                Problema4();
                ImprimirMatriz();
                int[] dimensions = SacarDimensiones();
                System.out.println("La matriz contiene:");
                System.out.println(dimensions[0] + " filas y " + dimensions[1] + " columnas");
                System.out.println();
                int[] mayor = ObtenerMayor();
                System.out.println("El número mayor es: " + mayor[0] + 
                        " que se encuentra en la fila " + mayor[1] + ", columna " + mayor[2]);
                System.out.println();
                int[] menor = ObtenerMenor();
                System.out.println("El número menor es: " + menor[0] +
                        " que se encuentra en la fila " + menor[1] + ", columna " + menor[2]);
                break;
        }
        
    }
    
    public void Problema1() {
        System.out.print("Cantidad de filas: ");
        m = s.nextInt();
        System.out.print("Cantidad de columnas: ");
        n = s.nextInt();
        
        //Para generar la matriz
        matriz = new int[m][];
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = new int[n];
            for (int j = 0; j < matriz[i].length; j++) {
                if (i == j)
                    matriz[i][j] = 1;
                else
                    matriz[i][j] = 0;
            }
        }
    }
    
    public void Problema2() {
        System.out.print("Cantidad de filas: ");
        m = s.nextInt();
        System.out.print("Cantidad de columnas: ");
        n = s.nextInt();
        
        // diag es para saber la diagonal inversa
        int diag;
        if (m < n)
            diag = m - 1;
        else
            diag = n - 1;
        
        //      Esto es para generar la matriz
        matriz = new int[m][];
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = new int[n];
            for (int j = 0; j < matriz[i].length; j++) {
                if (i + j == diag) 
                    matriz[i][j] = 0;
                else
                    matriz[i][j] = 1;
            }
        }
        
    }
    
    public void Problema3() {
        System.out.print("Ingresa la longitud de un lado: ");
        m = s.nextInt();
        
        //      Generar la matriz
        matriz = new int[m][];
        for (int i = 0; i < matriz.length; i++) {
            matriz[i] = new int[m];
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j] = (int)(Math.random() * 99) + 1;
            }
        }
        
        //      Generar el vector
        Vector v = new Vector(1,1);
        int temporal;
        
        for (int i = 0; i < matriz.length; i++) {
            temporal = 0;
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] % 2 == 0) {
                    temporal = temporal + matriz[i][j];
                }
            }
            v.addElement(temporal);
        }
        
        ImprimirMatriz();
        System.out.println();
        for (int i = 0; i < v.capacity(); i++) {
            System.out.println(v.elementAt(i));
        }
    }
    
    public void Problema4() {
        System.out.print("Cantidad de filas: ");
        m = s.nextInt();
        System.out.print("Cantidad de columnas: ");
        n = s.nextInt();
        
        //      Para generar la matriz
        matriz = new int[m][];
        for (int i = 0; i < m; i++) {
            matriz[i] = new int[n];
            for (int j = 0; j < n; j++) {
                matriz[i][j] = (int)(Math.random() * 99) + 1;
            }
        }
    }
    
    public void ImprimirMatriz() {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(" " + matriz[i][j]);
            }
            System.out.println();
        }
    }
    
    public int[] SacarDimensiones() {
        //      Uso lenght para sacar las dimensiones
        return new int[] {matriz.length, matriz[0].length};
    }
    
    public int[] ObtenerMayor() {
        int[] coordenadas = new int[2];
        
        int mayor = 0;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > mayor) {
                    mayor = matriz[i][j];
                    coordenadas[0] = i + 1;
                    coordenadas[1] = j + 1;
                }
            }
        }
        
        
        return new int[] {mayor, coordenadas[0], coordenadas[1]};
    }
    
    public int[] ObtenerMenor() {
        int[] coordenadas = new int[2];
        
        int menor = 101;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] < menor) {
                    menor = matriz[i][j];
                    coordenadas[0] = i + 1;
                    coordenadas[1] = j + 1;
                }
            }
        }
        
        return new int[] {menor, coordenadas[0], coordenadas[1]};
    }
}
