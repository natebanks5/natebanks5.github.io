/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.translate.AmazonTranslate;
import com.amazonaws.services.translate.AmazonTranslateClientBuilder;
import com.amazonaws.services.translate.model.TranslateTextRequest;
import com.amazonaws.services.translate.model.TranslateTextResult;

/**
 *Model class that utilizes Amazon Translation API
 * @author hoovb
 */
public class Translation {

    /**
     * Translates text that has been digitized
     * to English.
     * @param text
     * @return 
     */
    public String translateText(String text) {
        BasicAWSCredentials creds = new BasicAWSCredentials("AKIAINPI6PCQUEK67HPA", "xzanBqXX7+9jYGRDdDEsHnWSVd4gsNMX5+wQ4y5D");
        
        AmazonTranslate translate = AmazonTranslateClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(creds))
                .withRegion("us-east-1")
                .build();
                
        TranslateTextRequest request = new TranslateTextRequest()
                .withText(text)
                .withSourceLanguageCode("auto")
                .withTargetLanguageCode("en");
        TranslateTextResult result = translate.translateText(request);
        System.out.println("Detected language: " + result.getSourceLanguageCode());
        return result.getTranslatedText();
    }
}
