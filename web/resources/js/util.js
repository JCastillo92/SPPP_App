
	//valida el numero de cedula recibe el input
	function validaCedula(cedula2) {
            
            var cedula = '' + cedula2;
            while (cedula.length < 10) {
                cedula = '0' + cedula;
            }

		var retorno = true;
		var v1 = 0,
		d1 = 0,
		d2 = 0,
		d3 = 0,
		d4 = 0,
		d5 = 0,
		d6 = 0,
		d7 = 0,
		d8 = 0,
		d9 = 0;
		var cv1 = 0,
		cd1 = 0,
		cd2 = 0,
		cd3 = 0,
		cd4 = 0,
		cd5 = 0,
		cd6 = 0,
		cd7 = 0,
		cd8 = 0,
		cd9 = 0;
		var w_acum = 0,
		w_sum = 0,
		w_verif;
		if (cedula.length != 10) {
			//window.alert("N�mero de c�dula es s�lo de 10 Digitos")
                        retorno = false;
                        if (retorno === false){
                            alert("CI Incorrecta!");
                            var s= document.getElementById("input_formWizardDB:cedulaId");
                            s.value = '';
                        }
		} else {

			v1 = parseInt(cedula.charAt(9), 10);
			d1 = parseInt(cedula.charAt(8), 10);
			d2 = parseInt(cedula.charAt(7), 10);
			d3 = parseInt(cedula.charAt(6), 10);
			d4 = parseInt(cedula.charAt(5), 10);
			d5 = parseInt(cedula.charAt(4), 10);
			d6 = parseInt(cedula.charAt(3), 10);
			d7 = parseInt(cedula.charAt(2), 10);
			d8 = parseInt(cedula.charAt(1), 10);
			d9 = parseInt(cedula.charAt(0), 10);

			cv1 = v1;
			cd1 = d1;
			cd2 = d2;
			cd3 = d3;
			cd4 = d4;
			cd5 = d5;
			cd6 = d6;
			cd7 = d7;
			cd8 = d8;
			cd9 = d9;

			w_sum = cd1 * 2;
			if (w_sum > 9) {
				w_sum -= 9;
			}
			w_acum = w_acum + w_sum;
			w_sum = cd2 * 1;
			w_acum = w_acum + w_sum;

			w_sum = cd3 * 2;
			if (w_sum > 9) {
				w_sum -= 9;
			}
			w_acum = w_acum + w_sum;
			w_sum = cd4 * 1;
			w_acum = w_acum + w_sum;

			w_sum = cd5 * 2;
			if (w_sum > 9) {
				w_sum -= 9;
			}
			w_acum = w_acum + w_sum;
			w_sum = cd6 * 1;
			w_acum = w_acum + w_sum;

			w_sum = cd7 * 2;
			if (w_sum > 9) {
				w_sum = w_sum - 9;
			}
			w_acum = w_acum + w_sum;
			w_sum = cd8 * 1;
			w_acum = w_acum + w_sum;

			w_sum = cd9 * 2;
			if (w_sum > 9) {
				w_sum = w_sum - 9;
			}
			w_acum = w_acum + w_sum;

			w_verif = 0;
			if (w_acum <= 10) {
				w_verif = 10 - w_acum;
			} else {
				if (w_acum <= 20) {
					w_verif = 20 - w_acum;
				} else {
					if (w_acum <= 30) {
						w_verif = 30 - w_acum;
					} else {
						if (w_acum <= 40) {
							w_verif = 40 - w_acum;
						} else {
							if (w_acum <= 50) {
								w_verif = 50 - w_acum;
							} else {
								if (w_acum <= 60) {
									w_verif = 60 - w_acum;
								} else {
									if (w_acum <= 70) {
										w_verif = 70 - w_acum;
									} else {
										if (w_acum <= 80) {
											w_verif = 80 - w_acum;
										} else {
											if (w_acum <= 90) {
												w_verif = 90 - w_acum;
											}
										}
									}
								}
							}
						}
					}
				}
			}
			if (w_verif == cv1) {
				retorno = true;
			} else {
				//window.alert("N�mero de c�dula es Incorrecto")

				retorno = false;
			}
		}
                if (retorno === false){
                            alert("CI Incorrecta!");
                            var s= document.getElementById("input_formWizardDB:cedulaId");
                            s.value = '';
                        }
		return retorno;
	}
	/* Funcion que valida los 13 digitos del RUC
	 * recibe el input
	 * */
	function validaRuc(identificacion2) {
            
            var identificacion = '' + identificacion2;
            while (identificacion.length < 13) {
                identificacion = '0' + identificacion;
            }
		var valorRetorno = true;
		if (identificacion.length != 13) {
			//alert("N�mero de RUC debe tener 13 Digitos")

			valorRetorno = false;
                        alert("RUC Incorrecto!");
                        var s= document.getElementById("input_formWizardDB:idEmp");
                        s.value = '';
		} else {
			var modulo11 = new Array(9);

			var verif = parseFloat("0");
			if (parseInt(identificacion.substring(0, 2), 10) < parseInt(1, 10) ||
				parseInt(identificacion.substring(0, 2), 10) > parseInt(22, 10)) {
				valorRetorno = false;
			} else
				if (parseInt(identificacion.substring(2, 3), 10) < parseInt(0, 10)
					 || (parseInt(identificacion.substring(2, 3), 10) > parseInt(6, 10)
						 && parseInt(identificacion.substring(2, 3), 10) != parseInt(9, 10))) {
					valorRetorno = false;
				} else {
					if (parseInt(identificacion.substring(2, 3), 10) == parseInt(9, 10)) {
						//sociedad privada o extranjeros
						if (identificacion.substring(10, 13) != "001")
							valorRetorno = false;
						else {
							modulo11[0] = 4;
							modulo11[1] = 3;
							modulo11[2] = 2;
							modulo11[3] = 7;
							modulo11[4] = 6;
							modulo11[5] = 5;
							modulo11[6] = 4;
							modulo11[7] = 3;
							modulo11[8] = 2;
							for (var i = 0; i < 9; i++) {
								verif = verif + (parseFloat(identificacion.substring(i, (i + 1))) * (parseFloat(modulo11[i])));
							}
							if (verif % 11 == 0)
								if (parseInt(identificacion.substring(9, 10), 10) == 0)
									valorRetorno = true;
								else
									valorRetorno = false;
							else
								if ((11 - (verif % 11)) == parseInt(identificacion.substring(9, 10), 10))
									valorRetorno = true;
								else
									valorRetorno = false;
						}
					} else
						if (parseInt(identificacion.substring(2, 3), 10) == 6) {
							//sociedad p�blicas
							if (identificacion.substring(10, 13) != "001")
								valorRetorno = false;
							else {
								modulo11[0] = 3;
								modulo11[1] = 2;
								modulo11[2] = 7;
								modulo11[3] = 6;
								modulo11[4] = 5;
								modulo11[5] = 4;
								modulo11[6] = 3;
								modulo11[7] = 2;
								for (var i = 0; i < 8; i++) {
									verif = verif + (parseFloat(identificacion.substring(i, (i + 1))) * (parseFloat(modulo11[i])));
								}
								if (verif % 11 == 0)
									if (parseInt(identificacion.substring(8, 9), 10) == 0)
										valorRetorno = true;
									else
										valorRetorno = false;
								else if ((11 - (verif % 11)) == parseInt(identificacion.substring(8, 9), 10))
									valorRetorno = true;
								else
									valorRetorno = false;
							}
						} else
							if (parseInt(identificacion.substring(2, 3), 10) < 6 &&
								parseInt(identificacion.substring(2, 3), 10) >= 0) {
								//personas naturales
								if (identificacion.substring(10, 13) != "001")
									valorRetorno = false;
								else {
									modulo11[0] = 2;
									modulo11[1] = 1;
									modulo11[2] = 2;
									modulo11[3] = 1;
									modulo11[4] = 2;
									modulo11[5] = 1;
									modulo11[6] = 2;
									modulo11[7] = 1;
									modulo11[8] = 2;
									for (var i = 0; i < 9; i++) {
										var temp = parseFloat(identificacion.substring(i, (i + 1))) * parseFloat((modulo11[i]));
										if (temp > 9)
											temp = temp - parseFloat("9");
										verif = verif + temp;
									}
									if (verif % 10 == 0)
										if (parseInt(identificacion.substring(9, 10), 10) == 0)
											valorRetorno = true;
										else
											valorRetorno = false;
									else
										if ((10 - (verif % 10)) == parseInt(identificacion.substring(9, 10), 10))
											valorRetorno = true;
										else
											valorRetorno = false;
								}
							}
				}
                        
                
                
                if (valorRetorno === false){
                    alert("RUC Incorrecto!");
                    var s= document.getElementById("input_formWizardDB:idEmp");
                    s.value = '';
                }
                return valorRetorno;
		}
	}
