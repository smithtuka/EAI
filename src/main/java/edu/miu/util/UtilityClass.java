package edu.miu.util;

import edu.miu.domain.Requisition;

public class UtilityClass {
    public static void sendingNotification(Requisition requisition){
        String m = "Hello <strong>" + requisition.getEmployee().getFirstName() + " " + requisition.getEmployee().getLastName()+" <br/>"
                + "</strong>, I would like to inform you that  <strong> your requisition  has been submitted ,"
                + "</strong>  <br/> your supervisor will look at it and get back to you as soon as possible.<br/>"
                +"";
        String subject = "NEW REQUEST ADDED SUCCESSFULLY";

        try {
            EmailSender.registrationConfirmation(requisition.getEmployee().getEmail(), subject, Template.sendingEmail(m));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
