package simplelifesolutions.com.shaondaggerapp_convertto_mvp.root;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.scopes.MyApplicationScope;

@Module
public class ContextModule {

    Context context;

    public ContextModule(Context context)
    {
        this.context = context;
    }

    @MyApplicationScope
    @Provides
    public Context context()
    {
        return context.getApplicationContext();
    }

}
