package com.travelassitant.microservice.usermanagementservice.DAOs;

import com.travelassitant.microservice.usermanagementservice.bean.Search;
import com.travelassitant.microservice.usermanagementservice.dbRepositories.RecentSearchRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecentSearchDao {

    @Autowired
    private RecentSearchRepository recentSearchRepository;

    public List<Search> getAllSearches() {
        return recentSearchRepository.findAll();
    }

    public Search getSearchById(String id) {
        return recentSearchRepository.findById(id).orElse(null);
    }

    public Search saveSearch(Search search) {
        return recentSearchRepository.save(search);
    }

    public void deleteSearch(String id) {
        recentSearchRepository.deleteById(id);
    }

    public List<String> getMostSearchedDestinations() {
        return recentSearchRepository.findTop3Destinations();
    }
}
