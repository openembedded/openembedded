DESCRIPTION = "ulseAudio Volume Control (pavucontrol) is a simple GTK based volume control tool ("mixer") for the PulseAudio sound server."
LICENSE = "GPLv2"
DEPENDS = "libglademm libcanberra gtk+ libnotify gconf pulseaudio"

inherit gnome

SRC_URI = "http://0pointer.de/lennart/projects/${PN}/${PN}-${PV}.tar.gz"



SRC_URI[md5sum] = "ec37148c658fa5110bc991ab17ea82f0"
SRC_URI[sha256sum] = "e0ac5d5a0e936d564785270c6dab756d156c7d24d06a9ab71e1c87362b221447"
