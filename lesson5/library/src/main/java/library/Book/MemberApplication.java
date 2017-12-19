package library.Book;

import library.Book.Book;
import library.Book.BookRepository;
import library.Book.Member;
import library.Book.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class MemberApplication {

    private MemberRepository memberRepository;
    private BookRepository bookRepository;
    @Autowired
    public MemberApplication(MemberRepository memberRepository,BookRepository bookrepo) {
        this.memberRepository = memberRepository;
        this.bookRepository=bookrepo;
    }

    public void start()
    {

        Scanner s=new Scanner(System.in);

        while(true)
        {
            System.out.println("Enter option 'register' ,'list' , 'lend' or 'go back'");
            String option=s.nextLine().toLowerCase();
            if(option.equals("register"))
            {   System.out.println("Enter name and embg'");
                String name=s.nextLine().toLowerCase();

                String embg=s.nextLine().toLowerCase();
                this.memberRepository.save(new Member(name,embg));
            }
            else  if(option.equals("list"))
            {
                Iterable<Member> members=this.memberRepository.findAll();

                for(Member member:members){
                    member.displayBooks();
                }
            }
            else  if(option.equals("lend"))
            {   System.out.println("Enter member name'");
                String membername=s.nextLine().toLowerCase();
                System.out.println("Enter book name'");
                String bookname=s.nextLine().toLowerCase();
                Member member=this.memberRepository.findmember(membername);
                Book book=this.bookRepository.findbook(bookname);
                System.out.println("Member "+membername+" lend "+bookname);
                member.lendBook(book);
                memberRepository.save(member);

            }
            else
            {
                break;
            }

        }
    }
}
