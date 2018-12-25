package visual.util.process_blocker;

import java.awt.Frame;

import visual.util.WindowUtils;
import visual.util.process_blocker.view.DlgView;

public class ProcessBlocker {
    private static ProcessBlocker singleton = new ProcessBlocker();
    private static Frame parentFrame;

    public static ProcessBlocker instance(){
        return singleton;
    }
    public static void initialize(Frame parentFramePar){
        parentFrame = parentFramePar;
    }

    ////////////////// CLASS SUPPORT //////////////////
 //   private DlgMensaje dlgView;
    private ViewDisplayer viewDisplayer = new ViewDisplayer();
    
    public void showMessage(String message){
        if (viewDisplayer.running) {
            viewDisplayer.dlgView.setTitle(message); //JCM agregado
            return;
        }
        viewDisplayer.init(message);
        new Thread(viewDisplayer).start();
        viewDisplayer.waitUntilWindowShow();
    }
    public void removeMessage(){
        viewDisplayer.stopRun();
    }
    private class ViewDisplayer implements Runnable{
        public boolean running = false;
        private DlgView dlgView;

        public void init(String message) {
            if (parentFrame!=null)
                dlgView = new DlgView(parentFrame, "[Programa de Gestión de Alumnos]  Por favor espere.", true);
            else
                dlgView = new DlgView();
            //Util.locateOnScreenCenter(dlgView);
            WindowUtils.centerDialogInParent(dlgView);

            dlgView.getLblMessage().setText(message);
            running = false;
        }

        public void run() {
            running = true; // not completely thread safe but is the best aproach one can do
            //dlgView.setModal(false);
            dlgView.setVisible(true);
            //dlgView.setModal(true);
        }

        public void stopRun() {
            if(dlgView!=null){
                dlgView.setVisible(false);
                dlgView.dispose();
            }
            running=false;
        }
        public void waitUntilWindowShow() {
            // wait to window is show
            while (!running)
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {}
            //try {
            //    Thread.sleep(3*1000);
            //} catch (InterruptedException e) {}
        }

    }
//    public static void main(String a[]) throws InterruptedException {
//        instance().showMessage("sasas");
//        Thread.sleep(3*1000);
//        instance().removeMessage();
//        FrmConvenios frmConvenios = new FrmConvenios();
//        Thread.sleep(1*1000);
//
//        instance().showMessage("sasasssss");
//        Thread.sleep(3*1000);
//        instance().removeMessage();
//        Thread.sleep(3*1000);
//        instance().showMessage("sasasssss");
//        Thread.sleep(3*1000);
//        instance().removeMessage();
//    }
}