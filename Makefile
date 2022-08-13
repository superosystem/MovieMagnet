ifneq (,$(wildcard ./.env))
    include .env
    export
    ENV_FILE_PARAM = --env-file .env
endif

docker-dev:
	docker compose -f docker/docker-compose-dev.yml up

createdb:
	docker exec -it golang-bank-api createdb --port=5432 --host=localhost --username=${DB_USERNAME} --owner=${DB_USERNAME} simple_bank

dropdb:
	docker exec -it golang-bank-api dropdb simple_bank

migrateup:
	migrate -path internal/database/migration -database "postgresql://${DB_USERNAME}:${DB_PASSWD}@localhost:5432/simple_bank?sslmode=disable" -verbose up

migratedown:
	migrate -path internal/database/migration -database "postgresql://${DB_USERNAME}:${DB_PASSWD}@localhost:5432/simple_bank?sslmode=disable" -verbose down

sqlc:
	sqlc generate

test:
	go test -v -cover ./...

.PHONY: docker-dev createdb dropdb sqlc test