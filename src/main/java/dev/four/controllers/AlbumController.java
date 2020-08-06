package dev.four.controllers;

import java.util.List;

import com.google.gson.Gson;

import dev.four.daos.AlbumDAO;
import dev.four.daos.AlbumDAOImpl;
import dev.four.entities.Album;
import dev.four.services.AlbumService;
import dev.four.services.AlbumServiceImpl;
import io.javalin.http.Handler;

public class AlbumController {
	
	private static AlbumDAO adao = AlbumDAOImpl.getAlbumDAO();
	private static AlbumService aserv = new AlbumServiceImpl(adao);
	
	private static Gson gson = new Gson();
	

	public static Handler createAlbum = (ctx) -> {
		
		String albumJson = ctx.body();
		Album album = gson.fromJson(albumJson, Album.class);
		aserv.createAlbum(album);
		ctx.status(201);
		ctx.result(gson.toJson(album));

	};

	public static Handler getAlbumbyId = (ctx) -> {
		
		String id = ctx.pathParam("id");
		Album album = aserv.getAlbumById(Integer.parseInt(id));
		
		if(album == null) {
			ctx.status(404);
		}else {
			
			String json = gson.toJson(album);
			ctx.result(json);
		}
	};
	
	public static Handler getAllAlbums = (ctx) -> {
		
		List<Album> allalbums = aserv.getAllAlbums();
		String json = gson.toJson(allalbums);
		ctx.result(json);
	};
	
	public static Handler getAllAlbumsSorted = (ctx) -> {
		
		List<Album> allalbums = aserv.getAllAlbums();
		List<Album> sortedAlbums = aserv.sortAlbumsByTitle(allalbums);
		String json = gson.toJson(sortedAlbums);
		ctx.result(json);

	};
	
	public static Handler updateAlbum = (ctx) -> {
		
		String albumJson = ctx.body();
		Album album = gson.fromJson(albumJson, Album.class);
		aserv.updateAlbum(album);
		ctx.result(gson.toJson(album));
	};
	
	public static Handler deleteAlbum = (ctx) -> {
		
		String id = ctx.pathParam("id");
		Boolean result = aserv.deleteAlbumById(Integer.parseInt(id));
		ctx.result(result.toString());
	};

}
