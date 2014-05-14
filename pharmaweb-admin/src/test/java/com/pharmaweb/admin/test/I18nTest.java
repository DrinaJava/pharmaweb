package com.pharmaweb.admin.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.pharmaweb.admin.i18n.I18n;

public class I18nTest {

	@Test
	public void test_() {
		String str = I18n._(I18n.INVALID_LOGIN);
		assertTrue(str.equals("Identifiant et/ou mot de passe invalide."));
	}
}
