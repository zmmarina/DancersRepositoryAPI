package com.zmonteiro.dancersapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import static com.zmonteiro.dancersapi.constants.DancersConstant.ENDPOINT_DYNAMO;
import static com.zmonteiro.dancersapi.constants.DancersConstant.REGION_DYNAMO;

public class DancersData {
    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();

        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Dancers_Table");
        Item dancer = new Item()
                .withPrimaryKey("id", 1)
                .withString("name", "Alina Cojocaru")
                .withString("type", "Classic")
                .withNumber("presentations", 100);

        PutItemOutcome outcome = table.putItem(dancer);
    }
}
