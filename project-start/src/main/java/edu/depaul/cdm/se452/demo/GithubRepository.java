package edu.depaul.cdm.se452.demo;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * TestRepo
 */
public interface GithubRepository extends PagingAndSortingRepository<GithubProject, Long> {
    GithubProject findByRepoName(String repoName);    
}