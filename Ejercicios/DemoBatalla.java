package laboratorio3;
import java.util.*;
import java.io.*;
public class DemoBatalla {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) throws IOException {
	Nave[] misNaves = new Nave[4];
	String nomb;
	int fil, col,punt,opcion,continuar;
	boolean est;
	for (int i = 0; i < misNaves.length; i++) {
            System.out.println("Nave " + (i + 1));
            System.out.print("Nombre: ");
            nomb = br.readLine();
            System.out.print("Fila : ");
            fil = sc.nextInt();
            System.out.print("Columna: ");
            col = sc.nextInt();
            System.out.print("Estado: ");
            est = sc.nextBoolean();
            System.out.print("Puntos: ");
            punt = sc.nextInt();
            misNaves[i] = new Nave();
            misNaves[i].setNombre(nomb);
            misNaves[i].setFila(fil);
            misNaves[i].setColumna(col);
            misNaves[i].setEstado(est);
            misNaves[i].setPuntos(punt);
	}
//        while(true){
//            System.out.println("Ingrese una opcion a mostrar");
//            System.out.println("1 = Buscar nave por nombre\n2 = Buscar nave por puntos\n"
//                    + "3 = Mostrar las naves de forma aleatoria\n4 = Salir");
//            opcion = sc.nextInt();
//            switch(opcion){
//                case 1: mostrarPorNombre(misNaves);
//                    break;
//                case 2: mostrarPorPuntos(misNaves);
//                    break;
//                case 3:  mostrarNavesAleatoriamente(misNaves);
//                    break;
//            }
//            if(opcion == 4)
//                break;
//            System.out.println("Desea seguir consultando (1 = Si / 2 = No)");
//            continuar = sc.nextInt();
//            while(continuar != 1 &&  continuar != 2 ){
//                System.out.println("Ingrese opcion valida");
//                continuar = sc.nextInt();
//            }
//            if(continuar == 2)
//                break;
//        }
        System.out.println("\nNaves creadas:");
        mostrarNaves(misNaves);
        System.out.println("\nNave con mayor número de puntos: " + mostrarMayorPuntos(misNaves));
        System.out.println("Busqueda Lineal nombre : (nave c)");
        int pos = busquedaLinealNombre(misNaves,"nave c");
        if(pos != -1){
            System.out.println("Encontrado");
            System.out.println("Nombre : " + misNaves[pos].getNombre());
            System.out.println("Puntos  : " + misNaves[pos].getPuntos());
            System.out.println("Estado : " + misNaves[pos].getEstado());
            System.out.println("Posicion : ("+ misNaves[pos].getFila()
                                + "," + misNaves[pos].getColumna() +  ")");
        }else{
            System.out.println("No se encontro ninguna coincidencia");
        }
        System.out.println("Ordenamiento por puntos Metodo burbuja");
        ordenarPorPuntosBurbuja(misNaves);
        mostrarNaves(misNaves);
            System.out.println("Ordenamiento por nombre Metodo burbuja");
        ordenarPorNombreBurbuja(misNaves);
        mostrarNaves(misNaves);
        System.out.println("Busqueda Lineal nombre : (nave e)");
        int pos1 = busquedaBinariaNombre(misNaves,"nave e");
        if(pos1 != -1){
            System.out.println("Encontrado");
            System.out.println("Nombre : " + misNaves[pos1].getNombre());
            System.out.println("Puntos  : " + misNaves[pos1].getPuntos());
            System.out.println("Estado : " + misNaves[pos1].getEstado());
            System.out.println("Posicion : "+ misNaves[pos1].getFila()
                                + "," + misNaves[pos1].getColumna() +  ")");
        }else{
            System.out.println("No se encontro ninguna coincidencia");
        }
        System.out.println("Ordenamiento por puntos Metodo Seleccion");
        ordenarPorPuntosSeleccion(misNaves);
        mostrarNaves(misNaves);
        System.out.println("Ordenamiento por puntos Metodo Insercion");
        ordenarPorPuntosInsercion(misNaves);
        mostrarNaves(misNaves);
        System.out.println("Ordenamiento por nombre Metodo Seleccion");
        ordenarPorNombreSeleccion(misNaves);
        mostrarNaves(misNaves);
        System.out.println("Ordenamiento por nombre Metodo Insercion");
        ordenarPorNombreInsercion(misNaves);
        mostrarNaves(misNaves);
        
//        mostrarMatrizDeNaves(misNaves);
//        System.out.println("\nMostrar detalle de nave por nombre:");
//        mostrarPorNombre(misNaves);
//        System.out.println("\nMostrar detalle de naves por puntos");
//        mostrarPorPuntos(misNaves);
//        System.out.println("\nMostrar naves aleatorias");
    }
    // Método para mostrar todas las naves
    public static void mostrarNaves(Nave[] flota) {
        for (int i = 0; i < flota.length; i++) {
            System.out.println("Nave N°" + (i+1) );
            System.out.println("Nombre : " + flota[i].getNombre());
            System.out.println("Puntos : " + flota[i].getPuntos());
            System.out.println("Estado : " + flota[i].getEstado());
            System.out.println("Posicion : ("+ flota[i].getFila()
                    + "," + flota[i].getColumna() +  ")");
        }
    }
    // Método para mostrar todas las naves de un nombre que se pide por teclado
    public static void mostrarPorNombre(Nave[] flota) throws IOException {
        String nombreNave;
        int cantEncontrados = 0;
        System.out.println("Ingrese nombre de la nave a buscar : ");
        nombreNave = br.readLine();
        for (int i = 0; i < flota.length; i++) {
            if(nombreNave.equals(flota[i].getNombre())){
                System.out.println("Puntos : " + flota[i].getPuntos());
                System.out.println("Estado : " + flota[i].getEstado());
                System.out.println("Posicion : ("+ flota[i].getFila()
                    + "," + flota[i].getColumna() +  ")");
                cantEncontrados++;
            }
        }
        if(cantEncontrados == 0){
            System.out.println("No se encontro ninguna coincidencia");
        }
    }
    // Método para mostrar todas las naves con un número de puntos inferior o igual
    // al número de puntos que se pide por teclado
    public static void mostrarPorPuntos(Nave[] flota) {
        int puntosNave,cantEncontrados = 0;
        System.out.println("Ingrese cantidad de puntos de la(s) nave(s) a buscar");
        puntosNave = sc.nextInt();
        for (int i = 0; i < flota.length; i++) {
            if(puntosNave == flota[i].getPuntos()){
                System.out.println("Nombre : " + flota[i].getNombre());
                System.out.println("Estado : " + flota[i].getEstado());
                System.out.println("Posicion : ("+ flota[i].getFila()
                    + "," + flota[i].getColumna() +  ")");
                cantEncontrados++;
            }
        }
        if(cantEncontrados == 0){
            System.out.println("No se encontro ninguna coincidencia");
        }
    }
    // Método que muestra las naves de forma matricial
    public static void mostrarMatrizDeNaves(Nave[] flota) {
        Nave [][] matriz;
        int fila = flota[0].getFila(),col = flota[0].getColumna();
        //evalua la fila y la columna mayor
        for (int i = 1; i < flota.length; i++) {
            if(fila < flota[i].getFila())
                fila = flota[i].getFila();
            if(col < flota[i].getColumna())
                col = flota[i].getColumna();
        }
        matriz = new Nave[fila+1][col+1];
        //completacion de datos en la matriz 
        for (int i = 0; i < flota.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                for (int k = 0; k < matriz[j].length; k++) {
                    if(flota[i].getFila() == j && flota[i].getColumna() == k)
                        matriz[j][k] = flota[i];
                }
            }
        }
        //impresion de forma matricial
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if(matriz[i][j] == null)
                    System.out.print("---\t");
                else
                    System.out.print(matriz[i][j].getNombre() + "\t");
            }
            System.out.println();
        }
    }
    public static void mostrarNavesAleatoriamente(Nave[] flota){
        Random rand = new Random();			
        for (int i = 0; i<flota.length; i++) {
            int indice = rand.nextInt(flota.length);
            Nave temp = flota[i];
            flota[i] = flota[indice];
            flota[indice] = temp;
        }
        mostrarNaves(flota);
    }
    
    public static void intercambiar(Nave[] flota,int a,int b){
        Nave auxiliar = new Nave();
        auxiliar = flota[b];
        flota[b] = flota[a];
        flota[a] = auxiliar;
    }
    public static int busquedaLinealNombre(Nave[] flota,String nombreNave) throws IOException{
        for (int i = 0; i < flota.length; i++) {
            if(nombreNave.equals(flota[i].getNombre())){
                return i;
            }
        }
        return -1;
    }
    public static void ordenarPorPuntosBurbuja(Nave[] flota){
        for (int i = 0; i < flota.length; i++) {
            for (int j = 0; j < flota.length-i-1; j++) {
                if(flota[j+1].getPuntos() < flota[j].getPuntos()){
                    intercambiar(flota, j, j+1);
                }
            }
        }
    }
    public static void ordenarPorNombreBurbuja(Nave[] flota){
        for (int i = 0; i < flota.length - 1; i++) {
            for (int j = 0; j < flota.length-i - 1; j++) {
                if(flota[j+1].getNombre().compareTo(flota[j].getNombre()) < 0){
                    intercambiar(flota, j, j+1);
                }
            }
        }
    }
    public static int busquedaBinariaNombre(Nave[] flota,String nombreNave)throws IOException{
        int media,baja,alta;
        baja = 0;
        alta = flota.length - 1;
        ordenarPorNombreBurbuja(flota);
        while(baja<=alta){
            media = (alta+baja)/2;
            if(flota[media].getNombre().compareTo(nombreNave) == 0)
                return media;
            else{
                if(nombreNave.compareTo(flota[media].getNombre()) < 0)
                    alta = media-1;
                else
                    baja = media+1;
            }
        }
        return -1;
    }
    public static void ordenarPorPuntosSeleccion(Nave[] flota){
        int minimo;
        for (int i = 0; i < flota.length; i++) {
            minimo = i;
            for (int j = i + 1; j < flota.length; j++) {
                if(flota[j].getPuntos()< flota[minimo].getPuntos()){
                    minimo = j;
                }
            }
            intercambiar(flota, i, minimo);
        }
    }
    public static void ordenarPorNombreSeleccion(Nave[] flota){
        int minimo;
        for (int i = 0; i < flota.length; i++) {
            minimo = i;
            for (int j = i + 1; j < flota.length; j++) {
                if(flota[j].getNombre().compareTo(flota[minimo].getNombre()) < 0){
                    minimo = j;
                }
            }
            intercambiar(flota, i, minimo);
        }
    }
    public static void ordenarPorPuntosInsercion(Nave[] flota){
        int j;
        Nave auxiliar = new Nave();
        for (int i = 0; i < flota.length; i++) {
            auxiliar = flota[i];
            j = i - 1;
            while(j>=0 && auxiliar.getPuntos() < flota[j].getPuntos()){
                flota[j+1] = flota[j];
                j--;
            }
            flota[j+1] = auxiliar;
        }
    }
    public static void ordenarPorNombreInsercion(Nave[] flota){
        int j;
        Nave auxiliar = new Nave();
        for (int i = 0; i < flota.length; i++) {
            auxiliar = flota[i];
            j = i - 1;
            while( ( j >= 0 ) && ( auxiliar.getNombre().compareTo(flota[j].getNombre()) < 0) ){
                flota[j+1] = flota[j];
                j--;
            }
            flota[j+1] = auxiliar;
        }
    }
    public static String mostrarMayorPuntos(Nave[] flota){
        ordenarPorPuntosBurbuja(flota);
        return flota[flota.length-1].getNombre();
    }
}
