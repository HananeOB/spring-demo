package com.emse.spring.faircorp.repository;

import com.emse.spring.faircorp.model.LightDao;
import com.emse.spring.faircorp.model.Status;
import org.assertj.core.api.Assertions;
import org.assertj.core.groups.Tuple;
import org.springframework.beans.factory.annotation.Autowired;
import org.junit.Test;

public class LightDaoCustomImplTest {
    @Autowired
    private LightDao lightDao;

    @Test
    public void shouldFindOnLights() {
        Assertions.assertThat(lightDao.findOnLights())
                .hasSize(1)
                .extracting("id", "status")
                .containsExactly(Tuple.tuple(-1L, Status.ON));
    }
}
