package dao;

import java.util.List;

import entities.Album;

public interface AlbumDAO {

	// CRUD
	Album createAlbum(Album album);
	Album getAlbumById(int id);
	List<Album> getAllAlbums();
	Album updateAlbum(Album album);
	boolean deleteAlbumById(int id);

}