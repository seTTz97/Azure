package com.example.AzureApp2;

import com.example.AzureApp2.model.Author;
import com.example.AzureApp2.model.StorageResponse;
import com.microsoft.azure.storage.StorageException;
import com.microsoft.azure.storage.blob.CloudBlobContainer;
import com.microsoft.azure.storage.blob.CloudBlockBlob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
public class FirstWebAppApplication {
    @Autowired
    CloudBlobContainer blobContainer;

    public static void main(String[] args) {
        SpringApplication.run(FirstWebAppApplication.class, args);
    }

	public StorageResponse upload(Author author, CloudBlobContainer cloudBlobContainer){
		URI uri = null;
		boolean error = false;
		CloudBlockBlob blob = null;
		try {
			blob = cloudBlobContainer.getBlockBlobReference(author.getId()+".txt");
			blob.uploadText(author.toString());
			// blob.upload(new ByteArrayInputStream(multipartFile), -1);
			uri = blob.getUri();
		} catch (URISyntaxException e) {
			error =true;
			e.printStackTrace();
		} catch (StorageException e) {
			error =true;
			e.printStackTrace();
		}catch (IOException e) {
			error =true;
			e.printStackTrace();
		}

		return new StorageResponse(uri.toString(),error, HttpStatus.OK.toString());
	}

}
