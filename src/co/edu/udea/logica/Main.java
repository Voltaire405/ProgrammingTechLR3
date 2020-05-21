package co.edu.udea.logica;

public class Main {

    public static void main(String[] args) {
        //Primer punto parcial
	    //int[] vector = {12,82,71,34,15,10,7,6,8,14,22,51,65};//el dato de la posición 0 es la magnitud del vector.
        int[] vector = {10,90,77,88,99,100,102,106,120,200,307};
        DivideAndConquer dc = new DivideAndConquer(vector);
        int[] minimun = dc.getMinimunValue();
        String result = String.format("La posición del vector %s dónde cambia el ordenamiento es %s, \n" +
                "Correspondiente al dato %s", dc.printVector(), minimun[0], minimun[1]);
        System.out.println(result);

        //Punto 2 de la solución (backtracking)
        int[] coins = {6, 100, 50, 20, 10, 5, 2};
        Backtracking backtracking = new Backtracking(coins, 667);
        backtracking.showChangeInDisplay(1);
    }
}
