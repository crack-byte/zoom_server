package com.crackbyte.services;

import com.crackbyte.dto.ShowDetailsDTO;
import com.crackbyte.dto.ShowsDTO;

public interface TvShowsService {
    /**
     * @param searchKey
     * @param page
     * @return
     */
    ShowsDTO searchShows(String searchKey, int page);

    /**
     * @param page
     * @return
     */
    ShowsDTO mostPopularShows(int page);

    /**
     * @param searchKey
     * @return
     */
    ShowDetailsDTO searchShowDetails(String searchKey);
}
