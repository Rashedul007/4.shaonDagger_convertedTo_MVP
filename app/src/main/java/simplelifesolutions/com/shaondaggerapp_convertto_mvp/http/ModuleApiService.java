package simplelifesolutions.com.shaondaggerapp_convertto_mvp.http;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.scopes.MyApplicationScope;

@Module(includes = ModuleHttpClient.class)
public class ModuleApiService
{

    @Provides
    public APIInterface provideApiInterface(Retrofit mRetrofit)
    {
       return  mRetrofit.create(APIInterface.class);
    }

    @MyApplicationScope
    @Provides
    public Retrofit provideRetrofit(OkHttpClient mOkhttpClient, GsonConverterFactory mGsonConverterfactory)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://randomuser.me")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(mGsonConverterfactory)
                .client(mOkhttpClient)
                .build();


        return retrofit;
    }

    @MyApplicationScope
    @Provides
    public GsonConverterFactory provideGsonConverterFactory()
    {
        return  GsonConverterFactory.create();

    }

}
