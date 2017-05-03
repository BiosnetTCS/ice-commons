package com.biosnettcs.main;

public class AppMain {
    /*
	public static void main(String args[]){
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("quartz-context.xml");
	}
	*/
    
    public static void main(String args[]) {

        int [] arr = new int[]{3, 10, 6, 8, 55, 20, 100};                 
        ordenaArreglo(arr);
        
        System.out.println("Array ordenado:");
        for(int n: arr) {
            System.out.print(n+ " ");
        }
    }

    public static int factorial(double number) {
        if (number <= 1)
            return 1;
        else
            return (int) (number * factorial(number - 1));
    }

    
    public static void ordenaArreglo(int[] arr) {
        int aux = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    aux = arr[i];
                    arr[i] = arr[j];
                    arr[j] = aux;
                }
            }
        }
    }


}
