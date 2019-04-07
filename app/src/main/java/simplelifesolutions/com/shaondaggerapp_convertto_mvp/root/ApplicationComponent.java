package simplelifesolutions.com.shaondaggerapp_convertto_mvp.root;

import dagger.Component;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.http.APIInterface;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.http.ModuleApiService;
import simplelifesolutions.com.shaondaggerapp_convertto_mvp.scopes.MyApplicationScope;

@MyApplicationScope
@Component(modules = {ModuleApiService.class})
public interface ApplicationComponent {

    APIInterface getApiService();
}
