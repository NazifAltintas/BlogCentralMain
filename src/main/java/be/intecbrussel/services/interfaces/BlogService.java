package be.intecbrussel.services.interfaces;

import be.intecbrussel.data.Blog;

import java.util.List;
import java.util.Optional;

public interface BlogService {

    public List<Blog> getAllBlogs();
    public Blog getBlogById(Long id);
    public void createBlog(Blog blog);
    public List<Blog> findBlogsByTitle(String title);
    public List<Blog> findBlogsByAuthor(String Name);
    public void deleteBlog(Blog blog);
    public List<Blog> sortByDate();
    public List<Blog> getBlogByPageNum(int id);
}
