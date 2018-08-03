package com.oreillyauto.projecttemplate.controllers;

//Install the Java helper library from twilio.com/docs/libraries/java
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.lookups.v1.PhoneNumber;


public class SmsSender {
    // Find your Account Sid and Auth Token at twilio.com/console
    public static final String ACCOUNT_SID = "AC964b7f57262528afe2b5fbe92306c98b";
    public static final String AUTH_TOKEN = "907b61ecc2a4332f9ef094a2afeaaa98";

    /*manages the to and from number messages, getting the to number from input*/
    public static void send(String body, String number) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        Message message = Message.creator(new com.twilio.type.PhoneNumber("+1" + number), // to
                                          new com.twilio.type.PhoneNumber("+14175516383"), // from
                                          body)
                .create();

        System.out.println(message.getSid());
    }

    public static boolean validate(String n) {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        /*looks for VoIP and Mobile numbers using data from twilio, also verifies it's not null*/
        PhoneNumber number = PhoneNumber
                .fetcher(new com.twilio.type.PhoneNumber(n))
                .setType("carrier")
                .fetch();
        
        String type = number.getCarrier().get("type");
        System.out.println(type);
        return type !=null && (type.equalsIgnoreCase("voip") || type.equalsIgnoreCase("mobile"));
        
    }
}