#!/bin/bash

echo "########### Creating profile ###########"
aws configure set aws_access_key_id localstack_access_key --profile=localstack
aws configure set aws_secret_access_key localstack_secret_key --profile=localstack
aws configure set region us-east-1 --profile=localstack

echo "########### Setting default profile ###########"
export AWS_DEFAULT_PROFILE=localstack