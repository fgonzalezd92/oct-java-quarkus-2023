package com.herbalife.resource;

import com.herbalife.dto.AccountDto;
import com.herbalife.dto.AccountTransactionDto;
import com.herbalife.service.BankService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/bank")
public class BankResource {

    @Inject
    private BankService bankService;

    @POST
    @Path("/deposit")
    public Response deposit(AccountDto accountDto) {
        bankService.deposit(accountDto.accountNumber(), accountDto.amount(), accountDto.type());
        return Response.ok().build();
    }

    @POST
    @Path("/withdraw")
    public Response withdraw(AccountDto accountDto) {
        bankService.withdraw(accountDto.accountNumber(), accountDto.amount(), accountDto.type());
        return Response.ok().build();
    }

    @GET
    @Path("/statement/{accountNumber}")
    public List<AccountTransactionDto> statement(@PathParam("accountNumber") String accountNumber) {
        return bankService.statement(accountNumber);
    }

}
