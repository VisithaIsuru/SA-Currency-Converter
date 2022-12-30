/** AA1665 */

package com.sltc.soa.client;

import com.sltc.soa.client.stub.DemoWS;
import com.sltc.soa.client.stub.DemoWSService;

import java.util.Scanner;

public class Main
{

    public static void main( String[] args )
    {
//         URL url = new URL("http://demowebservice.com:8080/currencyservice?wsdl");
//        DemoWSService = new DemoWSService(url);

        boolean menu=true;

        do
        {
            System.out.println( " (1) Currency conversion\n (2) Exit" );
            float result=readInputFloat();

            if      (result==1)       {convert();}
            else if (result==2)       {menu=false;}
            else                      {System.out.println( "Invalid input" );}

            System.out.println( "" );

        }while(menu==true);

    }

    private static float readInputFloat()
    {
        float inputInt = 0;
        boolean numberFound = false;
        Scanner scan = new Scanner( System.in );
        do
        {
            System.out.println( "Please input your choice: " );
            String inputStr = scan.next();
            try
            {
                inputInt = Float.valueOf( inputStr );
                numberFound = true;
            }
            catch( Exception e )
            {
                System.out.println( "Invalid input " + inputStr + ". Please input a number." );
            }

        } while( !numberFound );
        return inputInt;
    }

    private static String readInputIntStr()
    {
        Scanner scan = new Scanner( System.in );
        String inputStr = scan.next();
        return inputStr;
    }

    private static int convert()
    {
        DemoWSService demoWSService = new DemoWSService();
        DemoWS demoWSPort = demoWSService.getDemoWSPort();

        System.out.println( "Please input amount to convert: " );
        float amountInSourceCurrency = Float.parseFloat(readInputIntStr());

        System.out.println( "Please input code of source currency(Ex:-USD) : " );
        String sourceCurrency = readInputIntStr();

        System.out.println( "Please input code of target currency(Ex:-LKR) : " );
        String targetCurrency = readInputIntStr();


        System.out.println( "***************************************" );
        System.out.println('\n');

        float result = demoWSPort.convert( amountInSourceCurrency, sourceCurrency , targetCurrency);

        if(result==-1){System.out.println( "Invalid input");}
        else {System.out.println( "Converted currency value is : " + result );}

        return 0;
    }



}

