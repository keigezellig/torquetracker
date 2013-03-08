package com.joco.webservice;

import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.servlet.GuiceServletContextListener;
import com.joco.trackerservice.common.IDataWriter;
import com.joco.trackerservice.common.IRequestProcessor;
import com.joco.trackerservice.datawriter.*;
import com.joco.trackerservice.rabbitmq.RabbitQueueWriter;
import com.joco.trackerservice.requestprocessor.TorqueRequestProcessor;
import com.sun.jersey.guice.JerseyServletModule;
import com.sun.jersey.guice.spi.container.servlet.GuiceContainer;

public class GuiceServletConfig extends GuiceServletContextListener
{
	@Override
    protected Injector getInjector() {
        return Guice.createInjector(new JerseyServletModule() {

            @Override
            protected void configureServlets() {

                /* bind the REST resources */
                bind(VehicleDataService.class);

                /* bind jackson converters for JAXB/JSON serialization */
                bind(MessageBodyReader.class).to(JacksonJsonProvider.class);
                bind(MessageBodyWriter.class).to(JacksonJsonProvider.class);
                
                bind(IRequestProcessor.class).to(TorqueRequestProcessor.class);
                bind(IDataWriter.class).to(RabbitQueueWriter.class);

                serve("/rest/*").with(GuiceContainer.class);

            }
        });
	}
}
