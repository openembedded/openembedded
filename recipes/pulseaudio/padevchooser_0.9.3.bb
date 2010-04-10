DESCRIPTION = "PulseAudio Device Chooser (padevchooser) is a simple GTK tool which registers an icon in the tray area and allows quick access to some features of the PulseAudio sound server"
LICENSE = "GPLv2"
DEPENDS = "gtk+ libnotify gconf pulseaudio"

SRC_URI = "http://0pointer.de/lennart/projects/padevchooser/padevchooser-${PV}.tar.gz"

inherit autotools



SRC_URI[md5sum] = "6a9b52ad349f3fb3d5a3ccdf85958710"
SRC_URI[sha256sum] = "3238f19ea5a3c54efef31e4f86c712232c92704d68c9d2bbef0339ba9b4cb674"
