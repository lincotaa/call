package fr.agregio.call.service.impl;

import fr.agregio.call.service.ProductionGroupService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("producerService")
public class ProductionProductionGroupServiceImpl implements ProductionGroupService {
}
