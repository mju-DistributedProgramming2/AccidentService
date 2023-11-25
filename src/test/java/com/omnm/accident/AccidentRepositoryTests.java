package com.omnm.accident;

import com.omnm.accident.Entity.Accident;
import com.omnm.accident.Repository.AccidentRepository;
import com.omnm.accident.enumeration.accident.AccidentStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.sql.Timestamp;
import java.util.List;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class AccidentRepositoryTests {
    @Autowired
    AccidentRepository accidentRepository;
    @BeforeEach
        // 테스트 실행 전 실행
    void setup(){
        Accident accident1 = new Accident();
        accident1.setId(1);
        accident1.setContractId(1);
        accident1.setStatus(AccidentStatus.Compensate);
        accident1.setCause("화재");
        accident1.setContent("업장에서 불이 났습니다");
        accident1.setDate(new Timestamp(System.currentTimeMillis()));
        accident1.setAccountNumber("1234-32-2132322");
        accident1.setDamage(50000000);
        accident1.setLocation("강남");
        accidentRepository.save(accident1);
        Accident accident2 = new Accident();
        accident2.setId(2);
        accident2.setContractId(1);
        accident2.setStatus(AccidentStatus.Compensate);
        accident2.setCause("화재");
        accident2.setContent("업장에서 불이 났습니다");
        accident2.setDate(new Timestamp(System.currentTimeMillis()));
        accident2.setAccountNumber("1234-32-2132322");
        accident2.setDamage(50000000);
        accident2.setLocation("강남");
        accidentRepository.save(accident2);
        Accident accident3 = new Accident();
        accident3.setId(3);
        accident3.setContractId(1);
        accident3.setStatus(AccidentStatus.ReportAccident);
        accident3.setCause("화재");
        accident3.setContent("업장에서 불이 났습니다");
        accident3.setDate(new Timestamp(System.currentTimeMillis()));
        accident3.setAccountNumber("1234-32-2132322");
        accident3.setDamage(50000000);
        accident3.setLocation("강남");
        accidentRepository.save(accident3);
    }
    @Test
    @DisplayName("사고 저장")
    void contextLoads() {
        Accident accident = new Accident();
        accident.setId(1);
        accident.setContractId(1);
        accident.setStatus(AccidentStatus.Compensate);
        accident.setCause("화재");
        accident.setContent("업장에서 불이 났습니다");
        accident.setDate(new Timestamp(System.currentTimeMillis()));
        accident.setAccountNumber("1234-32-2132322");
        accident.setDamage(50000000);
        accident.setLocation("강남");

        Accident result = accidentRepository.save(accident);

        Assertions.assertThat(result.getId()).isEqualTo(accident.getId());
        Assertions.assertThat(result.getContractId()).isEqualTo(accident.getContractId());
        Assertions.assertThat(result.getStatus()).isEqualTo(accident.getStatus());
        Assertions.assertThat(result.getCause()).isEqualTo(accident.getCause());
        Assertions.assertThat(result.getContent()).isEqualTo(accident.getContent());
        Assertions.assertThat(result.getDate()).isEqualTo(accident.getDate());
        Assertions.assertThat(result.getAccountNumber()).isEqualTo(accident.getAccountNumber());
        Assertions.assertThat(result.getDamage()).isEqualTo(accident.getDamage());
        Assertions.assertThat(result.getLocation()).isEqualTo(accident.getLocation());
    }
    @Test
    @DisplayName("모든 사고 조회")
    void getAllAccidents() {
        List<Accident> bookList = accidentRepository.findAll();
        Assertions.assertThat(bookList.size()).isEqualTo(3);
    }

}
