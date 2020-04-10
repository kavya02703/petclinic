import java.io.IOException;
import java.net.URL;
import java.net.HttpURLConnection;

public class API{
    public static void main(String args[]) throws IOException
    {
        URL url = new URL("http://18.156.30.63:8080/");
        HttpURLConnection http = (HttpURLConnection)url.openConnection();
        int statusCode = http.getResponseCode();
        if(statusCode > 100 && statusCode < 199 || statusCode == 100 || statusCode == 199 )
        {
                System.out.println("Informational");
        }
        else if(statusCode > 200 && statusCode < 299 || statusCode == 200 || statusCode == 299 )
        {
                System.out.println("Successful Response, the site is up and running");
        }
        else if(statusCode >300  && statusCode < 399 || statusCode == 300 || statusCode == 399 )
        {
                System.out.println("Redirectional response");
        }
        else if(statusCode > 400 && statusCode < 499 || statusCode == 400 || statusCode == 499 )
        {
                System.out.println("client error");
        }
        else if(statusCode > 500 && statusCode < 599 || statusCode == 500 || statusCode == 599 )
        {
                System.out.println("server error");
        }
        else
        {
                System.out.println("error unknown");
        }
    }
}
