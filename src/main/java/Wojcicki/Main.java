package Wojcicki;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import java.io.File;
import javax.sql.rowset.spi.XmlWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Account> list = new LinkedList<>();
        Account account = new Account();
        Conditions condits = new Conditions();
        File file = new File("./input.xml");
        XmlMapper xmlMapper = new XmlMapper();
        try {
            Accounts accounts = xmlMapper.readValue(file, Accounts.class);
            for (int i = 0; i <accounts.getAccount().size() ; i++) {
                if(accounts.getAccount().get(i).getBalance()>0 && condits.IbanFitter(accounts.getAccount().get(i).getIban())==1 &&
                     condits.CurrencyFitter(accounts.getAccount().get(i).getCurrency())==1 &&
                        condits.DateComparator(accounts.getAccount().get(1).getClosingDate()) == 1 ){

                   list.add(accounts.getAccount().get(i));


                }
            }

            accounts.getAccount().clear();
             accounts.getAccount().add(list.get(0));
             accounts.getAccount().add(list.get(1));
                jaxbObjectToXML(accounts);


        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    private static void jaxbObjectToXML(Accounts account)
    {
        try
        {
            //Create JAXB Context
            JAXBContext jaxbContext = JAXBContext.newInstance(Accounts.class);

            //Create Marshaller
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            //Required formatting??
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

            //Store XML to File
            File file = new File("output.xml");

            //Writes XML file to file-system
            jaxbMarshaller.marshal(account, file);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
    }
}
