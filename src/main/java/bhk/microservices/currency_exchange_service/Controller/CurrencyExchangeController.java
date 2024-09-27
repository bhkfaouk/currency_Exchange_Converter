package bhk.microservices.currency_exchange_service.Controller;

import bhk.microservices.currency_exchange_service.Models.CurrencyRequest;
import bhk.microservices.currency_exchange_service.Models.CurrencyResponse;

import bhk.microservices.currency_exchange_service.microcervicesConfig.currencyExchangeServiceProxy;
import bhk.microservices.currency_exchange_service.services.ExchangeService;
import bhk.microservices.currency_exchange_service.services.ExchangeServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
@Slf4j
@RestController("/exchange")
@RequiredArgsConstructor
public class CurrencyExchangeController {

    private final ExchangeService exchangeService;

    private final currencyExchangeServiceProxy proxy;

@PostMapping("/exchangeValue")
    public ResponseEntity<CurrencyResponse> getExchangeValue(@RequestBody CurrencyRequest currencyRequest) throws IOException {


log.info("request :{}",currencyRequest + " from getExchangeValue method");
     return ResponseEntity.ok(exchangeService.convertCurrency(currencyRequest));

}



}
