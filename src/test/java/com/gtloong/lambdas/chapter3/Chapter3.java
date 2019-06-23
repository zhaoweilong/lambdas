package com.gtloong.lambdas.chapter3;

import com.gtloong.lambdas.chapter1.Album;
import com.gtloong.lambdas.chapter1.Artist;
import com.gtloong.lambdas.chapter1.SampleData;
import com.gtloong.lambdas.chapter1.Track;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.gtloong.lambdas.chapter1.SampleData.membersOfTheBeatles;

public class Chapter3 {


    List<Artist> allArtitsts  = membersOfTheBeatles;
    List<Album>  list = SampleData.albumList;
    @Test
    public void test32(){
        long count = allArtitsts.stream().filter(artist -> artist.isFrom("London")).count();

        System.out.println(count);
    }
    @Test
    public void test331(){
        List<String> collected = Stream.of("a","b","c").collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("a","b","c1"),collected);

    }

    @Test
    public void test39(){

        List<String> collected = Stream.of("a","b").map(list -> list.toUpperCase()).collect(Collectors.toList());
        Assert.assertEquals(Arrays.asList("A","B"),collected);

    }
    @Test
    public void test31(){
        List<String> beginningWithNumbers = Stream.of("a","b","ab1").filter(value -> value.startsWith("a")).collect(Collectors.toList());
        System.out.println(beginningWithNumbers);
    }
    @Test
    public void test312(){
        List<Integer> together = Stream.of(Arrays.asList(1,2),Arrays.asList(3,4)).flatMap(number->{
                    System.out.println(number);
                    return number.stream();
                }

               ).collect(Collectors.toList());
        System.out.println(together);


    }
    @Test
    public  void test313(){
        List<Track>  tracks = Arrays.asList(new Track("a",1),new Track("b",2),new Track("a",3));
        Track shortest = tracks.stream().min(Comparator.comparing(track -> track.getLength())).get();
        System.out.println(shortest.getName());

    }
    @Test
    public void test316(){
        int count = Stream.of(1,2,3).reduce(3,(acc,element)->acc + element);
        System.out.println(count);
    }
    @Test
    public void test319(){
        Set<String> trackNames = new HashSet<>();
        for(Album album:list){
            for (Track track:album.getTrackList()){
                if (track.getLength() > 60){
                    trackNames.add(track.getName());
                }
            }
        }
        System.out.println(trackNames);
    }
    @Test
    public void test320(){
        Set<String> trackNames = list.stream().flatMap(album -> album.getTracks()).filter(track -> track.getLength() > 60).map(track -> track.getName()).collect(Collectors.toSet());

        System.out.println(trackNames);
    }
    @Test
    public void test391a(){
        Stream<Integer> numbers = Stream.of(1,2,3,4);
        Integer sum = numbers.reduce(0,(a,b)->a+b);
        System.out.println(sum);

    }
    @Test
    public  void  test3191b(){
        List result = allArtitsts.stream().flatMap(artist -> Stream.of(artist.getName(),artist.getNationality())).collect(Collectors.toList());
        System.out.println(result);
    }
    @Test
    public  void  test3191c(){
        List result =list.stream().filter(album -> album.getTracks().count() <=3).collect(Collectors.toList());
        System.out.println(result);
    }
    @Test
    public void test3192(){
       int result= allArtitsts.stream().map(artist -> artist.getMembers().count()).reduce(0L,(aac,x)-> aac + x).intValue();
        System.out.println(result);
    }
    @Test
    public void test396(){

        String strs = "hjkdKJL";
        long result =strs.chars().filter(value -> value > 'a' && value < 'z').count();
        System.out.println(result);
    }
    public void test397(){

    }

}
