package com.timeapi.timeapi.service;

import com.timeapi.timeapi.configuration.Bootstrap;
import com.timeapi.timeapi.model.Timezone;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class TimeServiceTest {

    @Autowired
    Bootstrap bootstrap;

    @Autowired
    TimeService timeService;

    @Test
    public void testGetTimeZoneDetails() {
        Timezone timezone = timeService.getTimeZoneDetails("America/Adak");
        Assert.assertNotNull(timezone);
    }

    @Test(expected = Exception.class)
    public void testGetTimeZoneDetailsWithInvalidResponse() {
        Timezone timezone = timeService.getTimeZoneDetails(null);
    }

}
