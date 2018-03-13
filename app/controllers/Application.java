package controllers;


import com.google.inject.Inject;
import models.User;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;
import views.html.test;
import java.util.List;

import static play.libs.Scala.asScala;


public class Application extends Controller {
    private final Form<UserData> form;
    private final List<User> users;

    @Inject
    public Application(FormFactory formFactory) {
    this.form=formFactory.form(UserData.class);

        this.users = com.google.common.collect.Lists.newArrayList(
                new User("wangjialu", "123"),
                new User("akapandaroad", "4546")
        );

    }

    public  Result index() {

        return ok(index.render(" wangjialu"));
    }




  //  public  Result addPerson() {
//
//        FormFactory formFactory = null;
//        Form<Person> userForm = formFactory.form(Person.class);
//        Person person=userForm.bindFromRequest().get();
//        person.save();
//        return redirect(routes.Application.index());
   //     return ok(views.html.addperson.render(" "));

  //  }


    public Result form(){
        return ok(views.html.form.render(asScala(users), form));

    }
    public  Result postForm(){



        Form<UserData> userform = form.bindFromRequest();
        UserData result    = userform.get();
        users.add(new User(result.getName(),result.getPassword()));
        flash("info", "added!");
        return redirect(routes.Application.form());

    }

    public Result test(){

        System.out.println("------------");
        return ok(test.render("sucess index test"));

    }

    //public Result addPersons(){

       // List<Person> persons=new Model.Finder<>(String.class, Person.class);
       // return ok(toJson(persons));
    //}
}
