package com.sample.flavouredproject;

import dagger.Component;

/**
 * Created by razzle on 12/18/15.
 */

@Component(modules = {ApiModule.class})
public interface ApiComponent {

    void inject(MainActivity activity);

}
