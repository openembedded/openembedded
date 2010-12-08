require gst-plugins.inc

SRC_URI[archive.md5sum] = "7c84766f6d24f41ba90c3f6141012ab8"
SRC_URI[archive.sha256sum] = "1031dff866df976a957f34039addbab4c0753406299a275f4cf1780e1dbe2a90"

DEPENDS += "orc-native orc libcdaudio gst-plugins-base openssl directfb libmodplug librsvg"

PR = "${INC_PR}.1"

# We don't have vdpau headers in OE and it creates crosscompile badness
EXTRA_OECONF_append = " --disable-vdpau --enable-sdl"
