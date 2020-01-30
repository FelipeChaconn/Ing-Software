"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const express_1 = require("express");
const almacigoController_1 = __importDefault(require("../controllers/almacigoController"));
class AlmacigoRoutes {
    constructor() {
        this.router = express_1.Router();
        this.config();
    }
    config() {
        this.router.get('/', almacigoController_1.default.list);
        this.router.get('/:id', almacigoController_1.default.getOne);
        this.router.post('/', almacigoController_1.default.create);
        this.router.delete('/:id', almacigoController_1.default.delete);
        this.router.put('/:id', almacigoController_1.default.update);
    }
}
const almacigoRoutes = new AlmacigoRoutes();
exports.default = almacigoRoutes.router;
