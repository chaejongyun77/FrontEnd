package memberMVC.dao;

import java.sql.SQLException;
import java.util.List;

import memberMVC.dto.MemberDto;
import memberMVC.exception.DuplicatedIdException;
import memberMVC.exception.RecordNotFoundException;




public interface MemberDao {
	  //등록
	  public void add(MemberDto m) throws SQLException, DuplicatedIdException;
	  //수정
	  public void update(MemberDto m) throws SQLException, RecordNotFoundException;
	  //삭제
	  public void delete(String id) throws SQLException, RecordNotFoundException;
	  //갯수
	  public int count() throws SQLException;
	  //목록
	  public List<MemberDto> list() throws SQLException;
	  //검색
	  public MemberDto findById(String id) throws SQLException;
}
