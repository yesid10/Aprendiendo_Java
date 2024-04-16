import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        System.out.println("Ingrese tres numeros: ");
        int num1 = scaner.nextInt();
        int num2 = scaner.nextInt();
        int num3 = scaner.nextInt();

        calcularNumeroMayor(num1, num2, num3);
        calcularNumeroMenor(num1, num2, num3);

        Double res = promedioNumeros(Double.valueOf(num1),Double.valueOf(num2), Double.valueOf(num3));
        System.out.println(res);
        numParImpar(num1);
    }


    private static void calcularNumeroMayor(int num1, int num2, int num3){
        if(num1 > num2 && num1 > num3){
            System.out.println("El numero mayor es: " + num1);
        } else if (num2>num1 && num2 > num3) {
            System.out.println("El numero mayor es: " + num2);
        }else{
            System.out.println("El numero mayor es: " + num3);
        }

    }
    private static void calcularNumeroMenor(int num1, int num2, int num3){
        if(num1 < num2 && num1 < num3){
            System.out.println("El numero menor es: " + num1);
        } else if (num2<num1 && num2 < num3) {
            System.out.println("El numero menor es: " + num2);
        }else{
            System.out.println("El numero menor es: " + num3);
        }

    }

    private static Double promedioNumeros(Double num1, Double num2, Double num3){
        Double sum = (num1+num2+num3)/3;
        return sum;
    }
    private static void numParImpar(int num1){
        if((num1%2)==0){
            System.out.println("El numero es par.");
        }else{
            System.out.println("El numero es impar");
        }
    }
}