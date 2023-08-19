package address;

import addressViaCep.AddressViaCep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.List;

public class Address {

    private String bairro;
    private String logradouro;

    private String cep;
    private String localidade;

    private String complemento;

    private String uf;
    public Address(AddressViaCep addressViaCep){
        try{
            this.bairro = addressViaCep.bairro();
            this.logradouro = addressViaCep.logradouro();
            this.cep = addressViaCep.cep();
            this.localidade = addressViaCep.localidade();
            this.complemento = addressViaCep.complemento();
            this.uf = addressViaCep.uf();
        }catch (NullPointerException e){
            e.getMessage();
        }
    }

    public boolean verifyNullFields(){
        return bairro == null || logradouro == null || cep == null || localidade == null || uf == null;
    }



    @Override
    public String toString() {
        if(this.complemento.isEmpty()){
            return String.format("(%s, %s, %s-%s)", this.logradouro, this.bairro, this.localidade, this.uf);
        }
        return String.format("(%s, %s, %s, %s-%s)", this.logradouro, this.complemento, this.bairro, this.localidade, this.uf);
    }
}
