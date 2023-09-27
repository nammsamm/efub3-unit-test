package efub.session.test.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ScoreServiceTest {

    @InjectMocks
    private ScoreService scoreService;

    @Test
    public void doScore_GivenHighScore_ReturnGradeA(){
        /* given */
        final Long HIGH_SCORE = 95L;
        final String GRADE_A = "A";

        /* when, then */
        assertThat(scoreService.doScore(HIGH_SCORE)).isEqualTo(GRADE_A);
    }


    @Test
    public void doScore_GivenLowScore_ReturnGradeF(){
        /* given */
        final Long LOW_SCORE = 20L;
        final String GRADE_F = "F";

        /* when , them */
        assertThat(scoreService.doScore(LOW_SCORE)).isEqualTo(GRADE_F);
    }

    @Test
    public void doScore_GivenMinusScore_ReturnWarningPhrase(){
        /* given */
        final Long MINUS_SCORE = -2L;
        final String WARNING_PHRASE = "Insert a number from 0 to 100";


        /* when, then */
        assertThat(scoreService.doScore(MINUS_SCORE)).isEqualTo(WARNING_PHRASE);
    }


    @Test
    public void doScore_GivenTooHighScore_ReturnWarningPhrase() throws Exception{
        /* given */
        final Long TOO_HIGH_SCORE = 200L;
        final String WARNING_PHRASE = "Insert a number from 0 to 100";

        /* when, then */
        assertThat(scoreService.doScore(TOO_HIGH_SCORE)).isEqualTo(WARNING_PHRASE);
    }

}