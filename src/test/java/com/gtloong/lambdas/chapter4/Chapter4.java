package com.gtloong.lambdas.chapter4;

import com.gtloong.lambdas.chapter1.Album;
import com.gtloong.lambdas.chapter1.Artist;
import com.gtloong.lambdas.chapter1.SampleData;
import org.junit.Test;

import java.util.IntSummaryStatistics;
import java.util.List;

import static com.gtloong.lambdas.chapter1.SampleData.aLoveSupreme;
import static com.gtloong.lambdas.chapter1.SampleData.membersOfTheBeatles;

public class Chapter4 {
    List<Artist> allArtitsts  = membersOfTheBeatles;
    List<Album>  list = SampleData.albumList;
    Album album = aLoveSupreme;
    @Test
    public void test44(){
        IntSummaryStatistics tracklengthStats = album.getTracks().mapToInt(track->track.getLength()).summaryStatistics();
        System.out.println(tracklengthStats.getMax());

    }
}
