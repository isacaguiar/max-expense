package br.com.novemax;

import br.com.novemax.parser.BankStatementCSVParser;

import java.io.IOException;

public class MainApplication {

  public static void main(String args[]) throws IOException {
    var bankStatementAnalyzer = new BankStatementAnalyser();
    var bankStatementParser = new BankStatementCSVParser();
    bankStatementAnalyzer.analyze(args[0], bankStatementParser);
  }
}
