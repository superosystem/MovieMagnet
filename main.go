package main

import (
	"log"
	"net/http"

	"github.com/gusrylmubarok/golang-web/handler"
)

func main() {
	mux := http.NewServeMux()

	mux.HandleFunc("/", handler.HomeHandler)
	mux.HandleFunc("/about", handler.AboutHandler)
	mux.HandleFunc("/product", handler.ProductHandler)
	
	log.Println("Starting WEB on port 8080")

	err := http.ListenAndServe(":8080", mux)
	log.Fatal(err)
}
