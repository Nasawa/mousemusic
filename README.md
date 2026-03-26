# 🎵 MouseMusic

**Turn your mouse into a musical instrument.** Every pixel on your screen maps to a unique combination of pitch and timbre — move your mouse, make music.

## How It Works

MouseMusic tracks your cursor position and maps it to MIDI output in real time:

- **X axis** → **Pitch** — Moving left/right changes the note (0–127, the full MIDI range)
- **Y axis** → **Instrument** — Moving up/down changes the MIDI program (piano, strings, synth pads, steel drums, and everything in between)

Every position on screen is a unique note played on a unique instrument. Move diagonally and you're shifting pitch *and* timbre simultaneously. Move in circles and you're playing arpeggios across an orchestra.

## The Idea

This was an experiment in **sensory substitution** — using one sense (hearing) to build spatial awareness that normally relies on another (sight). The theory: if the mapping between position and sound is consistent, your brain will eventually internalize it. After enough use, you'd develop an intuitive sense of *where* your cursor is based purely on what you hear.

The same principle shows up in research on sensory augmentation — vibration vests that let deaf people perceive speech, or haptic feedback that creates new spatial senses. The human brain is remarkably plastic; give it a consistent signal and it'll figure out what to do with it.

## Running

Requires Java with `javax.sound.midi` (included in most JDK/JRE distributions).

```bash
# Compile
javac -d out MouseMusic.java Note.java SuperMusic.java SuperSynth.java

# Run
java -cp out MouseMusic.MouseMusic
```

Or, if you have the jar:

```bash
java -jar MouseMusic.jar
```

Move your mouse. Listen. That's it.

## Architecture

| Class | Role |
|-------|------|
| `MouseMusic` | Main loop — polls mouse position, triggers notes |
| `SuperSynth` | MIDI synthesizer wrapper — manages channels, instruments, playback |
| `SuperMusic` | Music theory utilities — note aliases, duration constants |
| `Note` | Data class — pitch, volume, duration |

The `SuperMusic` base class includes a note aliasing system (`c4` → 60, `a3` → 57, etc.) and rhythmic duration constants (`q` for quarter, `h` for half, `w` for whole), suggesting this was part of a larger compositional toolkit.

## History

Written circa 2012–2014 as a college project exploring the intersection of HCI, music, and perception. Uploaded to GitHub in March 2016. The code is a snapshot of that era — Java Swing, raw MIDI, and a 50×50px window that exists solely so you can close the program.

## License

MIT License — see [LICENSE](LICENSE).
