/*
 * Developed by Luis (@realluuuuuis)
 * Last modified 16.10.21, 20:48
 * Copyright (c) 2021
 */

package de.luuuuuis.whaleymaster.docker.services.impl;

import com.github.dockerjava.api.model.ContainerSpec;
import com.github.dockerjava.api.model.EndpointResolutionMode;
import com.github.dockerjava.api.model.PortConfig;
import com.github.dockerjava.api.model.ServicePlacement;
import de.luuuuuis.whaleymaster.docker.Docker;
import de.luuuuuis.whaleymaster.docker.services.Service;

import java.util.List;

public class MessengerService extends Service {

    public MessengerService(Docker docker, List<Service> serviceList) {
        super(docker, serviceList);
        createService();
    }

    @Override
    public ServicePlacement servicePlacement() {
        return null;
    }

    @Override
    public List<PortConfig> ports() {
        return List.of(new PortConfig().withPublishedPort(81).withTargetPort(80));
    }

    @Override
    public EndpointResolutionMode endpointResolutionMode() {
        return null;
    }

    @Override
    public ContainerSpec containerSpec() {
        return new ContainerSpec()
                .withImage("luuuuuis/gesetzeapi:latest");
    }

    @Override
    public String serviceName() {
        return "Messenger";
    }
}
