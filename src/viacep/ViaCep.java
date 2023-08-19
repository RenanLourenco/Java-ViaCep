package viacep;

import addressViaCep.AddressViaCep;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ViaCep {
    private String url;

    public ViaCep(){
        this.url = "https://viacep.com.br/ws";
    }

    public AddressViaCep findStreetForCep(String cep){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(buildUrl(cep)))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            AddressViaCep addressViaCep = gson.fromJson(json, AddressViaCep.class);
            return addressViaCep;
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    private String buildUrl(String cep){
        String url = String.format("%s/%s/json/", this.url, cep);

        return url;
    }


}
