import boto3

s3 = boto3.client(
    "s3",
    endpoint_url="https://<account>.r2.cloudflarestorage.com",
    aws_access_key_id="KEY",
    aws_secret_access_key="SECRET"
)

def upload_file(file, name):
    s3.upload_fileobj(file, "audiolingo", name)