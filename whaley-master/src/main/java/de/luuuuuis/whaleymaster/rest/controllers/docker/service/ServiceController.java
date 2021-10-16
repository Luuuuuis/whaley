/*
 * Developed by Luis (@realluuuuuis)
 * Last modified 16.10.21, 20:53
 * Copyright (c) 2021
 */

package de.luuuuuis.whaleymaster.rest.controllers.docker.service;

import com.github.dockerjava.api.model.ContainerSpec;
import com.github.dockerjava.api.model.EndpointResolutionMode;
import com.github.dockerjava.api.model.PortConfig;
import com.github.dockerjava.api.model.ServicePlacement;
import de.luuuuuis.whaleymaster.WhaleyMasterApplication;
import de.luuuuuis.whaleymaster.docker.services.Service;
import de.luuuuuis.whaleymaster.docker.services.impl.CreatableService;
import lombok.Data;
import lombok.NonNull;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/docker/service")
public class ServiceController {

    @GetMapping("/{serviceName}")
    public com.github.dockerjava.api.model.Service getService(@PathVariable String serviceName) {
        return WhaleyMasterApplication.getDocker().getDockerClient().inspectServiceCmd(serviceName).exec();
    }

    @GetMapping("/all")
    public Object[] getAllServices() {
        return WhaleyMasterApplication.getDocker().getDockerClient().listServicesCmd().exec().toArray();
//        return WhaleyMasterApplication.getDocker().getServiceList().toArray();
    }

    @PostMapping()
    public Service createService(@RequestBody ServiceModel serviceModel) {
        return new CreatableService(WhaleyMasterApplication.getDocker(), serviceModel.getName(), serviceModel.getPorts(), serviceModel.getContainerSpec(), serviceModel.getServicePlacement(), serviceModel.getEndpointResolutionMode());
    }

    @PostMapping("/{serviceName}/scale")
    public Service scaleService(@PathVariable String serviceName, @RequestBody int replicas) {
        Service service = WhaleyMasterApplication.getDocker().getServiceList().stream().filter(serv -> serv.serviceName().equals(serviceName)).findFirst().orElseThrow();
        service.updateService(replicas);
        return service;
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