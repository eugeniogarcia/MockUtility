package com.ng.systemtest.app;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ng.systemtest.MockServer;

//Nuestra Aplicación de Mock
public class mockApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(mockApp.class);
    private static MockServer mockServer;

    private static final String COLLECTION_OPTION = "collection";


    public mockApp() {

    }

    public static void main(String[] args) {
        //Toma los parametros de la linea de comandos
        final CommandLine commandLine = parseArgs(args);
        final String basepath=commandLine.getOptionValue(COLLECTION_OPTION, "v1/ngeso");
        LOGGER.info("Starting NGESO Mocking App");
    	mockServer=new MockServer(basepath);

        //Prepara los datos a mockear
    	mockServer.setTestData(new TestDataFactory());
    	LOGGER.info("Mock of NGESO is on");
    	LOGGER.info("Try http://localhost:9999/v1/ngeso/oce/fda/v1/individuals?scn=90000001");

    }

    private static CommandLine parseArgs(String[] args) {

        final Options options = new Options();

        final Option output = new Option("c", COLLECTION_OPTION, true, "collection of mocks");
        options.addOption(output);

        final CommandLineParser parser = new DefaultParser();
        final HelpFormatter formatter = new HelpFormatter();
        CommandLine cmd;

        try {
            cmd = parser.parse(options, args);
        } catch (final ParseException e) {
            System.out.println(e.getMessage());
            formatter.printHelp("java -jar mocks.jar", options);

            System.exit(1);
            return null;
        }

        return cmd;
    }

}
