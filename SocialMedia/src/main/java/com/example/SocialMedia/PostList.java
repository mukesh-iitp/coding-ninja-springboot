package com.example.SocialMedia;

import java.util.ArrayList;

public interface PostList {
	public ArrayList<Post> getAllPosts();
	public Post getPost(int i);
	public void setPost(Post post);
	public int size();
}
