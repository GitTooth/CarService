package by.service.project.controllers;

import by.service.project.entities.Car;
import by.service.project.entities.Mark;
import by.service.project.repository.CarRepository;
import by.service.project.repository.MarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/CarService")
public class HomePage {
    @Autowired
    MarkRepository markRepository;

    @Autowired
    CarRepository carRepository;

    @InitBinder
    public final void initBinderUsuariosFormValidator(final WebDataBinder binder, final Locale locale) {
        final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", locale);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "")
    public String homePage(Model model){
        model.addAttribute("carList", carRepository.findAll());
        model.addAttribute("markList", markRepository.findAll().stream().map(Mark::getTitle).collect(Collectors.toList()));
        model.addAttribute("car", new Car());
        return "homePage";
    }

    @RequestMapping(value = "/update")
    public String create(@ModelAttribute("car") @Valid Car car, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errors", result);
            model.addAttribute("car", car);
            model.addAttribute("carList", carRepository.findAll());
            model.addAttribute("markList", markRepository.findAll().stream().map(Mark::getTitle).collect(Collectors.toList()));
            return "homePage";
        }
        car.setMark(markRepository.getByTitle(car.getMark().getTitle()).get(0));
        carRepository.save(car);
        return "redirect:/CarService";
    }

    @RequestMapping(value = "/{id}/delete")
    public String delete(@PathVariable ("id") int id){
        carRepository.delete(id);
        return "redirect:/CarService";
    }

}
