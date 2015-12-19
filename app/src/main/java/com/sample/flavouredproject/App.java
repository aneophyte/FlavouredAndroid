package com.sample.flavouredproject;

import android.app.Application;

/**
 * Created by razzle on 12/18/15.
 */
public class App extends Application {

    private static final String BASE_URL = "https://gist.githubusercontent.com/aneophyte/974ce781b25bc2f73be5/raw/0214391ea6a3a08d0824831271f4fd3de9202bea/";

    private static App sInstance;
    private ApiComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        sInstance = this;

        if(component == null) {
            ApiModule module = new ApiModule(BASE_URL);
            component = DaggerApiComponent.builder().apiModule(module).build();
        }
    }

    public static void inject(MainActivity activity) {
        sInstance.component.inject(activity);
    }

}
