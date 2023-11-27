package com.omnm.accident;

import com.omnm.accident.Repository.AccidentRepository;
import com.omnm.accident.DAO.AccidentDao;
import com.omnm.accident.Service.AccidentService;
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
