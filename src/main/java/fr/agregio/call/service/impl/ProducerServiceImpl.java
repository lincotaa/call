package fr.agregio.call.service.impl;

import fr.agregio.call.service.ProducerService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("producerService")
public class ProducerServiceImpl implements ProducerService {
}
