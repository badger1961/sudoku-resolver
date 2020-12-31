package org.houseofbadger.sudoku.main;

import org.apache.commons.cli.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.PrintWriter;
import java.util.Optional;

public class CommandLineHandler {
    private static Logger LOG = LoggerFactory.getLogger(CommandLineHandler.class);

    final public static String VERSION = "1.0.0";
    // output file name
    final public static String OPTION_OUTPUT_FILE_NAME_SHORT = "o";
    final public static String OPTION_OUTPUT_NAME_LONG       = "output";
    final public static String OPTION_OUTPUT_OPTION_DESC     = "file name where solution will be placed";
    final public static String OPTION_OUTPUT_FILE_NAME_ARG   = "outputname";

    // input file's name
    final public static String OPTION_INPUT_FILE_NAME_SHORT = "i";
    final public static String OPTION_INPUT_FILE_NAME_LONG  = "input";
    final public static String OPTION_INPUT_FILE_NAME_DESC  = "file with task definition";
    final public static String OPTION_INPUT_FILE_NAME_ARG   = "inputname";

    // print vrsion option
    final public static String OPTION_GET_VERSION_SHORT = "v";
    final public static String OPTION_GET_VERSION_LONG  = "version";
    final public static String OPTION_GET_VERSION_DESC  = "print version and exit";
    final public static String OPTION_GET_VERSION_ARG   = "version";

    final public static String        OPTION_HELP_SHORT = "h";
    final public static String        OPTION_HELP_LONG  = "help";
    final public static String        OPTION_HELP_DESC  = "Help printing";

    public boolean checkForHelp(String[] args, Options mainOptions) {
        final String        OPTION_HELP_SHORT = "h";
        final String        OPTION_HELP_LONG  = "help";
        final String        OPTION_HELP_DESC  = "Help printing";

        final String        OPTION_VERSION_SHORT = "v";
        final String        OPTION_VERSION_LONG  = "version";
        final String        OPTION_VERSION_DESC  = "version printing abd exit";


        CommandLineParser parser = new DefaultParser();
        Option help = Option.builder(OPTION_HELP_SHORT)
                            .desc(OPTION_HELP_DESC)
                            .longOpt(OPTION_HELP_LONG)
                            .build();
        Option version = Option.builder(OPTION_VERSION_SHORT)
                .desc(OPTION_VERSION_DESC)
                .longOpt(OPTION_VERSION_LONG)
                .build();

        Options options = new Options();
        options.addOption(help);
        options.addOption(version);
        final CommandLine cmdLine;
        try {
            cmdLine = parser.parse(options, args, true);
            if (cmdLine.hasOption(OPTION_HELP_SHORT)) {
                this.printHelp(mainOptions);
                return true;
            }
            if (cmdLine.hasOption(OPTION_VERSION_SHORT)) {
                this.printVersion();
                return true;
            }

        } catch (ParseException e) {
            LOG.error("Hmm ... could no parse command line ");
            LOG.error(e.getMessage());
            return true;
        }

        return false;
    }


    public Optional<CommandLine> parse(String[] args) {
        CommandLineParser parser = new DefaultParser();
        final Option inputFileName = Option.builder(OPTION_INPUT_FILE_NAME_SHORT)
                                         .argName(OPTION_INPUT_FILE_NAME_ARG)
                                         .hasArgs()
                                         .valueSeparator()
                                         .desc(OPTION_INPUT_FILE_NAME_DESC)
                                         .required(true)
                                         .longOpt(OPTION_INPUT_FILE_NAME_LONG)
                                         .type(String.class)
                                         .build();

        final Option outputFileName = Option.builder(OPTION_OUTPUT_FILE_NAME_SHORT)
                                            .argName(OPTION_OUTPUT_FILE_NAME_ARG)
                                            .hasArgs()
                                            .valueSeparator()
                                            .desc(OPTION_OUTPUT_OPTION_DESC)
                                            .required(true)
                                            .longOpt(OPTION_OUTPUT_NAME_LONG)
                                            .type(String.class)
                                            .build();

        final Option printVersion = Option.builder(OPTION_GET_VERSION_SHORT)
                .argName(OPTION_GET_VERSION_ARG)
                .hasArgs()
                .valueSeparator()
                .desc(OPTION_GET_VERSION_ARG)
                .longOpt(OPTION_GET_VERSION_LONG)
                .type(String.class)
                .build();

        final Option help = Option.builder(OPTION_HELP_SHORT)
                                  .desc(OPTION_HELP_DESC)
                                  .longOpt(OPTION_HELP_LONG)
                                  .build();

        Options options = new Options();
        options.addOption(inputFileName);
        options.addOption(outputFileName);
        options.addOption(help);
        options.addOption(printVersion);
        final CommandLine cmdLine;

        if (this.checkForHelp(args, options)) {
            return Optional.empty();
        }

        try {
            cmdLine = parser.parse(options, args);
        } catch (ParseException e) {
            LOG.error("Hmm ... could no parse command line ");
            LOG.error(e.getMessage());
            return Optional.empty();
        }

        return Optional.of(cmdLine);
    }

    public void printHelp(final Options options) {
        final String        header            = " == Report Importer HELP BEGIN == ";
        final String        footer            = " == Report Importer HELP END == ";
        final String        commandLineSyntax = "java -jar <sudoku resolver jar file name> <options>";
        final PrintWriter   writer            = new PrintWriter(System.out);
        final HelpFormatter helpFormatter     = new HelpFormatter();
        helpFormatter.printHelp(writer, 80, commandLineSyntax, header, options, 5, 3, footer, true);
        writer.close();
    }

    public void printVersion() {
        final PrintWriter   writer = new PrintWriter(System.out);
        writer.println(VERSION);
        writer.close();
    }
}
