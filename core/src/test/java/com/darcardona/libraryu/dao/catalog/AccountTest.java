package com.darcardona.libraryu.dao.catalog;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

import org.junit.Ignore;
import org.junit.Test;

import com.darcardona.libraryu.model.dao.account.Account;
import com.darcardona.libraryu.model.dao.account.AccountState;
import com.darcardona.libraryu.model.dao.account.Student;
import com.darcardona.libraryu.model.dao.account.User;

/**
 * Created by dar on 11/22/14.
 */
@Ignore
public class AccountTest {

	// TODO: change this

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
		assertEquals(LocalDate.now(), createAccount().getOpeningDate()
				.toLocalDate());
	}

	@Test
	public void anAccountMustBeAssociatedWithAnUser() {
		Account account = createAccount();
		assertNotNull(account.getUser());
		assertNotNull(account.getUser().getId());
		assertNotNull(account.getUser().getNames());
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