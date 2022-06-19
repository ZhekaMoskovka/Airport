package App.Controller;

import App.DTO.RequestTicketDTO;
import App.DTO.ResponseTicketDTO;
import App.Service.Impl.TicketServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.TimeZone;

@RestController
@AllArgsConstructor
public class TicketController {
    private TicketServiceImpl ticketService;

    @PostMapping("/ticket/buying")
    public ResponseTicketDTO buyTickets (@RequestBody RequestTicketDTO ticketDTO) {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        return ticketService.buyTickets(ticketDTO);
    }
}