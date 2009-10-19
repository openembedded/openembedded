DESCRIPTION = "XDG Sound Theme, for generating event sounds on free desktops."
LICENSE = "LGPL"
DEPENDS = "gtk+ pulseaudio alsa-lib gstreamer"

inherit gnome

SRC_URI = "http://cgit.freedesktop.org/sound-theme-freedesktop/snapshot/sound-theme-freedesktop-${PV}.tar.bz2"

