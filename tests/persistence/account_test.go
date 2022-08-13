package testing

import (
	"context"
	"database/sql"
	"testing"
	"time"

	"github.com/gusrylmubarok/golang-bank-api/internal/database"
	"github.com/gusrylmubarok/golang-bank-api/internal/utility"
	"github.com/stretchr/testify/require"
)

func createRandomAccount(t *testing.T) Account {
	arg := CreateAccountParams{
		Owner: utility.RandomOwner(),
		Balance: utility.RandomMoney(),
		Currency: utility.RandomCurrency(),
	}

	account, err := testQueries.CreateAccount(context.Background(), arg)

	require.NoError(t, err)
	require.NotEmpty(t, account)

	require.Equal(t, arg.Owner, account.Owner)
	require.Equal(t, arg.Balance, account.Balance)
	require.Equal(t, arg.Currency, account.Currency)

	require.NotZero(t, account.ID)
	require.NotZero(t, account.CreatedAt)

	return account
}

func TestCreateAccount(t *testing.T) {
	createRandomAccount(t)
}

func TestGetAccount(t *testing.T) {
	account1 := createRandomAccount(t)
	accountActual, err := testQueries.GetAccount(context.Background(), account1.ID)
	require.NoError(t, err)
	require.NotEmpty(t, accountActual)

	require.Equal(t, account1.ID, accountActual.ID)
	require.Equal(t, account1.Owner, accountActual.Owner)
	require.Equal(t, account1.Balance, accountActual.Balance)
	require.Equal(t, account1.Currency, accountActual.Currency)
	require.WithinDuration(t, account1.CreatedAt, accountActual.CreatedAt, time.Second)
}


func TestUpdateAccount(t *testing.T) {
	account1 := createRandomAccount(t)

	arg := UpdateAccountParams{
		ID: account1.ID,
		Balance: account1.Balance,
	}

	accountActual, err := testQueries.UpdateAccount(context.Background(), arg)
	require.NoError(t, err)
	require.NotEmpty(t, accountActual)

	require.Equal(t, account1.ID, accountActual.ID)
	require.Equal(t, account1.Owner, accountActual.Owner)
	require.Equal(t, arg.Balance, accountActual.Balance)
	require.Equal(t, account1.Currency, accountActual.Currency)
	require.WithinDuration(t, account1.CreatedAt, accountActual.CreatedAt, time.Second)
}

func TestDeleteAccount(t *testing.T) {
	account1 := createRandomAccount(t)
	err := testQueries.DeleteAccount(context.Background(), account1.ID)
	require.NoError(t, err)

	accountActual, err := testQueries.GetAccount(context.Background(), account1.ID)
	require.Error(t, err)
	require.EqualError(t, err, sql.ErrNoRows.Error())
	require.Empty(t, accountActual)
}

func TestListAccounts(t *testing.T) {
	var lastAccount Account
	for i := 0; i < 10; i++ {
		lastAccount = createRandomAccount(t)
	}

	arg := ListAccountsParams{
		Owner:	lastAccount.Owner,
		Limit: 5,
		Offset: 0,
	}

	accounts, err := testQueries.ListAccounts(context.Background(), arg)
	require.NoError(t, err)
	require.NotEmpty(t, accounts)

	for _, account := range accounts {
		require.NotEmpty(t, account)
		require.Equal(t, lastAccount.Owner, account.Owner)
	}
}

