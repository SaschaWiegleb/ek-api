package com.github.saschawiegleb.ek.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.net.URL;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Element;
import org.junit.Test;

public class QueryUtilTest implements DefaultConfiguration {

    @Test
    public void categoryTest() {
        Category category = defaultConfiguration.category(245).get();
        URL pageUrl = defaultConfiguration.pageUrl(category, 1).get();
        Map<Long, Element> listOfElements = QueryUtil.mapOfElements(pageUrl);
        assertThat(listOfElements).hasSize(27);
        List<Ad> listOfAds = QueryUtil.listOfAds(listOfElements);
        assertTrue(listOfAds.size() == 27);
    }

    @Test
    public void topPageTest() {
        Category category = defaultConfiguration.category(245).get();
        URL topPageUrl = defaultConfiguration.topPageUrl(category, 1).get();
        Map<Long, Element> listOfElements = QueryUtil.mapOfElements(topPageUrl);
        assertThat(listOfElements.size()).isBetween(1, 27);
        List<Ad> listOfAds = QueryUtil.listOfAds(listOfElements);
        assertTrue(listOfAds.size() > 0);
    }
}
