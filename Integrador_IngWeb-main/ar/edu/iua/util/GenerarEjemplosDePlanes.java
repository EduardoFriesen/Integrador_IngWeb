package ar.edu.iua.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import ar.edu.iua.Excepciones.modeloEx.CrearPlanEx;
import ar.edu.iua.modelo.academico.plan.*;
import ar.edu.iua.negocio.academico.plan.CrearPlan;
import ar.edu.iua.negocio.academico.plan.CrearPlanImpl;
//import ar.edu.iua.negocio.academico.plan.CrearPlanes;
//import ar.edu.iua.negocio.academico.plan.CrearPlanesImpl;
import ar.edu.iua.persistencia.*;

public class GenerarEjemplosDePlanes {

    // Este metodo primero crea 2 planes, segun
    // https://monserrat.unc.edu.ar/secundario/plan-de-estudios/#1523542585948-acc3dfd8-8da3
    // y tambien crea de forma aleatoria una determinada cantidad de planes
    public static List<Plan> generar(int cantidadAGenerar, boolean imprimirResultado) throws CrearPlanEx {

        List<Plan> planes = new ArrayList<Plan>();

        Plan plan2018 = new PlanImpl();

        plan2018.setAnio(2018);
        plan2018.setEstadoActivo();

        planes.add(plan2018);

        // AÑOS DEL PLAN 2018

        AnioPlan primero = new AnioPlanImpl(plan2018, 1, "Primer año");
        AnioPlan segundo = new AnioPlanImpl(plan2018, 2, "Segundo año");
        AnioPlan tercero = new AnioPlanImpl(plan2018, 3, "Tercero año");
        AnioPlan cuarto = new AnioPlanImpl(plan2018, 4, "Cuarto año");
        AnioPlan quinto = new AnioPlanImpl(plan2018, 5, "Quinto año");

        plan2018.getAnios().add(primero);
        plan2018.getAnios().add(segundo);
        plan2018.getAnios().add(tercero);
        plan2018.getAnios().add(cuarto);
        plan2018.getAnios().add(quinto);

        // MATERIAS DEL PLAN 2018 - PRIMER AÑO

        int codigoMateria = 1;

        Materia m1 = new MateriaImpl(primero, codigoMateria++, "Ciencias de la Vida y de la Tierra ", 3.0);
        Materia m2 = new MateriaImpl(primero, codigoMateria++, "Lengua y Literatura Castellanas I", 5.0);
        Materia m3 = new MateriaImpl(primero, codigoMateria++, "Lengua y Cultura Latinas I ", 4.0);
        Materia m4 = new MateriaImpl(primero, codigoMateria++, "Lengua y Cultura Inglesas I ", 3.0);
        Materia m5 = new MateriaImpl(primero, codigoMateria++, "Formación Musical I ", 3.0);
        Materia m6 = new MateriaImpl(primero, codigoMateria++, "Formación Plástica I ", 3.0);
        Materia m7 = new MateriaImpl(primero, codigoMateria++, "Matemática I", 4.0);
        Materia m8 = new MateriaImpl(primero, codigoMateria++, "Geografía I ", 3.0);
        Materia m9 = new MateriaImpl(primero, codigoMateria++, "Historia I", 3.0);
        Materia m10 = new MateriaImpl(primero, codigoMateria++, "Formación Ética y Ciudadana I", 3.0);
        Materia m11 = new MateriaImpl(primero, codigoMateria++, "Estrategias de Aprendizaje y Entornos Virtuales",
                4.0);
        Materia m12 = new MateriaImpl(primero, codigoMateria++, "Educación Física y Deportes I", 1.0);

        primero.getMaterias().add(m1);
        primero.getMaterias().add(m2);
        primero.getMaterias().add(m3);
        primero.getMaterias().add(m4);
        primero.getMaterias().add(m5);
        primero.getMaterias().add(m6);
        primero.getMaterias().add(m7);
        primero.getMaterias().add(m8);
        primero.getMaterias().add(m9);
        primero.getMaterias().add(m10);
        primero.getMaterias().add(m11);
        primero.getMaterias().add(m12);

        // MATEIAS DEL PLAN 2018 - SEGUNDO AÑO

        codigoMateria = 1;

        segundo.getMaterias().add(new MateriaImpl(segundo, codigoMateria++, "Eduardo Friesen", 4.0));
        segundo.getMaterias()
                .add(new MateriaImpl(segundo, codigoMateria++, "Lengua y Literatura Castellanas II ", 5.0));
        segundo.getMaterias().add(new MateriaImpl(segundo, codigoMateria++, "Lengua y Cultura Latinas II ", 4.0));
        segundo.getMaterias().add(new MateriaImpl(segundo, codigoMateria++, "Lengua y Cultura Inglesas II  ", 3.0));
        segundo.getMaterias().add(new MateriaImpl(segundo, codigoMateria++, "Formación Musical II ", 3.0));
        segundo.getMaterias().add(new MateriaImpl(segundo, codigoMateria++, "Formación Plástica II ", 3.0));
        segundo.getMaterias().add(new MateriaImpl(segundo, codigoMateria++, "Matemática II ", 4.0));
        segundo.getMaterias().add(new MateriaImpl(segundo, codigoMateria++, "Geografía II ", 3.0));
        segundo.getMaterias().add(new MateriaImpl(segundo, codigoMateria++, "Historia II", 3.0));
        segundo.getMaterias().add(new MateriaImpl(segundo, codigoMateria++, "Formación Ética y Ciudadana II", 3.0));
        segundo.getMaterias().add(new MateriaImpl(segundo, codigoMateria++, "Educación Física y Deportes II", 3.0));
        segundo.getMaterias().add(new MateriaImpl(segundo, codigoMateria++, "Espacios Optativos 2019/2021", 3.0));
        segundo.getMaterias().add(new MateriaImpl(segundo, codigoMateria++, "Espacios Optativos 2022", 3.0));

        // MATERIAS DEL PLAN 2018 - TERCER AÑO
        tercero.getMaterias().add(new MateriaImpl(tercero, codigoMateria++, "Ciencias Naturales", 3.0));
        tercero.getMaterias()
                .add(new MateriaImpl(tercero, codigoMateria++, "Lengua y LIteratura Castellanas III", 5.0));
        tercero.getMaterias().add(new MateriaImpl(tercero, codigoMateria++, "Lengua y Culturas Latinas III", 4.0));
        tercero.getMaterias().add(new MateriaImpl(tercero, codigoMateria++, "Lengua y Culturas Inglesas III", 3.0));
        tercero.getMaterias().add(new MateriaImpl(tercero, codigoMateria++, "Formacion Plastica III", 3.0));
        tercero.getMaterias().add(new MateriaImpl(tercero, codigoMateria++, "Matematica III", 4.0));
        tercero.getMaterias().add(new MateriaImpl(tercero, codigoMateria++, "Geografia III", 3.0));
        tercero.getMaterias().add(new MateriaImpl(tercero, codigoMateria++, "Historia III", 3.0));
        tercero.getMaterias().add(new MateriaImpl(tercero, codigoMateria++, "Formacion Etica y Ciudadana III", 3.0));
        tercero.getMaterias().add(new MateriaImpl(tercero, codigoMateria++, "Educacion Tecnologica", 3.0));
        tercero.getMaterias().add(new MateriaImpl(tercero, codigoMateria++, "Educacion Fisica y Deportes III", 3.0));
        tercero.getMaterias().add(new MateriaImpl(tercero, codigoMateria++, "Espacios Optativos 2020/2021", 3.0));
        tercero.getMaterias().add(new MateriaImpl(tercero, codigoMateria++, "Espacios Optativos 2021", 3.0));
        tercero.getMaterias().add(new MateriaImpl(tercero, codigoMateria++, "Espacios Optativos 2022", 3.0));

        // MATERIAS DEL PLAN 2018 - CUARTO AÑO

        cuarto.getMaterias().add(new MateriaImpl(cuarto, codigoMateria++, "Biologia 1", 3.0));
        cuarto.getMaterias().add(new MateriaImpl(cuarto, codigoMateria++, "nombre", 1.0));
        cuarto.getMaterias().add(new MateriaImpl(cuarto, codigoMateria++, "nombre", 1.0));
        cuarto.getMaterias().add(new MateriaImpl(cuarto, codigoMateria++, "nombre", 1.0));
        cuarto.getMaterias().add(new MateriaImpl(cuarto, codigoMateria++, "nombre", 1.0));
        cuarto.getMaterias().add(new MateriaImpl(cuarto, codigoMateria++, "nombre", 1.0));
        cuarto.getMaterias().add(new MateriaImpl(cuarto, codigoMateria++, "nombre", 1.0));
        cuarto.getMaterias().add(new MateriaImpl(cuarto, codigoMateria++, "nombre", 1.0));
        cuarto.getMaterias().add(new MateriaImpl(cuarto, codigoMateria++, "nombre", 1.0));
        cuarto.getMaterias().add(new MateriaImpl(cuarto, codigoMateria++, "nombre", 1.0));
        cuarto.getMaterias().add(new MateriaImpl(cuarto, codigoMateria++, "nombre", 1.0));
        cuarto.getMaterias().add(new MateriaImpl(cuarto, codigoMateria++, "nombre", 1.0));
        cuarto.getMaterias().add(new MateriaImpl(cuarto, codigoMateria++, "nombre", 1.0));
        cuarto.getMaterias().add(new MateriaImpl(cuarto, codigoMateria++, "nombre", 1.0));

        // MATERIAS DE QUINTO AÑO

        quinto.getMaterias().add(new MateriaImpl(quinto, codigoMateria++, "nombre", 1.0));
        quinto.getMaterias().add(new MateriaImpl(quinto, codigoMateria++, "nombre", 1.0));
        quinto.getMaterias().add(new MateriaImpl(quinto, codigoMateria++, "nombre", 1.0));
        quinto.getMaterias().add(new MateriaImpl(quinto, codigoMateria++, "nombre", 1.0));
        quinto.getMaterias().add(new MateriaImpl(quinto, codigoMateria++, "nombre", 1.0));
        quinto.getMaterias().add(new MateriaImpl(quinto, codigoMateria++, "nombre", 1.0));
        quinto.getMaterias().add(new MateriaImpl(quinto, codigoMateria++, "nombre", 1.0));
        quinto.getMaterias().add(new MateriaImpl(quinto, codigoMateria++, "nombre", 1.0));
        quinto.getMaterias().add(new MateriaImpl(quinto, codigoMateria++, "nombre", 1.0));
        quinto.getMaterias().add(new MateriaImpl(quinto, codigoMateria++, "nombre", 1.0));
        quinto.getMaterias().add(new MateriaImpl(quinto, codigoMateria++, "nombre", 1.0));
        quinto.getMaterias().add(new MateriaImpl(quinto, codigoMateria++, "nombre", 1.0));

        // PLAN 2001

        Plan plan2001 = new PlanImpl();

        plan2001.setAnio(2001);
        plan2001.setEstadoNoActivo();

        planes.add(plan2001);

        // AÑOS DEL PLAN 2001

        AnioPlan primer = new AnioPlanImpl(plan2001, 1, "Primer año");
        AnioPlan segund = new AnioPlanImpl(plan2001, 2, "Segundo año");
        AnioPlan tercer = new AnioPlanImpl(plan2001, 3, "Tercero año");
        AnioPlan cuart = new AnioPlanImpl(plan2001, 4, "Cuarto año");
        AnioPlan quint = new AnioPlanImpl(plan2001, 5, "Quinto año");
        AnioPlan sexto = new AnioPlanImpl(plan2001, 5, "Sexto año");
        AnioPlan septimo = new AnioPlanImpl(plan2001, 5, "Septimo año");

        plan2001.getAnios().add(primero);
        plan2001.getAnios().add(segundo);
        plan2001.getAnios().add(tercero);
        plan2001.getAnios().add(cuarto);
        plan2001.getAnios().add(quinto);

        codigoMateria = 1;

        // MATERIAS DEL PLAN 2001 - PRIMER AÑO
        primer.getMaterias().add(new MateriaImpl(primer, codigoMateria++, "nombre", 0.0));
        primer.getMaterias().add(new MateriaImpl(primer, codigoMateria++, "nombre", 0.0));
        primer.getMaterias().add(new MateriaImpl(primer, codigoMateria++, "nombre", 0.0));
        primer.getMaterias().add(new MateriaImpl(primer, codigoMateria++, "nombre", 0.0));
        primer.getMaterias().add(new MateriaImpl(primer, codigoMateria++, "nombre", 0.0));
        primer.getMaterias().add(new MateriaImpl(primer, codigoMateria++, "nombre", 0.0));
        primer.getMaterias().add(new MateriaImpl(primer, codigoMateria++, "nombre", 0.0));
        primer.getMaterias().add(new MateriaImpl(primer, codigoMateria++, "nombre", 0.0));
        primer.getMaterias().add(new MateriaImpl(primer, codigoMateria++, "nombre", 0.0));
        primer.getMaterias().add(new MateriaImpl(primer, codigoMateria++, "nombre", 0.0));
        primer.getMaterias().add(new MateriaImpl(primer, codigoMateria++, "nombre", 0.0));
        primer.getMaterias().add(new MateriaImpl(primer, codigoMateria++, "nombre", 0.0));

        // MATERIAS DEL PLAN 2001 - SEGUNDO AÑO
        segund.getMaterias().add(new MateriaImpl(segund, codigoMateria++, "nombre", 0.0));
        segund.getMaterias().add(new MateriaImpl(segund, codigoMateria++, "nombre", 0.0));
        segund.getMaterias().add(new MateriaImpl(segund, codigoMateria++, "nombre", 0.0));
        segund.getMaterias().add(new MateriaImpl(segund, codigoMateria++, "nombre", 0.0));
        segund.getMaterias().add(new MateriaImpl(segund, codigoMateria++, "nombre", 0.0));
        segund.getMaterias().add(new MateriaImpl(segund, codigoMateria++, "nombre", 0.0));
        segund.getMaterias().add(new MateriaImpl(segund, codigoMateria++, "nombre", 0.0));
        segund.getMaterias().add(new MateriaImpl(segund, codigoMateria++, "nombre", 0.0));
        segund.getMaterias().add(new MateriaImpl(segund, codigoMateria++, "nombre", 0.0));
        segund.getMaterias().add(new MateriaImpl(segund, codigoMateria++, "nombre", 0.0));
        segund.getMaterias().add(new MateriaImpl(segund, codigoMateria++, "nombre", 0.0));
        segund.getMaterias().add(new MateriaImpl(segund, codigoMateria++, "nombre", 0.0));

        // MATERIAS DEL PLAN 2001 - TERCER AÑO
        tercer.getMaterias().add(new MateriaImpl(tercer, codigoMateria++, "nombre", 0.0));
        tercer.getMaterias().add(new MateriaImpl(tercer, codigoMateria++, "nombre", 0.0));
        tercer.getMaterias().add(new MateriaImpl(tercer, codigoMateria++, "nombre", 0.0));
        tercer.getMaterias().add(new MateriaImpl(tercer, codigoMateria++, "nombre", 0.0));
        tercer.getMaterias().add(new MateriaImpl(tercer, codigoMateria++, "nombre", 0.0));
        tercer.getMaterias().add(new MateriaImpl(tercer, codigoMateria++, "nombre", 0.0));
        tercer.getMaterias().add(new MateriaImpl(tercer, codigoMateria++, "nombre", 0.0));
        tercer.getMaterias().add(new MateriaImpl(tercer, codigoMateria++, "nombre", 0.0));
        tercer.getMaterias().add(new MateriaImpl(tercer, codigoMateria++, "nombre", 0.0));
        tercer.getMaterias().add(new MateriaImpl(tercer, codigoMateria++, "nombre", 0.0));
        tercer.getMaterias().add(new MateriaImpl(tercer, codigoMateria++, "nombre", 0.0));
        tercer.getMaterias().add(new MateriaImpl(tercer, codigoMateria++, "nombre", 0.0));

        // MATERIAS DEL PLAN 2001 - CUARTO AÑO
        cuart.getMaterias().add(new MateriaImpl(cuart, codigoMateria++, "nombre", 0.0));
        cuart.getMaterias().add(new MateriaImpl(cuart, codigoMateria++, "nombre", 0.0));
        cuart.getMaterias().add(new MateriaImpl(cuart, codigoMateria++, "nombre", 0.0));
        cuart.getMaterias().add(new MateriaImpl(cuart, codigoMateria++, "nombre", 0.0));
        cuart.getMaterias().add(new MateriaImpl(cuart, codigoMateria++, "nombre", 0.0));
        cuart.getMaterias().add(new MateriaImpl(cuart, codigoMateria++, "nombre", 0.0));
        cuart.getMaterias().add(new MateriaImpl(cuart, codigoMateria++, "nombre", 0.0));
        cuart.getMaterias().add(new MateriaImpl(cuart, codigoMateria++, "nombre", 0.0));
        cuart.getMaterias().add(new MateriaImpl(cuart, codigoMateria++, "nombre", 0.0));
        cuart.getMaterias().add(new MateriaImpl(cuart, codigoMateria++, "nombre", 0.0));
        cuart.getMaterias().add(new MateriaImpl(cuart, codigoMateria++, "nombre", 0.0));
        cuart.getMaterias().add(new MateriaImpl(cuart, codigoMateria++, "nombre", 0.0));

        // MATERIAS DEL PLAN 2001 - QUINTO AÑO
        quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, "nombre", 0.0));
        quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, "nombre", 0.0));
        quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, "nombre", 0.0));
        quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, "nombre", 0.0));
        quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, "nombre", 0.0));
        quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, "nombre", 0.0));
        quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, "nombre", 0.0));
        quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, "nombre", 0.0));
        quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, "nombre", 0.0));
        quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, "nombre", 0.0));
        quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, "nombre", 0.0));
        quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, "nombre", 0.0));
        quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, "nombre", 0.0));
        quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, "nombre", 0.0));
        quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, "nombre", 0.0));

        // MATERIAS DEL PLAN 2001 - SEXTO AÑO
        sexto.getMaterias().add(new MateriaImpl(sexto, codigoMateria++, "nombre", 0.0));
        sexto.getMaterias().add(new MateriaImpl(sexto, codigoMateria++, "nombre", 0.0));
        sexto.getMaterias().add(new MateriaImpl(sexto, codigoMateria++, "nombre", 0.0));
        sexto.getMaterias().add(new MateriaImpl(sexto, codigoMateria++, "nombre", 0.0));
        sexto.getMaterias().add(new MateriaImpl(sexto, codigoMateria++, "nombre", 0.0));
        sexto.getMaterias().add(new MateriaImpl(sexto, codigoMateria++, "nombre", 0.0));
        sexto.getMaterias().add(new MateriaImpl(sexto, codigoMateria++, "nombre", 0.0));
        sexto.getMaterias().add(new MateriaImpl(sexto, codigoMateria++, "nombre", 0.0));
        sexto.getMaterias().add(new MateriaImpl(sexto, codigoMateria++, "nombre", 0.0));
        sexto.getMaterias().add(new MateriaImpl(sexto, codigoMateria++, "nombre", 0.0));
        sexto.getMaterias().add(new MateriaImpl(sexto, codigoMateria++, "nombre", 0.0));
        sexto.getMaterias().add(new MateriaImpl(sexto, codigoMateria++, "nombre", 0.0));
        sexto.getMaterias().add(new MateriaImpl(sexto, codigoMateria++, "nombre", 0.0));
        sexto.getMaterias().add(new MateriaImpl(sexto, codigoMateria++, "nombre", 0.0));
        sexto.getMaterias().add(new MateriaImpl(sexto, codigoMateria++, "nombre", 0.0));

        // MATERIAS DEL PLAN 2001 - SEPTIMO AÑO
        septimo.getMaterias().add(new MateriaImpl(septimo, codigoMateria++, "nombre", 0.0));
        septimo.getMaterias().add(new MateriaImpl(septimo, codigoMateria++, "nombre", 0.0));
        septimo.getMaterias().add(new MateriaImpl(septimo, codigoMateria++, "nombre", 0.0));
        septimo.getMaterias().add(new MateriaImpl(septimo, codigoMateria++, "nombre", 0.0));
        septimo.getMaterias().add(new MateriaImpl(septimo, codigoMateria++, "nombre", 0.0));
        septimo.getMaterias().add(new MateriaImpl(septimo, codigoMateria++, "nombre", 0.0));
        septimo.getMaterias().add(new MateriaImpl(septimo, codigoMateria++, "nombre", 0.0));
        septimo.getMaterias().add(new MateriaImpl(septimo, codigoMateria++, "nombre", 0.0));
        septimo.getMaterias().add(new MateriaImpl(septimo, codigoMateria++, "nombre", 0.0));
        septimo.getMaterias().add(new MateriaImpl(septimo, codigoMateria++, "nombre", 0.0));
        septimo.getMaterias().add(new MateriaImpl(septimo, codigoMateria++, "nombre", 0.0));
        septimo.getMaterias().add(new MateriaImpl(septimo, codigoMateria++, "nombre", 0.0));
        septimo.getMaterias().add(new MateriaImpl(septimo, codigoMateria++, "nombre", 0.0));
        septimo.getMaterias().add(new MateriaImpl(septimo, codigoMateria++, "nombre", 0.0));
        septimo.getMaterias().add(new MateriaImpl(septimo, codigoMateria++, "nombre", 0.0));

        generarYAgregarPlanesAleatoriamente(cantidadAGenerar, planes);

        if (imprimirResultado) {
            imprimirPlanes(planes);
        }

        return planes;

    }

    private static void generarYAgregarPlanesAleatoriamente(int cantidadAGenerar, List<Plan> planes) throws CrearPlanEx {
        Random random = new Random(System.currentTimeMillis());
        CrearPlan crearPlan = new CrearPlanImpl();
        String materiasPrimerAño[] = { "Ciencias de la Vida y de la Tierra ", "Lengua y Literatura Castellanas I",
                "Lengua y Cultura Latinas I ", "Lengua y Cultura Inglesas I ", "Formación Musical I ",
                "Formación Plástica I ", "Matemática I", "Geografía I ", "Historia I", "Formación Ética y Ciudadana I",
                "Estrategias de Aprendizaje y Entornos Virtuales", "Educación Física y Deportes I", "Informatica"};
        String materiasSegundorAño[] = { "Ciencias de la Vida y de la Tierra ", "Lengua y Literatura Castellanas I",
                "Lengua y Cultura Latinas I ", "Lengua y Cultura Inglesas I ", "Formación Musical I ",
                "Formación Plástica I ", "Matemática I", "Geografía I ", "Historia I", "Formación Ética y Ciudadana I",
                "Estrategias de Aprendizaje y Entornos Virtuales", "Educación Física y Deportes I" };
        String materiasTercerAño[] = { "Ciencias de la Vida y de la Tierra ", "Lengua y Literatura Castellanas I",
                "Lengua y Cultura Latinas I ", "Lengua y Cultura Inglesas I ", "Formación Musical I ",
                "Formación Plástica I ", "Matemática I", "Geografía I ", "Historia I", "Formación Ética y Ciudadana I",
                "Estrategias de Aprendizaje y Entornos Virtuales", "Educación Física y Deportes I" };
        String materiasCuartoAño[] = { "Ciencias de la Vida y de la Tierra ", "Lengua y Literatura Castellanas I",
                "Lengua y Cultura Latinas I ", "Lengua y Cultura Inglesas I ", "Formación Musical I ",
                "Formación Plástica I ", "Matemática I", "Geografía I ", "Historia I", "Formación Ética y Ciudadana I",
                "Estrategias de Aprendizaje y Entornos Virtuales", "Educación Física y Deportes I" };
        String materiasQuintoAño[] = { "Ciencias de la Vida y de la Tierra ", "Lengua y Literatura Castellanas I",
                "Lengua y Cultura Latinas I ", "Lengua y Cultura Inglesas I ", "Formación Musical I ",
                "Formación Plástica I ", "Matemática I", "Geografía I ", "Historia I", "Formación Ética y Ciudadana I",
                "Estrategias de Aprendizaje y Entornos Virtuales", "Educación Física y Deportes I" };
        for (int i = 0; i < cantidadAGenerar; i++) {
            Plan planAleatorio = new PlanImpl();
            
            planAleatorio.setAnio(2019 + i);
            int val = random.nextInt(0 + 2) + 0;
            if(val == 0) planAleatorio.setEstadoActivo();
            if(val == 1) planAleatorio.setEstadoBorrador();
            if(val == 2) planAleatorio.setEstadoNoActivo();

            planes.add(planAleatorio);
            

            AnioPlan primer = new AnioPlanImpl(planAleatorio, 1, "Primer año");
            AnioPlan segund = new AnioPlanImpl(planAleatorio, 2, "Segundo año");
            AnioPlan tercer = new AnioPlanImpl(planAleatorio, 3, "Tercero año");
            AnioPlan cuart = new AnioPlanImpl(planAleatorio, 4, "Cuarto año");
            AnioPlan quint = new AnioPlanImpl(planAleatorio, 5, "Quinto año");

            planAleatorio.getAnios().add(primer);
            planAleatorio.getAnios().add(segund);
            planAleatorio.getAnios().add(tercer);
            planAleatorio.getAnios().add(cuart);
            planAleatorio.getAnios().add(quint);

            int codigoMateria = 1;

            for(int j=0;j<materiasPrimerAño.length;j++){
            val = random.nextInt(0 + materiasPrimerAño.length) + 0;
            Double cargaHoraria = random.nextDouble(0 + 5) + 0;
            primer.getMaterias().add(new MateriaImpl(primer, codigoMateria++, materiasPrimerAño[val], cargaHoraria));
            }

            codigoMateria = 1;
            for(int j=0;j<materiasSegundorAño.length;j++){
                val = random.nextInt(0 + materiasSegundorAño.length) + 0;
                Double cargaHoraria = random.nextDouble(0 + 5) + 0;
                segund.getMaterias().add(new MateriaImpl(segund, codigoMateria++, materiasSegundorAño[val], cargaHoraria));
                }
         
            codigoMateria = 1;
            for(int j=0;j<materiasTercerAño.length;j++){
                val = random.nextInt(0 + materiasTercerAño.length) + 0;
                Double cargaHoraria = random.nextDouble(0 + 5) + 0;
                tercer.getMaterias().add(new MateriaImpl(tercer, codigoMateria++, materiasTercerAño[val],cargaHoraria));
                }


            codigoMateria = 1;
            for(int j=0;j<materiasCuartoAño.length;j++){
                val = random.nextInt(0 + materiasCuartoAño.length) + 0;
                Double cargaHoraria = random.nextDouble(0 + 5) + 0;
                cuart.getMaterias().add(new MateriaImpl(cuart, codigoMateria++, materiasCuartoAño[val], cargaHoraria));
                }
            

            codigoMateria = 1;
            for(int j=0;j<materiasQuintoAño.length;j++){
                val = random.nextInt(0 + materiasQuintoAño.length) + 0;
                Double cargaHoraria = random.nextDouble(0 + 5) + 0;
                quint.getMaterias().add(new MateriaImpl(quint, codigoMateria++, materiasQuintoAño[val], cargaHoraria));
                }
            boolean ok = crearPlan.crear(planAleatorio);
            if(ok == true) BaseDeDatos.planes.add(planAleatorio);
        }
    }

    public static void imprimirPlanes(List<Plan> planes) {
        for (Plan plan : planes) {
            System.out.println("\n" + plan);
            for (AnioPlan anio : plan.getAnios()) {
                System.out.println("\t" + anio);
                for (Materia materia : anio.getMaterias()) {
                    System.out.println("\t\t" + String.format("%1$" + 2 + "s", materia.getCodigo()) + " - " + materia);
                }
                if (anio.getMaterias().size() == 0) {
                    System.out.println("\t\tA este año no se le cargaron materias!!");
                }
            }
            if (plan.getAnios().size() == 0) {
                System.out.println("\tA este plan no se le cargaron años!!");
            }

        }
    }

}
