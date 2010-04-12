DESCRIPTION = "XDG Sound Theme, for generating event sounds on free desktops."
LICENSE = "LGPL"
DEPENDS = "gtk+ pulseaudio alsa-lib gstreamer"

inherit gnome

SRC_URI = "http://cgit.freedesktop.org/sound-theme-freedesktop/snapshot/sound-theme-freedesktop-${PV}.tar.bz2"


SRC_URI[md5sum] = "b56ccb5b7afbd29434289c29423ee577"
SRC_URI[sha256sum] = "14f56bd90c66cdf651637618a298cf2b8ded72ea0135236ed76d5678ddc65d55"
