package dev.four.serviceTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.Mockito;

import dev.four.daos.AlbumDAO;
import dev.four.entities.Album;
import dev.four.services.AlbumService;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
class AlbumServiceTests {
	
	private AlbumService aserv = null;
	
	Album makeAlbum;
	Album fakeAlbum;
	Album updatedAlbum;
	Album badAlbum;
	List<Album> allAlbums;
	
	@BeforeAll
	void setUpMocks() {
		List<String> songs = new ArrayList<String>();
		songs.add("Come Together");
		songs.add("Something");
		songs.add("Maxwell's Silver Hammer");
		songs.add("Oh! Darling");
		songs.add("Octupus's Garden");
		songs.add("I Want You (She's So Heavy)");
		songs.add("Here Comes the Sun");
		songs.add("Because");
		songs.add("Medley");
		songs.add("Her Majesty");
		makeAlbum = new Album(0, "Abby Road", "The Beatles", songs);
		fakeAlbum = new Album(1, "Abby Road", "The Beatles", songs);
		updatedAlbum = new Album(1, "Abbey Road", "The Beatles", songs);
		badAlbum = new Album(70, "Arby's Road", "Somoe Poor Soul", songs);
		
		AlbumDAO adao = Mockito.mock(AlbumDAO.class);
		Mockito.when(adao.createAlbum(makeAlbum)).thenReturn(fakeAlbum);
		
		Mockito.when(adao.getAlbumById(1)).thenReturn(fakeAlbum);
		Mockito.when(adao.getAlbumById(70)).thenReturn(null);
		
		allAlbums = new ArrayList<Album>();
		allAlbums.add(fakeAlbum);
		Mockito.when(adao.getAllAlbums()).thenReturn(allAlbums);
		
		Mockito.when(adao.updateAlbum(updatedAlbum)).thenReturn(updatedAlbum);
		Mockito.when(adao.updateAlbum(badAlbum)).thenReturn(null);
		
		Mockito.when(adao.deleteAlbumById(1)).thenReturn(true);
		Mockito.when(adao.deleteAlbumById(70)).thenReturn(false);
	}
	
	@Test
	@Order(1)
	void create() {
		Album album = aserv.createAlbum(makeAlbum);
		Assertions.assertNotEquals(0, album.getId());
	}
	
	@Test
	@Order(2)
	void getById() {
		Album album = aserv.getAlbumById(1);
		Assertions.assertEquals(1, album.getId());
	}
	
	@Test
	@Order(3)
	void getByIdNegative() {
		Album album = aserv.getAlbumById(70);
		Assertions.assertNull(album);
	}
	
	@Test
	@Order(4)
	void getAllAlbums() {
		List<Album> albums = aserv.getAllAlbums();
		Assertions.assertEquals(allAlbums, albums);
	}
	
	@Test
	@Order(5)
	void updateAlbum() {
		Album album = aserv.updateAlbum(updatedAlbum);
		Assertions.assertEquals("Abbey Road", album.getTitle());
	}
	
	@Test
	@Order(6)
	void updateAlbumNegative() {
		Album album = aserv.updateAlbum(badAlbum);
		Assertions.assertNull(album);
	}
	
	@Test
	@Order(7)
	void deleteAlbum() {
		boolean retVal = aserv.deleteAlbumById(1);
		Assertions.assertTrue(retVal);
	}
	
	@Test
	@Order(8)
	void deleteAlbumNegative() {
		boolean retVal = aserv.deleteAlbumById(70);
		Assertions.assertFalse(retVal);
	}

}
