package handler

import (
	"html/template"
	"log"
	"net/http"
	"path"
	"strconv"

	"github.com/gusrylmubarok/golang-web/entity"
)

/////
// Handler Function for Home View
/////
func HomeHandler(w http.ResponseWriter, r *http.Request) {
	if r.URL.Path != "/" {
		http.NotFound(w, r)
		return
	}
	
	tmpl, err := template.ParseFiles(path.Join("view", "index.html"), path.Join("view", "layout.html"))
	if err != nil {
		log.Println(err)
		mClient := "400 - That's an error \nThe request URL doesn't was found on this server. That's all we know."
		http.Error(w, mClient, http.StatusInternalServerError)
		return
	}

	// data := entity.Product{ID: 1, Name: "Avanza", Price: 250000000, Stock: 5}
	data := []entity.Product{
		{ID: 1, Name: "Avanza", Price: 250000000, Stock: 5},
		{ID: 1, Name: "Honda", Price: 230000000, Stock: 8},
		{ID: 1, Name: "Daihatsu", Price: 210000000, Stock: 10},
	}

	err = tmpl.Execute(w, data)
	if err != nil {
		log.Println(err)
		mClient := "400 - That's an error \nThe request URL doesn't was found on this server. That's all we know."
		http.Error(w, mClient, http.StatusInternalServerError)
		return
	}
}

/////
// Handler Function for About View 
/////
func AboutHandler(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("About Page"))
}

/////
// Handler Function for Product View 
/////
func ProductHandler(w http.ResponseWriter, r *http.Request) {
	id := r.URL.Query().Get("id")
	idNumb, err := strconv.Atoi(id)

	if err != nil || idNumb < 1 {
		http.NotFound(w, r)
		return
	}

	// fmt.Fprintf(w, "Project page: %d", idNumb)
	data := map[string]interface{}{
		"content": idNumb,
	}

	tmpl, err := template.ParseFiles(path.Join("view", "product.html"), path.Join("view", "layout.html"))
	if err != nil {
		log.Println(err)
		http.Error(w, "400 - That's an error \nThe request URL doesn't was found on this server. That's all we know.", http.StatusInternalServerError)
		return
	}

	err = tmpl.Execute(w, data)
	if err != nil {
		log.Println(err)
		http.Error(w, "400 - That's an error \nThe request URL doesn't was found on this server. That's all we know.", http.StatusInternalServerError)
		return
	}
}


