package memberMVC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import memberMVC.dto.MemberDto;
import memberMVC.exception.DuplicatedIdException;
import memberMVC.exception.RecordNotFoundException;
import memberMVC.util.JdbcUtil;




public class MemberDaoImpl implements MemberDao {

	@Override
	public void add(MemberDto dto) throws SQLException, DuplicatedIdException {// 예외는 부모다 갯수가 같거나 작아야함,예외타입은 부모보다 같거나 자식타입
		

			//DBMS연결
			Connection con = null;
			PreparedStatement pstmt = null;
			try {
				con = JdbcUtil.connect();
				// 3. SQL 작성
				String sql = "INSERT INTO Members(id,name,passwd,status)";
				sql += "VALUES(?,?,?,?)";
				// 4. Statement 생성
				pstmt = con.prepareStatement(sql);
				// 5. 데이터 설정
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getName());
				pstmt.setString(3, dto.getPasswd());
				pstmt.setString(4, dto.getStatus());
				// 6. SQL 전송, 결과수신
				int count = pstmt.executeUpdate();
			} catch (ClassNotFoundException e) {
				throw new SQLException(e);
			} finally {
				JdbcUtil.close(pstmt, con);
			}
		
	}

	@Override
	 public void update(MemberDto m) throws SQLException, RecordNotFoundException {
        //DBMS연결
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
            con = JdbcUtil.connect();
            //등록여부검사
            if(findById(m.getId()) == null) {
        		throw new RecordNotFoundException(m.getId()+"는 없습니다");
        	}// 메소드 멈추고 리턴
            
            // 3. SQL 작성
            String sql = "UPDATE MEMBERS set name=?, passwd=?, status = ?";
            sql += "WHERE id = ?";
            // 4. Statement 생성
            pstmt = con.prepareStatement(sql);
            // 5. 데이터 설정
            pstmt.setString(1, m.getName());
            pstmt.setString(2, m.getPasswd());
            pstmt.setString(3, m.getStatus());
            pstmt.setString(4, m.getId());
            // 6. SQL 전송, 결과수신
            int count = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        } finally {
            JdbcUtil.close(pstmt, con);
        }
    }


	@Override
	   public void delete(String id) throws SQLException, RecordNotFoundException {
        //DBMS연결
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
        	if(findById(id) == null) {
        		throw new RecordNotFoundException(id+"는 사용중입니다");
        	}
            con = JdbcUtil.connect();
            // 3. SQL 작성
            String sql = "DELETE MEMBERS ";
            sql += "WHERE id = ?";
            // 4. Statement 생성
            pstmt = con.prepareStatement(sql);
            // 5. 데이터 설정
            pstmt.setString(1, id);
            // 6. SQL 전송, 결과수신
            int count = pstmt.executeUpdate();
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        } finally {
            JdbcUtil.close(pstmt, con);
        }

    }

	@Override
	public int count() throws SQLException {
		int count =0;
		//DBMS연결
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
        	
            con = JdbcUtil.connect();
            String sql = "SELECT count(*) FROM MEMBERS "; 
        	pstmt = con.prepareStatement(sql);
        	
        	
        	ResultSet rs = pstmt.executeQuery();  //결과받아와서    
    		rs.next();  //무조건 값이 있기 때문에 if가 필요없음
    			count =rs.getInt(1);
    			
    			
    		
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        } finally {
            JdbcUtil.close(pstmt, con);
        }
		return count;
	}

	@Override
	public List<MemberDto> list() throws SQLException {
		List<MemberDto> result = new ArrayList<MemberDto>();
		
		Connection con = null;
        PreparedStatement pstmt = null;
        try {
        	
            con = JdbcUtil.connect();
            String sql = "SELECT * FROM MEMBERS order by id"; 
        	pstmt = con.prepareStatement(sql);
        	
        	
        	ResultSet rs = pstmt.executeQuery();  //결과받아와서    
    		while(rs.next()) { //조회결과가 있다.
    			String id = rs.getString("id"); 
    			String name = rs.getString("name");
    			String passwd = rs.getString("passwd");
    			String status = rs.getString("status");
    			MemberDto dto = new MemberDto(id,name,passwd,status);
    			result.add(dto);
    			
    		}
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        } finally {
            JdbcUtil.close(pstmt, con);
        }
		return result;
	}

	@Override
	public MemberDto findById(String id) throws SQLException {
		MemberDto dto = null; //객체를 못찾았다는 가정하에
		//DBMS연결
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
        	
            con = JdbcUtil.connect();
            String sql = "SELECT * FROM MEMBERS where id =?"; 
        	pstmt = con.prepareStatement(sql);
        	pstmt.setString(1,id);
        	
        	ResultSet rs = pstmt.executeQuery();  //결과받아와서    
    		if(rs.next()) { //조회결과가 있다.
    			//String id = rs.getString("id"); 이미있음
    			String name = rs.getString("name");
    			String passwd = rs.getString("passwd");
    			String status = rs.getString("status");
    			dto = new MemberDto(id,name,passwd,status);
    			
    		}
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        } finally {
            JdbcUtil.close(pstmt, con);
        }
		return dto;
	}
	

}
