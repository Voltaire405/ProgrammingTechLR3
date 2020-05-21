package co.edu.udea.logica;

public class Backtracking {
    private int[] coins, store;
    private int denominationsNumber, change, total, count;

    public Backtracking(int[] coins, int change) {
        this.coins = coins;
        this.change = change;
        denominationsNumber = coins.length - 1;
        total = 0;
        store = new int[coins.length];
        count = 0; //contador de formas de devolver
    }

    public void showChangeInDisplay(int d) {

        if (d <= denominationsNumber) {
            while (total <= change - coins[d]) {
                total += coins[d];
                store[d] += 1;
            }
            if (total == change) {
                String cash = "";
                int ammount = 0;//Para realizar la comprobación del cambio.
                for (int i = 1; i <= denominationsNumber; i++) {
                    cash += String.format("%s monedas de $%s. ",
                            store[i], coins[i]);
                    ammount += store[i] * coins[i];
                }
                if (ammount == change) {//lineas de comprobación de resultados.
                    count++;
                    System.out.println(count + " Se devuelve: " + cash);
                } else{
                    System.out.println(
                            "Hubo un error durante la ejecución de su programa, sacaste 0.0!"
                    );
                    return;
                }

            } else {
                showChangeInDisplay(d + 1);// siguiente denominación
            }
            while (store[d] > 0) {
                store[d] -= 1;
                total -= coins[d];
                showChangeInDisplay(d + 1);
            }
        }
    }

}
