package bhk.microservices.currency_exchange_service.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CurrencyRequest {

    private CurrencyCode targetCurrencyCode;    // The currency you want to convert to

    private CurrencyCode sourceCurrencyCode;    // The currency you're converting from

    private Double sourceAmountToConvert;      // The amount of money to be converted


}
