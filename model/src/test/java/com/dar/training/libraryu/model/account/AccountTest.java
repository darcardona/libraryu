package com.dar.training.libraryu.model.account;

import org.junit.Test;

import com.dar.training.libraryu.model.account.Account;
import com.dar.training.libraryu.model.account.AccountState;
import com.dar.training.libraryu.model.account.Student;
import com.dar.training.libraryu.model.account.User;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;

/**
 * Created by dar on 11/22/14.
 */
public class AccountTest {

    @Test
    public void openingDateCannotBeNullWhenCreated() {
        assertNotNull(createAccount().getOpeningDate());
    }

    @Test
    public void stateCannotBeNullWhenCreated() {
        assertNotNull(createAccount().getState());
    }

    @Test
    public void stateShouldBeOpenedWhenCreated() {
        assertEquals(AccountState.OPENED, createAccount().getState());
    }

    @Test
    public void openingDateMustBeSetToToday() {
        assertEquals(LocalDate.now(), createAccount().getOpeningDate().toLocalDate());
    }

    @Test
    public void anAccountMustBeAssociatedWithAnUser() {
        Account account = createAccount();
        assertNotNull(account.getUser());
        assertNotNull(account.getUser().getId());
        assertNotNull(account.getUser().getName());
    }

    @Test
    public void userRemainsTheSame() {
        assertEquals(new Long(1), createAccount().getUser().getId());
    }

    @Test
    public void studentHaveAdditionalProperties() {
        Account account = createAccount();
        assertTrue(account.getUser() instanceof Student);
        assertNotNull(((Student) account.getUser()).getFaculty());
    }

    private Account createAccount() {
        return new Account(createStudent());
    }

    private User createStudent() {
        AtomicLong id = new AtomicLong();
        return new Student(id.incrementAndGet(), "name" + id, "faculty" + 1);
    }
}