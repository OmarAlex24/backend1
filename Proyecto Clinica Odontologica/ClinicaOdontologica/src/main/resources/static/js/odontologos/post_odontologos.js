window.addEventListener('load',()=>{
    document.addEventListener('submit',(e)=>{
        e.preventDefault();

        const matriculaOdontologo = e.target.matricula.value;
        const nombreOdontologo = e.target.nombre.value;
        const apellidoOdontologo = e.target.apellido.value;

        if(matriculaOdontologo === "" || nombreOdontologo === "" || apellidoOdontologo === "" ){
            return;
        }

        const url = '/odontologos';
        const body= {
            "matricula": matriculaOdontologo,
            "nombre": nombreOdontologo,
            "apellido": apellidoOdontologo
        }
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(body)
        }


        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
                const pathListOdontologos = 'get_odontologos.html';
                window.location.href = '../' + pathListOdontologos;
                console.log(data, "Hola")
            })
    })
})