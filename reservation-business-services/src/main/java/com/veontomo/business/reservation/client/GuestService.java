package com.veontomo.business.reservation.client;

import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.veontomo.business.reservation.domain.Guest;

import java.util.Collections;
import java.util.List;

/**
 * Created by frankmoley on 5/23/17.
 */
@FeignClient(value = "GUESTSERVICES", fallback = GuestServiceFallbackImpl.class)
public interface GuestService {

    @RequestMapping(value="/guests", method= RequestMethod.GET)
    List<Guest> findAll(@RequestParam(name="emailAddress", required = false)String emailAddress);

    @RequestMapping(value = "/guests/{id}", method = RequestMethod.GET)
    Guest findOne(@PathVariable(name="id")long id);
}
