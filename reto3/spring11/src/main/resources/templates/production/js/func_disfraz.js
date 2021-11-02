function consultar() {

    $.ajax (
               {
                        // url          : 'https://g3dfaaa3dcf4589-disfracesbd.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/costume/costume',
                        url          : 'http://localhost:8080/api/Costume/all',
                        type         : 'GET',
                        dataType     : 'json',
                        
                        success      :  function(response){
                            var misItems=response;

                                            
                                            for (i=0; i < misItems.length; i++){
                                                $("#idDivConsulta").append("<tr class='even pointer'>");
                                                // $("#idDivConsulta").append("<td class='a-center'>" + "<input type= 'checkbox' class='flat' name= 'table_records'>" + "</td>");
                                                $("#idDivConsulta").append("<td>" + misItems[i].id + "</td>");
                                                $("#idDivConsulta").append("<td>" + misItems[i].brand + "</td>");
                                                $("#idDivConsulta").append("<td>" + misItems[i].model + "</td>");
                                                $("#idDivConsulta").append("<td>" + misItems[i].category_id + "</td>");
                                                $("#idDivConsulta").append("<td>" + misItems[i].name + "</td>");
                                                $("#idDivConsulta").append("<td>" + misItems[i].descripcion + "</td>");
                                                $("#idDivConsulta").append('<td><button class="btn btn-info btn-sm" onclick="borrar('+misItems[i].id+'), location.reload()">Eliminar</button></td>');
                                                $("#idDivConsulta").append('<td><button class="btn btn-info btn-sm" onclick="obtenerItemEspecifico('+misItems[i].id+')">Ver detalles y editar</button></td>');
                                                $("#idDivConsulta").append("</tr>");
                                            }

                                         },
                        error        :   function(jqXHR, textStatus, errorThrown){
                                            
                                        }
               }

           );

}
function insertar() {
    var disfraz;

    valoresDisfraz = { id:$('#producto_id').val() , brand:$('#marca').val(), model:$('#modelo').val(), category_id:$('#categoria').val(), name:$('#nombre').val(), descripcion:$('#descripcion').val()};

    $.ajax (
        {

            dataType: 'json',
            // url          : 'https://g3dfaaa3dcf4589-disfracesbd.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/costume/costume',
            url          : 'http://localhost:8080/api/Costume/save',
            type         : 'POST',
            data         :  valoresDisfraz,

            success      :  function(response){
                               console.log(response);
                            },
            error       :   function(xhr,status){
                            console.log( xhr);

                            }


        }
    );



}
function borrar(idElemento){
    var data={
        id:idElemento
    }

    var datoAEliminar=JSON.stringify(data);  // dao a eliminar id
    console.log(datoAEliminar);

    $.ajax({
        dataType: 'Json',
        data:datoAEliminar,  // para el caso de DELETE
        //url:"https://g3dfaaa3dcf4589-disfracesbd.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/costume/costume",
        url  :  'http://localhost:8080/api/Costume/delete',
        type:'DELETE',
        contentType:'application/json',  // linea clave para el borrado, action unblock
        success:function(response) {
            console.log(response);
            
        },
        error: function(jqXHR, textStatus, errorThrown){ 
            
        }
    })
}

function actualizar() {

    datosDisfraz      = { id:$('#producto_id').val() , brand:$('#marca').val(), model:$('#modelo').val(), category_id:$('#categoria').val(), name:$('#nombre').val(), descripcion:$('#descripcion').val()};
    datosEnvio   = JSON.stringify(datosDisfraz);


    $.ajax (
                {

                    //url          : 'https://g3dfaaa3dcf4589-disfracesbd.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/costume/costume',
                    url          : 'http://localhost:8080/api/Costume/modificar',
                    type         : 'PUT',
                    data         :  datosEnvio,
                    contentType  : 'application/json',

                    success      :  function(response){
                                        console.log(response);
                                    },
                    error       :   function(xhr,status){
                                        console.log( xhr);

                                    }

                }
            );



}
function consultarId() {

    var codigo =$("#idCodigo").val();

    $.ajax (
                {

                    url          : 'https://g23bfb99f5036e6-bdpais.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/planeta/planeta/' + codigo ,
                    type         : 'GET',
                    dataType     : 'json',

                    success      :  function(json){
                                        $("#idDivConsulta").empty();
                                        for (i=0; i < json.items.length; i++){
                                            $("#idDivConsulta").append(json.items[i].codigo + json.items[i].nombre + " ");
                                        }
                                        console.log(json)
                                    },
                    error       :   function(xhr,status){
                                        console.log(xhr)
                                    },



                }
            );


}
function obtenerItemEspecifico(idItem){  // para mostrar los datos
    $.ajax({
        dataType: 'Json',
        url:'https://g3dfaaa3dcf4589-disfracesbd.adb.sa-santiago-1.oraclecloudapps.com/ords/admin/costume/costume/'+idItem,
        type:'GET', 

        success:function(response) {
        var item=response.items[0]; 
        $("#producto_id").val(item.id),
        $("#marca").val(item.brand),
        $("#modelo").val(item.model),
        $("#categoria").val(item.category_id)
        $("#nombre").val(item.name)
        $("#descripcion").val(item.descripcion)               
        },
        error: function(jqXHR, textStatus, errorThrown){ 
            
        }
    })
}