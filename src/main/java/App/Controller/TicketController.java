package App.Controller;

import App.DTO.RequestTicketDTO;
import App.DTO.ResponseTicketDTO;
import App.Service.Impl.TicketServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.TimeZone;

@RestController
@AllArgsConstructor
@Slf4j
public class TicketController {
    private TicketServiceImpl ticketService;

    @PostMapping("/ticket")
    public ResponseTicketDTO buyTickets (@RequestBody RequestTicketDTO requestTicketDTO) {
        log.info("Ticket controller buy ticket");
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        return ticketService.buyTickets(requestTicketDTO);
    }

    @GetMapping("/ticket")
    public List<ResponseTicketDTO> getTickets() {
        log.info("Ticket controller get all tickets");
        return ticketService.getTickets();
    }

    @DeleteMapping("/ticket")
    public String deleteTicket(@RequestBody RequestTicketDTO requestTicketDTO) {
        log.info("Ticket controller delete ticket");
        return ticketService.deleteTicket(requestTicketDTO);
    }
}