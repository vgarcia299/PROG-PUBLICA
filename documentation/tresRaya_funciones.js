
//variables globales

    var pieza= 'x';
    var vecesRecargada = localStorage.getItem('vecesRecargada'); 

    if (vecesRecargada == null) {
        vecesRecargada = 11;
    }
    // aseguramos fondo en 1º carga de pagina, pq valor x defecto es null
//



/**
 * esta funcion comprende todo lo que ocurre al colocar una pieza
 * @param {*} id columna y fila de la casilla donde queremos colocar la pieza (ej: 31)
 */
function turno(id)
{   
    placePiece(id);
    comprobarGanador();
    alternarPiezas();
}



/**
 * metodo con el que se colocan las piezas
 * @param {*} id columna y fila de la casilla donde queremos colocar la pieza (ej: 31)
 */
function placePiece(id) 
{
    const casilla = document.getElementById(id);

    if (!isEmpty(id)) {
        throw Error("la celda esta ocupada");
    }
    casilla.innerHTML = pieza;
    casilla.className = isCruz() ? "cruz" : "cara";
}



/**
 * cambia la pieza de circulo a cruz o viceversa
 */
function alternarPiezas() 
{
    pieza = isCruz() ? 'o' : 'x';
}



/**
 * @returns (pieza=='x')
 */
function isCruz() 
{
    return (pieza=='x');
}



/**
 * revisa las condiciones de ganar. 
 * de ser este el caso, se imprime un mensaje y un boton replay
 */
function comprobarGanador()
{
    if (checkVertical() | checkHorizontal() | checkDiagonal() | !hayLibres())
    {
        printWinner();
        disableButtons();
    }
}



/**
 * imprime el ganador de la partida, asi como un boton que permite recargar la pagina
 */
function printWinner()
{
    if (hayLibres()) 
    {
        document.getElementById("winnerMessage").innerHTML = ("ha ganado el jugador con pieza " + pieza);
    }
    document.getElementById("replay").style.visibility="visible";
}




/**
 * "desactiva" todos los botones excepto el de refrescar la pagina
 * 
 * @note length-1 tiene en cuenta que hay 10 botones en el codigo fuente, 
 *       cambiar este statement de añadirse mas
 */
function disableButtons()
{
    let botones = document.getElementsByTagName("button");

    for (let i=0; i<botones.length-1; i++)  // length-1 
    {
        botones[i].style.pointerEvents="none";
    }
}



/**
 * @param {*} id la columna y fila de la casilla a revisar
 * @returns true si solo tiene '·' dentro, false de lo contrario
 */
function isEmpty(id)
{
    return (document.getElementById(id).innerHTML == '·');
}



/**
 * comprueba si aun quedan casillas libres
 * @returns true si aun quedan casillas sin ocupar
 */
function hayLibres()
{
    let libres= document.querySelectorAll('button.unmarked');
    return !(libres.length == 0);
}



/**
 * comprueba todas las columnas
 * @returns true si tres en raya
 */
function checkVertical()
{
    for (let i=1; i<=3; i++) 
    {
        if (auxVertical(i)) 
        {
            return true;    // early return indica 3 en raya
        }
    }
}



/**
 * comprueba una unica columna
 * @param {*} col la posicion de la columna a revisar
 * @returns true si tres en raya
 */
function auxVertical(col) 
{
    let cell1 = document.getElementById(col + "1").innerHTML;
    let cell2 = document.getElementById(col + "2").innerHTML;
    let cell3 = document.getElementById(col + "3").innerHTML;

    return ( (cell1 != '·') && (cell1 == cell2) && (cell2 == cell3) );
}



/**
 * comprueba todas las filas
 * @returns true si tres en raya
 */
function checkHorizontal()
{
    for (let i=1; i<=3; i++) 
    {
        if (auxHorizontal(i)) 
        {
            return true;    // early return indica 3 en raya
        }
    }
}



/**
 * revisa una unica fila
 * @param {*} row la posicion de la fila a revisar
 * @returns true si tres en raya
 */
function auxHorizontal(row) 
{
    let cell1 = document.getElementById("1" + row).innerHTML;
    let cell2 = document.getElementById("2" + row).innerHTML;
    let cell3 = document.getElementById("3" + row).innerHTML;

    return ( (cell1 != '·')  &&  (cell1 == cell2)  &&  (cell2 == cell3) );
}



/**
 * revisa ambas diagonales
 * @returns true si tres en raya
 */
function checkDiagonal()
{
    return (
        auxDiagonal(1,3,3,1) ||	    // esquina sup derecha a inf izquierda 
        auxDiagonal(1,1,3,3)		// esquina sup izquierda a inf derecha
    );
}



/**
 * revisa una unica diagonal
 * @param {*} x1 la posicion en el eje x de la primera esquina
 * @param {*} y1 la posicion en el eje y de la primera esquina
 * @param {*} x2 la posicion en el eje x de la segunda esquina
 * @param {*} y2 la posicion en el eje y de la segunda esquina
 * @returns true si tres en raya
 */
function auxDiagonal(x1, y1, x2, y2)
{
    let cornerCell1 = document.getElementById(x1 + ""+ y1).innerHTML;
    let cornerCell2 = document.getElementById(x2 + ""+ y2).innerHTML;
    let centerCell  = document.getElementById(2  + "" + 2).innerHTML;

    return ( (centerCell != '·') && (cornerCell1 == centerCell) && (cornerCell2 == centerCell) );
}



/**
 * cambia la clase del elemento "body", esto afecta unicamente al css donde figura el fondo de pantalla
 * todos los fondos son 1920x1080
 * 
 * @nota si se ha cambiado el nº de fondos, ver comentario bajo if
 */
function setFondo()
{
    if (vecesRecargada >= 11) 
    {
        localStorage.clear();
    }
    // reseteamos contador de recargas si este supera el numero de fondos de pantalla disponibles,

    document.getElementById("body").className = ("fondo" + vecesRecargada);     
}



/**
 * esto sigue la cuenta del nº de veces que se ha recargado la pagina.
 * usaremos este numero para determinar que fondo de pantalla le toca al usuario.
 */
function contarRecargas()
{
    window.addEventListener
    (
        "unload", function()
        {
            let contador = parseInt(localStorage.getItem('vecesRecargada') || 0);
        
            localStorage.setItem('vecesRecargada', ++contador)
        }, 
        false
    );       
}