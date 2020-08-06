package entities;

import java.util.List;

public class Album {

	private int id;
	private String title;
	private String artist;
	private List<String> songs;
	public Album() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Album(int id, String title, String artist, List<String> songs) {
		super();
		this.id = id;
		this.title = title;
		this.artist = artist;
		this.songs = songs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public List<String> getSongs() {
		return songs;
	}
	public void setSongs(List<String> songs) {
		this.songs = songs;
	}
	@Override
	public String toString() {
		return "Album [id=" + id + ", title=" + title + ", artist=" + artist + ", songs=" + songs + "]";
	}

	
}