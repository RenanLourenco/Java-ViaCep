import address.Address;
import address.StorageAddress;
import addressViaCep.AddressViaCep;

import viacep.ViaCep;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        ViaCep viacep = new ViaCep();
        List<Address> enderecos = new ArrayList<>();

        System.out.println("""
                *********************************************************************
                        - Olá, seja bem vindo ao buscar de endereço.
                        
                        Digite o cep ou digite "sair" para finalizar o sistema.
                        
                *********************************************************************
                """);

        String out = "";


        while (!out.equalsIgnoreCase("sair")){
            String cep = read.nextLine();

            if(cep.equals("sair")){
                out = "sair";
                System.out.println("Endereços encontrados: " + enderecos);
                System.out.println("GUARDANDO ENDERECOS (enderecos.json)");
                StorageAddress.storageData(enderecos);
                System.out.println("Programa finalizado.");
                break;
            }
            AddressViaCep busca = viacep.findStreetForCep(cep);
            Address endereco = new Address(busca);

            if(endereco.verifyNullFields()){
                System.out.println("Cep invalido!!");
            }else {
                System.out.println("Endereço encontrado: " + endereco);
                System.out.println("Inserindo na lista de endereços..");
                enderecos.add(endereco);
            }

            System.out.println("Digite o cep ou digite 'sair' para finalizar o programa. ");

        }






    }
}
