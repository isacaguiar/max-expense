package br.com.novemax.parser;

import br.com.novemax.bean.BankTransaction;

import java.util.List;

public interface BankStatementParse {
  BankTransaction parseFrom(String line);
  List<BankTransaction> parseLinesFrom(List<String> lines);
}
