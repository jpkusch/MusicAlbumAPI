package dev.four.daos;

import java.util.List;

import dev.four.entities.Album;

public interface AlbumDAO {
	
	// CRUD
	Album createAlbum(Album album);
	Album getAlbumById(Album album);
	List<Album> getAllAlbums();
	Album updateAlbum(Album album);
	boolean deleteAlbumById(int id);

}
