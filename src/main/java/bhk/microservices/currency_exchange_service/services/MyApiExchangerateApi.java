package bhk.microservices.currency_exchange_service.services;

import bhk.microservices.currency_exchange_service.Models.CurrencyExchangeApiResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyApiExchangerateApi {



    // The currencyCode parameter will replace the "{currencyCode}" part of the URL.
    @GET("v6/{apiKey}/latest/{currencyCode}")
    Call<CurrencyExchangeApiResponse> getExchangeRates(
            @Path("apiKey") String apiKey,
            @Path("currencyCode") String currencyCode
    );
}
