package com.example.accidentservice;

import com.example.accidentservice.Repository.AccidentRepository;
import com.example.accidentservice.dao.AccidentDao;
import com.example.accidentservice.service.AccidentService;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AccidentServiceTests {
    @Autowired
    AccidentService accidentService;
    @Mock
    AccidentDao accidentDao;
    @Mock
    AccidentRepository accidentRepository;
}
