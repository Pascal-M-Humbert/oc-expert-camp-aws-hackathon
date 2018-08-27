package de.opitz.aws.hackathon.handler;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;
import de.opitz.aws.hackathon.dao.PaymentType;
import de.opitz.aws.hackathon.dao.Transaction;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class ParserHandler implements RequestHandler<String, String> {

    static final Logger logger = LogManager.getLogger(ParserHandler.class);

    private static final Regions DEFAULT_REGION = Regions.EU_CENTRAL_1;
    private static final String BUCKET_NAME = "oc-expert-camp-dump-file";
    private static final String KEY = "SalesJan2009.csv";
    private static final int SIZE_CSV_LINE = 12;
    private static final String CSV_SPLIT_CHARACTERE = ",";

    private static final SimpleDateFormat sdf = new SimpleDateFormat("MM/DD/YY hh:mm", Locale.GERMANY);


    @Override
    public String handleRequest(String s, Context context) {
        S3Object fileToParse = null;

        try {
            AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                    .withRegion(DEFAULT_REGION)
                    .build();
            fileToParse = s3Client.getObject(new GetObjectRequest(BUCKET_NAME, KEY));
            parseFile(fileToParse.getObjectContent());
        } catch (Exception e) {
            logger.error("Exception occured", e);
            return "failed";
        }
        return "success";
    }

    private static void parseFile(InputStream input) throws IOException {
        // Read the text input stream one line at a time and display each line.
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        int lineNumber = 0;
        List<Transaction> transactions = new LinkedList<>();
        while ((line = reader.readLine()) != null) {
            // ignore first line
            if (lineNumber != 0) {
                try {
                    transactions.add(createTransaction(line.split(CSV_SPLIT_CHARACTERE)));
                } catch (Exception e) {
                    logger.error(String.format("error of parsing for line %s", line), e);
                }
            }
            lineNumber++;
        }
        transactions.stream().forEach(transaction -> System.out.println(transaction.toString()));
    }

    private static Transaction createTransaction(String[] transactionString) throws ParseException {
        if (transactionString == null || transactionString.length != SIZE_CSV_LINE) {
            logger.error(String.format("transactionString was empty or too small %s", transactionString));
        }
        Calendar cal = Calendar.getInstance();
        Transaction transaction = new Transaction();
        cal.setTime(sdf.parse(transactionString[0]));
        transaction.setTransactionDate((Calendar) cal.clone());
        transaction.setProduct(transactionString[1]);
        transaction.setPrice(Float.valueOf(transactionString[2]));
        transaction.setPaymentType(PaymentType.valueOf(transactionString[3]));
        transaction.setName(transactionString[4]);
        transaction.setCity(transactionString[5]);
        transaction.setState(transactionString[6]);
        transaction.setCountry(transactionString[7]);
        cal.setTime(sdf.parse(transactionString[8]));
        transaction.setAccountCreated((Calendar) cal.clone());
        cal.setTime(sdf.parse(transactionString[9]));
        transaction.setLastLogin((Calendar) cal.clone());
        transaction.setLatitude(Float.valueOf(transactionString[10]));
        transaction.setLongitude(Float.valueOf(transactionString[11]));
        return transaction;
    }
}
