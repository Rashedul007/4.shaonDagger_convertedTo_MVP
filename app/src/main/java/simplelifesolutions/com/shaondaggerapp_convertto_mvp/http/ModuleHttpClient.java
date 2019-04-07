package simplelifesolutions.com.shaondaggerapp_convertto_mvp.http;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.scopes.MyApplicationScope;

//(includes = ContextModule.class)

@Module
public class ModuleHttpClient {

    @MyApplicationScope
    @Provides
    public OkHttpClient provideHttpClient(HttpLoggingInterceptor mHttpInterceptor) // , Cache mCache)
    {
        OkHttpClient client = new OkHttpClient.Builder()
                                    .addInterceptor(mHttpInterceptor)
                                    //.cache(mCache)
                                    .build();

        return client;
    }

    @MyApplicationScope
    @Provides
    public HttpLoggingInterceptor provideHttpLogInterceptor()
    {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return interceptor;
    }


    /*@Provides
    public Cache provideCache(File mCahecFile)
    {
        return new Cache(mCahecFile , 10*1000*1000);

    }

    @Provides
    public File provideFile(Context mContext)
    {
        File fl = new File(mContext.getCacheDir() , "httpCache");
        fl.mkdirs();

        return fl;

    }*/
}
