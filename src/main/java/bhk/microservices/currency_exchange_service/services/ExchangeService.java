package bhk.microservices.currency_exchange_service.services;

import bhk.microservices.currency_exchange_service.Models.CurrencyRequest;
import bhk.microservices.currency_exchange_service.Models.CurrencyResponse;

import java.io.IOException;

public interface ExchangeService {

CurrencyResponse convertCurrency(CurrencyRequest currencyRequest) throws IOException;


}
