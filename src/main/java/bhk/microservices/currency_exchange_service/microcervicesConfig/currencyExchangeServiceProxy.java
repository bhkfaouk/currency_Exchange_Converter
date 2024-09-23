package bhk.microservices.currency_exchange_service.microcervicesConfig;

import bhk.microservices.currency_exchange_service.Models.CurrencyRequest;
import bhk.microservices.currency_exchange_service.Models.CurrencyResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
public interface currencyExchangeServiceProxy {

    @GetMapping("/convert")
    public ResponseEntity<CurrencyResponse> getExchangeValue(@RequestBody CurrencyRequest currencyRequest) throws IOException;


}
