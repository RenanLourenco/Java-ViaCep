package address;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class StorageAddress {

    public static void storageData(List<Address> enderecos){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            FileWriter write = new FileWriter("enderecos.json");
            write.write(gson.toJson(enderecos));
            write.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
