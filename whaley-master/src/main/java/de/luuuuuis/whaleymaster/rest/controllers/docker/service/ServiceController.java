/*
 * Developed by Luis (Luuuuuis @realluuuuuis)
 * Last modified 06.10.21, 20:16
 * Copyright (c) 2021
 */

package de.luuuuuis.whaleymaster.rest.controllers.docker.service;

import com.github.dockerjava.api.model.*;
import de.luuuuuis.whaleymaster.WhaleyMasterApplication;
import de.luuuuuis.whaleymaster.docker.services.impl.CreatableService;
import lombok.Data;
import lombok.NonNull;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docker/service")
public class ServiceController {

    @GetMapping("/{service}")
    public Service getService(@PathVariable String service) {
        return WhaleyMasterApplication.getDocker().getDockerClient().inspectServiceCmd(service).exec();
    }

    @GetMapping("/all")
    public Object[] getAllServices() {
        return WhaleyMasterApplication.getDocker().getDockerClient().listServicesCmd().exec().toArray();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public void createService(@RequestBody ServiceModel serviceModel) {
        new CreatableService(WhaleyMasterApplication.getDocker(), serviceModel.getName(), serviceModel.getPorts(), serviceModel.getContainerSpec(), serviceModel.getServicePlacement(), serviceModel.getEndpointResolutionMode());
    }
}

@Data
class ServiceModel {

    private @NonNull String name;
    private List<PortConfig> ports;
    private @NonNull ContainerSpec containerSpec;
    private ServicePlacement servicePlacement;
    private EndpointResolutionMode endpointResolutionMode;


}