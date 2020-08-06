package services;

import java.util.List;

import entities.Album;

public interface AlbumService {
	
	Album createAlbum(Album album);
	Album getAlbumById(int id);
	List<Album> getAllAlbums();
	Album updateAlbum(Album album);
	boolean deleteAlbumById(int id);
	
	List<Album> sortAlbumsByTitle();

}
