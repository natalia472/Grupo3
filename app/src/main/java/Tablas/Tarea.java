package Tablas;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class Tarea implements Parcelable {
    private int id;
    private int asignatura;
    private String tituloTarea;
    private String descripcion;
    private Date fechaEntrega;

    public Tarea() {
    }


    public Tarea(int id, int asignatura, String tituloTarea, String descripcion, String fechaEntrega) {
        this.id = id;
        this.asignatura = asignatura;
        this.tituloTarea = tituloTarea;
        this.descripcion = descripcion;
        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            this.fechaEntrega = dateFormat.parse(fechaEntrega);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    protected Tarea(Parcel in) {
        id = in.readInt();
        asignatura = in.readInt();
        tituloTarea = in.readString();
        descripcion = in.readString();
    }

    public static final Creator<Tarea> CREATOR = new Creator<Tarea>() {
        @Override
        public Tarea createFromParcel(Parcel in) {
            return new Tarea(in);
        }

        @Override
        public Tarea[] newArray(int size) {
            return new Tarea[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(int asignatura) {
        this.asignatura = asignatura;
    }

    public String getTituloTarea() {
        return tituloTarea;
    }

    public void setTituloTarea(String tituloTarea) {
        this.tituloTarea = tituloTarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeInt(asignatura);
        dest.writeString(tituloTarea);
        dest.writeString(descripcion);
    }
}
