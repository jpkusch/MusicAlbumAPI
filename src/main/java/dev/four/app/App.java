package dev.four.app;

import dev.four.controllers.AlbumController;
import io.javalin.Javalin;

public class App {
	
	public static void main(String[] args) {
		
		Javalin app = Javalin.create().start(7000);
		
		app.post("/albums", AlbumController.createAlbum); // create album
		
		app.get("/albums", AlbumController.getAllAlbums); // get all albums
		
		app.get("/albumssorted", AlbumController.getAllAlbumsSorted); // get all albums sorted
		
		app.get("/albums/:id", AlbumController.getAlbumbyId); // get album by id
		
		app.put("/albums/:id", AlbumController.updateAlbum); // to update album
		
		app.delete("/albums/:id", AlbumController.deleteAlbum); // to delete album
	}

}
