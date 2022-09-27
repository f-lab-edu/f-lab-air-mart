package com.airmart.ordercommand.common.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.commons.lang.RandomStringUtils;

public class IdentifierGenerator {
  private static final int TOKEN_LENGTH = 6;
  private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

  public static String randomIdentifier() {
    return LocalDateTime.now().format(formatter)
        + RandomStringUtils.randomAlphanumeric(TOKEN_LENGTH);
  }
}
