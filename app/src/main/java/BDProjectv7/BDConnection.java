package BDProjectv7;


import UIPackage.VizualizareGrupaPanel;
import java.awt.List;
import java.sql.*;
import java.util.ArrayList;

import java.util.Calendar;
import java.time.LocalDate; 
import javax.swing.JTextField;

import UIPackage.AdminPanel;
import UIPackage.SuperAdminPanel;
        
public class BDConnection {
    
    Connection conn;
    private User currentUser;
    
    public BDConnection(){
        try{
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "root", "rootpass");
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }    
    }
    public void insertPonderi(String username, String cursNume, ArrayList<Double> ponderi){
        try{
            Statement stmt = conn.createStatement();
            String command = 
            "UPDATE asign_profesori_cursuri SET pondere_curs = " + ponderi.get(0) +", pondere_laborator = " + ponderi.get(1) + ", pondere_seminar = " + ponderi.get(2)
                   + " WHERE username = \"" + username + "\" and nume_curs = \"" + cursNume + "\";";
            stmt.execute(command);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    public void setNewCurrentUser(String username, String password, String role){
        // todo
        // functie de luad informatii din bd si actualizat currentUser;
        
       // if(role == "student"){
            currentUser = new Student(username, password, role);
       // }
    }
    
    String isUserRegistered(String username, String password){
        try{
            Statement stmt = conn.createStatement();
            String command = "select role from users where username =\"" + username +"\" and password=\"" + password +"\";";
            
            ResultSet rset = stmt.executeQuery(command);
            if(!rset.next()){
                System.out.println("Logarea nu a avut succes");
                return null;
            }
            else{
                System.out.println("Userul este inregistrat");
                return rset.getString("role");
            }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
    ArrayList<Integer> getGroups(){
        ArrayList<Integer> queryData = new ArrayList<Integer>();
        try{
            Statement stmt = conn.createStatement();
            String command = "select distinct id_grupa from grupa_studiu order by id_grupa;";
            
            ResultSet rset = stmt.executeQuery(command);
            
            while(rset.next()){
                queryData.add(rset.getInt(1));
            }
            
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
     ArrayList<String> getCoursesProf(){
        ArrayList<String> queryData = new ArrayList<String>();
        try{
            Statement stmt = conn.createStatement();
            String command = "select nume_curs from asign_profesori_cursuri where username = \"" + currentUser.username + "\";";
        
            ResultSet rset = stmt.executeQuery(command);
            
            while(rset.next()){
                queryData.add(rset.getString(1));
            }
            
            return queryData;
        }
        
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }   
     }
     
    Integer getIDAsignProfCurs(String numecurs){
        Integer queryData = new Integer(0);
         try{
            Statement stmt = conn.createStatement();
            String command = "select id_asignare_prof_curs from asign_profesori_cursuri where username = \"" + currentUser.username 
                    + "\" and nume_curs = \"" + numecurs + "\";";
            
            ResultSet rset = stmt.executeQuery(command);
            rset.next();
            queryData=rset.getInt("id_asignare_prof_curs");
            return queryData;
         }
         catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }   
    }
     
     ArrayList<Integer> getCursLabSem(){
         ArrayList<Integer> queryData = new ArrayList<Integer>();
         try{
            Statement stmt = conn.createStatement();
            String command = "select bool_curs, bool_laborator, bool_seminar from asign_profesori_cursuri where username = \"" + currentUser.username + "\";";
         
            ResultSet rset = stmt.executeQuery(command);
            
            rset.next();
            queryData.add(rset.getInt("bool_curs"));
            queryData.add(rset.getInt("bool_laborator"));
            queryData.add(rset.getInt("bool_seminar"));
            return queryData;
            
         }
         
         catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }   
                 
     }
     
     ArrayList<Double> getPonderi(String numeCurs){
         ArrayList<Double> queryData = new ArrayList<Double>();
         try{
             Statement stmt = conn.createStatement();
             String command = "select pondere_curs, pondere_laborator, pondere_seminar from asign_profesori_cursuri where username = \"" + currentUser.username + "\" and"
                     + " nume_curs = \"" + numeCurs + "\";";
             ResultSet rset = stmt.executeQuery(command);
             rset.next();
             queryData.add(rset.getDouble("pondere_curs"));
             queryData.add(rset.getDouble("pondere_laborator"));
             queryData.add(rset.getDouble("pondere_seminar"));
             return queryData;
             
         }
         
         catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
     }
    
    String getCursGrupa(int idGrupa){
        try{
            Statement stmt = conn.createStatement();
            String command = "select nume_curs from grupa_studiu where id_grupa=" + idGrupa + ";";
            
            ResultSet rset = stmt.executeQuery(command);
            
            rset.next();
            String curs = rset.getString(1);
            
            return curs;
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }    
    
    ArrayList<Integer> getInvitatiiGrupa(){
        ArrayList<Integer> queryData = new ArrayList<Integer>();
        try{
            Statement stmt = conn.createStatement();
            String command = "select id_grupa from invitatii_grupa where username_destinatar = \"" + currentUser.username + "\";";
            
            ResultSet rset = stmt.executeQuery(command);
            
            while(rset.next()){
                queryData.add(rset.getInt("id_grupa"));
                
            }
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
   
    
    public void deleteInviteProfesorGrupa(String username, int idActiv){
        try{
            String command = "delete from invitatii_activitate_prof where id_activ = "+idActiv+" and username_destinatar = \"" + username + "\";";
            PreparedStatement stmt = conn.prepareStatement(command);
            stmt.execute(); 
            
        }
        catch(SQLException ex){
           ex.printStackTrace();
       }
    }
    
    public void deleteInviteGrupa(String username, int idGrupa){
        try{
            String command = "delete from invitatii_grupa where id_grupa = "+idGrupa+" and username_destinatar = \"" + username + "\";";
            PreparedStatement stmt = conn.prepareStatement(command);
            stmt.execute(); 
            
        }
        catch(SQLException ex){
           ex.printStackTrace();
       }
    }
    
    ArrayList<Activitate> getProfessorGroupInvites(){
        ArrayList<Activitate> queryData = new ArrayList<Activitate>();
        try{
            Statement stmt = conn.createStatement();
            String command = "select activ.id_activ, activ.tip_activitate, activ.start_date, activ.ora, activ.durata from activitate activ, invitatii_activitate_prof acp where acp.username_destinatar = \"" + currentUser.username+"\" and activ.id_activ = acp.id_activ;";
            
            ResultSet rset = stmt.executeQuery(command);
            
            while(rset.next()){
                
                Activitate activ = new Activitate();
                activ.id_activ = rset.getInt("activ.id_activ");
                activ.tipActivitate = rset.getString("activ.tip_activitate");
                activ.start_date = rset.getDate("activ.start_date");
                activ.ora = rset.getTime("activ.ora");
                activ.durata = rset.getInt("activ.durata");
                
                queryData.add(activ);
            }
            
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
     ArrayList<String> getCourses(){
        ArrayList<String> queryData = new ArrayList<String>();
        try{
            Statement stmt = conn.createStatement();
            String command = "select distinct nume_curs from cursuri order by nume_curs;";
            
            ResultSet rset = stmt.executeQuery(command);
            
            while(rset.next()){
                queryData.add(rset.getString(1));
            }
            
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
     
     ArrayList<ArrayList<String>> getChat(int idGrupa){
        ArrayList<ArrayList<String>> queryData = new ArrayList<ArrayList<String>>();
        try{
            Statement stmt = conn.createStatement();
            String command = "select username, textmesaj from grupa_chat where id_grupa =" + idGrupa + " order by id_mesaj;";
            
            
            ResultSet rset = stmt.executeQuery(command);
            
 
            while(rset.next()){
      
                ArrayList<String> querySet = new ArrayList<String>();
                querySet.add(rset.getString(1));
                querySet.add(rset.getString(2));
                queryData.add(querySet);
            }
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
     String getCursByGroupID(int idGrupa){
        String numeCurs = new String();
        try{
            Statement stmt = conn.createStatement();
            String command = "select nume_curs from grupa_studiu where id_grupa =" + idGrupa + ";";
            
            
            ResultSet rset = stmt.executeQuery(command);
            
 
            rset.next();
            numeCurs = rset.getString(1);

            return numeCurs;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
     
    public void insertInviteToProfesorAtLastGroupActivity(String username){
        try{
            String command = "insert into invitatii_activitate_prof(username_destinatar, id_activ) select \"" + username + "\", activ.id_activ from activitate activ order by activ.id_activ desc limit 1;";
            PreparedStatement stmt = conn.prepareStatement(command);
            stmt.execute(); 
            
        }
        catch(SQLException ex){
           ex.printStackTrace();
       }
        
    }
    
    ArrayList<String> getColegi(int idGrupa){
        ArrayList<String> queryData = new ArrayList<String>();
        try{
            Statement stmt = conn.createStatement();
            String command = "select distinct username from participanti_grupa where id_grupa=" + idGrupa + " order by username;";
            
            ResultSet rset = stmt.executeQuery(command);
            
            while(rset.next()){
                queryData.add(rset.getString(1));
            }
            
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    public void InsertGrupaStudiu(String curs){
        try{
            String command = "insert into grupa_studiu(nume_curs) values(?);";
            PreparedStatement stmt = conn.prepareStatement(command);
            stmt.setString(1, curs);
            stmt.execute();
        }
        catch(SQLException ex){
           ex.printStackTrace();
       }
    }
    
    public void InsertActivitateProf(JTextField[] fields, String tipActivitate, int idAPC){
        try{
            String command = "insert into activitate(start_date, final_date, zi, ora, durata,"
                            +" tip_activitate, locuri_max, id_asignare_prof_curs, nr_part_curent) values(\""
                            + fields[0].getText() + "\", \"" + fields[1].getText() + "\", \""
                            + fields[2].getText() + "\", \"" + fields[3].getText() + "\", "
                            + Integer.parseInt(fields[4].getText()) + ", \"" + tipActivitate + "\", "
                            + Integer.parseInt(fields[5].getText()) + ", " + idAPC + ", 0);";
        
            Statement stmt = conn.createStatement();
            stmt.execute(command);
        }
        
        catch(SQLException ex){
           ex.printStackTrace();
       }
    }
    
    public void InsertActivitateGrupa(JTextField[] fields, int idgrupa){
        try{
            String command2 = "insert into activitati_grupa_studiu(participanti_min, id_grupa, data_expirare)"
                    + " values(" + Integer.parseInt(fields[6].getText()) + ", " +idgrupa 
                    + ", \"" + fields[8].getText() + ":00:00" + "\");";
            PreparedStatement stmt2 = conn.prepareStatement(command2);
            stmt2.execute(); 
            
            String command3 = "select max(id_activ_grupa) from activitati_grupa_studiu;";
            PreparedStatement stmt3 = conn.prepareStatement(command3);
            ResultSet rset = stmt3.executeQuery(command3);
            
            rset.next();
            int var = rset.getInt(1);
            
            
            
            
            String command = "insert into activitate(start_date, final_date, zi, ora, durata,"
                    + "tip_activitate, locuri_max, id_activ_grupa, nr_part_curent) values"
                    +"(\"" +fields[0].getText() +"\", \"" + fields[1].getText() + "\", \"" + fields[2].getText() +"\", \"" 
                    + fields[3].getText() +"\", " + Integer.parseInt(fields[4].getText()) +", \"" 
                    + fields[5].getText() +"\", " +  Integer.parseInt(fields[7].getText()) + ", " + var +", 0)";
            PreparedStatement stmt = conn.prepareStatement(command);
            stmt.execute();
            
             
            
        }
        catch(SQLException ex){
           ex.printStackTrace();
       }
        
    }
    
    public boolean VerificareInscriereStudentGrupa(String username, int grID){
       try{
       Statement stmt = conn.createStatement();
       String command = "select distinct id_part_grupa from participanti_grupa where participanti_grupa.username= \"" + username + "\" and participanti_grupa.id_grupa=" + grID+";";
       ResultSet rset = stmt.executeQuery(command);
            if(!rset.next())
                return false;
            else
                return true;   
        }
       catch(SQLException ex){
           ex.printStackTrace();
       }
       return false;
    }
    
    public void InscriereGrupaStudiu(String username, int id){
        try{
            String command = "insert into participanti_grupa(username, id_grupa) values(\""
                    + username + "\", " + id + ");";
            PreparedStatement stmt = conn.prepareStatement(command);
            stmt.executeUpdate();
           
        }
        catch(SQLException ex){
           ex.printStackTrace();
       }
    }
    
    public void SendMSG(String username, String msg, int idGrupa){
        try{
            String command = "insert into grupa_chat(username, textmesaj, id_grupa) values(\""
                    + username + "\", \"" + msg + "\", " + idGrupa + ");";
            PreparedStatement stmt = conn.prepareStatement(command);
            stmt.executeUpdate();
        }
        catch(SQLException ex){
           ex.printStackTrace();
       }
        
    }
    
    ArrayList<ArrayList<String>> getStudentActiveCourses(){
        ArrayList<ArrayList<String>> queryData = new ArrayList<ArrayList<String>>();
        try{
            Statement stmt = conn.createStatement();
            String command = "select asign_profesori_cursuri.nume_curs, cursuri.descriere, users.nume, users.prenume from asign_profesori_cursuri, asign_studenti_cursuri, users, cursuri where asign_studenti_cursuri.username = \"" + currentUser.username +"\" \n" +
"and asign_studenti_cursuri.id_asignare_prof_curs = asign_profesori_cursuri.id_asignare_prof_curs and users.username = asign_profesori_cursuri.username and cursuri.nume_curs = asign_profesori_cursuri.nume_curs;";
            
            ResultSet rset = stmt.executeQuery(command);
            
            while(rset.next()){
                ArrayList<String> querySet = new ArrayList<String>();
                querySet.add(rset.getString(1));
                querySet.add(rset.getString(2));
                querySet.add(rset.getString(3));
                querySet.add(rset.getString(4));
                queryData.add(querySet);
            }
            
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    ArrayList<String> getStudentPossibleCourses(){
        ArrayList<String> querySet = new ArrayList<String>();
        try{
            Statement stmt = conn.createStatement();
            String command = "select distinct c.nume_curs from cursuri c where not exists (" +
"select apc.nume_curs from asign_profesori_cursuri apc, asign_studenti_cursuri ascc where ascc.username = \"" + currentUser.username + "\" and ascc.id_asignare_prof_curs = apc.id_asignare_prof_curs and apc.nume_curs = c.nume_curs);";
            
            ResultSet rset = stmt.executeQuery(command);
            
            while(rset.next()){
                querySet.add(rset.getString(1));
            }
            
            return querySet;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
   ArrayList<Activitate> getPossibleActivities(){
       ArrayList<Activitate> activitati = new ArrayList<Activitate>();
        try{
          Statement stmt = conn.createStatement();
          String command = "select activ.id_activ, activ.zi, activ.ora, activ.durata, activ.tip_activitate, apc.nume_curs from activitate activ, asign_profesori_cursuri apc, asign_studenti_cursuri ascc where ascc.username = \"" + currentUser.username + "\" \n" +
"and ascc.id_asignare_prof_curs = apc.id_asignare_prof_curs and apc.id_asignare_prof_curs = activ.id_asignare_prof_curs and\n" +
"not exists ( select part.id_part from participanti part, activitate activ2, asign_profesori_cursuri apc2, asign_studenti_cursuri ascc2 \n" +
"where ascc2.username = \"" + currentUser.username + "\" and ascc2.id_asignare_prof_curs = apc2.id_asignare_prof_curs and apc2.id_asignare_prof_curs = activ2.id_asignare_prof_curs and\n" +
"part.id_activ = activ.id_activ and part.username = \"" + currentUser.username + "\");";
          
        ResultSet rset = stmt.executeQuery(command);
          
        while(rset.next()){
            Activitate newActiv = new Activitate();
            newActiv.id_activ = rset.getInt(1);
            newActiv.zi = rset.getString(2);
            newActiv.oraString = rset.getString(3);
            
            newActiv.durata = rset.getInt(4);
            newActiv.tipActivitate = rset.getString(5);
            newActiv.numeCurs = rset.getString(6);
            activitati.add(newActiv);
        }
        
        Statement stmtGrupa = conn.createStatement();
        String commandGrupa = "select activ.id_activ, activ.zi, activ.ora, activ.durata, activ.tip_activitate, gs.nume_curs from activitate activ, activitati_grupa_studiu ags, grupa_studiu gs, participanti_grupa pg where pg.username = \"" + currentUser.username + "\" and\n" +
"pg.id_grupa = gs.id_grupa and ags.id_grupa = pg.id_grupa and activ.id_activ_grupa = ags.id_activ_grupa and not exists( select part.id_part from participanti part\n" +
" where part.id_activ = activ.id_activ and part.username = \"" + currentUser.username + "\");";
        ResultSet rsetGrupa = stmtGrupa.executeQuery(commandGrupa);
        
        while(rsetGrupa.next()){
            Activitate newActiv = new Activitate();
            newActiv.id_activ = rsetGrupa.getInt(1);
            newActiv.zi = rsetGrupa.getString(2);
            newActiv.oraString = rsetGrupa.getString(3);
            
            newActiv.durata = rsetGrupa.getInt(4);
            newActiv.tipActivitate = rsetGrupa.getString(5);
            newActiv.numeCurs = rsetGrupa.getString(6);
            activitati.add(newActiv);
        }
        
        // --------- Filtrare activitati care se suprapun sau au atins nr max de participanti -------
        for(int i = 0; i < activitati.size(); i++){
            if(!verificareNumarMaximDeParticipantiAtins(activitati.get(i).id_activ) || isActivityInInterval(activitati.get(i).oraString, activitati.get(i).durata, activitati.get(i).zi)){
                activitati.remove(i);
                
            }
        }

        return activitati;
          
      }
      catch(SQLException ex){
          ex.printStackTrace();
          return null;
      }
       
   }
   
   public ArrayList<ArrayList<String>> getSuggestedStudentsForGroup(int idGroup){
       ArrayList<ArrayList<String>> queryData = new ArrayList<ArrayList<String>>();
        try{
            Statement stmt = conn.createStatement();
            String command = "select us.username, us.nume, us.prenume from users us, grupa_studiu gs, asign_profesori_cursuri apc, asign_studenti_cursuri assc where gs.id_grupa = " + idGroup+" and gs.nume_curs = apc.nume_curs \n" +
"and assc.id_asignare_prof_curs = apc.id_asignare_prof_curs and us.username = assc.username and not exists(select part.username from participanti_grupa part where part.id_grupa = "+idGroup+" and part.username = us.username) and not exists (select username_destinatar from invitatii_grupa where username_destinatar = us.username and id_grupa = "+idGroup+ ");";
            
            ResultSet rset = stmt.executeQuery(command);
            
            while(rset.next()){
                
                ArrayList<String> querySet = new ArrayList<String>();
                
                querySet.add(rset.getString("us.username"));
                querySet.add(rset.getString("us.nume"));
                querySet.add(rset.getString("us.prenume"));
                
                queryData.add(querySet);
            }
            
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
   }
   
   public ArrayList<ArrayList<String>> getSuggestedProfessorsForGroup(String numeCurs){
       ArrayList<ArrayList<String>> queryData = new ArrayList<ArrayList<String>>();
       try{
            Statement stmt = conn.createStatement();
            String command = "select us.username, us.nume, us.prenume from users us, asign_profesori_cursuri apc where apc.nume_curs = \"" + numeCurs + "\" and apc.username = us.username;";
            
            ResultSet rset = stmt.executeQuery(command);
            
            while(rset.next()){
                
                ArrayList<String> querySet = new ArrayList<String>();
                
                querySet.add(rset.getString("us.username"));
                querySet.add(rset.getString("us.nume"));
                querySet.add(rset.getString("us.prenume"));
                
                queryData.add(querySet);
            }
            
            return queryData;
        }
       catch(SQLException ex){
           ex.printStackTrace();
           return null;
       }
   }
   
   public boolean verificareNumarMaximDeParticipantiAtins(int idActivitate){
       
       try{
           CallableStatement stmt = conn.prepareCall("{call checkIfActivityMaxAttendants(?, ?)}");
           int boolVal;
           stmt.setInt("my_id_activ", idActivitate);
           stmt.execute();
           boolVal = stmt.getInt("bool_activ");
           if(boolVal == 0){
               return false;
           }
           else 
               return true;
       }
       catch(SQLException ex){
           ex.printStackTrace();
           return false;
       }
       
   }
   
   public void insertInvitatieGrupa(int idGrupa, String username){
       try{
            Statement stmt = conn.createStatement();
            
            String command = "insert into invitatii_grupa(id_grupa, username_destinatar) values ("+ idGrupa +", \""+ username +"\");";
            stmt.executeUpdate(command);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
   }
   
    
    public void inscriereUserLaCurs(String numeCurs){
        try{
             CallableStatement stmt = conn.prepareCall("{call InsertStudentLaProfesorMin(?, ?)}");
             stmt.setString("username_student", currentUser.username);
             stmt.setString("nume_curs_ales", numeCurs);
             stmt.execute();
        }
       catch(SQLException ex){
           ex.printStackTrace();
       }
        
    }
    
    public void inscriereUserLaActivitate(int idActivitate){
        try{
            Statement stmt = conn.createStatement();
            
            String command = "insert into participanti(id_activ, username) values(" + idActivitate + ",\"" + currentUser.username + "\")";
            stmt.executeUpdate(command);
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    boolean isUsernameUsed(String username){
        try{
            Statement stmt = conn.createStatement();
            String command = "select username from users where username =\"" + username +"\";";
            ResultSet rset = stmt.executeQuery(command);
            if(!rset.next())
                return false;
            else
                return true;   
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        return false;
    }
    
    boolean isActivityInInterval(String ora, int durata, String zi){
        try{
            Time timpFinal = java.sql.Time.valueOf(ora);
            timpFinal.setHours(timpFinal.getHours() + durata);
            String oraFinala = timpFinal.toString();

            CallableStatement statement = conn.prepareCall("{call checkIfActivityInInterval(?,?,?,?,?)}");
            statement.setString("username", currentUser.username);
            statement.setString("startTime", ora);
            statement.setString("endTime", oraFinala);
            statement.setString("zi", zi);
            statement.execute();
            int result = statement.getInt("isActivityInInterval");
            
            if(result == 1){
                return true;
            }
            else{
                return false;
            }
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return false;
        }
    }
    
    public User getUserInformation(){
        try{
            
            if(currentUser.role.equals("student"))
                currentUser = new Student(currentUser.username, currentUser.password, currentUser.role);
            else 
                currentUser = new Profesor(currentUser.username, currentUser.password, currentUser.role);
            
            CallableStatement statement = conn.prepareCall("{call GetUserInfo(?, ?, ?, ?, ?, ?, ?, ?, ?)}");
            statement.setString("username", currentUser.username);
            statement.execute();
            currentUser.CNP = statement.getString("CNP");
            currentUser.nume = statement.getString("nume");
            currentUser.prenume = statement.getString("prenume");
            currentUser.adresa = statement.getString("adresa");
            currentUser.nr_telefon = statement.getString("nr_telefon");
            currentUser.email = statement.getString("email");
            currentUser.IBAN = statement.getString("IBAN");
            currentUser.nr_contract = statement.getString("nr_contract");
            
            if(currentUser.role.equals("student")){
                CallableStatement studentStatement = conn.prepareCall("{call GetStudentInfo(?, ?, ?)}");
                studentStatement.setString("username", currentUser.username);
                studentStatement.execute();
                ((Student)currentUser).an_studiu = studentStatement.getInt("an_studiu");
                ((Student)currentUser).nr_ore = studentStatement.getInt("nr_ore");
            }
            else if(currentUser.role.equals("profesor")){
                CallableStatement profesorStatement = conn.prepareCall("{call GetProfesorInfo(?, ?, ?, ?)}");
                profesorStatement.setString("username", currentUser.username);
                profesorStatement.execute();
                
                ((Profesor)currentUser).min_ore = profesorStatement.getInt("min_ore");
                ((Profesor)currentUser).max_ore = profesorStatement.getInt("max_ore");
                ((Profesor)currentUser).departament = profesorStatement.getString("departament");
            }
            return currentUser;
        }
        catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }
    
    public void registerStudent(String username, String password, String CNP,
                                String nume, String prenume, String adresa, 
                                String nr_telefon, String email, String IBAN,
                                String nr_contract, int an_studiu, int nr_ore )
    {
        try{
             CallableStatement statement = conn.prepareCall("{call RegisterStudent(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
             statement.setString("username", username);
             statement.setString("password", password);
             statement.setString("CNP", CNP);
             statement.setString("nume", nume);
             statement.setString("prenume", prenume);
             statement.setString("adresa", adresa);
             statement.setString("nr_telefon", nr_telefon);
             statement.setString("email", email);
             statement.setString("IBAN", IBAN);
             statement.setString("nr_contract", nr_contract);
             statement.setString("role", "student");
             statement.setInt("an_studiu", an_studiu);
             statement.setInt("nr_ore", nr_ore);
             statement.execute();
      
        }
       catch(SQLException ex){
           ex.printStackTrace();
       }
        
        
    }
    public void registerProfesor(String username, String password, String CNP,
                                String nume, String prenume, String adresa, 
                                String nr_telefon, String email, String IBAN,
                                String nr_contract, String departament)
    {
        try{
             CallableStatement statement = conn.prepareCall("{call RegisterProfesor(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
             statement.setString("username", username);
             statement.setString("password", password);
             statement.setString("CNP", CNP);
             statement.setString("nume", nume);
             statement.setString("prenume", prenume);
             statement.setString("adresa", adresa);
             statement.setString("nr_telefon", nr_telefon);
             statement.setString("email", email);
             statement.setString("IBAN", IBAN);
             statement.setString("nr_contract", nr_contract);
             statement.setString("role", "student");
             statement.setString("departament", departament);
             statement.execute();
      
        }
       catch(SQLException ex){
           ex.printStackTrace();
       }
        
        
    }
    public void registerAdministrator(String username, String password, String CNP,
                                String nume, String prenume, String adresa, 
                                String nr_telefon, String email, String IBAN,
                                String nr_contract)
    {
        try{
             CallableStatement statement = conn.prepareCall("{call RegisterUser(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)}");
             statement.setString("username", username);
             statement.setString("password", password);
             statement.setString("CNP", CNP);
             statement.setString("nume", nume);
             statement.setString("prenume", prenume);
             statement.setString("adresa", adresa);
             statement.setString("nr_telefon", nr_telefon);
             statement.setString("email", email);
             statement.setString("IBAN", IBAN);
             statement.setString("nr_contract", nr_contract);
             statement.setString("role", "admin");
             statement.execute();
      
        }
       catch(SQLException ex){
           ex.printStackTrace();
       }
    }
    ArrayList<NotaStudent> getStudentNote(){
        ArrayList<NotaStudent> queryData = new ArrayList<NotaStudent>();
        try{
            Statement stmt = conn.createStatement();  
            String command = " select cursuri.nume_curs, asign_studenti_cursuri.nota_curs, asign_studenti_cursuri.nota_seminar, asign_studenti_cursuri.nota_laborator, asign_studenti_cursuri.nota_finala \n" +
                             "		from asign_studenti_cursuri, asign_profesori_cursuri, studenti, cursuri\n" +
                             "    where studenti.username = \"" + currentUser.username + "\"\n" +
                             "		and studenti.username = asign_studenti_cursuri.username \n" +
                             "		and  asign_profesori_cursuri.id_asignare_prof_curs = asign_studenti_cursuri.id_asignare_prof_curs \n" +
                             "		and asign_profesori_cursuri.nume_curs = cursuri.nume_curs;";
            
            ResultSet rset = stmt.executeQuery(command);
            
            while(rset.next()){
                ArrayList<NotaStudent> querySet = new ArrayList<NotaStudent>();
                String nume_curs = rset.getString(1);
                double nota_curs = rset.getDouble(2);
                double nota_seminar = rset.getDouble(3);
                double nota_laborator = rset.getDouble(4);
                int nota_finala = rset.getInt(5);
                
                NotaStudent disciplina = new NotaStudent();
                disciplina.nume_curs = nume_curs;
                disciplina.nota_curs = nota_curs;
                disciplina.nota_seminar = nota_seminar;
                disciplina.nota_laborator = nota_laborator;
                disciplina.nota_finala = nota_finala;

                queryData.add(disciplina);
            }
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }


    String[][] getCurrentDayActiv(){
        String queryData[][] = new String[5][4];
        try{

            String day = LocalDate.now().getDayOfWeek().name();
            String ziuaCurenta;
            switch(day){
                case "MONDAY":
                    ziuaCurenta = "luni";
                    break;
                case "TUESDAY":
                    ziuaCurenta = "marti";
                    break;
                case "WEDNESDAY" :
                    ziuaCurenta = "miercuri";
                    break;
                case "THURSDAY" :
                    ziuaCurenta = "joi";
                    break;
                case "FRIDAY" :
                    ziuaCurenta = "vineri";
                    break;
                default : 
                    ziuaCurenta = "weekend";                                                                
            }

            Statement stmt = conn.createStatement();  
            String command = " select distinct asign_profesori_cursuri.nume_curs, activitate.tip_activitate, activitate.ora, activitate.durata from activitate, participanti, asign_profesori_cursuri\n" +
                             "    where participanti.username =\"" + currentUser.username + "\" and activitate.zi = \"" + ziuaCurenta + "\"  and asign_profesori_cursuri.id_asignare_prof_curs = activitate.id_asignare_prof_curs and activitate.id_activ = participanti.id_activ;";
            
            ResultSet rset = stmt.executeQuery(command);
            
            for(int i = 0; rset.next(); i++){
                for(int j = 0; j < 4; j++){
                    queryData[i][j] = String.valueOf(rset.getString(j+1));
                }
            }
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    
    
    String[][] getCurrentDayActivProfesor(){
        String queryData[][] = new String[5][4];
        try{

            String day = LocalDate.now().getDayOfWeek().name();
            String ziuaCurenta;
            switch(day){
                case "MONDAY":
                    ziuaCurenta = "luni";
                    break;
                case "TUESDAY":
                    ziuaCurenta = "marti";
                    break;
                case "WEDNESDAY" :
                    ziuaCurenta = "miercuri";
                    break;
                case "THURSDAY" :
                    ziuaCurenta = "joi";
                    break;
                case "FRIDAY" :
                    ziuaCurenta = "vineri";
                    break;
                default : 
                    ziuaCurenta = "weekend";                                                                
            }

            Statement stmt = conn.createStatement();  
            String command = "select distinct asign_profesori_cursuri.nume_curs, activitate.tip_activitate, activitate.ora, activitate.durata from activitate, asign_profesori_cursuri\n" +
"    where asign_profesori_cursuri.username = \"" + currentUser.username + "\"and activitate.zi = \"" + ziuaCurenta + "\" and asign_profesori_cursuri.id_asignare_prof_curs = activitate.id_asignare_prof_curs;";
            
            ResultSet rset = stmt.executeQuery(command);
            
            for(int i = 0; rset.next(); i++){
                for(int j = 0; j < 4; j++){
                    queryData[i][j] = String.valueOf(rset.getString(j+1));
                }
            }
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
    ArrayList<Activitate> getActivitatiStudent(){
        ArrayList<Activitate> queryData = new ArrayList<Activitate>();
        try{
            // activitati curs
            Statement stmt = conn.createStatement();  
            String command = "select distinct activitate.id_activ, asign_profesori_cursuri.nume_curs, activitate.tip_activitate, activitate.ora, activitate.durata, activitate.zi\n" + 
                             "from activitate, participanti, asign_profesori_cursuri\n" +
                             "    where participanti.username = \"" + currentUser.username + "\"and activitate.id_activ = participanti.id_activ \n" + 
                             " and asign_profesori_cursuri.id_asignare_prof_curs = activitate.id_asignare_prof_curs\n" +
                             "    order by zi ASC;";
            
            ResultSet rset = stmt.executeQuery(command);
            
            while(rset.next()){
                Activitate activ = new Activitate();
                activ.id_activ = rset.getInt(1);
                activ.numeCurs = rset.getString(2);
                activ.tipActivitate = rset.getString(3);
                activ.oraString = rset.getString(4);
                activ.durata = rset.getInt(5);
                activ.zi = rset.getString(6);
                
                queryData.add(activ);
                
            }
            
            // activitati grupa
            
            Statement stmtGrupa = conn.createStatement();  
            String commandGrupa = "select activ.id_activ, gs.nume_curs, activ.tip_activitate, activ.ora, activ.durata, activ.zi from grupa_studiu gs, participanti_grupa pg, activitati_grupa_studiu ags, activitate activ, participanti part where pg.username = \""+ currentUser.username+"\" and pg.id_grupa = ags.id_grupa \n" +
"and ags.id_activ_grupa = activ.id_activ_grupa and gs.id_grupa = pg.id_grupa and part.id_activ = activ.id_activ and part.username = \""+ currentUser.username+"\";";
            
            ResultSet rsetGrupa = stmtGrupa.executeQuery(commandGrupa);

           while(rsetGrupa.next()){
                Activitate activ = new Activitate();
                activ.id_activ = rsetGrupa.getInt(1);
                activ.numeCurs = rsetGrupa.getString(2);
                activ.tipActivitate = rsetGrupa.getString(3);
                activ.oraString = rsetGrupa.getString(4);
                activ.durata = rsetGrupa.getInt(5);
                activ.zi = rsetGrupa.getString(6);
                
                queryData.add(activ);
                
            }
            
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    ArrayList<Activitate> getActivitatiProfesor(){
        ArrayList<Activitate> queryData = new ArrayList<Activitate>();
        try{

            Statement stmt = conn.createStatement();  
            String command = "select distinct activitate.id_activ, asign_profesori_cursuri.nume_curs, activitate.tip_activitate, activitate.ora, activitate.durata, activitate.zi \n" +
"	from activitate, asign_profesori_cursuri\n" +
"    where asign_profesori_cursuri.username = \"" + currentUser.username + "\" and asign_profesori_cursuri.id_asignare_prof_curs = activitate.id_asignare_prof_curs\n" +
"    order by zi ASC;";
            
            ResultSet rset = stmt.executeQuery(command);
            int arrayCount = 0;
            
            while(rset.next()){
                Activitate activ = new Activitate();
                activ.id_activ = rset.getInt(1);
                activ.numeCurs = rset.getString(2);
                activ.tipActivitate = rset.getString(3);
                activ.oraString = rset.getString(4);
                activ.durata = rset.getInt(5);
                activ.zi = rset.getString(6);
                
                queryData.add(activ);
            }
                    
            //activitati grupa 
            
            Statement stmtGrupa = conn.createStatement();  
            String commandGrupa = "select activitate.id_activ, grupa_studiu.nume_curs, activitate.tip_activitate, activitate.ora, activitate.durata, activitate.zi \n" +
"from activitate, activitati_grupa_studiu, grupa_studiu, participanti where grupa_studiu.id_grupa = activitati_grupa_studiu.id_grupa and \n" +
"activitate.id_activ_grupa = activitati_grupa_studiu.id_activ_grupa and participanti.id_activ = activitate.id_activ and participanti.username = \""+currentUser.username + "\";";
            
            ResultSet rsetGrupa = stmtGrupa.executeQuery(commandGrupa);

            
            while(rsetGrupa.next()){
                Activitate activ = new Activitate();
                activ.id_activ = rsetGrupa.getInt(1);
                activ.numeCurs = rsetGrupa.getString(2);
                activ.tipActivitate = rsetGrupa.getString(3);
                activ.oraString = rsetGrupa.getString(4);
                activ.durata = rsetGrupa.getInt(5);
                activ.zi = rsetGrupa.getString(6);
                
                queryData.add(activ);
            }
            return queryData;   
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public void updateActivitatiProfesor(String[] data, int idActiv){
        try{

            Statement stmt = conn.createStatement();
            String command = "update activitate, asign_profesori_cursuri\n" +
                             "    Set \n" +
                             "        ora = \"" + data[2] + "\",\n" +
                             "        durata = " + data[3] + ",\n" +
                             "        zi = \"" + data[4] + "\"\n" +
                             "    where activitate.id_activ =\"" + idActiv + "\";";
            
            stmt.executeUpdate(command);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    ArrayList<String> getCursuriProfesor(){
        ArrayList<String> queryData = new ArrayList<String>();
        try{
            Statement stmt = conn.createStatement();  
            String command = "select nume_curs from asign_profesori_cursuri \n" +
                             "where username = \"" + currentUser.username + "\";";
            
            ResultSet rset = stmt.executeQuery(command);
            
            while(rset.next()){
                queryData.add(rset.getString(1));
            }
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    String[][] getStudentiProfesor(String curs){
        String[][] queryData = new String[30][7];
        try{
            Statement stmt = conn.createStatement();  
            String command = "select users.nume, users.prenume, asign_studenti_cursuri.username, asign_studenti_cursuri.nota_curs, asign_studenti_cursuri.nota_seminar, \n" +
                             "	asign_studenti_cursuri.nota_laborator, asign_studenti_cursuri.nota_finala\n" +
                             "from users, studenti, asign_studenti_cursuri, asign_profesori_cursuri\n" +
                             "where users.username = studenti.username and studenti.username = asign_studenti_cursuri.username and \n" +
                             "	asign_studenti_cursuri.id_asignare_prof_curs = asign_profesori_cursuri.id_asignare_prof_curs and\n" +
                             "    asign_profesori_cursuri.username = \"" + currentUser.username + "\" and asign_profesori_cursuri.nume_curs = \"" + curs + "\";";
            
            ResultSet rset = stmt.executeQuery(command);
            
            for(int i = 0; rset.next(); i++){
                for(int j = 0; j < 7; j++){
                    queryData[i][j] = String.valueOf(rset.getString(j+1));
                }
            }
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public void updateNoteCatalog(String[] data){
        try{
//data[0] = nume data[1] = prenume data[2] = username data[3] = nota_curs data[4] = nota_seminar data[5] = nota_laborator data[6] = nota_finala data[7] = nume_curs
            double nota_curs, nota_seminar, nota_lab;
            
            nota_curs = Double.parseDouble(data[3]);
            nota_seminar = Double.parseDouble(data[4]);
            nota_lab = Double.parseDouble(data[5]);
            
            Statement stmt = conn.createStatement();
            String command = "update asign_studenti_cursuri, asign_profesori_cursuri, studenti, users\n" +
                             "set asign_studenti_cursuri.nota_curs = " + nota_curs + ",\n" +
                             "	asign_studenti_cursuri.nota_seminar = " + nota_seminar + ",\n" +
                             "    asign_studenti_cursuri.nota_laborator = " + nota_lab + "\n" +
                             "where asign_profesori_cursuri.id_asignare_prof_curs = asign_studenti_cursuri.id_asignare_prof_curs\n" +
                             "	and asign_studenti_cursuri.username = studenti.username and studenti.username = users.username\n" +
                             "    and asign_studenti_cursuri.username = \"" + data[2] + "\" and asign_profesori_cursuri.username = \"" + currentUser.username + "\"\n" +
                             "    and asign_profesori_cursuri.nume_curs = \"" + data[7] + "\";";
            
            stmt.executeUpdate(command);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }
    
    public void parasireActivitateUser(int idActivitate){
        
        try{
            Statement stmt = conn.createStatement();
            
            String command = "delete participanti from participanti, activitate where activitate.id_activ = " + idActivitate + " and participanti.id_activ = activitate.id_activ and participanti.username =\"" + currentUser.username + "\";";
            stmt.executeUpdate(command);
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    public void parasireCursUser(String numeCurs){
        
        try{
            Statement stmt = conn.createStatement();
            
            String command = "delete asign_studenti_cursuri from asign_studenti_cursuri, asign_profesori_cursuri where asign_studenti_cursuri.username = \"" + currentUser.username + "\" and asign_studenti_cursuri.id_asignare_prof_curs = asign_profesori_cursuri.id_asignare_prof_curs and asign_profesori_cursuri.nume_curs =\"" + numeCurs + "\";";
            stmt.executeUpdate(command);
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    public void parasireGrupUser(int idGrup){
        
        try{
            Statement stmt = conn.createStatement();
            
            String command = "delete participanti_grupa from participanti_grupa where participanti_grupa.username = \"" + currentUser.username + "\" and participanti_grupa.id_grupa =" + idGrup + ";";
            stmt.executeUpdate(command);
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    /////       ADMINISTRATOR

    String[][] selectOneUser(String[] data){

// data[0] = nume  data[1] = prenume

        String queryData[][] = new String[1][11];
        try{
            Statement stmt = conn.createStatement();
            String command = "select username, users.password, nume, prenume, nr_contract, CNP, adresa, nr_telefon, email, IBAN from users\n" +
                             "where nume = \"" + data[0] + "\" and prenume = \"" + data[1] + "\";";
            ResultSet rset = stmt.executeQuery(command);
            
           for(int i = 0; rset.next(); i++){
                for(int j = 0; j < 10; j++){
                    queryData[i][j] = String.valueOf(rset.getString(j+1));
                }
            }
            return queryData;   
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    String[][] selectMultipleUsers(String rol){
        String queryData[][] = new String[100][4];
        try{
            Statement stmt = conn.createStatement();
            String command = "select prenume, nume, username from users \n" +
                             "where role = \"" + rol + "\";";
            ResultSet rset = stmt.executeQuery(command);
            
           for(int i = 0; rset.next(); i++){
                for(int j = 0; j < 3; j++){
                    queryData[i][j] = String.valueOf(rset.getString(j+1));
                }
            }
            return queryData;   
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    String[][] selectOneUserUsername(String username){
        String queryData[][] = new String[1][11];
        try{
            Statement stmt = conn.createStatement();
            String command = "select username, users.password, nume, prenume, nr_contract, CNP, adresa, nr_telefon, email, IBAN from users\n" +
                             "where username = \"" + username + "\";";
            ResultSet rset = stmt.executeQuery(command);
            
           for(int i = 0; rset.next(); i++){
                for(int j = 0; j < 10; j++){
                    queryData[i][j] = String.valueOf(rset.getString(j+1));
                }
            }
            return queryData;   
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public void updateDateUser(String[] data){
        try{
//data[0] = username, data[1] = password, data[2] = nume, data[3] = prenume data[4] = nr_contract data[5] = cnp data[6] = adresa data[7] = nrtelefon data[8] = email data[9] = iban

            Statement stmt = conn.createStatement();
            String command ="update users\n" +
                            "set  username = \"" + data[0] + "\",\n" +
                            "  password = \"" + data[1] + "\",\n" +
                            "  nume = \"" + data[2] + "\",\n" +
                            "  prenume = \"" + data[3] + "\",\n" +
                            "  nr_contract = " + data[4] + ",\n" +
                            "  CNP = \"" + data[5] + "\",\n" +
                            "  adresa = \"" + data[6] + "\",\n" +
                            "  nr_telefon = \"" + data[7] + "\",\n" +
                            "  email = \"" + data[8] + "\",\n" +
                            "  IBAN = \"" + data[9] + "\"\n" +
                             "where username = \"" + data[0] + "\";";
            stmt.executeUpdate(command);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    ArrayList<String> getAllCursuri(){
        ArrayList<String> queryData = new ArrayList<String>();
        try{
            Statement stmt = conn.createStatement();  
            String command = " select cursuri.nume_curs\n" +
                             "		from cursuri\n;";
            
            ResultSet rset = stmt.executeQuery(command);
            
            while(rset.next()){
                queryData.add(rset.getString(1));
            }
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    ArrayList<String> getProfCurs(String curs, AdminPanel adminPanel){
        ArrayList<String> queryData = new ArrayList<String>();
        try{
            Statement stmt = conn.createStatement();  
            String command = "select users.nume, users.prenume, users.username from users, profesori, asign_profesori_cursuri\n" +
                             "where nume_curs = \"" + curs + "\" and asign_profesori_cursuri.username = profesori.username and\n" +
                             "	profesori.username = users.username;";
            
            ResultSet rset = stmt.executeQuery(command);
            
            for(int i = 0; rset.next(); i++){;
                String fullName = rset.getString(1) + " " + rset.getString(2);
                queryData.add(fullName);
                String username = rset.getString(3);

                adminPanel.profesorUsername[i] = username;
            }
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    ArrayList<String> getStudentiProfesor(String curs, String username, AdminPanel adminPanel){
        ArrayList<String> queryData = new ArrayList<>();
        try{
            Statement stmt = conn.createStatement();  
            String command = "select users.nume, users.prenume, asign_studenti_cursuri.username, asign_studenti_cursuri.nota_curs, asign_studenti_cursuri.nota_seminar, \n" +
                             "	asign_studenti_cursuri.nota_laborator, asign_studenti_cursuri.nota_finala\n" +
                             "from users, studenti, asign_studenti_cursuri, asign_profesori_cursuri\n" +
                             "where users.username = studenti.username and studenti.username = asign_studenti_cursuri.username and \n" +
                             "	asign_studenti_cursuri.id_asignare_prof_curs = asign_profesori_cursuri.id_asignare_prof_curs and\n" +
                             "    asign_profesori_cursuri.username = \"" + username + "\" and asign_profesori_cursuri.nume_curs = \"" + curs + "\";";
            
            ResultSet rset = stmt.executeQuery(command);
            
            for(int i = 0; rset.next(); i++){
                queryData.add(rset.getString(1) + " " + rset.getString(2));
                adminPanel.studentUsername[i] = rset.getString(3);
            }
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    public void asignareProfesorLaCurs(String[] date){

//date[0] = username, date[1] = nume_curs, date[2] = bool_curs, date[3] = bool_seminar, date[4] = bool_laborator
        try{
            Statement stmt = conn.createStatement();
            
            String command = "insert into asign_profesori_cursuri (username, nume_curs, pondere_curs, pondere_laborator, pondere_seminar, bool_curs, bool_seminar, bool_laborator) values\n" +
                             "(\"" + date[0] + "\", \"" + date[1] + "\", 0, 0, 0, " + date[2] + ", " + date[3] + ", " + date[4] + ")";
          
            stmt.executeUpdate(command);
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void addNewCurs(String[] date){

//date[0] = nume_curs, date[1] = mesaj, date[2] = nr_studenti
        try{
            Statement stmt = conn.createStatement();
            
            String command = "insert into cursuri (nume_curs, descriere, nr_max_participanti) values\n" +
                             "(\"" + date[0] + "\", \"" + date[1] + "\", " + date[2] + ");";
           
            stmt.executeUpdate(command);
            
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void deleteStudentFromCurs(String[] data)
//data[0] = username_student, data[1] = username_profesor, data[2] = nume_curs
    {
        try{
             CallableStatement statement = conn.prepareCall("{call deleteStudentFromCurs(?, ?, ?)}");
             statement.setString("username_student", data[0]);
             statement.setString("username_profesor", data[1]);
             statement.setString("nume_curs_in", data[2]);
             statement.execute();
        }
       catch(SQLException ex){
           ex.printStackTrace();
       }
        
        
    }

    public void deleteProfesorFromCurs(String[] data)
// data[0] = username_profesor, data[0] = nume_curs
    {
        try{
             CallableStatement statement = conn.prepareCall("{call deleteProfesorFromCurs(?, ?)}");
             statement.setString("username_profesor", data[0]);
             statement.setString("nume_curs_in", data[1]);
             statement.execute();
        }
       catch(SQLException ex){
           ex.printStackTrace();
       }
    }

    public void deleteCurs(String curs)
    {
        try{
             CallableStatement statement = conn.prepareCall("{call deleteCurs(?)}");
             statement.setString("nume_curs_in", curs);
             statement.execute();
        }
       catch(SQLException ex){
           ex.printStackTrace();
       }
    }   

    public void deleteUser(String username)
    {
        try{
             CallableStatement statement = conn.prepareCall("{call deleteUser(?)}");
             statement.setString("username_in", username);
             statement.execute();
        }
       catch(SQLException ex){
           ex.printStackTrace();
       }
    }  

    public void asignareStudentLaCurs(String[] data){
// data[0] = username_profesor data[1] = nume_curs, data[2] = username_student
        try{
            Statement stmt = conn.createStatement(); 
            String command = "select id_asignare_prof_curs from asign_profesori_cursuri\n" +
                             "where username = \"" + data[0] + "\" and nume_curs = \"" + data[1] + "\";";
            ResultSet rset = stmt.executeQuery(command);

            int index = 0;
            while(rset.next()){
                index = rset.getInt(1);
            }
            
            Statement stmt2 = conn.createStatement();
            String command2 = "insert into asign_studenti_cursuri (username, id_asignare_prof_curs, nota_finala, nota_laborator, nota_seminar, nota_curs) values\n" +
                              "(\"" + data[2] + "\"," + index + ", 1, 0, 0, 0);";

            stmt2.executeUpdate(command2);
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public void deleteGrupaStudiuAdmin(int idGrupa){
        try{
            String command = "delete from grupa_studiu\n" +
                             "where id_grupa = " + idGrupa + ";";
            PreparedStatement stmt = conn.prepareStatement(command);
            stmt.executeUpdate();
        }
        catch(SQLException ex){
           ex.printStackTrace();
       }
        
    }


//          SUPER ADMINISTRATOR

    ArrayList<String> getProfCursSuper(String curs, SuperAdminPanel superAdminPanel){
        ArrayList<String> queryData = new ArrayList<String>();
        try{
            Statement stmt = conn.createStatement();  
            String command = "select users.nume, users.prenume, users.username from users, profesori, asign_profesori_cursuri\n" +
                             "where nume_curs = \"" + curs + "\" and asign_profesori_cursuri.username = profesori.username and\n" +
                             "	profesori.username = users.username;";
            
            ResultSet rset = stmt.executeQuery(command);
            
            for(int i = 0; rset.next(); i++){;
                String fullName = rset.getString(1) + " " + rset.getString(2);
                queryData.add(fullName);
                String username = rset.getString(3);

                superAdminPanel.profesorUsername[i] = username;
            }
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }

    ArrayList<String> getStudentiProfesorSuper(String curs, String username, SuperAdminPanel superAdminPanel){
        ArrayList<String> queryData = new ArrayList<>();
        try{
            Statement stmt = conn.createStatement();  
            String command = "select users.nume, users.prenume, asign_studenti_cursuri.username, asign_studenti_cursuri.nota_curs, asign_studenti_cursuri.nota_seminar, \n" +
                             "	asign_studenti_cursuri.nota_laborator, asign_studenti_cursuri.nota_finala\n" +
                             "from users, studenti, asign_studenti_cursuri, asign_profesori_cursuri\n" +
                             "where users.username = studenti.username and studenti.username = asign_studenti_cursuri.username and \n" +
                             "	asign_studenti_cursuri.id_asignare_prof_curs = asign_profesori_cursuri.id_asignare_prof_curs and\n" +
                             "    asign_profesori_cursuri.username = \"" + username + "\" and asign_profesori_cursuri.nume_curs = \"" + curs + "\";";
            
            ResultSet rset = stmt.executeQuery(command);
            
            for(int i = 0; rset.next(); i++){
                queryData.add(rset.getString(1) + " " + rset.getString(2));
                superAdminPanel.studentUsername[i] = rset.getString(3);
            }
            return queryData;
        }
        catch(SQLException ex){
            ex.printStackTrace();
            return null;
        }
    }
    
}

    



