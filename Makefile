docker-image:
	docker build -t $(name) ./$(on)/

docker-container:
	docker compose up