package test.restclient;


import junit.framework.TestCase;

import org.json.JSONException;
import org.json.JSONObject;


/**
 * @author Javier J. (javierj@us.es)
 *
 */
public class TestRestClient extends TestCase {


	public void testRestClient_GET() {
		MovieFactory movieFactory = new MovieFactory();
		
		RestClient client = new RestClient("http://www.omdbapi.com/");
		client.AddParam("t", "prometheus");
		  
		try {
			client.Execute(RestClient.RequestMethod.GET);
		} catch (Exception e) {
			e.printStackTrace();
		}
		  
		String response = client.getResponse();	
		
		Movie movie = null;
		try {
			movie = movieFactory.getMovie(response);
		} catch(Exception e) {
			fail("Exception when generating movie objet from JSon repsonse");
		}
		
		assertNotNull(movie);
		assertEquals("Prometheus", movie.title);
		assertEquals("2012", movie.year);
		assertEquals("Ridley Scott", movie.director);
	}
	
	
	
	static class MovieFactory  {
		
		public Movie getMovie(String json) throws JSONException {
			JSONObject jsonObject = new JSONObject(json);
			Movie movie = new Movie();
			movie.title = jsonObject.getString("Title");
			movie.year = jsonObject.getString("Year");
			movie.director = jsonObject.getString("Director");
			return movie;
		}
	}


	static class Movie {
		String title;
		String year;
		String director;
	}
		
}
