package App.Controller;

import App.DTO.RequestRouteDTO;
import App.Service.RouteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class RouteController {
    private RouteService routeService;

    @DeleteMapping("/delete/route")
    public String deleteRoute(@RequestBody RequestRouteDTO requestRouteDTO) {
        return routeService.deleteRoute(requestRouteDTO);
    }
}