package bhk.microservices.currency_exchange_service.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CurrencyResponse {

      private CurrencyCode targetCurrencyCode;    // The currency you want to convert to

      private CurrencyCode sourceCurrencyCode;    // The currency you're converting from

      private Double targetAmountConverted;      // The amount of money  converted to the target Currency

      private int serverPort;
}
