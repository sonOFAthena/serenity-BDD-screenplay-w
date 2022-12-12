package co.com.choucair.cetification.proyectobase.utils.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CleanDataBase {

    @Before
    public static void beforeHook(){
        System.out.println("Before hook");
    }

    @Before("@foo")
    public static void beforeHookFoo(){
        System.out.println("Before hook foo");
    }

    @After
    public static void afterHook(){
        System.out.println("After hook");
    }

}
