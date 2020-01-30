import { Router} from 'express';
import almacigoController from '../controllers/almacigoController'
class AlmacigoRoutes{
     public router : Router = Router();

     constructor(){
        this.config();
     }
     config(): void{
         this.router.get('/',almacigoController.list);
         this.router.get('/:id',almacigoController.getOne);
         this.router.post('/',almacigoController.create);
         this.router.delete('/:id',almacigoController.delete);
         this.router.put('/:id',almacigoController.update);
     }
}
const almacigoRoutes = new AlmacigoRoutes();
export default almacigoRoutes.router; 