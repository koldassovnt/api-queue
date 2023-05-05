package kz.nkoldassov.apiqueue.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class ScoreboardCodeServiceImplTest {

    @InjectMocks
    private ScoreboardCodeServiceImpl scoreboardCodeService;

    @Test
    public void testGenerateNewCode__a0a0__to__a0a1() {
        String lastCode = "a0a0";

        String newCode = scoreboardCodeService.generateNewCode(lastCode);

        assertThat(newCode).isEqualTo("a0a1");
    }

    @Test
    public void testGenerateNewCode__a0a9__to__a0b0() {
        String lastCode = "a0a9";

        String newCode = scoreboardCodeService.generateNewCode(lastCode);

        assertThat(newCode).isEqualTo("a0b0");
    }

    @Test
    public void testGenerateNewCode__a7g9__to__a7h0() {
        String lastCode = "a7g9";

        String newCode = scoreboardCodeService.generateNewCode(lastCode);

        assertThat(newCode).isEqualTo("a7h0");
    }

    @Test
    public void testGenerateNewCode__a0z9__to__a1a0() {
        String lastCode = "a0z9";

        String newCode = scoreboardCodeService.generateNewCode(lastCode);

        assertThat(newCode).isEqualTo("a1a0");
    }

    @Test
    public void testGenerateNewCode__a9z9_to__b0a0() {
        String lastCode = "a9z9";

        String newCode = scoreboardCodeService.generateNewCode(lastCode);

        assertThat(newCode).isEqualTo("b0a0");
    }

    @Test
    public void testGenerateNewCode__z9z9_to__a0a0a0() {
        String lastCode = "z9z9";

        String newCode = scoreboardCodeService.generateNewCode(lastCode);

        assertThat(newCode).isEqualTo("a0a0a0");
    }

    @Test
    public void testGenerateNewCode__z9z9z9_to__a0a0a0a0() {
        String lastCode = "z9z9z9";

        String newCode = scoreboardCodeService.generateNewCode(lastCode);

        assertThat(newCode).isEqualTo("a0a0a0a0");
    }
}