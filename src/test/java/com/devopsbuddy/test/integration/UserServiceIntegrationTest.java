package com.devopsbuddy.test.integration;

import com.devopsbuddy.backend.persistence.domain.backend.User;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * Created by Donald F. Coffin on 5/31/17.
 */
/*  @RunWith(SpringJUnit4ClassRunner.class)  */
/*  @SpringApplicationConfiguration(classes = DevopsbuddyApplication.class)  */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceIntegrationTest extends AbstractServiceIntegrationTest {

    @Rule public TestName testName = new TestName();

    @Test
    public void testCreateNewUser() throws Exception {

        User user = createUser(testName);
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());
    }
}
