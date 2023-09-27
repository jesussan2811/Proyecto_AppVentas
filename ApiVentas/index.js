const express = require('express');
const mysql = require('mysql');
const Connection = require('mysql/lib/Connection');
const cors = require('cors')

const PORT = process.env.PORT || 4040;

const app = express();


app.use(express.json());
app.use(cors());

// MySQL
const conexion = mysql.createConnection({
  host: 'localhost',
  user: 'root',
  password: 'heroineX10',
  database: 'APPVENTAS'
});
// checar conexion
conexion.connect(error => {
  if (error) throw error;
  console.log('conexion ok')
});
//listen to port
app.listen(PORT, () =>
  console.log(`Server en el puerto ${PORT}`));

//RUTAS
app.get('/', (req, res) => {
    res.send('Hola, si funciono');
});

//GET usuarios
app.get('/allUsuarios', (req, res) => {
    const query = 'select * from USUARIOS;';
    
    conexion.query(query, (error, results) => {
        if (error) throw error;
        if (results.length > 0) {
            res.json(results);
        } else {
            res.send([]);
        }
    });
})
//GET clientes
app.get('/allClientes', (req, res) => {
    const query = 'select * from CLIENTES;';
    
    conexion.query(query, (error, results) => {
        if (error) throw error;
        if (results.length > 0) {
            res.json(results);
        } else {
            res.send([]);
        }
    });
})
//GET productos
app.get('/allProductos', (req, res) => {
    const query = 'select * from PRODUCTOS;';
    
    conexion.query(query, (error, results) => {
        if (error) throw error;
        if (results.length > 0) {
            res.json(results);
        } else {
            res.send([]);
        }
    });
})
//GET ventas
app.get('/allVentas', (req, res) => {
    const query = 'select * from VENTAS;';
    
    conexion.query(query, (error, results) => {
        if (error) throw error;
        if (results.length > 0) {
            res.json(results);
        } else {
            res.send([]);
        }
    });
})

//GET cliente con ID
app.get('/clientes/:id', (req, res) => {
    const { id } = req.params;
    const query = 
    `select * from CLIENTES where CLIID = ${id}`;

    conexion.query(query, (error, results) => {
        if (error) throw error;
        if (results.length > 0) {
            res.json(results);
        } else {
            res.send('Empty')
        }
    });
});

//GET producto con ID
app.get('/productos/:id', (req, res) => {
    const { id } = req.params;
    const query = 
    `select * from PRODUCTOS where CODIGO = ${id}`;

    conexion.query(query, (error, results) => {
        if (error) throw error;
        if (results.length > 0) {
            res.json(results);
        } else {
            res.send('Empty')
        }
    });
});


//Post usuario
app.post('/addUsuario', (req, res) => {
    const query = 'INSERT INTO USUARIOS SET ?';

    const usuarioObj = {
        USERNAME:req.body.USERNAME,
        USERPASSWORD:req.body.USERPASSWORD
    }
    conexion.query(query,usuarioObj,error => {
        if (error) throw error;
        
        res.send(usuarioObj);
      });
    
});
//Post cliente
app.post('/addCliente', (req, res) => {
    const query = 'INSERT INTO CLIENTES SET ?';

    const clienteObj = {
        CLINOMBRE:req.body.CLINOMBRE,
        APELLIDOS:req.body.APELLIDOS,
        CREDITO:req.body.CREDITO,
        TELEFONO:req.body.TELEFONO,
        DOMICILIO:req.body.DOMICILIO,
        FECHANACIMIENTO:req.body.FECHANACIMIENTO
    }
    conexion.query(query,clienteObj,error => {
        if (error) throw error;
        
        res.send(clienteObj);
      });
    
});
//Post producto
app.post('/addProducto', (req, res) => {
    const query = 'INSERT INTO PRODUCTOS SET ?';

    const productoObj = {
        PRODNOMBRE:req.body.PRODNOMBRE,
        DESCRIPCION:req.body.DESCRIPCION,
        MARCA:req.body.MARCA,
        CANTIDAD:req.body.CANTIDAD,
        PRECIO:req.body.PRECIO
    }
    conexion.query(query,productoObj,error => {
        if (error) throw error;
        
        res.send(productoObj);
      });
    
});
//Post venta
app.post('/addVenta', (req, res) => {
    const query = 'INSERT INTO VENTAS SET ?';

    const ventaObj = {
        CLIENTE:req.body.CLIENTE,
        PRODUCTOS:req.body.PRODUCTOS,
        IMPORTE:req.body.IMPORTE,
        FECHAVENTA:req.body.FECHAVENTA
    }
    conexion.query(query,ventaObj,error => {
        if (error) throw error;
        
        res.send(ventaObj);
      });
    
});

//UPDATE el credito de un cliente
app.put('/clientes/update/:id', (req, res) => {
    console.log("si entro");
    const { id } = req.params;
    const { credito } = req.body;
    console.log(credito);
    const query = `UPDATE CLIENTES set CREDITO = '${credito}' where CLIID = ${id}`;

    conexion.query(query,error => {
        if (error) throw error;
        res.send({mensaje:'Evaluado'});
    });
});

//UPDATE la cantidad de un producto
app.put('/productos/update/:id', (req, res) => {
    console.log("si entro");
    const { id } = req.params;
    const { cantidad } = req.body;
    console.log(cantidad);
    const query = `UPDATE PRODUCTOS set CANTIDAD = '${cantidad}' where CODIGO = ${id}`;

    conexion.query(query,error => {
        if (error) throw error;
        res.send({mensaje:'Evaluado'});
    });
});