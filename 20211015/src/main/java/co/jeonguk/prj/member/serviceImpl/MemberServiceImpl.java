package co.jeonguk.prj.member.serviceImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import co.jeonguk.prj.hash.DataSources;
import co.jeonguk.prj.member.service.MemberService;
import co.jeonguk.prj.member.service.MemberVO;

public class MemberServiceImpl implements MemberService {
	private DataSources dao = DataSources.getInstance();
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	@Override
	public MemberVO memberLogin(MemberVO vo) {
		String sql = "select * from member where id = ? and password = ?";
		try {
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, vo.getId());
			psmt.setString(2, vo.getPassword());
			rs = psmt.executeQuery();
			if(rs.next()) {
				vo.setName(rs.getString("name"));
				vo.setTel(rs.getString("tel"));
				vo.setAddress(rs.getString("address"));
				vo.setAuthor(rs.getString("author"));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	@Override
	public String encKey() {	//암호화 key 가져오기
		String sql = "select * from encrytion";
		String val = null;
		try{
			conn = dao.getConnection();
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery();
			if(rs.next()) {
				val = rs.getString("enckey");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return val;
	}


}
