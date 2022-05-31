package be.intecbrussel.services.implementations;

import be.intecbrussel.data.Blog;
import be.intecbrussel.services.interfaces.BlogSpotService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogSpotServiceImpl implements BlogSpotService {

    @Override
    public List<Blog> getAllBlogSpots() {
        return null;
    }

    @Override
    public Blog getBlogSpotById() {
        return null;
    }

    @Override
    public void deleteBlogById() {

    }
}
