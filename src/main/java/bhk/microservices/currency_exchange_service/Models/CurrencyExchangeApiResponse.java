package bhk.microservices.currency_exchange_service.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchangeApiResponse {

    private String result;
    private String base_code;
    private Map<CurrencyCode, Double> conversion_rates;

    // Method to get conversion rate for a specific currency
    public Double getConversionRate(CurrencyCode currencyCode) {
        return conversion_rates.get(currencyCode);
    }

    @Override
    public String toString() {
        return "Base Currency: " + base_code + "\nConversion Rates: " + conversion_rates;
    }


}
