package FilEksempler;



class Skjald extends Thread{

    private String[] strofer;
    private int forsinkelse;
    private int gentagelser;


    public Skjald(String[] strofer, int forsinkelse, int gentagelser){
        super();
        this.strofer = strofer;
        this.forsinkelse = forsinkelse;
        this.gentagelser = gentagelser;
    }

    synchronized private void syngVers(){
        for(int i = 0; i < strofer.length; i++){
            System.out.println(strofer[i]);
            try{
                Thread.sleep(forsinkelse);
            }
            catch (InterruptedException e)
            {}

        }
    }

    public void run(){
        for(int g = 1; g <= gentagelser; g++){
            syngVers();
        }
    } // end run

} // end class Skjald

class Sangkor{

    private static String[] mesterJakob =
            {"MESTER JAKOB, MESTER JAKOB", "SOVER DU, SOVER DU",
                    "HØRER DU EJ KLOKKEN, HØRER DU EJ KLOKKEN",
                    "BIM BAM BUM, BIM BAM BUM"};

    private static String[] gladeJul =
            {"Glade jul, dejlige jul", "Engle daler ned i skjul!",
                    "Hid de flyver med paradisgrønt", "Hvor de ser, hvad for Gud er kønt",
                    "Lønligt iblandt os de går", "Lønligt iblandt os de går"};

    public static void main(String[] args){
        Skjald skjald1 = new Skjald(mesterJakob,500,2);
        Skjald skjald2 = new Skjald(gladeJul,500,2);

        skjald1.start();  skjald2.start();
    }
} // end class Sangkor

