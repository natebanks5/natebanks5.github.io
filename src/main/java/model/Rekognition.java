/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.rekognition.model.AmazonRekognitionException;
import com.amazonaws.services.rekognition.model.DetectLabelsResult;
import com.amazonaws.services.rekognition.model.DetectTextRequest;
import com.amazonaws.services.rekognition.model.DetectTextResult;
import com.amazonaws.services.rekognition.model.Image;
import com.amazonaws.services.rekognition.model.Label;
import com.amazonaws.services.rekognition.model.S3Object;
import com.amazonaws.services.rekognition.model.TextDetection;
import com.amazonaws.util.IOUtils;
import java.io.IOException;

/**
 *Model class to utilize Amazon Rekognition API
 * @author hoovb
 */
public class Rekognition {

    AmazonRekognition rekognitionClient;

    /**
     * Digitizes the text found in an image
     * @param photo
     * @return
     * @throws IOException 
     */
    public String digitizeText(String photo) throws IOException {
        BasicAWSCredentials creds = new BasicAWSCredentials("AKIAINPI6PCQUEK67HPA", "xzanBqXX7+9jYGRDdDEsHnWSVd4gsNMX5+wQ4y5D");
        rekognitionClient = AmazonRekognitionClientBuilder.standard()
                .withRegion("us-east-1")
                .withCredentials(new AWSStaticCredentialsProvider(creds))
                .build();
        ByteBuffer imageBytes;
        StringBuilder sb = new StringBuilder();
        try (InputStream inputStream = new FileInputStream(new File(photo))) {
            imageBytes = ByteBuffer.wrap(IOUtils.toByteArray(inputStream));
        }
        /*DetectLabelsRequest request = new DetectLabelsRequest()
                .withImage(new Image()
                        .withBytes(imageBytes))
                .withMaxLabels(10)
                .withMinConfidence(77F); */
        DetectTextRequest request = new DetectTextRequest()
                .withImage(new Image()
                        .withBytes(imageBytes));
        try {
            DetectTextResult result = rekognitionClient.detectText(request);
            List<TextDetection> textDetections = result.getTextDetections();
            System.out.println("Detected lines and words for " + photo);
            for (TextDetection text : textDetections) {
                if (text.getParentId() == null){
                sb.append(text.getDetectedText());
                }
                System.out.println("Detected: " + text.getDetectedText());
                System.out.println("Confidence: " + text.getConfidence().toString());
                System.out.println("Id : " + text.getId());
                System.out.println("Parent Id: " + text.getParentId());
                System.out.println("Type: " + text.getType());
                System.out.println();
            }
        } catch (AmazonRekognitionException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}
