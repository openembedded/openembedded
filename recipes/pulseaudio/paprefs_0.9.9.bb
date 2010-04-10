DESCRIPTION = "PulseAudio Preferences (paprefs) is a simple GTK based configuration dialog for the PulseAudio sound server"
LICENSE = "GPLv2"
DEPENDS = "gconfmm libglademm libcanberra gtk+ libnotify gconf pulseaudio"

inherit gnome

SRC_URI = "http://0pointer.de/lennart/projects/${PN}/${PN}-${PV}.tar.gz"



SRC_URI[md5sum] = "0592ccb28c8f601a8fe3607b64e9f5bc"
SRC_URI[sha256sum] = "1237939f0cea478ecd51452e817e08877e914c919239fcb63aa2471a389769a9"
