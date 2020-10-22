package by.compit.verhovni.sud.soap.parsing;

import by.compit.verhovni.sud.exception.NotFoundException;
import supremeCourt.wsdl.*;
import org.json.JSONObject;

public interface SOAPResponseProducer {

    JSONObject produce(GetBankruptSuitByNameResponse response) throws NotFoundException;

    JSONObject produce(GetBankruptSuitByUNPResponse response) throws NotFoundException;

    JSONObject produce(GetOrderParticipantByNameResponse response) throws NotFoundException;

    JSONObject produce(GetOrderParticipantByUNPResponse response) throws NotFoundException;

}
