package by.compit.verhovni.sud.soap.parsing.impl;

import by.compit.verhovni.sud.entity.OrderSuitConverted;
import by.compit.verhovni.sud.exception.NotFoundException;
import by.compit.verhovni.sud.soap.parsing.SOAPResponseProducer;
import supremeCourt.wsdl.*;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

/**
 * Класс SOAPResponseProducerImpl предназначен для формирования ответа SOAP-сервиса в виде
 * объекта формата {@link org.json.JSONObject}.
 */
@Component
public class SOAPResponseProducerImpl implements SOAPResponseProducer {

    /**
     * Переводит объект из формата {@link supremeCourt.wsdl.GetBankruptSuitByNameResponse}
     * в формат {@link org.json.JSONObject}.
     *
     * @param response - ответ SOAP-сервиса, полученный в {@link by.compit.verhovni.sud.soap.impl.SOAPMessageSenderImpl}
     * @return объект формата {@link org.json.JSONObject}
     * @throws NotFoundException если объект ен найден
     */
    @Override
    public JSONObject produce(GetBankruptSuitByNameResponse response) throws NotFoundException {
        if (response == null || response.getReturn() == null || response.getReturn().isEmpty()) {
            throw new NotFoundException();
        }
        JSONObject responseJson = new JSONObject();
        for (int i = 0; i < response.getReturn().size(); i++) {
            responseJson.put("item" + i, new JSONObject(response.getReturn().get(i)));
        }
        System.out.println(responseJson.toString());
        return responseJson;
    }

    /**
     * Переводит объект из формата {@link supremeCourt.wsdl.GetBankruptSuitByUNPResponse}
     * в формат {@link org.json.JSONObject}.
     *
     * @param response - ответ SOAP-сервиса, полученный в {@link by.compit.verhovni.sud.soap.impl.SOAPMessageSenderImpl}
     * @return объект формата {@link org.json.JSONObject}
     * @throws NotFoundException если объект ен найден
     */
    @Override
    public JSONObject produce(GetBankruptSuitByUNPResponse response) throws NotFoundException {
        if (response == null || response.getReturn() == null || response.getReturn().isEmpty()) {
            throw new NotFoundException();
        }
        JSONObject responseJson = new JSONObject();
        for (int i = 0; i < response.getReturn().size(); i++) {
            responseJson.put("item" + i, new JSONObject(response.getReturn().get(i)));
        }
        return responseJson;
    }

    /**
     * Переводит объект из формата {@link supremeCourt.wsdl.GetOrderParticipantByNameResponse}
     * в формат {@link org.json.JSONObject}.
     *
     * @param response - ответ SOAP-сервиса, полученный в {@link by.compit.verhovni.sud.soap.impl.SOAPMessageSenderImpl}
     * @return объект формата {@link org.json.JSONObject}
     * @throws NotFoundException если объект ен найден
     */
    @Override
    public JSONObject produce(GetOrderParticipantByNameResponse response) throws NotFoundException {
        if (response == null || response.getReturn() == null || response.getReturn().isEmpty()) {
            throw new NotFoundException();
        }
        JSONObject responseJson = new JSONObject();
        for (int i = 0; i < response.getReturn().size(); i++) {
            responseJson.put("item" + i, new JSONObject(getOrderSuitConverted(response.getReturn().get(i))));
        }
        return responseJson;
    }

    /**
     * Переводит объект из формата {@link supremeCourt.wsdl.GetOrderParticipantByUNPResponse}
     * в формат {@link org.json.JSONObject}.
     *
     * @param response - ответ SOAP-сервиса, полученный в {@link by.compit.verhovni.sud.soap.impl.SOAPMessageSenderImpl}
     * @return объект формата {@link org.json.JSONObject}
     * @throws NotFoundException если объект ен найден
     */
    @Override
    public JSONObject produce(GetOrderParticipantByUNPResponse response) throws NotFoundException {
        if (response == null || response.getReturn() == null || response.getReturn().isEmpty()) {
            throw new NotFoundException();
        }
        JSONObject responseJson = new JSONObject();

        for (int i = 0; i < response.getReturn().size(); i++) {
            responseJson.put("item" + i, new JSONObject(getOrderSuitConverted(response.getReturn().get(i))));
        }
        return responseJson;
    }

    /**
     * Конвертирует объект формата {@link OrderSuit} в объект формата {@link OrderSuitConverted}
     *
     * @param orderSuit формата {@link OrderSuit}
     * @return объект формата {@link OrderSuitConverted}
     */
    private OrderSuitConverted getOrderSuitConverted(OrderSuit orderSuit) {
        OrderSuitConverted orderSuitConverted = new OrderSuitConverted();

        orderSuitConverted.setClaimId(orderSuit.getClaimId());
        orderSuitConverted.setNameParticipant(orderSuit.getNameParticipant());
        orderSuitConverted.setOpenDecisionDate(orderSuit.getOpenDecisionDate());
        orderSuitConverted.setPrice(orderSuit.getPrice());
        orderSuitConverted.setPriceDecl(orderSuit.getPriceDecl());
        orderSuitConverted.setUnp(orderSuit.getUnp());
        if (orderSuit.getCloseDecisionDate() != null) {
            orderSuitConverted.setCloseDecisionDate(orderSuit.getCloseDecisionDate().getValue());
        }
        return orderSuitConverted;
    }
}
