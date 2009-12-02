DESCRIPTION = "PulseAudio Preferences (paprefs) is a simple GTK based configuration dialog for the PulseAudio sound server"
LICENSE = "GPLv2"
DEPENDS = "gconfmm libglademm libcanberra gtk+ libnotify gconf pulseaudio"

inherit gnome

SRC_URI = "http://0pointer.de/lennart/projects/${PN}/${PN}-${PV}.tar.gz"


