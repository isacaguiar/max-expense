package br.com.novemax.processor;

import br.com.novemax.bean.BankTransaction;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class BankStatementProcessor {

  List<BankTransaction> bankTransactions;

  public BankStatementProcessor(List<BankTransaction> bankTransactions) {
    this.bankTransactions = bankTransactions;
  }

  public double calculateTotalAmount() {
    var total = 0;
    for(BankTransaction bankTransaction : bankTransactions) {
      total += bankTransaction.getAmount();
    }
    return total;
  }

  public double calculateTotalInMonth(Month month) {
    var total = 0;
    for (var bankTransaction : bankTransactions) {
      if(bankTransaction.getDate().getMonth() == month) {
        total += bankTransaction.getAmount();
      }
    }
    return total;
  }

  public double calculateTotalForCategory(String category) {
    var total = 0;
    for (var bankTransaction : bankTransactions) {
      if(bankTransaction.getDescription().equals(category)) {
        total += bankTransaction.getAmount();
      }
    }
    return total;
  }
}
