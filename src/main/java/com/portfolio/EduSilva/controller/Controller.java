package com.portfolio.EduSilva.controller;

import com.portfolio.EduSilva.dto.PortfolioDto;
import com.portfolio.EduSilva.model.Educacion;
import com.portfolio.EduSilva.model.Experiencia;
import com.portfolio.EduSilva.model.Imagen;
import com.portfolio.EduSilva.model.ImagenProyecto;
import com.portfolio.EduSilva.model.Persona;
import com.portfolio.EduSilva.model.Proyecto;
import com.portfolio.EduSilva.model.Skill;
import com.portfolio.EduSilva.model.foto;
import com.portfolio.EduSilva.service.CloudinaryService.CloudinaryService;
import com.portfolio.EduSilva.service.FotoService;
import com.portfolio.EduSilva.service.IEducacionService;
import com.portfolio.EduSilva.service.IExperienciaService;
import com.portfolio.EduSilva.service.IPersonaService;
import com.portfolio.EduSilva.service.IProyectoService;
import com.portfolio.EduSilva.service.ISkillService;
import com.portfolio.EduSilva.service.ImagenProyectoService;
import com.portfolio.EduSilva.service.ImagenService;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


//@CrossOrigin(origins = "https://porfolioeduardojsilva.web.app")//@CrossOrigin(origins = "http://localhost:4200")

@RestController
@CrossOrigin(origins = "https://porfolioeduardojsilva.web.app")
public class Controller {

    @Autowired
    private IPersonaService persoServ;
    
    @Autowired
    PortfolioDto dtoServ;

    @Autowired
    private IEducacionService eduServ;

    @Autowired
    private IExperienciaService expServ;

    @Autowired
    private ISkillService skillServ;

    @Autowired
    private IProyectoService proyecServ;

    @Autowired
    CloudinaryService cloudinaryService;

    @Autowired
    ImagenService imagenService;

    @Autowired
    FotoService fotoService;

    @Autowired
    ImagenProyectoService imagenProyectoService;

    //HEADER DEL PORFOLIO
    //GET de TODOS los datos de la persona 
    @GetMapping("/ver/personas")
    @ResponseBody
    public List<Persona> verPersonas() {
        return persoServ.verPersonas();
    }

