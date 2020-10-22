package by.compit.verhovni.sud.soap;

import by.compit.verhovni.sud.exception.NotFoundException;
import org.json.JSONObject;

public interface SOAPMessageSender {

    JSONObject getBankruptSuitByName(String nameBankrupt) throws NotFoundException;

    JSONObject getBankruptSuitByUNP(int unp) throws NotFoundException;

    JSONObject getOrderParticipantByName(String nameParticipant, String dateStart, String dateEnd) throws NotFoundException;

    JSONObject getOrderParticipantByUNP(int unp, String dateStart, String dateEnd) throws NotFoundException;

}
