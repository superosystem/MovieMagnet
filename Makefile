postgres:
    docker-compose up

createdb:
    docker exec -it golang-bank-api createdb --username=admin --owner=admin --password=DZg2JVG2K7NQ7kW0XEUx simple_bank

dropdb:
    docker exec -it golang-bank-api dropdb simple_bank

migrateup:
    migrate -path db/migration -database "postgresql://admin:DZg2JVG2K7NQ7kW0XEUx@localhost:5432/simple_bank?sslmode=disable" -verbose up

migratedown:
    migrate -path db/migration -database "postgresql://admin:secDZg2JVG2K7NQ7kW0XEUxret@localhost:5432/simple_bank?sslmode=disable" -verbose down

sqlc:
    sqlc generate

.PHONY: postgres createdb dropdb sqlc