package handler

import (
	"fmt"
	"net/http"
	"strconv"
)

func HomeHandler(w http.ResponseWriter, r *http.Request) {
	if r.URL.Path != "/" {
		http.NotFound(w, r)
		return
	}
	w.Write([]byte("Hello World!"))
}

func AboutHandler(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("About Page"))
}

func SkillsHandler(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("Skills Page"))
}

func ProjectsHandler(w http.ResponseWriter, r *http.Request) {
	id := r.URL.Query().Get("id")
	idNumb, err := strconv.Atoi(id)

	if err != nil || idNumb < 1 {
		http.NotFound(w, r)
		return
	}

	fmt.Fprintf(w, "Project page: %d", idNumb)
}

func ContactHandler(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("Contact Page"))
}
