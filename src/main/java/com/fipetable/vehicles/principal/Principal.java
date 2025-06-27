package com.fipetable.vehicles.principal;

import com.fipetable.vehicles.models.Data;
import com.fipetable.vehicles.models.BrandData;
import com.fipetable.vehicles.models.Vehicle;
import com.fipetable.vehicles.models.VehicleData;
import com.fipetable.vehicles.services.ApiService;
import com.fipetable.vehicles.services.Converter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner sc = new Scanner(System.in);
    ApiService apiService = new ApiService();
    Converter converter = new Converter();
    List<Vehicle> vehicles = new ArrayList<>();
    private final String BASE_URL = "https://parallelum.com.br/fipe/api/v1/";
    private String ADRESS = "";

    public void showMenu(){
        //ADRESS = BASE_URL+selectVehicle();
        selectVehicle();
        String jsonData = apiService.getData(ADRESS);
        var data = converter.getList(jsonData, Data.class);
        printList(data, Comparator.comparing(d -> Long.parseLong(d.code())));

        selectVehicleBrand();
        jsonData = apiService.getData(ADRESS);
        var brandData = converter.getData(jsonData, BrandData.class);
        printList(brandData.models(), Comparator.comparing(d -> Long.parseLong(d.code())));

        searchVehiclesByName(brandData.models());

        selectVehicleModel();
        jsonData = apiService.getData(ADRESS);
        var modelData = converter.getList(jsonData, Data.class);
        System.out.println(modelData);

        printModelByValue(modelData);

    }


    private void selectVehicle(){
        String menu = """
                1 - Carro
                2 - Motos
                3 - Caminhões
                """;
        System.out.println(menu);
        System.out.println("Selecione o código correspondente ao veiculo: ");
        int type = Integer.parseInt(sc.nextLine());
        String urlType = "";
        if(type == 1){
            urlType = "carros/marcas";
        }else if(type == 2){
            urlType = "motos/marcas";
        }else{
            urlType = "caminhoes/marcas";
        }
        ADRESS = BASE_URL + urlType;
    }

    public void selectVehicleBrand(){
        System.out.println("Informe o código da marca para realizar a consulta: ");
        int code = Integer.parseInt(sc.nextLine());
        ADRESS +="/"+code+"/modelos";
    }

    public void selectVehicleModel(){
        System.out.println("Informe código do modelo para consultar os valores: ");
        int code = Integer.parseInt(sc.nextLine());
        ADRESS+="/"+code+"/anos";
    }

    private void printModelByValue(List<Data> data){
        for(Data d : data){
            String adress = ADRESS + "/"+d.code();
            String jsonData = apiService.getData(adress);
            System.out.println("json url: "+jsonData);
            var vehicleData = converter.getData(jsonData, VehicleData.class);
            System.out.println("url iteracao: "+vehicleData);
            vehicles.add(new Vehicle(vehicleData));
        }
    }

    public <T> void printList(List<T> list, Comparator<T> comparator){
        list.sort(comparator);
        list.forEach(System.out::println);
    }

    public void searchVehiclesByName(List<Data> vehiclesList){
        System.out.println("Digite um trecho do nome do veículo para realizar a consulta: ");
        String query = sc.nextLine().toLowerCase();
        vehiclesList.stream()
                .filter(vehicle -> vehicle.name().toLowerCase().contains(query))
                .sorted(Comparator.comparing(v -> Long.parseLong(v.code())))
                .forEach(System.out::println);
    }

}
