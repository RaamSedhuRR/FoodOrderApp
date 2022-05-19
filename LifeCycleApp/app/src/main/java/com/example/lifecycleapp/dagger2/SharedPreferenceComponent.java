package com.example.lifecycleapp.dagger2;
import com.example.lifecycleapp.fragments.Dagger2Fragment;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(modules = {SharedPreferenceModule.class})
public interface SharedPreferenceComponent {
    void inject(Dagger2Fragment dagger2Fragment);
}