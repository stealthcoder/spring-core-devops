package guru.springframework.test.external.props;

import guru.springframework.test.jms.FakeJmsBroker;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import test.config.external.props.ExternalPropsPropertySourceTestConfig;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ExternalPropsPropertySourceTestConfig.class)
public class PropertySourceTest {

    @Autowired
    FakeJmsBroker fakeJmsBroker;

    @Test
    public void testPropsSet() throws Exception{
        assertEquals("10.10.10.123",fakeJmsBroker.getUrl());
        assertEquals("password",fakeJmsBroker.getPassword());
        assertEquals("user",fakeJmsBroker.getUser());
        assertTrue(3330 == fakeJmsBroker.getPort());
    }
}
