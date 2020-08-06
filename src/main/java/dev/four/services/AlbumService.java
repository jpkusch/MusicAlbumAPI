package dev.four.services;

import java.util.List;

import dev.four.entities.Album;

public interface AlbumService {
	
	Album createAlbum(Album album);
	Album getAlbumById(Album album);
	List<Album> getAllAlbums();
	Album updateAlbum(Album album);
	boolean deleteAlbumById(int id);
	
	List<Album> sortAlbumsByTitle(List<Album> albums);

}
