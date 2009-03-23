DESCRIPTION = "PulseAudio Device Chooser (padevchooser) is a simple GTK tool which registers an icon in the tray area and allows quick access to some features of the PulseAudio sound server"
LICENSE = "GPLv2"
DEPENDS = "gtk+ libnotify gconf pulseaudio"

SRC_URI = "http://0pointer.de/lennart/projects/padevchooser/padevchooser-${PV}.tar.gz"

inherit autotools


