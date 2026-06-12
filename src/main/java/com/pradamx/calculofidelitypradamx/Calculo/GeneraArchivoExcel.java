/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pradamx.calculofidelitypradamx.Calculo;

import com.pradamx.calculofidelitypradamx.contenedor.DataCalculo;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import com.opencsv.CSVWriter;
import com.pradamx.calculofidelitypradamx.service.ProcesoManualFidelityService;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.File;

/**
 *
 * @author analistabi2
 */
@Service("GeneraArchivoExcel")
public class GeneraArchivoExcel {

    @Autowired
    private ProcesoManualFidelityService ProcesoManualFidelityService;

    public void generarCSV(List<DataCalculo> Registros, String ACustomer) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar fecha = Calendar.getInstance();
        String fechaInicio = sdf.format(fecha.getTime());
        String NombreClienteArchivo = ACustomer.replace("-", "_");
        // Ruta completa del archivo
        String directorio = "D:\\SoporteEMICOFI\\Soporte\\HistorialNivelFidelity\\";
        String nombreArchivo = "HistorialVentas_" + NombreClienteArchivo + ".csv";
        String csvFilePath = directorio + nombreArchivo;

        try {
            // Verifica si el directorio existe, si no lo crea
            File folder = new File(directorio);
            if (!folder.exists()) {
                boolean creado = folder.mkdirs();
                if (!creado) {
                    throw new IOException("No se pudo crear el directorio destino: " + directorio);
                }
            }

            try ( CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
                // Escribir la cabecera del archivo CSV
                String[] header = {
                    "CustomerId", "No Ticket", "Fecha Inscripción Fidelity",
                    "Fecha Asignación / compra", "Fecha vencimiento", "Monto",
                    "Compras Acumuladas", "Nivel", "Monto para Mantener",
                    "Monto para Ascender", "Ticket Origen"
                };
                writer.writeNext(header);

                // Escribir los datos
                for (DataCalculo registro : Registros) {
                    String[] row = new String[11];
                    row[0] = registro.getCustomerId();
                    row[1] = registro.getUniversalNo();
                    row[2] = registro.getFecha_Fidelizacion();
                    row[3] = registro.getFecha_Asignacion();
                    row[4] = registro.getFecha_Vencimiento();
                    row[5] = registro.getMonto();
                    row[6] = registro.getComprasAcumuladas();
                    row[7] = registro.getNivel();
                    row[8] = registro.getMontoMantener();
                    row[9] = registro.getMontoAscender();
                    row[10] = registro.getTicketDevolucion();

                    writer.writeNext(row);
                }

                System.out.println("Datos escritos exitosamente en el archivo CSV: " + csvFilePath);
                ProcesoManualFidelityService.GuardarProcesoManualFidelity(ACustomer, 1, "Archivo generado correctamente");

            }

        } catch (IOException error) {
            System.out.println("Error discriminarPLU: " + error.getMessage());
            Logger.getLogger(GeneraArchivoExcel.class.getName()).log(Level.SEVERE, "Error generarCSV: ", error);
            ProcesoManualFidelityService.GuardarProcesoManualFidelity(ACustomer, 2, "Error al momento de generar el archivo CSV");
        }
    }

}
