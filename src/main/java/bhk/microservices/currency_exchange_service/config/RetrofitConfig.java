package bhk.microservices.currency_exchange_service.config;



import bhk.microservices.currency_exchange_service.services.MyApiExchangerateApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Configuration
public class RetrofitConfig {



    @Bean
    public Retrofit retrofit() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);

        return new Retrofit.Builder()
                .baseUrl("https://v6.exchangerate-api.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @Bean
    public MyApiExchangerateApi myApiService(Retrofit retrofit) {
        return retrofit.create(MyApiExchangerateApi.class);
    }
}
