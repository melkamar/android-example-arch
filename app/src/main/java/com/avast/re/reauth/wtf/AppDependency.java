package com.avast.re.reauth.wtf;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.logging.Logger;

@Singleton
public final class AppDependency {
//    @Inject
//    AppDependency() {
//    }

    public int test(){
        Logger l = Logger.getLogger(this.getClass().getName());
        l.info("WORKING");
        return 1;
    }
}
