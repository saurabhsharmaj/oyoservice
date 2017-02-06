package org.phstudy.sample.common;

import org.phstudy.sample.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Saurabh
 *
 */
public class SecurityUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(SecurityUtil.class);

    public static void logInUser(User user) {
        LOGGER.info("Logging in user: {}", user);
    }
}
