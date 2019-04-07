package simplelifesolutions.com.shaondaggerapp_convertto_mvp.mainActivity;


import dagger.Module;
import dagger.Provides;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.http.APIInterface;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.mainActivity.mainActivity_MVP.MainActMVP;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.mainActivity.mainActivity_MVP.MainActModel;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.mainActivity.mainActivity_MVP.MainActPresenter;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.mainActivity.mainActivity_MVP.MainActRepository;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.mainActivity.mainActivity_MVP.Repository;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.scopes.MyActivityScope;

@Module
public class MainActivityModule {

    private final MainActivity mMainActivity;

    public MainActivityModule(MainActivity mActivity)
    {
            this.mMainActivity = mActivity ;
    }


    @MyActivityScope
    @Provides
    public MyRecyclerAdapter provideRecyclerAdapter()
    {
        return new MyRecyclerAdapter(mMainActivity.getApplicationContext());
    }

    @Provides
    public MainActMVP.Presenter provideMainActPresenter(MainActMVP.Model mModel) {
        return new MainActPresenter(mModel);
    }

    @Provides
    public MainActMVP.Model provideTopMoviesActivityModel(Repository repository) {
        return new MainActModel(repository);
    }

    @MyActivityScope
    @Provides
    public Repository provideRepo(APIInterface mRetrofitInterfaced) {
        return new MainActRepository(mRetrofitInterfaced);
    }


}
