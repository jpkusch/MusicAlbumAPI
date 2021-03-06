package dev.four.services;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import dev.four.daos.AlbumDAO;
import dev.four.entities.Album;

public class AlbumServiceImpl implements AlbumService{
	
	private AlbumDAO adao = null;
	
	public AlbumServiceImpl(AlbumDAO adao) {
		this.adao = adao;	
	}
	
	public Album createAlbum(Album album) {
		return adao.createAlbum(album);
	}
	
	public Album getAlbumById(int id) {
		return adao.getAlbumById(id);
	}
	
	public List<Album> getAllAlbums() {
		return adao.getAllAlbums();
	}
	
	public Album updateAlbum(Album album) {
		return adao.updateAlbum(album);
	}
	
	public boolean deleteAlbumById(int id) {
		return adao.deleteAlbumById(id);
	}

	@Override
	public List<Album> sortAlbumsByTitle(List<Album> albums) {
		Comparator<Album> sortAlbumsByTitle = (album1,album2)->{
			if(album1.getTitle().charAt(0) < album2.getTitle().charAt(0) ) {
				return -1;
			}
			if(album1.getTitle().charAt(0) > album2.getTitle().charAt(0)  ) {
				return 1;
			}
			return 0;
		};
		
		// callback function
		Collections.sort(albums, sortAlbumsByTitle);
		
		return albums;
	}
	
}



