package fr.agregio.call.service.impl;

import fr.agregio.call.service.GroupOfProductionService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("groupOfProductionService")
public class GroupOfProductionServiceImpl implements GroupOfProductionService {
}
