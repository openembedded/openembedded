DESCRIPTION = "ulseAudio Volume Control (pavucontrol) is a simple GTK based volume control tool ("mixer") for the PulseAudio sound server."
LICENSE = "GPLv2"
DEPENDS = "libglademm libcanberra gtk+ libnotify gconf pulseaudio"

inherit gnome

SRC_URI = "http://0pointer.de/lennart/projects/${PN}/${PN}-${PV}.tar.gz"


