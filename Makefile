ifneq (,$(wildcard ./.env))
    include .env
    export
    ENV_FILE_PARAM = --env-file .env
endif

postgres:
	docker-compose up

createdb:
	docker exec -it golang-bank-api createdb --username=${DB_USERNAME} --owner=${DB_USERNAME} --password=${DB_PASSWD} simple_bank

dropdb:
	docker exec -it golang-bank-api dropdb simple_bank

migrateup:
	migrate -path db/migration -database "postgresql://${DB_USERNAME}:${DB_PASSWD}@localhost:5432/simple_bank?sslmode=disable" -verbose up

migratedown:
	migrate -path db/migration -database "postgresql://${DB_USERNAME}:${DB_PASSWD}@localhost:5432/simple_bank?sslmode=disable" -verbose down

sqlc:
	sqlc generate

test:
	go test -v -cover ./...

.PHONY: postgres createdb dropdb test