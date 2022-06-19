package App.Controller;

import App.DTO.RequestTicketDTO;
import App.DTO.ResponseTicketDTO;
import App.Service.Impl.TicketServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.TimeZone;

@RestController
@AllArgsConstructor
@Slf4j
public class TicketController {
    private TicketServiceImpl ticketService;

    @PostMapping("/ticket/buying")
    public ResponseTicketDTO buyTickets (@RequestBody RequestTicketDTO ticketDTO) {
        log.info("Ticket controller buy ticket");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        return ticketService.buyTickets(ticketDTO);
    }
}