package com.fipetable.vehicles.principal;

import com.fipetable.vehicles.models.Data;
import com.fipetable.vehicles.services.ApiService;
import com.fipetable.vehicles.services.Converter;

import java.util.Scanner;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    ApiService apiService = new ApiService();
    Converter converter = new Converter();
    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";
    private String ADRESS = "";
    public void showMenu(){
        ADRESS = BASE_URL+selectVehicle();
        String jsonData = apiService.getData(ADRESS);
        var data = converter.getList(jsonData, Data.class);
        System.out.println(data);
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
