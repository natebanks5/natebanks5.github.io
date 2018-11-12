/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.model.AttributeDefinition;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.CreateTableResult;
import com.amazonaws.services.dynamodbv2.model.KeySchemaElement;
import com.amazonaws.services.dynamodbv2.model.KeyType;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.dynamodbv2.model.ScalarAttributeType;
import com.amazonaws.services.dynamodbv2.model.TableDescription;

/**
 * Model class that utilizes DyamoDB hosted
 * on AWS to add new users.
 * @author hoovb
 */
public class UserTable {

    BasicAWSCredentials creds;
    AmazonDynamoDB client;
    DynamoDB db;
    TableDescription tableDescription;
    Table table;

    public UserTable() {
        createTable();
    }

    /**
     * Creates a data table with username as primary key
     * and also a password field.
     */
    public void createTable() {
        CreateTableRequest request = new CreateTableRequest()
                .withAttributeDefinitions(new AttributeDefinition(
                        "Username", ScalarAttributeType.S))
                .withKeySchema(new KeySchemaElement("Username", KeyType.HASH))
                .withProvisionedThroughput(new ProvisionedThroughput(
                        new Long(5), new Long(5)))
                .withTableName("IST440Users");

        creds = new BasicAWSCredentials("AKIAINPI6PCQUEK67HPA", "xzanBqXX7+9jYGRDdDEsHnWSVd4gsNMX5+wQ4y5D");
        client = AmazonDynamoDBClientBuilder.standard().
                withRegion("us-east-1")
                .withCredentials(new AWSStaticCredentialsProvider(creds))
                .build();

        db = new DynamoDB(client);
        table = db.getTable("IST440Users");
      
        
        tableDescription = table.describe();
        System.out.printf("%s: %s \t ReadCapacityUnits: %d \t WriteCapacityUnits: %d\n",
                tableDescription.getTableStatus(),
                tableDescription.getTableName(),
                tableDescription.getProvisionedThroughput().getReadCapacityUnits(),
                tableDescription.getProvisionedThroughput().getWriteCapacityUnits()); 
    }

    /**
     * Adds a new user to the database
     */
    public void addUser() {
        PutItemRequest request = new PutItemRequest().withTableName("IST440Users").withReturnConsumedCapacity("TOTAL");
        PutItemResult response = client.putItem(request);
    }
}
