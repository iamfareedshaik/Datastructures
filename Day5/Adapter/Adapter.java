interface MediaPlayer{
    void play(String filename);
}

class VlcPlayer implements MediaPlayer{
    void play(String filename){
        System.out.print("playing VLC" + filename);
    }
}

class Mp4 implements MediaPlayer{
    void play(String filename){
        System.out.print("playing Mp4" + filename);
    }
}

class MediaAdapter implements MediaPlayer{
    private MediaPlayer mediaplayer;

    public MediaAdapter(Strinf audioType){
        if(audioType.equalsIgnoreCase("vlc")){
            mediaplayer = new VlcPlayer();
        }
        else{
            mediaplayer = new Mp4();
        }
    }

    public void play(String filename){
        if(mediaplayer != null){
            mediaplayer.play(filename);
        }
    }
}

class AudioPlayer implements MediaPlayer{
    private MediaAdapter mediaAdapter;

    public void play(String filename){
        if(filename.endsWith(".mp4")){
            System.out.print("playing mp4" + filename);
        }else{
            mediaAdapter = new MediaAdapter(filename);
        }
    }
}


class Adapter{
    public static void main(String args[]){
        MediaPlayer audioplayer = new AudioPlayer();
        audioplayer.play("song.mp3");
    }
}