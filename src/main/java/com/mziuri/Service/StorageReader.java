package com.mziuri.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mziuri.Classes.AidClass;
import com.mziuri.Classes.Product;
import jakarta.persistence.*;


import java.io.File;
import java.io.IOException;
import java.util.List;

public class StorageReader {
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
        ObjectMapper objectMapper = new ObjectMapper();
        AidClass aidClass = null;
        try {
            aidClass = objectMapper.readValue(new File("src/main/resources/storage.json"), AidClass.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Product> list = databaseManager.read();
        if (list.isEmpty()) {
            for (int i = 0; i < aidClass.getArrayList().size(); i++) {
                System.out.println(aidClass.getArrayList().get(i) + "////");
                databaseManager.write(aidClass.getArrayList().get(i));
            }
        }
    }
}

