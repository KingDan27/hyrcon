This is a fork of the original project. due to it not being maintained for 9months at this point i will be maintaining this version everything below this line is the original authors words.


# HyRCON Mod

This mod runs a TCP server that listens for commands from external HyRCON/Source RCON clients to run in the server console, allowing easier commands in headless containerized deployments.

## Configuration

When you first add the mod to your server and start it, a new directory will get created containing a `config.yml.example` if you rename this file to `config.yml` or copy it to the new name, and change the options to fit your needs it will use the config file over environment variables.

This plugin can also read configuration elements directly from the process environment variables for use in things like docker, you can configure this mod with the following variables at server startup.

- `HYRCON_ENABLED` / `RCON_ENABLED`: Enables or disables the HyRCON server. Defaults to `true`.
- `HYRCON_BIND` / `RCON_BIND`: Optional combined bind address in `host:port` (or `[ipv6]:port`) form. Defaults to `0.0.0.0:25575`.
- `HYRCON_HOST` / `RCON_HOST`: Host fallback when no bind address is set. Defaults to `0.0.0.0`.
- `HYRCON_PORT` / `RCON_PORT`: Port fallback when no bind address is set. Defaults to `25575`.
- `HYRCON_PROTOCOL` / `RCON_PROTOCOL`: Chooses the remote console protocol to expose. Use `hyrcon` for the legacy line-based protocol or `source` for Source-compatible RCON. Defaults to `source`.
- `HYRCON_PASSWORD` / `RCON_PASSWORD`: Password required for client authentication. Defaults to `changeme`.

## Connecting to the HyRCON Server

Any tool that can connect to a Source-compatible RCON server will work (the default `source` protocol). Set `HYRCON_PROTOCOL=hyrcon` for the legacy line-based protocol. Report problems on the [issue tracker](https://github.com/KingDan27/hyrcon/issues).

## Building

Requires JDK 25. The plugin version comes from `src/main/resources/manifest.json`.

```
./gradlew build
```

The jar is written to `build/libs/HyRCON-<version>.jar`. Publishing a GitHub release builds and attaches the jar automatically.

## Credits

Originally created by [Dustin Rouillard](https://github.com/dustinrouillard/hyrcon) and now maintained by Daniel L. Licensed under MIT.
