package controledeclientes;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CarregarArquivo {
    
    private ArrayList<Cliente> clientes = new ArrayList();
    
    public ArrayList<Cliente> getClientes() {
        setClientes();
        return this.clientes;
    }
    
    public void removerCliente(Cliente cliente) {
        limparArquivo();
        for(int i = 0; i < this.clientes.size(); i++) {
            if(this.clientes.get(i).getTelefone().equals(cliente.getTelefone()) && this.clientes.get(i).getNome().equals(cliente.getNome()) && this.clientes.get(i).getEndereco().equals(cliente.getEndereco()))
                this.clientes.remove(i);
            else
                adicionarClienteArquivo(this.clientes.get(i));
        }
    }
    
    public ArrayList<Cliente> procurarClientes(String procurado) {
        ArrayList<Cliente> clientesProcurados = new ArrayList();
        setClientes();
        
        for(int i = 0; i < this.clientes.size(); i++) {
            if(this.clientes.get(i).getNome().toLowerCase().indexOf(procurado.toLowerCase()) >= 0)
                clientesProcurados.add(this.clientes.get(i));
            else if(this.clientes.get(i).getTelefone().toLowerCase().indexOf(procurado.toLowerCase()) >= 0)
                clientesProcurados.add(this.clientes.get(i));
            else if(this.clientes.get(i).getBairro().toLowerCase().indexOf(procurado.toLowerCase()) >= 0 || this.clientes.get(i).getRua().toLowerCase().indexOf(procurado.toLowerCase()) >= 0)
                clientesProcurados.add(this.clientes.get(i));
            else if(this.clientes.get(i).getEndereco().toLowerCase().indexOf(procurado.toLowerCase()) >= 0)
                clientesProcurados.add(this.clientes.get(i));
        }
        
        return clientesProcurados;
    }
    
    public void setClientes() {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        String caminhoArquivo = s+"\\clientes.txt";
        
        FileReader f;
        try {
            f = new FileReader(caminhoArquivo);
            BufferedReader readerf = new BufferedReader(f);
            String linha;
            try {
                linha = readerf.readLine();
                ArrayList<String> linhas = new ArrayList();
                while (linha != null) {
                linhas.add(linha);
                linha = readerf.readLine();
            }    
            int contador = 0;

            for(int i = 0; i < linhas.size(); i++) {
                Cliente e = new Cliente();
                if(contador > 5) 
                    contador = 0;
                else if(contador == 1) {
                    e.setNome(linhas.get(i-1));
                    e.setTelefone(linhas.get(i));
                    e.setBairro(linhas.get(i+1));
                    e.setRua(linhas.get(i+2));
                    e.setNumero(linhas.get(i+3));
                    e.setEndereco();
                    this.clientes.add(e);
                }
                contador++;
            }
            readerf.close();
            } catch (IOException ex) {
                Logger.getLogger(CarregarArquivo.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(CarregarArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void adicionarClienteArquivo(Cliente cliente) {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        String caminhoArquivo = s+"\\clientes.txt";

        escreverArquivo(cliente.getNome(), caminhoArquivo);
        escreverArquivo(cliente.getTelefone(), caminhoArquivo);
        escreverArquivo(cliente.getBairro(), caminhoArquivo);
        escreverArquivo(cliente.getRua(), caminhoArquivo);
        escreverArquivo(cliente.getNumero(), caminhoArquivo);
        escreverArquivo("", caminhoArquivo);
    }
    
    public void escreverArquivo(String linha, String caminhoArquivo) {
        FileWriter fw;
        try {
            fw = new FileWriter(caminhoArquivo, true);
            BufferedWriter conexao = new BufferedWriter(fw);
            conexao.write(linha);
            conexao.newLine();
            conexao.close();
        } catch (IOException ex) {
            Logger.getLogger(CarregarArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limparArquivo(){
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        String caminhoArquivo = s+"\\clientes.txt";
        
        File file = new File(caminhoArquivo);
        file.delete();
        File f = new File(caminhoArquivo);
        try {
            f.createNewFile();
        } catch (IOException ex) {
            Logger.getLogger(CarregarArquivo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
