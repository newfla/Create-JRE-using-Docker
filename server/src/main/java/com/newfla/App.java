package com.newfla;
import io.javalin.Javalin;
import io.javalin.core.util.JavalinLogger;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Javalin appJavalin = initServerJavalin();
        
    }
    public static Javalin initServerJavalin() {
        Javalin app = Javalin.create().start(7070);
        JavalinLogger.info("Started");
        return app.get("/", ctx -> {
            JavalinLogger.info( "Hello World Console!\n" );
            ctx.result("Hello World HTTP\n");
        });
    }
}
