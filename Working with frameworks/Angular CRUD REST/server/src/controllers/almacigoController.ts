import {Request, Response} from 'express';
import pool from '../database';

class AlmacigoController{
//Async es para que siva await y es para decirle al buscador que dura tiempo y tiene que esperar
    public async list(req:Request,res:Response){
        await pool.query('SELECT * FROM almacigo', function(err, result, fields) {
            if (err) throw err;
            res.json(result);
        });
    }
    public async getOne(req:Request,res:Response):Promise<void>{
        const {id} = req.params;
        await pool.query('SELECT * FROM almacigo WHERE id = ?',[id], function(err, result, fields) {
            
            console.log(result);
            res.json({message:'almacigo founded'});
        });
    }
    public async create(req:Request ,res:Response): Promise<void> {
        await pool.query('INSERT INTO almacigo set ?',[req.body])
        //Show in console the data send
        //console.log(req.body);
        res.json({message:'Added Almacigo'});
    }
    public async delete(req:Request ,res:Response){
        const {id} = req.params;
        await pool.query('DELETE FROM almacigo WHERE id = ?',[id], function(err, result, fields) {
            
            console.log(result);
            res.json({message:'almacigo deleted'});
        });
    }
    public  async update(req:Request ,res:Response){
        const {id} = req.params;
        await pool.query('Update  almacigo set ? WHERE id = ?',[req.body,id], function(err, result, fields) {
            
            console.log(result);
            res.json({message:'almacigo updated'});
        });
    }
}

const  almacigoController = new AlmacigoController();
export default almacigoController;