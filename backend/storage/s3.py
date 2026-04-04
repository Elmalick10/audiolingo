import boto3

s3 = boto3.client("s3")

def upload(file, name):
    s3.upload_file(file, "audiolingo-bucket", name)