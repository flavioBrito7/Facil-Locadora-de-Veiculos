
$(document).ready(function () {

// *********************************************************************************
// Validação dos dados de cadastrado do aluguel                         *
// *********************************************************************************
    $("#formCadAluguel").validate({

        rules: {
            clienteEntity: {
                required: true,
                number: true
            },
            veiculoEntity: {
                required: true,
                number: true
            },
            dataInicio: {
                required: true
            },
            funcionarioEntity: {
                required: true,
                number: true
            }
        },
        messages: {
            clienteEntity: {
                required: "O nome do(a) cliente é obrigatório",
                number: "Necessário inserir o código correto"
            },
            veiculoEntity: {
                required: "O  modelo do veículo é obrigatório",
                number: "Necessário inserir o código correto"
            },
            dataInicio: {
                required: "A data de retirada do veículo é obrigatória"
            },
            funcionarioEntity: {
                required: "O nome do(a) funcionário(a) responsável é obrigatório",
                number: "Necessário inserir o código correto"
            }
        },
        submitHandler: function (form) {
            alert("Aluguel cadastrado com sucesso!");
            form.submit();
        }

    });

    // *******************************************************************************
    // Validação do encerramento do aluguel                                     *
    // *******************************************************************************
    $("#formEncerramentoAluguel").validate({

        rules: {
            dataFim: {
                required: true,
                dataAnterior: false
            }
        },

        messages: {
            categoriaEntity: {
                required: "A data de retorno do veículo é obrigatória",
                dataAnterior: "Data de retorno do veículo anterior à data da retirada! Verifique o lançamento."
            }
        },
        submitHandler: function (form) {
            alert("Aluguel encerrado com sucesso!");
            form.submit();
        }

    });
    
    // *********************************************************************************
    // Validação dos dados de cadastro do funcionário                        *
    // *********************************************************************************
    $("#formCadFunc").validate({

        rules: {
            nome: {
                required: true,
                maxlength: 155
            },
            cpf: {
                required: true,
                minlength: 14
            },
            identidade: {
                required: true,
                minlength: 15
            },
            contato: {
                required: true,
                minlength: 15
            },
            endereco: {
                required: true,
                maxlength: 255
            },
            cargo: {
                required: true,
                maxlength: 55
            }
        },

        messages: {
            nome: {
                required: "O nome do funcionário é obrigatório",
                maxlength: "Permitido somente 155 caracteres"
            },
            cpf: {
                required: "O  CPF do funcionário é obrigatório",
                minlength: "Complete os números do CPF"
            },
            identidade: {
                required: "O dados da identidade são obrigatórios",
                maxlength: "Permitido até 15 caracteres"
            },
            contato: {
                required: "O número de telefone é obrigatório",
                minlength: "Digite o número completo, com DDD"
            },
            endereco: {
                required: "O endereço é obrigatório",
                maxlength: "Máximo de 255 caracteres"
            },
            cargo: {
                required: "O cargo é obrigatório",
                maxlength: "Máximo de 55 caracteres"
            }
        },
        submitHandler: function (form) {
            alert("Funcionário(a) cadastrado(a) com sucesso!");
            form.submit();
        }

    }),
    
    // *********************************************************************************
    // Validação da atualização dos dados do funcionário cadastrado *
    // *********************************************************************************
    $("#formAtFunc").validate({

        rules: {
            nome: {
                required: true,
                maxlength: 155
            },
            cpf: {
                required: true,
                minlength: 14
            },
            identidade: {
                required: true,
                maxlength: 15
            },
            contato: {
                required: true,
                minlength: 15
            },
            endereco: {
                required: true,
                maxlength: 255
            },
            cargo: {
                required: true,
                maxlength: 55
            }
        },

        messages: {
            nome: {
                required: "O nome do funcionário é obrigatório",
                maxlength: "Permitido somente 155 caracteres"
            },
            cpf: {
                required: "O  CPF do funcionário é obrigatório",
                minliegth: "Complete os números do CPF"
            },
            identidade: {
                required: "O dados da identidade são obrigatórios",
                maxlength: "Permitido até 15 caracteres"
            },
            contato: {
                required: "O número de telefone é obrigatório",
                minlength: "Digite o número completo, com DDD"
            },
            endereco: {
                required: "O endereço é obrigatório",
                maxlength: "Máximo de 255 caracteres"
            },
            cargo: {
                required: "O cargo é obrigatório",
                maxlength: "Máximo de 55 caracteres"
            }
        },
        submitHandler: function (form) {
            alert("Dados do(a) funcionário(a) atualizados com sucesso!");
            form.submit();
        }

    }),
    
    // ********************************************************************************
    // Validação dos dados de cadastro do cliente                              *
    // ********************************************************************************
    $("#formCadCliente").validate({

        rules: {
            nome: {
                required: true,
                maxlength: 155
            },
            cpf: {
                required: true,
                minlength: 14
            },
            identidade: {
                required: true,
                maxlength: 15
            },
            contato: {
                required: true,
                minlength: 15
            },
            endereco: {
                required: true,
                maxlength: 255
            },
            cnh: {
                required: true,
                number: true,
                maxlength: 55
            },
            email: {
                required: true,
                email: true
            }
        },

        messages: {
            nome: {
                required: "O nome do cliente é obrigatório",
                maxlength: "Permitido somente 155 caracteres"
            },
            cpf: {
                required: "O  CPF do cliente é obrigatório",
                minlength: "Complete os números do CPF"
            },
            identidade: {
                required: "O dados da identidade são obrigatórios",
                maxlength: "Permitido até 15 caracteres"
            },
            contato: {
                required: "O número de telefone é obrigatório",
                minlength: "Digite o número completo, com DDD"
            },
            endereco: {
                required: "O endereço é obrigatório",
                maxlength: "Máximo de 255 caracteres"
            },
            cnh: {
                required: "O número da CNH é obrigatório",
                number: "Digite somente números",
                maxlength: "Máximo de 15 caracteres"
            },
            email: {
                required: "O endereço de e-mail é obrigatório",
                email: "Digite um endereço de e-mail válido"
            }
        },
        submitHandler: function (form) {
            alert("Cliente cadastrado(a) com sucesso!");
            form.submit();
        }

    }),
    
    // ********************************************************************************
    // Validação da atualização dos dados do cliente cadastrado       *
    // ********************************************************************************
    $("#formAtCliente").validate({

        rules: {
            nome: {
                required: true,
                maxlength: 155
            },
            cpf: {
                required: true,
                minlength: 14
            },
            identidade: {
                required: true,
                maxlength: 15
            },
            contato: {
                required: true,
                minlength: 15
            },
            endereco: {
                required: true,
                maxlength: 255
            },
            cnh: {
                required: true,
                number: true,
                maxlength: 55
            },
            email: {
                required: true,
                email: true
            }
        },

        messages: {
            nome: {
                required: "O nome do cliente é obrigatório",
                maxlength: "Permitido somente 155 caracteres"
            },
            cpf: {
                required: "O  CPF do cliente é obrigatório",
                minlength: "Complete os números do CPF"
            },
            identidade: {
                required: "O dados da identidade são obrigatórios",
                maxlength: "Permitido até 15 caracteres"
            },
            contato: {
                required: "O número de telefone é obrigatório",
                minlength: "Digite o número completo, com DDD"
            },
            endereco: {
                required: "O endereço é obrigatório",
                maxlength: "Máximo de 255 caracteres"
            },
            cnh: {
                required: "O número da CNH é obrigatório",
                number: "Digite somente números",
                maxlength: "Máximo de 15 caracteres"
            },
            email: {
                required: "O endereço de e-mail é obrigatório",
                email: "Digite um endereço de e-mail válido"
            }
        },
        submitHandler: function (form) {
            alert("Dados do(a) cliente atualizados com sucesso!");
            form.submit();
        }

    });
    
    // ********************************************************************************
    // Validação dos dados de cadastro de veículo                             *
    // ********************************************************************************
    $("#formCadVeiculo").validate({

        rules: {
            modelo: {
                required: true,
                maxlength: 55
            },
            montadora: {
                required: true,
                maxlength: 55
            },
            cor: {
                required: true,
                maxlength: 55
            },
            ano: {
                required: true,
                number: true,
                minlength: 4,
                maxlength: 4
            },
            versao: {
                required: true,
                maxlength: 55
            },
            categoriaEntity: {
                required: true,
                number: true,
                maxlength: 2
            }
        },

        messages: {
            modelo: {
                required: "O modelo do veículo é obrigatório",
                maxlength: "Permitido somente 55 caracteres"
            },
            montadora: {
                required: "O  nome da montadora é obrigatório",
                maxlength: "Permitido somente 55 caracateres",
            },
            cor: {
                required: "A cor do veículo é obrigatória",
                maxlength: "Permitido até 55 caracteres"
            },
            ano: {
                required: "O ano do modelo é obrigatório",
                number: "Digite somente números",
                minlength: "Digite o ano com 4 dígitos",
                maxlength: "Máximo de 4 dígitos"
            },
            versao: {
                required: "O endereço é obrigatório",
                maxlength: "Máximo de 55 caracteres"
            },
            categoriaEntity: {
                required: "A categoria do veículo é obrigatória",
                number: "A categoria do veículo é obrigatória",
                maxlength: "Máximo de 2 caracteres"
            }
        },
        submitHandler: function (form) {
            alert("Dados do veículo cadastrados com sucesso!");
            form.submit();
        }

    });
    
    // *******************************************************************************
    // Validação da atualização dos dados do veículo cadastrado     *
    // *******************************************************************************
    $("#formAtVeiculo").validate({

        rules: {
            modelo: {
                required: true,
                maxlength: 55
            },
            montadora: {
                required: true,
                maxlength: 55
            },
            cor: {
                required: true,
                maxlength: 55
            },
            ano: {
                required: true,
                number: true,
                minlength: 4,
                maxlength: 4
            },
            versao: {
                required: true,
                maxlength: 55
            },
            categoriaEntity: {
                required: true,
                maxlength: 55
            }
        },

        messages: {
            modelo: {
                required: "O modelo do veículo é obrigatório",
                maxlength: "Permitido somente 55 caracteres"
            },
            montadora: {
                required: "O  nome da montadora é obrigatório",
                maxlength: "Permitido somente 55 caracateres",
            },
            cor: {
                required: "A cor do veículo é obrigatória",
                maxlength: "Permitido até 55 caracteres"
            },
            ano: {
                required: "O ano do modelo é obrigatório",
                number: "Digite somente números",
                minlength: "Digite o ano com 4 dígitos",
                maxlength: "Máximo de 4 dígitos"
            },
            versao: {
                required: "O endereço é obrigatório",
                maxlength: "Máximo de 55 caracteres"
            },
            categoriaEntity: {
                required: "A categoria do veículo é obrigatória",
                maxlength: "Máximo de 55 caracteres"
            }
        },
        submitHandler: function (form) {
            alert("Dados do veículo alterados com sucesso!");
            form.submit();
        }

    });

    // *******************************************************************************
    // Validação dos dados do cadastrado da categoria                    *
    // *******************************************************************************
    $("#formCadCategoria").validate({

        rules: {
            descricao: {
                required: true,
                maxlength: 55
            },
            valor: {
                required: true,
                number: true,
                maxlength: 55
            }
        },

        messages: {
            descricao: {
                required: "A descrição da categoria é obrigatória",
                maxlength: "Permitido somente 55 caracteres"
            },
            valor: {
                required: "O  valor da diária para a categoria é obrigatório",
                number: "Digite o valor da diária para a categoria",
                maxlength: "Permitido somente até 6 caracateres"
            }
        },
        submitHandler: function (form) {
            alert("Dados do veículo alterados com sucesso!");
            form.submit();
        }

    });

    // ********************************************************************************
    // Validação da atualização dos dados da categoria do veículo    *
    // ******************************************************************************** 
    $("#formAtCategoria").validate({

        rules: {
            descricao: {
                required: true,
                maxlength: 55
            },
            valor: {
                required: true,
                number: true,
                maxlength: 6
            }
        },

        messages: {
            descricao: {
                required: "A descrição da categoria é obrigatória",
                maxlength: "Permitido somente 55 caracteres"
            },
            valor: {
                required: "O  valor da diária para a categoria é obrigatório",
                number: "Digite o valor da diária para a categoria",
                maxlength: "Permitido somente até 6 caracateres"
            }
        },
        submitHandler: function (form) {
            alert("Dados da categoria alterados com sucesso!");
            form.submit();
        }

    });

});

