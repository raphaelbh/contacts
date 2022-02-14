#!/bin/bash

echo "########### Create table ###########"
aws dynamodb create-table \
    --endpoint-url http://localhost:4566 \
    --table-name contacts \
    --attribute-definitions AttributeName=id,AttributeType=S \
    --key-schema AttributeName=id,KeyType=HASH \
    --provisioned-throughput ReadCapacityUnits=10,WriteCapacityUnits=5
    