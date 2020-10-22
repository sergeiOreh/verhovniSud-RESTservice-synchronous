package by.compit.verhovni.sud.rest;

import by.compit.verhovni.sud.exception.NotFoundException;
import by.compit.verhovni.sud.soap.SOAPMessageSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Класс ClientController является точкой взаимодействия пользователя с сервисом.
 * В соответствии с введённым url-адресом происходит вызов соответстующего метода.
 */
@RestController
public class ClientController {

    private static final String GET_BANKRUPT_SUIT_BY_NAME_URL = "${get.bankrupt.suit.by.name.url}";
    private static final String GET_BANKRUPT_SUIT_BY_UNP_URL = "${get.bankrupt.suit.by.unp.url}";
    private static final String GET_ORDER_PARTICIPANT_BY_NAME_URL = "${get.order.participant.by.name.url}";
    private static final String GET_ORDER_PARTICIPANT_BY_UNP_URL = "${get.order.participant.by.unp.url}";

    private static final String NAME_BANKRUPT_PARAMETER = "${name.bankrupt.parameter}";
    private static final String UNP_PARAMETER = "${unp.parameter}";
    private static final String NAME_PARTICIPANT_PARAMETER = "${name.participant.parameter}";
    private static final String DATE_START_PARAMETER = "${date.start.parameter}";
    private static final String DATE_END_PARAMETER = "${date.end.parameter}";

    private final SOAPMessageSender soapMessageSender;

    @Autowired
    public ClientController(SOAPMessageSender soapMessageSender) {
        this.soapMessageSender = soapMessageSender;
    }

    /**
     * Возвращает ответ по запросу.
     *
     * @param nameBankrupt - введённый пользователем параметр при запросе
     * @return ответ в виде строки
     * @throws NotFoundException если объект не найден
     */
    @RequestMapping(value = GET_BANKRUPT_SUIT_BY_NAME_URL, method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String getBankruptSuitByName(@RequestParam(value = NAME_BANKRUPT_PARAMETER) String nameBankrupt) throws NotFoundException {

        return soapMessageSender.getBankruptSuitByName(nameBankrupt).toString();
    }

    /**
     * Возвращает ответ по запросу.
     *
     * @param unp - это введённый пользователем параметр при запросе
     * @return ответ в виде строки
     * @throws NotFoundException если объект не найден
     */
    @RequestMapping(value = GET_BANKRUPT_SUIT_BY_UNP_URL, method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String getBankruptSuitByUNP(@RequestParam(value = UNP_PARAMETER) int unp) throws NotFoundException {

        return soapMessageSender.getBankruptSuitByUNP(unp).toString();
    }

    /**
     * Возвращает ответ по запросу.
     *
     * @param nameParticipant - это введённый пользователем параметр при запросе
     * @param dateStart - это введённый пользователем параметр при запросе
     * @param dateEnd - это введённый пользователем параметр при запросе
     * @return ответ в виде строки
     * @throws NotFoundException если объект не найден
     */
    @RequestMapping(value = GET_ORDER_PARTICIPANT_BY_NAME_URL, method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String getOrderParticipantByName(@RequestParam(value = NAME_PARTICIPANT_PARAMETER) String nameParticipant,
                                            @RequestParam(value = DATE_START_PARAMETER) String dateStart,
                                            @RequestParam(value = DATE_END_PARAMETER) String dateEnd) throws NotFoundException {

        return soapMessageSender.getOrderParticipantByName(nameParticipant, dateStart, dateEnd).toString();
    }

    /**
     * Возвращает ответ по запросу.
     *
     * @param unp - это введённый пользователем параметр при запросе
     * @param dateStart - это введённый пользователем параметр при запросе
     * @param dateEnd - это введённый пользователем параметр при запросе
     * @return ответ в виде строки
     * @throws NotFoundException если объект не найден
     */
    @RequestMapping(value = GET_ORDER_PARTICIPANT_BY_UNP_URL, method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    public String getOrderParticipantByUNP(@RequestParam(value = UNP_PARAMETER) int unp,
                                           @RequestParam(value = DATE_START_PARAMETER) String dateStart,
                                           @RequestParam(value = DATE_END_PARAMETER) String dateEnd) throws NotFoundException {

        return soapMessageSender.getOrderParticipantByUNP(unp, dateStart, dateEnd).toString();
    }

}
