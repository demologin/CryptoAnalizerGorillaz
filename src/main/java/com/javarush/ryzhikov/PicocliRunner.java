package com.javarush.ryzhikov;

import picocli.CommandLine;
import picocli.CommandLine.*;
import picocli.CommandLine.Model.CommandSpec;

import java.io.File;

@Command(name = "cypher", subcommands =
        {CommandLine.HelpCommand.class },
        description = "Caesar cypher command")
public class PicocliRunner implements Runnable {
    @Spec CommandSpec spec;
    @Command(name = "encode", description = "encode from file to file using key")
            void encode(
            @Parameters(paramLabel = "", description =
                    "source file with text to encode") File src,
            @Parameters(paramLabel = "", description =
                    "dest file which should have encodeed text") File dest,
            @Parameters(paramLabel = "", description =
                    "key for encodeion") int key) {
        // TODO
    }

    @Command(name = "brute force", description = "Decrypt from file to file using brute force") // |3|
            void bruteForce(
            @Parameters(paramLabel = "", description =
                    "source file with encoded text") File src,
            @Option(names = {"-r",
                    "--representative"}, description = "file with unencodeed representative text") File representativeFile,
                    @Parameters(paramLabel = "", description =
                    "dest file which should have decrypted text") File dest) {
        // TODO
    }

    @Command(name = "statistical decryption", description =
            "Decrypt from file to file using statistical analysis") // |3|
    void statisticalDecrypt(
            @Parameters(paramLabel = "", description =
                    "source file with encodeed text") File src,
            @Option(names = {"-r",
                    "--representative"}, description = "file with unencodeed representative text") File representativeFile,
                    @Parameters(paramLabel = "", description =
                    "dest file which should have decrypted text") File dest) {
        // TODO
    }

    @Command(name = "decrypt", description = "Decrypt from file to file using statistical analysis") // |3|
            void decrypt(
            @Parameters(paramLabel = "", description =
                    "source file with encodeed text") File src,
            @Parameters(paramLabel = "", description =
                    "dest file which should have decrypted text") File dest,
            @Parameters(paramLabel = "", description =
                    "key for encodeion") int key) {
        // TODO
    }

    @Override
    public void run() {
        throw new ParameterException(spec.commandLine(),
                "Specify a subcommand");
    }

    public static void main(String[] args) {
        int exitCode = new CommandLine(new
                PicocliRunner()).execute(args);
        System.exit(exitCode);
    }
}