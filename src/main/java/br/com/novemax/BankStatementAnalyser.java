package br.com.novemax;

import br.com.novemax.bean.BankTransaction;
import br.com.novemax.parser.BankStatementCSVParser;
import br.com.novemax.parser.BankStatementParse;
import br.com.novemax.processor.BankStatementProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementAnalyser {

  private static final String RESOURCES = "src/main/resources/";
  public void analyze(String fileName, BankStatementParse bankStatementParse) throws IOException {

    var path = Paths.get(RESOURCES + fileName);
    var lines = Files.readAllLines(path);

    var bankTransactions = bankStatementParse.parseLinesFrom(lines);
    var bankStatementProcessor = new BankStatementProcessor((bankTransactions));

    collectSummary(bankStatementProcessor);
  }

  private static void collectSummary(BankStatementProcessor bankStatementProcessor) {
    System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());
    System.out.println("The total for all transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));
    System.out.println("The total for all transactions in February is " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));
    System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
  }
}
