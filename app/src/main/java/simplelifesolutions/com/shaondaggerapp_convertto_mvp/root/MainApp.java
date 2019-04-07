package simplelifesolutions.com.shaondaggerapp_convertto_mvp.root;

import android.app.Application;

import simplelifesolutions.com.shaondaggerapp_convertto_mvp.mainActivity.MainActivity;


public class MainApp extends Application {

    private ApplicationComponent mApiServiceComp;

    public static MainApp getAppInstance(MainActivity mAct)
    {
        return (MainApp) mAct.getApplication();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        mApiServiceComp = DaggerApplicationComponent.builder()
                            //.contextModule(new ContextModule(this))
                            .build();
    }


    public ApplicationComponent getAPIserviceComponents()
    {
        return mApiServiceComp ;
    }

}
