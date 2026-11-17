# Angry Goose — NeoForge 26.3

Minecraft **26.3** / NeoForge **26.3.0.x** mod.

## What it does

- Every time a **player hits a chicken**, an **angry goose** spawns nearby.
- The goose chases and attacks the player (~1.5 hearts damage).
- Right-click the goose while holding **cod, salmon, tropical fish, or pufferfish** to feed it.
- After being fed, the goose stops attacking and despawns after a short time.

## Requirements

- **Java 25**
- **Minecraft 26.3**
- **NeoForge 26.3.0.x** (project defaults to `26.3.0.103`)

## Build

```bash
./gradlew build
```

Output jar: `build/libs/angrygoose-1.0.0.jar`

## Dev run

```bash
./gradlew runClient
```

## Install

1. Install NeoForge 26.3 for Minecraft 26.3.
2. Drop `angrygoose-1.0.0.jar` into your `mods` folder.
3. Launch the game.

## Notes

- The goose reuses the vanilla chicken model with a simple white/orange texture.
- Spawn egg is registered as `angrygoose:goose_spawn_egg`.
- If API method names shifted slightly in your exact NeoForge build (e.g. damage events or spawn egg constructor), adjust imports against the MDK sources for that build.
