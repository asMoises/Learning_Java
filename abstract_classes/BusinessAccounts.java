package abstract_classes;

public class BusinessAccounts extends Accounts {
    private Double loanLimit;

    public BusinessAccounts() {
        super();
    }

    public BusinessAccounts(Integer number, String holder, Double balance, Double loanLimit) {
        super(number, holder, balance);
        this.loanLimit = loanLimit;
    }

    public Double getLoanLimit() {
        return loanLimit;
    }

    public void setLoanLimit(Double loanLimit) {
        this.loanLimit = loanLimit;
    }

    public void loan(double amount) {
        if (amount <= loanLimit) {
            balance += amount - 10.0;
        }
    }

    @Override
    public void withDraw(double amount) {
        super.withDraw(amount);
        balance -= 2.0;
    }
}
