package by.compit.verhovni.sud.soap.impl;

import by.compit.verhovni.sud.exception.NotFoundException;
import by.compit.verhovni.sud.soap.SOAPMessageSender;
import by.compit.verhovni.sud.soap.parsing.SOAPResponseProducer;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import supremeCourt.wsdl.*;

import javax.annotation.PostConstruct;
import javax.xml.bind.JAXBElement;

/**
 * Класс SOAPMessageSenderImpl предназначен для отправки запроса на SOAP-сервис и формирования ответа
 */
@Component
public class SOAPMessageSenderImpl extends WebServiceGatewaySupport implements SOAPMessageSender {

    @Value("${remote.soap.service.uri}")
    private String SERVICE_URI;
    private ObjectFactory factory = new ObjectFactory();

    private final SOAPResponseProducer soapResponseProducer;

    @Autowired
    public SOAPMessageSenderImpl(Jaxb2Marshaller marshaller, SOAPResponseProducer soapResponseProducer) {
        this.soapResponseProducer = soapResponseProducer;
        setMarshaller(marshaller);
        setUnmarshaller(marshaller);
    }

    /**
     * Настройка url-адреса SOAP-сервиса
     */
    @PostConstruct
    private void init() {
        setDefaultUri(SERVICE_URI);
    }


    /**
     * @param nameBankrupt - введённый пользователем параметр при запросе
     * @return ответ SOAP-сервиса в виде объекта формата {@link org.json.JSONObject}
     * @throws NotFoundException если объект ен найден
     */
    @Override
    public JSONObject getBankruptSuitByName(String nameBankrupt) throws NotFoundException {
        GetBankruptSuitByName request = new GetBankruptSuitByName();
        request.setNameBankrupt(nameBankrupt);

        JAXBElement<GetBankruptSuitByName> requestSOAP = factory.createGetBankruptSuitByName(request);
        JAXBElement<GetBankruptSuitByNameResponse> responseSOAP = (JAXBElement<GetBankruptSuitByNameResponse>) getWebServiceTemplate().marshalSendAndReceive(requestSOAP);
        GetBankruptSuitByNameResponse response = null;
        if (responseSOAP != null) {
            response = responseSOAP.getValue();
        }

        return soapResponseProducer.produce(response);
    }

    /**
     * @param unp - введённый пользователем параметр при запросе
     * @return ответ SOAP-сервиса в виде объекта формата {@link org.json.JSONObject}
     * @throws NotFoundException если объект ен найден
     */
    @Override
    public JSONObject getBankruptSuitByUNP(int unp) throws NotFoundException {
        GetBankruptSuitByUNP request = new GetBankruptSuitByUNP();
        request.setUnp(unp);

        JAXBElement<GetBankruptSuitByUNP> requestSOAP = factory.createGetBankruptSuitByUNP(request);
        JAXBElement<GetBankruptSuitByUNPResponse> responseSOAP = (JAXBElement<GetBankruptSuitByUNPResponse>) getWebServiceTemplate().marshalSendAndReceive(requestSOAP);
        GetBankruptSuitByUNPResponse response = null;
        if (responseSOAP != null) {
            response = responseSOAP.getValue();
        }

        return soapResponseProducer.produce(response);
    }

    /**
     * @param nameParticipant - введённый пользователем параметр при запросе
     * @param dateStart - введённый пользователем параметр при запросе
     * @param dateEnd - введённый пользователем параметр при запросе
     * @return ответ SOAP-сервиса в виде объекта формата {@link org.json.JSONObject}
     * @throws NotFoundException если объект ен найден
     */
    @Override
    public JSONObject getOrderParticipantByName(String nameParticipant, String dateStart, String dateEnd) throws NotFoundException {
        GetOrderParticipantByName request = new GetOrderParticipantByName();
        request.setNameParticipant(nameParticipant);
        request.setDateStart(dateStart);
        request.setDateEnd(dateEnd);

        JAXBElement<GetOrderParticipantByName> requestSOAP = factory.createGetOrderParticipantByName(request);
        JAXBElement<GetOrderParticipantByNameResponse> responseSOAP = (JAXBElement<GetOrderParticipantByNameResponse>) getWebServiceTemplate().marshalSendAndReceive(requestSOAP);
        GetOrderParticipantByNameResponse response = null;
        if (responseSOAP != null) {
            response = responseSOAP.getValue();
        }

        return soapResponseProducer.produce(response);
    }

    /**
     * @param unp - введённый пользователем параметр при запросе
     * @param dateStart - введённый пользователем параметр при запросе
     * @param dateEnd - введённый пользователем параметр при запросе
     * @return ответ SOAP-сервиса в виде объекта формата {@link org.json.JSONObject}
     * @throws NotFoundException если объект ен найден
     */
    @Override
    public JSONObject getOrderParticipantByUNP(int unp, String dateStart, String dateEnd) throws NotFoundException {
        GetOrderParticipantByUNP request = new GetOrderParticipantByUNP();
        request.setUnp(unp);
        request.setDateStart(dateStart);
        request.setDateEnd(dateEnd);

        JAXBElement<GetOrderParticipantByUNP> requestSOAP = factory.createGetOrderParticipantByUNP(request);
        JAXBElement<GetOrderParticipantByUNPResponse> responseSOAP = (JAXBElement<GetOrderParticipantByUNPResponse>) getWebServiceTemplate().marshalSendAndReceive(requestSOAP);
        GetOrderParticipantByUNPResponse response = null;
        if (responseSOAP != null) {
            response = responseSOAP.getValue();
        }

        return soapResponseProducer.produce(response);
    }



}
