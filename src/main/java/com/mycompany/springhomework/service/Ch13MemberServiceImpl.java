package com.mycompany.springhomework.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.mycompany.springhomework.dao.Ch13MemberDao;
import com.mycompany.springhomework.dto.Ch13Member;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class Ch13MemberServiceImpl implements Ch13MemberService {
   @Autowired
   private Ch13MemberDao memberDao;
   
   
   @Override
   public JoinResult join(Ch13Member member) {
      Ch13Member dbMember = memberDao.selectByMid(member.getMid());
      if(dbMember != null) {
         return JoinResult.FAIL_DUPLICATED_MID;
      } 
      PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
      member.setMpassword(passwordEncoder.encode(member.getMpassword()));   
      
      memberDao.insert(member);
      return JoinResult.SUCCESS;
         
         
      
   }

   @Override
   public LoginResult login(Ch13Member member) {
      Ch13Member dbMember = memberDao.selectByMid(member.getMid());
      if(dbMember == null) {
         return LoginResult.FAIL_MID;
      }
      
   
      
      PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
      if(passwordEncoder.matches(member.getMpassword(), dbMember.getMpassword())) {
         if(dbMember.isMenabled()) {
            return LoginResult.SUCCESS;
         } else {
            return LoginResult.FAIL_ENABLED;
         }
      } else {
         return LoginResult.FAIL_MPASSWORD;
      }
      
   }

   public void modifyMember(Ch13Member member) {
      memberDao.update(member);
   }

   @Override
   public void unjoin(String mid) {
      Ch13Member member = memberDao.selectByMid(mid);
      member.setMenabled(false);
      memberDao.update(member);
      //modify(member);
   }

   @Override
   public void logout(String mid) {
      // 만약 db에 로그인 정보가 저장되어 있다면, 삭제하는 코드를 작성
      
   }

   @Override
   public Ch13Member getMember(String mid) {
      Ch13Member member = memberDao.selectByMid(mid);
      
      return member;
   }

@Override
public void modify(Ch13Member member) {
	// TODO Auto-generated method stub
	
}

}