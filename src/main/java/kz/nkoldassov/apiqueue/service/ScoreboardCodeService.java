package kz.nkoldassov.apiqueue.service;

public interface ScoreboardCodeService {
    String getNextCode();

    String generateNewCode(String lastCode);
}
