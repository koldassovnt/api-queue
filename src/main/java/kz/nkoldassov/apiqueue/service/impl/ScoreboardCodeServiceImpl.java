package kz.nkoldassov.apiqueue.service.impl;

import kz.nkoldassov.apiqueue.db.dao.ScoreboardDao;
import kz.nkoldassov.apiqueue.db.entity.ScoreboardEntity;
import kz.nkoldassov.apiqueue.service.ScoreboardCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ScoreboardCodeServiceImpl implements ScoreboardCodeService {

    private final ScoreboardDao scoreboardDao;

    @Autowired
    public ScoreboardCodeServiceImpl(ScoreboardDao scoreboardDao) {
        this.scoreboardDao = scoreboardDao;
    }

    @Override
    public String getNextCode() {
        ScoreboardEntity lastScoreboard = scoreboardDao.getLastScoreboard();

        String newCode = generateNewCode(lastScoreboard.getCode());

        scoreboardDao.insertNewCode(newCode);

        return lastScoreboard.getCode();
    }

    @Override
    public String generateNewCode(String lastCode) {
        char[] symbols = {
                'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
                'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        char[] numbers = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

        char[] nextCode = lastCode.toCharArray();

        StringBuilder sb = new StringBuilder();

        sb.append("z9".repeat(nextCode.length / 2));

        if (Objects.equals(sb.toString(), String.copyValueOf(nextCode))) {
            return "a0".repeat(Math.max(0, (nextCode.length + 2) / 2));
        }

        if (nextCode[nextCode.length - 1] == '9') {

            boolean incrementPrev = false;

            for (int i = nextCode.length - 1; i >= 0; i--) {

                if (nextCode[i] == 'z') {
                    incrementPrev = true;
                    nextCode[i] = symbols[0];
                    continue;
                }

                if (nextCode[i] == '9') {
                    incrementPrev = true;
                    nextCode[i] = numbers[0];
                    continue;
                }

                if (incrementPrev && Character.isDigit(nextCode[i])) {
                    nextCode[i] = numbers[getIndex(numbers, nextCode[i]) + 1];
                    break;
                }

                if (incrementPrev && Character.isLetter(nextCode[i])) {
                    nextCode[i] = symbols[getIndex(symbols, nextCode[i]) + 1];
                    break;
                }
            }

        } else {
            nextCode[nextCode.length - 1] = numbers[getIndex(numbers, nextCode[nextCode.length - 1]) + 1];
        }

        return String.copyValueOf(nextCode);
    }

    private int getIndex(char[] symbols, char c) {
        for (int i = 0; i < symbols.length; i++) {
            if (symbols[i] == c) {
                return i;
            }
        }
        return -1;
    }
}
