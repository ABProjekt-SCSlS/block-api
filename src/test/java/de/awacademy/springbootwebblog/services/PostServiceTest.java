package de.awacademy.springbootwebblog.services;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;

import de.awacademy.springbootwebblog.entities.Comment;
import de.awacademy.springbootwebblog.repositories.CommentRepository;
import de.awacademy.springbootwebblog.repositories.PostRepository;

public class PostServiceTest {
	
	private PostService postService;
    private PostRepository postRepository;
    private CommentRepository commentRepository;
    
    
    @BeforeEach
    void setUp() {
    	postRepository = mock(PostRepository.class);
    	commentRepository = mock(CommentRepository.class);
    	postService = new PostService();
    }
    
 
//    void attachCommentTest() {
//    	Comment comment = new Comment();
//    	Comment result = commentRepository.save(comment);
//    	
//    		
//    }

    
    
}
