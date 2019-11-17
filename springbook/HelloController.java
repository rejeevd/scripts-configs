package spingboot;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.concurrent.ForkJoinPool;

/**
 * Created with IntelliJ IDEA.
 * User: rejeev
 * Date: 2019-11-17
 */

@RestController
public class HelloController {
	@RequestMapping("/sync")
	public ResponseEntity<String> index(){
		return ResponseEntity.ok("Hello world!");
	}
	
	@RequestMapping("/async")
	public DeferredResult<ResponseEntity<String>> async(){
		DeferredResult<ResponseEntity<String>> output = new DeferredResult<>();
		ForkJoinPool.commonPool().submit(() -> {
			try {
				Thread.sleep(1000);
			}catch (Exception e){
				e.printStackTrace();
			}
			output.setResult(ResponseEntity.ok("Async Invocation!"));
		});
		return output;
	}
	
	@RequestMapping(value = "/book", method = RequestMethod.POST)
	public ResponseEntity<Book> createBook(
		@RequestBody Book book
	){
		return ResponseEntity.ok(book);
	}
	
	@RequestMapping(value = "/book/{bookName}", method = RequestMethod.GET)
	public ResponseEntity<Book> getBook(@PathVariable String bookName){
		Book book = new Book();
		book.setName(bookName);
		return ResponseEntity.ok(book);
	}
}
