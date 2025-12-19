package com.sist.web.service;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberMapper mMapper;

	@Override
	public MemberVO memberLogin(String id, String pwd) {
		// TODO Auto-generated method stub
		MemberVO vo=new MemberVO();
		int count=mMapper.memberIdCount(id);
		if(count==0)
		{
			vo.setMsg("NOID");
		}
		else
		{
			MemberVO dbVO=mMapper.memberInfoData(id);
			if(pwd.equals(dbVO.getPwd()))
			{
				vo=dbVO;
				vo.setMsg("OK");
			}
			else
			{
				vo.setMsg("NOPWD");
			}
		}
		return vo;
	}

}
