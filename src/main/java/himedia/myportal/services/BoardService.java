package himedia.myportal.services;

import java.util.List;

import himedia.myportal.repositories.vo.BoardVo;

public interface BoardService {
	public List<BoardVo> getList();
	public BoardVo getContent(Long no);
	public boolean write(BoardVo boardvo);
	public boolean update(BoardVo boardvo);
	public boolean delete(Long no, Long userNo);
}
