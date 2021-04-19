package com.hawaya.socialnetwork.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hawaya.socialnetwork.dao.PostRepository;
import com.hawaya.socialnetwork.entity.Post;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
   
    
    public List<Post> getAllPost(){
        return this.postRepository.findAll();
    }

   public  List<Post> getPostByUserId(Long id){
	   return this.postRepository.findByUser_Id(id);
	   
   }
    
   
   public Post inser(Post post) {
	   return this.postRepository.save(post);
	   
   }
   
   
}
