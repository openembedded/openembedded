DESCRIPTION = "ulseAudio Volume Control (pavucontrol) is a simple GTK based volume control tool ("mixer") for the PulseAudio sound server."
LICENSE = "GPLv2"
DEPENDS = "libglademm libcanberra gtk+ libnotify gconf pulseaudio"

inherit gnome

SRC_URI = "http://0pointer.de/lennart/projects/${PN}/${PN}-${PV}.tar.gz"
SRC_URI[md5sum] = "b966eb31ec7fd6afa0f1ed7d5ba480b3"
SRC_URI[sha256sum] = "7ee96d2ddc28f53e392a1bc51a7316d2a9087ea2ad18e611f6f6725e756a5a3c"

