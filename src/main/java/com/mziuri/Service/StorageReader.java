package com.mziuri.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mziuri.Classes.AidClass;
import com.mziuri.Classes.Product;
import jakarta.persistence.*;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class StorageReader{
    private static StorageReader instance;
    private List<Product> products;

    public StorageReader() {
        readStorageFile();
    }

    public static StorageReader getInstance() {
        if (instance == null) {
            instance = new StorageReader();
        }
        return instance;
    }

    private void readStorageFile() {
        DatabaseManager databaseManager = new DatabaseManager();
        ObjectMapper mapper = new ObjectMapper();
        AidClass aidClass = null;
        try {
            aidClass = mapper.readValue(new File("src/main/resources/storage.json"), new TypeReference<AidClass>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(int i=0; i<aidClass.getArrayList().size(); i++){
            databaseManager.write(aidClass.getArrayList().get(i));
        }
    }
}

