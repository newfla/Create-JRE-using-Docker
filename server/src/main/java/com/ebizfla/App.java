package com.newfla;
import io.javalin.Javalin;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Javalin app = Javalin.create().start(7070);
        app.get("/", ctx -> {
            System.out.println( "Hello World Console!\n" );
            ctx.result("Hello World HTTP\n");
        });
    }
}
