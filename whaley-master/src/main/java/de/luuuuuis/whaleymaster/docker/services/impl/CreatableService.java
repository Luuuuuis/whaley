/*
 * Developed by Luis (Luuuuuis @realluuuuuis)
 * Last modified 06.10.21, 20:06
 * Copyright (c) 2021
 */

package de.luuuuuis.whaleymaster.docker.services.impl;

import com.github.dockerjava.api.model.ContainerSpec;
import com.github.dockerjava.api.model.EndpointResolutionMode;
import com.github.dockerjava.api.model.PortConfig;
import com.github.dockerjava.api.model.ServicePlacement;
import de.luuuuuis.whaleymaster.docker.Docker;
import de.luuuuuis.whaleymaster.docker.services.Service;

import java.util.Collections;
import java.util.List;

public class CreatableService extends Service {

    private final String serviceName;
    private final List<PortConfig> ports;
    private final ContainerSpec containerSpec;
    private final ServicePlacement servicePlacement;
    private final EndpointResolutionMode endpointResolutionMode;

    public CreatableService(Docker docker, String serviceName, List<PortConfig> ports, ContainerSpec containerSpec, ServicePlacement servicePlacement, EndpointResolutionMode endpointResolutionMode) {
        super(docker, Collections.emptyList());

        this.serviceName = serviceName;
        this.ports = ports;
        this.containerSpec = containerSpec;
        this.servicePlacement = servicePlacement;
        this.endpointResolutionMode = endpointResolutionMode;

        createService();
    }

    @Override
    public String serviceName() {
        return serviceName;
    }

    @Override
    public ServicePlacement servicePlacement() {
        return servicePlacement;
    }

    @Override
    public List<PortConfig> ports() {
        return ports;
    }

    @Override
    public EndpointResolutionMode endpointResolutionMode() {
        return endpointResolutionMode;
    }

    @Override
    public ContainerSpec containerSpec() {
        return containerSpec;
    }
}
