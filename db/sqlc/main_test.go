package db

import (
	"database/sql"
	"log"
	"os"
	"testing"

	_ "github.com/lib/pq"
)


const (
	dbDriver = "postgres"
	dbSource = "postgresql://admin:DZg2JVG2K7NQ7kW0XEUx@localhost:5432/simple_bank?sslmode=disable"
)

var testQueries *Queries

func TestMain(m *testing.M) {
	conn, err := sql.Open(dbDriver, dbSource)
	if err != nil {
		log.Fatal("Cannot connect to database:", err)
	}

	testQueries = New(conn)

	os.Exit(m.Run())
}