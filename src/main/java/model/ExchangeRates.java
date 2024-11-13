package model;

public class ExchangeRates {
    private int id;
    private int BaseCurrencyId;
    private int TargetCurrencyId;
    private long Rate;

    public ExchangeRates() {
    }

    public ExchangeRates(int baseCurrencyId, int targetCurrencyId, long rate) {
        BaseCurrencyId = baseCurrencyId;
        TargetCurrencyId = targetCurrencyId;
        Rate = rate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBaseCurrencyId() {
        return BaseCurrencyId;
    }

    public void setBaseCurrencyId(int baseCurrencyId) {
        BaseCurrencyId = baseCurrencyId;
    }

    public int getTargetCurrencyId() {
        return TargetCurrencyId;
    }

    public void setTargetCurrencyId(int targetCurrencyId) {
        TargetCurrencyId = targetCurrencyId;
    }

    public long getRate() {
        return Rate;
    }

    public void setRate(long rate) {
        Rate = rate;
    }

    @Override
    public String toString() {
        return "ExchangeRates{" +
                "id=" + id +
                ", BaseCurrencyId=" + BaseCurrencyId +
                ", TargetCurrencyId=" + TargetCurrencyId +
                ", Rate=" + Rate +
                '}';
    }
}
