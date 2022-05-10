package br.com.novemax.parser;

import br.com.novemax.bean.BankTransaction;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementCSVParserTest {

  BankStatementCSVParser statementCSVParser = new BankStatementCSVParser();

  @Test
  public void shouldParseOneCorrectLine() throws Exception {
    String line = "30-01-2017,-50,Tesco";

    BankTransaction result = statementCSVParser.parseFrom(line);

    BankTransaction expected = new BankTransaction(LocalDate.of(2017, Month.JANUARY, 30), -50d, "Tesco");
    double tolerance = 0.0d;

    Assert.assertEquals(expected.getDate(), result.getDate());
    Assert.assertEquals(expected.getAmount(), result.getAmount(), tolerance);
    Assert.assertEquals(expected.getDescription(), result.getDescription());
  }

  @Test
  public void shouldParseTwoLines() throws Exception {
    List<String> lines = new ArrayList<>();
    lines.add("30-01-2017,-50,Tesco");
    lines.add("01-02-2017,-6000,Salary");

    List<BankTransaction> result = statementCSVParser.parseLinesFrom(lines);

    Assert.assertEquals(result.size(), 2);
  }

}