package library.service;

import library.model.Member;

import java.util.List;

public interface MemberService {


    Member registerMember(Member member);

    Member lendBook(String memberName, String bookName);

    List<Member> listMembers();

    Member updateMember(Member member);
}