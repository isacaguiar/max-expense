package br.com.novemax.parser;

import br.com.novemax.bean.BankTransaction;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParser implements BankStatementParse {

  private static final DateTimeFormatter DATE_PATTERN = DateTimeFormatter.ofPattern("dd-MM-yyyy");

  public BankTransaction parseFrom(String line) {
    var columns = line.split(",");
    var date = LocalDate.parse(columns[0], DATE_PATTERN);
    var amount = Double.parseDouble(columns[1]);
    var description = columns[2];
    return new BankTransaction(date, amount, description);
  }

  public List<BankTransaction> parseLinesFrom(List<String> lines) {
    BankStatementCSVParser bankStatementCSVParser = new BankStatementCSVParser();
    List<BankTransaction> bankTransactions = new ArrayList<>();
    for(var line: lines) {
      bankTransactions.add(parseFrom(line));
    }
    return bankTransactions;
  }
}
