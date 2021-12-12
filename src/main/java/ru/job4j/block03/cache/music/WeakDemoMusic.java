package ru.job4j.block03.cache.music;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public class WeakDemoMusic  {
    private Map<String, WeakReference<Track>> tracks = new HashMap<String, WeakReference<Track>>();

    private void play(String nameTrack)  {
        Track trackCache = tracks.get(nameTrack).get();
        if (trackCache != null) {
            System.out.println("Воспроизвести трек" + trackCache);
        } else {
            System.out.println("Загрузить трек и воспроизвести");
        }
    }
}
