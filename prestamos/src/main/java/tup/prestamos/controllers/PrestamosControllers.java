package tup.prestamos.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



import tup.prestamos.models.Prestamos;
import tup.prestamos.repositories.PrestamosRepository;

@RestController

@RequestMapping("")
public class PrestamosControllers {

  @Autowired
  private PrestamosRepository PrestamosRepository; //corregir mayusculas


  @PostMapping("/add") 
  public String addNewPrestamos(@RequestParam Long id, @RequestParam Double monto){
  

   double cuota_03 =  (monto * 1.2) / 3 ; //Delcaramos estas Variables extra para hacer el calculo del interes sin necesidad de un metodo
   double cuota_06 = (monto * 1.25) / 6 ;
   double cuota_09 = (monto * 1.3) / 9 ;
   double cuota_12 = (monto * 1.4) / 12 ; //corregir numeros 03,06,09,12
   double cuota_18 = (monto * 1.5) / 18 ;

  
   Prestamos p = new Prestamos(); //cambiar n por p
    p.setId(id);
    p.setMonto(monto);
    p.setTres_cuotas(cuota_03);
    p.setSeis_cuotas(cuota_06);
    p.setNueve_cuotas(cuota_09);
    p.setDoce_cuotas(cuota_12);
    p.setDieciocho_cuotas(cuota_18);
    PrestamosRepository.save(p);
    return "Saved";


}
 



  @PostMapping("/delete/{id}") 
  public String deleteprestamoById(@PathVariable Long id) {
  
    PrestamosRepository.deleteById(id);
    return "Deleted";
  }


  @GetMapping("/{id}")
  public String findPrestamosById(@PathVariable Long id) { // se necesita que el ID sea un long, por mas de que en SQL sea un Int
   
    String resp = estilo(); // la vista fue creada en un metodo aparte para mayor comodidad
   
    if (PrestamosRepository.findById(id).isPresent()) { 
   
      Prestamos prestamo = PrestamosRepository.findById(id).get();
      
      resp +=
       "<tr>" 
      + "<td>" + prestamo.getId() + "</td>"
      + "<td>" + prestamo.getMonto() + "</td>"
      + "<td>" + prestamo.getTres_cuotas() + "</td>"
      + "<td>" + prestamo.getSeis_cuotas() + "</td>"
      + "<td>" + prestamo.getNueve_cuotas() + "</td>"
      + "<td>" + prestamo.getDoce_cuotas() + "</td>"
      + "<td>" + prestamo.getDieciocho_cuotas() + "</td>"
          + "</tr>";
    } else {
      resp += "<tr>"
          + "<td>" + "-" + "</td>"
          + "<td>" + "-" + "</td>"
          + "<td>" + "-" + "</td>"
          + "</tr>";

    }
    return resp + "</table>";
  }

  @GetMapping("/all")
  public String getAllPrestamos() {

    Iterable<Prestamos> iterable = PrestamosRepository.findAll();


            String resp = estilo();
    
        for (Prestamos prestamo : iterable) {

          
          resp += 
           "<tr>" 
          + "<td>" + prestamo.getId() + "</td>"
          + "<td>" + prestamo.getMonto() + "</td>"
          + "<td>" + prestamo.getTres_cuotas() + "</td>"
          + "<td>" + prestamo.getSeis_cuotas() + "</td>"
          + "<td>" + prestamo.getNueve_cuotas() + "</td>"
          + "<td>" + prestamo.getDoce_cuotas() + "</td>"
          + "<td>" + prestamo.getDieciocho_cuotas() + "</td>"
          + "</tr>";
        }
        return resp + "</table>"; 
                    
      }
    
      @GetMapping("")
      public String lobby() {
        return "Conexion establecida, ingrese una URL para continuar"; //Falta agregar una pagina de bienvenida o un lobby
      }
    
    

    
     

    private String estilo() { //lo aregamos dentro de un metodo porque no podemos importar un archivo externo todavia
    
      return """   
     <title> E.C.M.A </title>
      <div id='navbar'>
      <a href='#ecma'><b>E.C.M.A</b></a>
    </div>
      <Style>
          #prestamos {
            font-family: Arial, Helvetica, sans-serif;
            border-collapse: collapse; 
            width: 100%;
          }
          #prestamos td, #prestamos th { 
            border: 1px solid #ddd; 
          padding: 8px; 
          text-align: center; 
         } 
          #prestamos tr:nth-child(even){background-color: #f2f2f2;} 
          #prestamos tr:hover {background-color: #ddd;} 
          #prestamos th { 
            padding-top: 12px; 
            padding-bottom: 12px;
            text-align: center; 
            background-color: #5093BC;
            color: white;}
         
           #navbar {
            overflow: hidden;
            background-color: #5093BC;
          }
          
          #navbar a {
            float: center;
            display: block;
            color: #f2f2f2;
            text-align: center;
            font-family: Arial, Helvetica, sans-serif;
            padding: 14px;
            text-decoration: none;
          }
          
          body {
            font-size: 16px;
          }
          body:after {
            content: 'E.C.M.A';  
            font-size: 15em;   
            color: rgba(52, 166, 214, 0.2); 
            z-index: 7777; 
           
            display: flex;
            align-items: center;
            justify-content: center;
            position: fixed;
            top: 0;
            right: 0;
            bottom: 0;
            left: 0;
              
            -webkit-pointer-events: none; 
            -moz-pointer-events: none; 
            -ms-pointer-events: none; 
            -o-pointer-events: none; 
            pointer-events: none; 
          
            -webkit-user-select: none; 
            -moz-user-select: none; 
            -ms-user-select: none; 
            -o-user-select: none; 
            user-select: none; 
          } 
          
         
          .content {
            padding: 16px;
          }
          
          .sticky {
            position: fixed;
           top: 0;
           width: 100%;
          }
          
          .sticky  .content { 
            padding-top: 60px; 
          }
          </style>       
          <table id='prestamos'>
              <tr> 
                <th>Id</th>  
                <th>Monto</th> 
                <th>Tres Cuotas</th> 
                <th>Seis Cuotas</th> 
                <th>Nueve Cuotas</th> 
                <th>Doce Cuotas</th> 
                <th>Dieciocho Cuotas</th> 
              </tr>;""";
          
    }
  
  }

