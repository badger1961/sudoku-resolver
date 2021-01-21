package org.houseofbadger.sudoku.main;

import org.apache.commons.cli.CommandLine;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Optional;


public class CommandLineHandlerTest {

    @Test
    public void testCheckForHelp() {
        CommandLineHandler commandLineHandler = new CommandLineHandler();
        String command_line[] = new String[] {"--help22"};
        Optional<CommandLine> answer = commandLineHandler.parse(command_line);
        Assert.assertTrue(answer.isEmpty());
    }

    @Test
    public void testCheckForHelp2() {
        CommandLineHandler commandLineHandler = new CommandLineHandler();
        String command_line[] = new String[] {"--help"};
        Optional<CommandLine> answer = commandLineHandler.parse(command_line);
        Assert.assertTrue(answer.isEmpty());
    }

    @Test
    public void testCheckForHelp2_1() {
        CommandLineHandler commandLineHandler = new CommandLineHandler();
        String command_line[] = new String[] {"-h"};
        Optional<CommandLine> answer = commandLineHandler.parse(command_line);
        Assert.assertTrue(answer.isEmpty());
    }

    @Test
    public void testCheckForHelp3() {
        CommandLineHandler commandLineHandler = new CommandLineHandler();
        String command_line[] = new String[] {"--version"};
        Optional<CommandLine> answer = commandLineHandler.parse(command_line);
        Assert.assertTrue(answer.isEmpty());
    }

    @Test
    public void testCheckForHelp3_1() {
        CommandLineHandler commandLineHandler = new CommandLineHandler();
        String command_line[] = new String[] {"-v"};
        Optional<CommandLine> answer = commandLineHandler.parse(command_line);
        Assert.assertTrue(answer.isEmpty());
    }

    @Test
    public void testCheckForHelp4() {
        CommandLineHandler commandLineHandler = new CommandLineHandler();
        String command_line[] = new String[] {"--version22"};
        Optional<CommandLine> answer = commandLineHandler.parse(command_line);
        Assert.assertTrue(answer.isEmpty());
    }

    @Test
    public void testCheckForHelp5() {
        CommandLineHandler commandLineHandler = new CommandLineHandler();
        String command_line[] = new String[] {"-i data.txt"};
        Optional<CommandLine> answer = commandLineHandler.parse(command_line);
        Assert.assertTrue(answer.isEmpty());
    }

    @Test
    public void testCheckForHelp6() {
        CommandLineHandler commandLineHandler = new CommandLineHandler();
        String command_line[] = new String[] {"-o data.txt"};
        Optional<CommandLine> answer = commandLineHandler.parse(command_line);
        Assert.assertTrue(answer.isEmpty());
    }

    @Test
    public void testCheckForHelp7() {
        CommandLineHandler commandLineHandler = new CommandLineHandler();
        String command_line[] = new String[] {"-o", "data.txt", "-i", "task.txt"};
        Optional<CommandLine> answer = commandLineHandler.parse(command_line);
        Assert.assertTrue(!answer.isEmpty());
        CommandLine cmdl = answer.get();
        String task = cmdl.getOptionValue('i');
        String answer_data = cmdl.getOptionValue('o');
        Assert.assertEquals(task, "task.txt");
        Assert.assertEquals(answer_data, "data.txt");
    }

    @Test
    public void testCheckForHelp8() {
        CommandLineHandler commandLineHandler = new CommandLineHandler();
        String command_line[] = new String[] {"--output", "data.txt", "--input", "task.txt"};
        Optional<CommandLine> answer = commandLineHandler.parse(command_line);
        Assert.assertTrue(!answer.isEmpty());
        CommandLine cmdl = answer.get();
        String task = cmdl.getOptionValue('i');
        String answer_data = cmdl.getOptionValue('o');
        Assert.assertEquals(task, "task.txt");
        Assert.assertEquals(answer_data, "data.txt");
    }
}