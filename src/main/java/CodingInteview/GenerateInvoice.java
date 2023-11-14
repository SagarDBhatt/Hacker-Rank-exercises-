/**
 * Find the invoice for the customer with daily prorated rate.
 *
 * Month 2019-01
 * Subscription tier $4 / month
 * User activations 2018-11-04
 * 2018-12-04
 * 2019-01-10 (new this month)
 * User deactivations None
 *
 *
 *
 * Function to solve:
 * bill_for(month, active_subscription, users):
 *
 * Input:
 * month: '2019-01'
 * active_subs is in JSON:
 * {
 * 'id': 1,
 * 'customer_id': 1,
 * 'monthly_price_in_dollars': 4 # price per active user per month
 * }
 *
 * users in the activation:
 * [
 * {
 * 'id': 1,
 * 'name': 'Employee #1',
 * 'customer_id': 1,
 * # when this user started
 * 'activated_on': datetime.date(2018, 11, 4),
 * # last day to bill for user
 * # should bill up to and including this date
 * # since user had some access on this date
 * 'deactivated_on': datetime.date(2019, 1, 10)
 * },
 * {
 * 'id': 2,
 * 'name': 'Employee #2',
 * 'customer_id': 1,
 * # when this user started
 * 'activated_on': datetime.date(2018, 12, 4),
 * # hasn't been deactivated yet
 * 'deactivated_on': None
 * }
 * ]
 *
 *
 * Output:
 * $10.84
 *
 * Pseudocode:
 * 1. Func to find number of days in the requested month.
 * 2. Find the charge per user per day.
 * 3. Find the users' active days by passing the activation date and de-activation date.
 * 4. Calc cost by multiplying the daily user and daily charge.
 */

package CodingInteview;

import com.fasterxml.jackson.databind.ObjectMapper;
import netscape.javascript.JSException;
import netscape.javascript.JSObject;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

//import org.json.*;

import javax.management.ObjectName;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

public class GenerateInvoice {
    public static void main(String[] args) throws IOException {
        String month = "2019-01";
        String activeSubs = "{\n" +
                "\"id\": 1,\n" +
                "\"customer_id\": 1,\n" +
                "\"monthly_price_in_dollars\": 4\n" +
                "}";

        String listOfUsers = " [\n" +
                " {\n" +
                " \"id\": 1,\n" +
                " \"name\": 'Employee #1',\n" +
                " \"customer_id\": 1,\n" +
                " \"activated_on\": datetime.date(2018, 11, 4), \n" +
                " \"deactivated_on\": datetime.date(2019, 1, 10)\n" +
                " },\n" +
                "  {\n" +
                "  \"id\": 2,\n" +
                "  \"name\": 'Employee #2',\n" +
                "  \"customer_id\": 1,\n" +
                "  \"activated_on\": datetime.date(2018, 12, 4),\n" +
                " \"deactivated_on\": None\n" +
                " }\n" +
                " ]";

        String ls = "[\n" +
                "   {\n" +
                "      \"segmentId\":\"Source_2021-09-01_2021-10-01\",\n" +
                "      \"columns\":[\n" +
                "         \"merchantRefNum\",\n" +
                "         \"customerId\",\n" +
                "         \"firstName\"\n" +
                "      ],\n" +
                "      \"events\":[\n" +
                "         {\n" +
                "            \"event\":{\n" +
                "               \"merchantRefNum\":\"67456456\",\n" +
                "               \"customerId\":\"rfgvkhbj\",\n" +
                "               \"firstName\":\"peter\"\n" +
                "            }\n" +
                "         },\n" +
                "         {\n" +
                "            \"event\":{\n" +
                "               \"merchantRefNum\":\"654584856\",\n" +
                "               \"customerId\":null,\n" +
                "               \"firstName\":\"peter\"\n" +
                "            }\n" +
                "         }\n" +
                "      ]\n" +
                "   }\n" +
                "] \n";

        Object json = JSONValue.parse(activeSubs);
        System.out.println(json);

        JSONObject jsonObject = (JSONObject) json;

        Long customer = (Long) jsonObject.get("customer_id");
        System.out.println(customer);

        Object js1 = JSONValue.parse(ls);
        System.out.println(js1);

        //JSONObject ob2 = (JSONObject) js1;

        ObjectMapper objectMapper = new ObjectMapper();
        Object obj3 = objectMapper.readValue(ls, Object.class);
        System.out.println(obj3);

        String val = objectMapper.readTree(ls).path("segmentId").asText();
        System.out.println(val);

//        Object jsonActiveSubs = JSONValue.parse(activeSubs);
//        System.out.println(jsonActiveSubs);
//
//        List<Map<String,Object>> json = new ArrayList<>();
//        json.add(activeSubs);



    }//end main
}//end class
