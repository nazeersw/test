package com.hawaya.socialnetwork.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import com.hawaya.socialnetwork.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

		
	List<Post> findByUser_Id(@RequestParam("id") Long id);

}