    //POST de la persona
    @PostMapping("/new/persona")
    public void agregarPersona(@RequestBody Persona pers) {
        persoServ.crearPersona(pers);
    }

        
    //PUT/PATCH
    //modifica parcialmente los datos de la persona mediante el metodo PATCH
    @PatchMapping("/modificar/persona")
    public void modficiarPersona(@RequestBody Persona pers) {
        //traigo los datos de la persona
        Persona per = persoServ.verPersonas().get(0);
        //como acercaDe es uno de los campos de la tabla principal de Persona, 
        //y el formulario para modificar los datos principales no solicita que cargue este campo al cliente,
        //le digo que tome lo cargado anteriormente en AcercaDE 
        pers.setAcercaDe(per.getAcercaDe());

        //le indico que modifique los datos de la persona que tiene el id Nro. 1  
        pers.setId(1);
        
        //Si los campos son nulos o estan en blanco, devuelve el valor almacenado previamente en la base de datos
        dtoServ.modificadorPersona(pers);
     
        //por ultimo mediante el metodo save() de JpaRepository, modifico a la persona en cuestión. 
        persoServ.modificarPersona(pers);
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public void borrarPersona(@PathVariable int id) {
        persoServ.borrarPersona(id);
    }

    //ImagenesPortada
    @GetMapping("/list/imagen")
    public ResponseEntity<List<Imagen>> list() {
        List<Imagen> list = imagenService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/upload/imagen")
    public ResponseEntity<?> upload(@RequestParam MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null) {
            return new ResponseEntity(("imagen no válida"), HttpStatus.BAD_REQUEST);
        }
        
        Map result = cloudinaryService.uploadPortada(multipartFile);
        Imagen imagen
                = new Imagen((String) result.get("original_filename"),
                        (String) result.get("url"),
                        (String) result.get("public_id"));
        imagenService.save(imagen);
        return new ResponseEntity(("imagen subida"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/imagen/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) throws IOException {
        if (!imagenService.exists(id)) {
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        }
        Imagen imagen = imagenService.getOne(id).get();
        Map result = cloudinaryService.delete(imagen.getImagenId());
        imagenService.delete(id);
        return new ResponseEntity("imagen eliminada", HttpStatus.OK);
    }

    //FotoPrincipal
    @GetMapping("/list/fotos")
    public ResponseEntity<List<foto>> listFotos() {
        List<foto> list = fotoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/upload/foto")
    public ResponseEntity<?> uploadFoto(@RequestParam MultipartFile multipartFile) throws IOException {
        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null) {
            return new ResponseEntity(("foto no válida"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.uploadFoto(multipartFile);
        foto foto
                = new foto((String) result.get("original_filename"),
                        (String) result.get("url"),
                        (String) result.get("public_id"));
        fotoService.save(foto);
        return new ResponseEntity(("foto subida"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/foto/{id}")
    public ResponseEntity<?> deleteFoto(@PathVariable("id") int id) throws IOException {
        if (!fotoService.exists(id)) {
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        }
        foto foto = fotoService.getOne(id).get();
        Map result = cloudinaryService.delete(foto.getImagenId());
        fotoService.delete(id);
        return new ResponseEntity("foto eliminada", HttpStatus.OK);
    }

//SECCIONES DEL PORFOLIO
    @PatchMapping("/modificar/acercade/{id}")
    public void modficiarAcercaDe(@PathVariable int id, @RequestBody Persona acercade) {
     dtoServ.modificadorAcercaDe(id, acercade);
        persoServ.modificarAcercaDe(acercade);

    }

    //Educacion
    @GetMapping("/ver/educaciones")
    @ResponseBody
    public List<Educacion> verEducaciones() {
        return eduServ.verEducacion();
    }

    @PostMapping("/new/educacion")
    public void agregarEducacion(@RequestBody Educacion persEdu) {
        
        if (persEdu.getEstado().equals("false")) {
            persEdu.setEstado("Incompleto");
        } else {
            persEdu.setEstado("Graduado");
        }
        eduServ.crearEducacion(persEdu);
    }

    @PatchMapping("/modificar/educacion/{id}")
    public void modificarEducacion(@PathVariable Long id, @RequestBody Educacion persEdu) {

        persEdu.setIdEducacion(id);

        if (persEdu.getEstado().equals("false")) {
            persEdu.setEstado("Incompleto");
        } else {
            persEdu.setEstado("Graduado");
        }

        dtoServ.modificadorEdu(id, persEdu);
  
        eduServ.crearEducacion(persEdu);
    }

    @DeleteMapping("/delete/educacion/{id}")
    public void borrarEducacion(@PathVariable Long id) {
        eduServ.borrarEducacion(id);
    }

    //Experiencia
    @GetMapping("/ver/experiencias")
    @ResponseBody
    public List<Experiencia> verExperiencias() {
        return expServ.verExperiencia();
    }

    @PostMapping("/new/experiencia")
    public void agregarExperiencia(@RequestBody Experiencia persExp) {
        expServ.crearExperiencia(persExp);
    }

    @PatchMapping("/modificar/experiencia/{id}")
    public void modificarExperiencia(@PathVariable Long id, @RequestBody Experiencia persExp) {
  
         dtoServ.modificadorExp(id, persExp);
        
        persExp.setIdExperiencia(id);
        expServ.crearExperiencia(persExp);
    }

    @DeleteMapping("/delete/experiencia/{id}")
    public void borrarExperiencia(@PathVariable Long id) {
        expServ.borrarExperiencia(id);
    }

    //Skill
    @GetMapping("/ver/skills")
    @ResponseBody
    public List<Skill> verSkills() {
        return skillServ.verSkill();
    }

    @PostMapping("/new/skill")
    public void agregarSkill(@RequestBody Skill persExp) {
        if (persExp.getTipoSkill().equals("1")) {
            persExp.setTipoSkill("soft");
        }
        if (persExp.getTipoSkill().equals("2")) {
            persExp.setTipoSkill("hard");
        }
        skillServ.crearSkill(persExp);
    }

    @PatchMapping("/modificar/skill/{id}")
    public void modificarSkill(@PathVariable Long id, @RequestBody Skill persExp) {
       
      dtoServ.modificadorSkill(id, persExp);

        persExp.setIdSkill(id);
        skillServ.crearSkill(persExp);
    }

    @DeleteMapping("/delete/skill/{id}")
    public void borrarSkill(@PathVariable Long id) {
        skillServ.borrarSkill(id);
    }

    //CRUD de Proyecto
    //GET
    //mediante el metodo GET trae una lista de todos los proyectos almacenados en la base de datos
    @GetMapping("/ver/proyectos")
    @ResponseBody
    public List<Proyecto> verProyectos() {
        return proyecServ.verProyecto();
    }

    //POST
    //Agregar un nuevo proyecto a la base de datos
    @PostMapping("/new/proyecto")
    public void agregarProyecto(@RequestBody Proyecto persProyec) {
        proyecServ.crearProyecto(persProyec);
    }

    //PUT/PATCH
    //Modificar Proyecto
    //Para modificar solamente uno o alguno de los campos utilizo el metodo Patch
    @PatchMapping("/modificar/proyecto/{id}")
    //Solicita al cliente que pase como variable el id del proyecto a modificar y que en el cuerpo envie meidante un Json,
    //los campos y sus modificaciones.
    public void modificarProyecto(@PathVariable Long id, @RequestBody Proyecto persProyec) {

       dtoServ.modificadorProyecto(id, persProyec);

        //seteo el id del proyecto suministrado por el cliente
        persProyec.setIdProyecto(id);

        //Como ultimo paso,
        //utilizo el metodo save() de la interface JpaRepository para modificar el proyecto,
        proyecServ.crearProyecto(persProyec);
    }

    //ImagenProyecto
    @GetMapping("/list/imagen-proyectos")
    public ResponseEntity<List<ImagenProyecto>> listImagenProyectos() {
        List<ImagenProyecto> list = imagenProyectoService.list();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/upload/imagen-proyecto/{id}")
    public ResponseEntity<?> uploadImagenProyecto(@PathVariable("id") int id, @RequestParam MultipartFile multipartFile) throws IOException {

        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null) {
            return new ResponseEntity(("imagen no válida"), HttpStatus.BAD_REQUEST);
        }
        Map result = cloudinaryService.uploadProyectoImagenes(multipartFile);
        ImagenProyecto imagenProyecto
                = new ImagenProyecto(
                        (String) result.get("original_filename"),
                        (String) result.get("url"),
                        (String) result.get("public_id")
                );

        List<Proyecto> proyectoList = verProyectos();

        int contador = 0;

        imagenProyecto.setProyecto(proyectoList.get((proyectoList.size() - 1)));
        contador++;

        imagenProyectoService.save(imagenProyecto);
        return new ResponseEntity(("imagen del proyecto subida"), HttpStatus.OK);
    }

    @PutMapping("/modificar/imagen-proyecto/{id}")
    public ResponseEntity<?> modificarImagenProyecto(@PathVariable Long id, @RequestParam MultipartFile multipartFile) throws IOException {

        long l = id;
        int i = (int) l;

        BufferedImage bi = ImageIO.read(multipartFile.getInputStream());
        if (bi == null) {
            return new ResponseEntity(("imagen no válida"), HttpStatus.BAD_REQUEST);
        }

        Map result = cloudinaryService.uploadProyectoImagenes(multipartFile);

        List<ImagenProyecto> imgList = imagenProyectoService.list();

        for (ImagenProyecto imagenProyecto1 : imgList) {

            if (imagenProyecto1.getProyecto().getIdProyecto() == i) {

                imagenProyecto1.setName((String) result.get("original_filename"));
                imagenProyecto1.setImagenUrl((String) result.get("url"));
                imagenProyecto1.setImagenId((String) result.get("public_id"));

                imagenProyectoService.save(imagenProyecto1);

            }
        }

        return new ResponseEntity(("imagen del proyecto modificada"), HttpStatus.OK);
    }

    @DeleteMapping("/delete/imagen-proyecto/{id}")
    public ResponseEntity<?> deleteImagenProyecto(@PathVariable("id") int id) throws IOException {
        if (!imagenProyectoService.exists(id)) {
            return new ResponseEntity("no existe", HttpStatus.NOT_FOUND);
        }
        ImagenProyecto imagenProyecto = imagenProyectoService.getOne(id).get();
        Map result = cloudinaryService.delete(imagenProyecto.getImagenId());
        imagenProyectoService.delete(id);
        return new ResponseEntity("Imagen Proyecto eliminada", HttpStatus.OK);
    }

    //DELETE
    //utilizo el metodo deleteById(id); de la interface JpaRepository para borrar el proyecto,
    @DeleteMapping("/delete/proyecto/{id}")
    public void borrarProyecto(@PathVariable Long id) {
        proyecServ.borrarProyecto(id);
    }
    
    @GetMapping("/time")
    @ResponseStatus(HttpStatus.OK)
    public String getCurrentTime() {
        return Instant.now().toString();
    }

}
