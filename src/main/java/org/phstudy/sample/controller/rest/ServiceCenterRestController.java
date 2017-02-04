package org.phstudy.sample.controller.rest;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.phstudy.sample.model.ServiceCenter;
import org.phstudy.sample.repository.ServiceCenterRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceCenterRestController {
	@Resource
	private ServiceCenterRepository serviceCenterRepository;

	private static final Logger logger = LoggerFactory
			.getLogger(ServiceCenterRestController.class);

	@RequestMapping(value = "/rest/servicecenter", method = RequestMethod.GET)
	public Page<ServiceCenter> usePageable(
			@RequestParam(value = "query", required = false) String query,
			@PageableDefault(size = 10) Pageable pageable) {

		logger.info("/rest/servicecenter -> pageSize = {}, pageNumber = {}",
				pageable.getPageNumber(), pageable.getPageSize());

		if (StringUtils.isBlank(query)) {
			return serviceCenterRepository.findAll(pageable);
		}
		
		List<ServiceCenter>list = serviceCenterRepository.find(query);
		return new PageImpl<ServiceCenter>(list);
	}
}
