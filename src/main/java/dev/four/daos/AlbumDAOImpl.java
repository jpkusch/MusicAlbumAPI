package dev.four.daos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dev.four.entities.Album;

public class AlbumDAOImpl implements AlbumDAO{

	private static AlbumDAO adao = null;
	
	private AlbumDAOImpl() {
		
	}
	
	public static AlbumDAO getAlbumDAO() {
		if (adao == null)
			adao = new AlbumDAOImpl();
		return adao;
	}
	
	private Map<Integer, Album> album_table = new HashMap<Integer, Album>();
	
	private int counter = 1;
	
	public Album createAlbum(Album album) {
		album.setId(counter);
		this.album_table.put(counter, album);
		this.counter++;
		return album;
	}

	public Album getAlbumById(int id) {
		return this.album_table.get(id);
	}

	public List<Album> getAllAlbums() {
		List<Album> albums = new ArrayList<Album>(album_table.values());
		return albums;
	}

	public Album updateAlbum(Album album) {
		if(album_table.get(album.getId()) == null)
			return null;
		album_table.put(album.getId(), album);
		return album;
	}

	public boolean deleteAlbumById(int id) {
		Album album = album_table.remove(id);
		if(album != null)
			return true;
		else
			return false;
	}

}
