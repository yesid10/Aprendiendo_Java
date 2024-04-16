public class Main {
    public static void main(String[] args) {
        String res = "";
        Integer cont =0;
        Integer num =1;
        while(cont < 100){
            if(esPrimo(num)) {
                res += num + ",";
                cont++;
            }
            num++;
        }
        System.out.println("Los primeros 100 numeros primos son: " + res);
    }

    private static Boolean esPrimo(Integer num){
        Boolean esNumPrimo = true;

        for(int i=2; i<num ; i++){
            if(num % i == 0){
                esNumPrimo = false;
            }
        }
        return esNumPrimo;
    }
}