package simplelifesolutions.com.shaondaggerapp_convertto_mvp.mainActivity;

import dagger.Component;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.scopes.MyActivityScope;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.root.ApplicationComponent;


@MyActivityScope
@Component(modules = {MainActivityModule.class} , dependencies = {ApplicationComponent.class} )
public interface MainActivityComponent {

   /* MyRecyclerAdapter getRecyclerAdapter();  //inject this

    APIInterface getApiInterfaceCall();  //inject this*/


       void injectMainActivity(MainActivity mainActivity);
}
