package App.Controller;

import App.DTO.ResponseFlightDTO;
import lombok.Setter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class FlightControllerTest {
    @Setter(onMethod = @__({@Autowired}))
    private FlightController flightController;
    private List<ResponseFlightDTO> flightInBorders = new ArrayList<>();

    @Test
    void flightInBorders() {
        flightInBorders.add(ResponseFlightDTO.builder()
                .gate("N37")
                .name("West Terminal")
                .placeFrom("Kiev")
                .placeTo("London")
                .status("waiting")
                .time("2022-04-12T19:40:00.000Z")
                .build());
        assertEquals(flightController.flightInBorders("2022-04-11 00:00:00", "2022-04-20 00:00:00"), flightInBorders);
    }
}