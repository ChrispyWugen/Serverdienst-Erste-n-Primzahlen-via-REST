package com.example.actuatorservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

/**
 * An implementation of PrimeNumbersController
 * in actuator-service
 *
 * @author chris
 * @version 1.0
 * @since 2019-Dez-05
 */
@Controller
public class PrimeNumbersController {

    private static int SLEEP_TIME = 0;

    @GetMapping("/")
    @ResponseBody
    public String responseCalculationInteger() {

        try {
            return fileToString("public/index.html");
        } catch (IOException e) {
            System.err.println("Could not read index.html");
            System.err.println(e.getLocalizedMessage());
        }

        return "<h2>Hey, herzlich willkommen auf der &Uuml;bersichtsseite zu unserer Top-API f&uuml;r Primzahlen.</h2>\n" +
                "                <hr />\n" +
                "                <p>Primzahl-Antwort als Integer-Liste:</p>\n" +
                "                <p><code><a href=https://floating-gorge-01332.herokuapp.com/getPrimeNumbersInt?value=5>https://floating-gorge-01332.herokuapp.com/getPrimeNumbersInt?value=5</a></code></p>\n" +
                "                <p><code></code></p>\n" +
                "                <hr />\n" +
                "                <p>Primzahl-Antwort als String-Liste:</p>\n" +
                "                <p><code><a href=https://floating-gorge-01332.herokuapp.com/getPrimeNumbersInt?value=5>https://floating-gorge-01332.herokuapp.com/getPrimeNumbersString?value=5</a></code></p>\n" +
                "                <p><code></code></p>\n" +
                "                <hr />\n" +
                "                <p>Primzahl-Antwort als Objekt mit beiden Besandteilen:</p>\n" +
                "                <p><code><a href=https://floating-gorge-01332.herokuapp.com/getPrimeNumbersObject?value=5>https://floating-gorge-01332.herokuapp.com/getPrimeNumbersObject?value=5</a></code></p>\n" +
                "                <p><code></code></p>\n" +
                "                <hr />\n" +
                "                <p>Optional kann der Parameter 'delay' angegeben werden. Damit wartet das Programm die entsprechende Anzahl an Millisekunden zwischen einigen Befehlen, damit auf der Serverseite einzelne Schritte nachverfolgt werden k&ouml;nnen. <br />Bsp.: https://floating-gorge-01332.herokuapp.com/getPrimeNumbersInt?value=5&amp;<strong>delay=10</strong></p>";
    }

    //http://localhost:9000/getPrimeNumbersInt?value=5
    //https://floating-gorge-01332.herokuapp.com/getPrimeNumbersInt?value=5
    @GetMapping("/getPrimeNumbersInt")
    @ResponseBody
    public POJOPrimeNumbersIntegerList responseCalculationInteger(@RequestParam(value = "value", required = true) int primeCount,
                                                                  @RequestParam(value = "delay", required = false) Integer delay) {
        int requestId = getRequestId();
        System.out.println(String.format("[%d | Integer] Connection established", requestId));
        System.out.println(String.format("[%d | Integer] Received Request for Integer List with " + primeCount + " primes", requestId));
        sleep(delay);

        //create JSON container object
        POJOPrimeNumbersIntegerList primeNumberIntegerListObject = new POJOPrimeNumbersIntegerList(primeCount);
        sleep(delay);

        //calculate primeNumbers, parse and sets
        List<Integer> primeNumberList = CalculatePrimeNumbers.calculate(primeCount);
        int[] primeNumberArray = CalculatePrimeNumbers.toIntArray(primeNumberList);

        primeNumberIntegerListObject.setPrimeNumberList(primeNumberArray);

        System.out.println(String.format("[%d | Integer] Returning result...\n" +
                "[%d | Integer] Closing Connection and Switching Back to Waiting\n" +
                "------------------------------------------------------------", requestId, requestId));

        //return the object to request as a response
        return primeNumberIntegerListObject;
    }

    //http://localhost:9000/getPrimeNumbersString?value=5
    //https://floating-gorge-01332.herokuapp.com/getPrimeNumbersString?value=5
    @GetMapping("/getPrimeNumbersString")
    @ResponseBody
    public POJOPrimeNumbersString responseCalculationString(@RequestParam(value = "value", required = true) int primeCount,
                                                            @RequestParam(value = "delay", required = false) Integer delay) {
        int requestId = getRequestId();
        System.out.println(String.format("[%d | String] Connection established",requestId));
        sleep(delay);

        System.out.println(String.format("[%d | String] Received prime numbers request for string with value " + primeCount,requestId));
        System.out.println(String.format("[%d | String] Calculating prime numbers and packing object",requestId));
        sleep(delay);

        //calculate prime numbers
        Object[] listOfPrimeNumbers = CalculatePrimeNumbers.calculate(primeCount).toArray();

        //convert list into String with whitespaces
        String primeNumbersString = CalculatePrimeNumbers.convertArrayToString(listOfPrimeNumbers);

        // create JSON container object
        POJOPrimeNumbersString primeNumbers = new POJOPrimeNumbersString(primeNumbersString);

        System.out.println(String.format("[%d | String] Returning result...\n" +
                "[%d | String] Closing Connection and Switching Back to Waiting\n" +
                "------------------------------------------------------------",requestId,requestId));

        return primeNumbers;
    }

    //http://localhost:9000/getPrimeNumbersObject?value=5
    //https://floating-gorge-01332.herokuapp.com/getPrimeNumbersObject?value=5
    @GetMapping("/getPrimeNumbersObject")
    @ResponseBody
    public POJOPrimeNumbersObject responseCalculationObject(@RequestParam(value = "value", required = true) int primeCount,
                                                            @RequestParam(value = "delay", required = false) Integer delay) {
        int requestId = getRequestId();
        System.out.println(String.format("[%d | Object] Connection established",requestId));
        System.out.println(String.format("[%d | Object] Received prime numbers request for struct with value " + primeCount,requestId));
        sleep(delay);

        //calculate prime numbers
        int[] integerListOfPrimeNumbers = CalculatePrimeNumbers.toIntArray(CalculatePrimeNumbers.calculate(primeCount));
        Object[] objectListOfPrimeNumbers = CalculatePrimeNumbers.convertToObjectArray(integerListOfPrimeNumbers);

        //convert list into String with whitespaces
        String primeNumbersString = CalculatePrimeNumbers.convertArrayToString(objectListOfPrimeNumbers);

        // create JSON container Object
        POJOPrimeNumbersObject primeNumbers = new POJOPrimeNumbersObject(integerListOfPrimeNumbers, primeNumbersString);

        System.out.println(String.format("[%d | Object] Returning result...\n" +
                "[%d | Object] Closing Connection and Switching Back to Waiting\n" +
                "------------------------------------------------------------",requestId,requestId));

        return primeNumbers;
    }

    private static void sleep(Integer ms) {

        try {
            if (ms == null) {
                Thread.sleep(SLEEP_TIME);
            } else {
                Thread.sleep(ms);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }

    private static String fileToString(String filePath) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();
        Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8);
        //stream.forEach(s -> contentBuilder.append(s).append("\n"));
        stream.forEach(contentBuilder::append);

        return contentBuilder.toString();
    }

    /**
     * returns a random number that can be used as a request id
     *
     * @return random integer
     */
    private static int getRequestId() {
        return ThreadLocalRandom.current().nextInt(100000);
    }


}
