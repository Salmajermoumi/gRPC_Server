package service;

import io.grpc.stub.StreamObserver;
import org.xproc.stubs.Bank;
import org.xproc.stubs.BankServiceGrpc;

public class BankGrpcService extends BankServiceGrpc.BankServiceImplBase {
    @Override
    public void convert(Bank.ConvertCurrencyRequest request, StreamObserver<Bank.ConvertCurrencyResponse> responseObserver) {
        String currencyForm = request.getCurrencyFrom();
        String currencyTo = request.getCurrencyTo();
        double amount = request.getAmount();
        Bank.ConvertCurrencyResponse response = Bank.ConvertCurrencyResponse.newBuilder()
                .setCurrencyFrom(currencyForm)
                .setCurrencyTo(currencyTo)
                .setAmount(amount)
                .setResult(amount * 10)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
