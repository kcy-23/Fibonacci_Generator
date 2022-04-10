docker build . -t fibo_generator/app
docker run --rm -d -p 8080:8080 --name fibo_generator fibo_generator/app:latest