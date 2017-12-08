package infotech.model;

import java.time.LocalDate;

public class OrdemDeServicoModel {

    private int idOs;
    private String produto;
    private String marca;
    private String modelo;
    private String probInfor;
    private String status;
    private String probConst;
    private LocalDate data;
    private int osIdUsu;

    public OrdemDeServicoModel(int osIdUsu) {
        this.osIdUsu = osIdUsu;
    }

    public OrdemDeServicoModel(String probConst) {
        this.probConst =  probConst;
    }

    public OrdemDeServicoModel(int idOs, String probConst, String status) {
        this.idOs = idOs;
        this.probConst = probConst;
        this.status = status;
    }

    public OrdemDeServicoModel(String produto, String marca, String modelo, String probInfor, String status, String probConst, LocalDate data, int osIdUsu) {
        this.produto = produto;
        this.marca = marca;
        this.modelo = modelo;
        this.probInfor = probInfor;
        this.status = status;
        this.probConst = probConst;
        this.data = data;
        this.osIdUsu = osIdUsu;
    }

    public OrdemDeServicoModel(int idOs, String produto, String marca, String modelo, String probInfor, String status, String probConst, LocalDate data, int osIdUsu) {
        this.idOs = idOs;
        this.produto = produto;
        this.marca = marca;
        this.modelo = modelo;
        this.probInfor = probInfor;
        this.status = status;
        this.probConst = probConst;
        this.data = data;
        this.osIdUsu = osIdUsu;
    }

    
    public int getIdOs() {
        return idOs;
    }

    public void setIdOs(int idOs) {
        this.idOs = idOs;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getProbInfor() {
        return probInfor;
    }

    public void setProbInfor(String probInfor) {
        this.probInfor = probInfor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getProbConst() {
        return probConst;
    }

    public void setProbConst(String probConst) {
        this.probConst = probConst;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getOsIdUsu() {
        return osIdUsu;
    }

    public void setOsIdUsu(int osIdUsu) {
        this.osIdUsu = osIdUsu;
    }

}
