package be.intecbrussel.service.implemantation;

import be.intecbrussel.data.Blog;
import be.intecbrussel.repository.BlogsRepository;
import be.intecbrussel.service.intefaces.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements BlogService {
    BlogsRepository blogsRepository;
@Autowired
    public BlogServiceImpl(BlogsRepository blogsRepository) {
        this.blogsRepository = blogsRepository;
    }

    @Override
    public List<Blog> getAllBlogs() {
    return blogsRepository.findAll();
    }

    @Override
    public Blog getBlogById(long id) {
        Blog blog =  blogsRepository.findById(id).get();
        return blog;
    }

    @Override
    public void createBlog(Blog blog) {
    blogsRepository.save(blog);

    }
}
