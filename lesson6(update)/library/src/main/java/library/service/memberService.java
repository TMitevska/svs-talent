package library.service;

import library.model.Book;
import library.model.Member;
import library.repository.BookRepository;
import library.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class memberService implements MemberService {
    private BookRepository bookrepository;
    private MemberRepository memberrepository;

    @Autowired
    public memberService(BookRepository bookrepo, MemberRepository memberrepo) {
        this.bookrepository = bookrepo;
        this.memberrepository = memberrepo;
    }

    @Override
    public Member registerMember(Member member) {
        return memberrepository.save(member);
    }

    @Override
    public Member lendBook(String memberName, String bookName) {
        Member member = this.memberrepository.findMemberByName(memberName);
        Book book = this.bookrepository.findBookByTitle(bookName);

        if (member != null && book != null) {
            member.lendBook(book);
            return  memberrepository.save(member);

        } else {
            return null;
        }
    }

    @Override
    public List<Member> listMembers() {

        return (List<Member>) this.memberrepository.findAll();
    }

    @Override
    public Member updateMember(Member member) {
        return memberrepository.save(member);
    }
}
