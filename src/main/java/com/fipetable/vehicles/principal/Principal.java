package com.fipetable.vehicles.principal;

import java.util.Scanner;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";
    private String ADRESS = "";
    public void showMenu(){
        ADRESS = BASE_URL+selectVehicle();

    }

    private String selectVehicle(){
        String menu = """
                1 - Carro
                2 - Motos
                3 - Caminhões
                """;
        System.out.println(menu);
        System.out.println("Selecione o código correspondente ao veiculo: ");
        int type = sc.nextInt();
        if(type == 1){
            return "carros/marcas";
        }else if(type == 2){
            return "motos/marcas";
        }else{
            return "caminhoes/marcas";
        }
    }

}
