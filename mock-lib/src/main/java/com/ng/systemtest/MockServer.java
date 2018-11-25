package com.ng.systemtest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import com.github.tomakehurst.wiremock.extension.responsetemplating.ResponseTemplateTransformer;

//Define un mockserver
public class MockServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(MockServer.class);
    private static final int MOCK_SERVER_PORT=9999;
    private static int puerto;
    private static String base;
    private static WireMockServer wireMockServer;
    private static boolean estado=false;

    public MockServer(String baseurl,int port) {
    	base="/"+baseurl;
		puerto = port;
        wireMockServer = new WireMockServer(
                new WireMockConfiguration()
                        .port(puerto)
                        //Habilta la posibilidad de crear una respuesta personalizada
                        //usando templates, pero no la habilita por defecto (false) para
                        //todos los mocks, asi que habra que habilitarlo caso por caso
                        .extensions(new ResponseTemplateTransformer(false)));

        //Arranca el demonio que parara el mock server cuando la aplicación termine
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
			public void run() {
            	wireMockServer.stop();
            }
        });

	}

    //Si no especificamos el puerto toma el valor por defecto
	public MockServer(String baseurl) {
		this(baseurl,MOCK_SERVER_PORT);
    }

	//Arranca el mock
    public void start() {
        LOGGER.info("Starting mock server on port {}",puerto);
        wireMockServer.start();
        estado=true;
        LOGGER.info("Mock server started on port {}",puerto);
    }

    //Para el mock
    public void stop() {
    	LOGGER.info("Stopping mock server on port {}",puerto);
        wireMockServer.stop();
        estado=false;
        LOGGER.info("Mock server stopped");
    }

    //Prepara el mockserver para especificar los mocks
    private void initTestData() {
    	if(!estado) {
			start();
		}
        LOGGER.info("starting to create mocks");
        WireMock.configureFor(puerto);
        WireMock.reset();
    }

    public void setTestData(iDataFactory data) {
    	initTestData();
        LOGGER.info("starting to create mocks");
        WireMock.configureFor(puerto);
        WireMock.reset();
    	data.createTestData(base, this);
    }

	public static int getPort() {
		return puerto;
	}

}
