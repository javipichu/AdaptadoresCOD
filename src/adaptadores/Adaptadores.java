package adaptadores;

public class Adaptadores {

    public static void main(String[] args) {
        MediaPlayer player = new MP3();
        player.play("file.mp3");
        player = new FormatAdapter(new MP4());
        player.play("file.mp4");
        player = new FormatAdapter(new VLC());
        player.play("file.avi");
    }

    private static class FormatAdapter implements MediaPlayer {

        private MediaPackage mediaPak;
        private MediaDivX mediaDivX;
        private MediaPlayer mediaPlayer;

        public FormatAdapter(MediaPackage m) {
            mediaPak = m;
            mediaDivX = null;
            mediaPlayer =null;
        }
        public FormatAdapter(MediaDivX m) {
            mediaDivX = m;
            mediaPak = null;
            mediaPlayer = null;
        }
        public FormatAdapter(MediaPlayer m) {
            mediaPlayer = m;
            mediaPak = null;
            mediaDivX = null;
            
        }
        
        

        @Override
        public void play(String filename) {
            System.out.print("Using Adapter --> ");
            if(mediaPak != null){
            mediaPak.playFile(filename);}
            
            if(mediaDivX != null){
            mediaDivX.playFilm(filename);}
             if(mediaPlayer!= null){
            mediaPlayer.play(filename);}
        }
    }
}