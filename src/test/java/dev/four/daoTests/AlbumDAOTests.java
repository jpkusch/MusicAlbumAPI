package dev.four.daoTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import dev.four.daos.AlbumDAO;
import dev.four.daos.AlbumDAOImpl;
import dev.four.entities.Album;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;

@TestMethodOrder(OrderAnnotation.class)
class AlbumDAOTests {

	private static AlbumDAO adao = AlbumDAOImpl.getAlbumDAO();
	
	@Test
	@Order(1)
	void createAlbum() {
		List<String> songs = new ArrayList<String>();
		songs.add("Song One");
		songs.add("Song Two");
		Album album = new Album(0, "Blue", "Blue Band", songs);
		adao.createAlbum(album);
		Assertions.assertNotEquals(0, album.getId());
	}

	@Test
	@Order(2)
	void getAlbumById() {
		Album album = adao.getAlbumById(1);
		Assertions.assertEquals(1, album.getId());
		Assertions.assertEquals("Blue", album.getTitle());
	}
	
	@Test
	@Order(3)
	void getAlbums() {
		List<String> songs = new ArrayList<String>();
		songs.add("Song Three");
		songs.add("Song Four");
		Album album = new Album(0, "Red", "Red Band", songs);
		adao.createAlbum(album);
		List<Album> albums = adao.getAllAlbums();
		Assertions.assertEquals(2, albums.size());
	}
	
	@Test
	@Order(4)
	void updateAlbum() {
		List<String> songs = new ArrayList<String>();
		songs.add("Song Five");
		songs.add("Song Six");
		Album album = new Album(1, "Green", "Green Band", songs);
		album = adao.updateAlbum(album);
		album = adao.getAlbumById(album.getId());
		Assertions.assertEquals("Green", album.getTitle());
	}
	
	@Test
	@Order(5)
	void deleteAlbum() {
		boolean result = adao.deleteAlbumById(1);
		Assertions.assertTrue(result);
	}
	
	@Test
	@Order(6)
	void updateInvalidAlbum() {
		List<String> songs = new ArrayList<String>();
		songs.add("Song Five");
		songs.add("Song Six");
		Album album = new Album(3, "Green", "Green Band", songs);
		album = adao.updateAlbum(album);
		Assertions.assertEquals(null, album);
	}
	
	@Test
	@Order(7)
	void deleteInvalidAlbum() {
		boolean result = adao.deleteAlbumById(5);
		Assertions.assertFalse(result);
	}
	
	@Test
	@Order(8)
	void getInvalidAlbum() {
		Album album = adao.getAlbumById(5);
		Assertions.assertEquals(null, album);
	}
}
