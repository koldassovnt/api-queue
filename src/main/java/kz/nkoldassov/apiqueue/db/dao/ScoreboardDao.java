package kz.nkoldassov.apiqueue.db.dao;

import kz.nkoldassov.apiqueue.db.entity.ScoreboardEntity;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ScoreboardDao {

    @Select("select * from scoreboard order by id desc limit 1")
    ScoreboardEntity getLastScoreboard();

    @Insert("insert into scoreboard (code) values (#{newCode})")
    void insertNewCode(@Param("newCode") String newCode);
}
