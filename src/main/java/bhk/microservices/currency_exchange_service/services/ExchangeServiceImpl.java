package bhk.microservices.currency_exchange_service.services;

import bhk.microservices.currency_exchange_service.Models.CurrencyExchangeApiResponse;
import bhk.microservices.currency_exchange_service.Models.CurrencyRequest;
import bhk.microservices.currency_exchange_service.Models.CurrencyResponse;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExchangeServiceImpl implements ExchangeService{
    @Value("${exchange_rate_api_app_key}")
    private String apiKey;

    private final MyApiExchangerateApi myApiExchangerateApi;

    private final Environment environment;

    @Override
    public CurrencyResponse convertCurrency(CurrencyRequest currencyRequest) throws IOException {

        Call<CurrencyExchangeApiResponse> call = myApiExchangerateApi.getExchangeRates(apiKey,currencyRequest.getSourceCurrencyCode().name());
        Response<CurrencyExchangeApiResponse> response = call.execute();

        if(response.isSuccessful()){
        CurrencyExchangeApiResponse exchangeApiResponse = response.body();
        CurrencyResponse currencyResponse = CurrencyResponse.builder()
                .sourceCurrencyCode(currencyRequest.getSourceCurrencyCode())
                .targetCurrencyCode(currencyRequest.getTargetCurrencyCode())
                .targetAmountConverted(exchangeApiResponse.getConversionRate(currencyRequest.getTargetCurrencyCode()))
                .serverPort(Integer.parseInt(environment.getProperty("server.port")))
                .build();
            return currencyResponse;
        }
        else throw new IOException("eroor in exchange currency please try later "+response.errorBody().string());

    }
}
