package com.avast.re.reauth.wtf;

import javax.inject.Inject;
import javax.inject.Scope;
import javax.inject.Singleton;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class Util {
    // PerActivity.java
    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PerActivity {
    }

    // PerFragment.java
    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PerFragment {
    }

    // PerChildFragment.java
    @Scope
    @Retention(RetentionPolicy.RUNTIME)
    public @interface PerChildFragment {
    }

//    // AppDependency.java
//    @Singleton
//    public final class AppDependency {
//        @Inject
//        AppDependency() {
//        }
//    }
//
//    // ActivityDependency.java
//    @PerActivity
//    public final class ActivityDependency {
//        @Inject
//        ActivityDependency() {
//        }
//    }
//
//    // FragmentDependency.java
//    @PerFragment
//    public final class FragmentDependency {
//        @Inject
//        FragmentDependency() {
//        }
//    }
//
//    // ChildFragmentDependency.java
//    @PerChildFragment
//    public final class ChildFragmentDependency {
//        @Inject
//        ChildFragmentDependency() {
//        }
//    }
}
