package ru.job4j.block03.cache.music;
import java.lang.ref.SoftReference;

public class SoftDemoMusic {
    private Track track = new Track("track1");
    private SoftReference<Track> softTrack = new SoftReference<>(track);

    private void play(SoftReference<Track> softTrack) {
        Track trackCache = softTrack.get();
        if (trackCache != null) {
            System.out.println("Воспроизвести трек" + trackCache);
        } else {
            System.out.println("Загрузить трек и воспроизвести");
        }
    }
}
