package edu.issi.machine.mvc.controller.fakes;

import edu.issi.machine.mvc.controller.Controller;
import edu.issi.machine.mvc.model.Model;

@SuppressWarnings("javadoc")
public class TestingController extends Controller {

    public TestingController(Model model) {
	super(model);
    }
    
    public int getNumViews() {
	return views.size();
    }

}
