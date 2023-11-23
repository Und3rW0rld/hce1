package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Paraclinico {
    private Long id;
    private Tipos tipo;
    private Estados estado;
    private Long id_paciente;
    private Long id_profesional_salud;
    private boolean valido;
    private String valor;
    private LocalDateTime fecha;
    private String interpretacion;
    //Asumimos que el paraclínico está creado (en otro módulo se crea)
    public Paraclinico(Long id, Paciente paciente, ProfesionalSalud profesionalSalud,  Tipos tipo) {
        this.id = id;
        this.id_paciente = paciente.getId();
        this.tipo = tipo;
        this.estado = Estados.CREADO;
        this.id_profesional_salud = profesionalSalud.getId();
        this.valido = true;
        this.fecha = LocalDateTime.now();

    }

    public void evaluarParaclinico(boolean validez){
        if (this.estado == Estados.CREADO){
            this.estado = Estados.EVALUADO;
            this.fecha = LocalDateTime.now();
            if(!validez){
                this.valido = validez;
            }
        }else{
            System.out.println("No puedes realizar esta operacion!");
        }
    }

    public void parametrizarParaclinico(String valor){
        if (this.valido && this.estado == Estados.EVALUADO){
            this.estado = Estados.PARAMETRIZADO;
            this.valor = valor;
            this.fecha = LocalDateTime.now();
        }else{
            System.out.println("No puedes realizar esta operacion!");
        }
    }

    public void paraclinicoInterpretado(String interpretacion){
        if (this.valido && this.estado == Estados.PARAMETRIZADO){
            this.estado = Estados.INTERPRETADO;
            this.fecha = LocalDateTime.now();
            this.interpretacion = interpretacion;
        } else{
            System.out.println("No puedes realizar esta operacion!");
        }
    }

    public static List<Paraclinico> listarParaclinicos(){
        ArrayList <Paraclinico> lista_paraclinicos = new ArrayList<>();
        return lista_paraclinicos;
    }

    public static List<Paraclinico> listarParaclinicosEstado(Estados estado){
        ArrayList <Paraclinico> lista_paraclinicos = new ArrayList<>();
        if(estado == Estados.CREADO){
            return listarParaclinicos();
        }else if(estado == Estados.EVALUADO){
            return lista_paraclinicos;
        }else if (estado == Estados.PARAMETRIZADO) {
            return lista_paraclinicos;
        }else if (estado == Estados.INTERPRETADO){
            return lista_paraclinicos;
        }
        return null;
    }
    public static List<Paraclinico> listarParaclinicoPaciente(Paciente paciente){
        ArrayList <Paraclinico> lista_paraclinicos = new ArrayList<>();
        return lista_paraclinicos;
    }

    public static List<Paraclinico> listarParaclinicoProfesionalSalud(ProfesionalSalud profesionalSalud){
        ArrayList <Paraclinico> lista_paraclinicos = new ArrayList<>();
        return lista_paraclinicos;
    }
}
