package App.Controller;

import App.DTO.RequestRouteDTO;
import App.Service.RouteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class RouteController {
    private RouteService routeService;

    @DeleteMapping("/route")
    public String deleteRoute(@RequestBody RequestRouteDTO requestRouteDTO) {
        log.info("Route controller delete route");
        return routeService.deleteRoute(requestRouteDTO);
    }
}