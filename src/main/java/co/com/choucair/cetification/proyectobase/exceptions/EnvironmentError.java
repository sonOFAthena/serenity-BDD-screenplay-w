package co.com.choucair.cetification.proyectobase.exceptions;

public class EnvironmentError extends Error{

    public EnvironmentError(String exceptionMessage, Throwable throwable){
        super(exceptionMessage, throwable);
    }

    public EnvironmentError(String exceptionMessage){
        super(exceptionMessage);
    }
}
