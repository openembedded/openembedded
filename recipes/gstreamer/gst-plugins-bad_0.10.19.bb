require gst-plugins.inc

SRC_URI[archive.md5sum] = "368f72e2a1c7a6e8fe60394e4315259b"
SRC_URI[archive.sha256sum] = "7b6c49f22caad3b573aee481381355b38ac9f2077f291d9f33a9a808a2568888"

DEPENDS += "orc-native orc libcdaudio gst-plugins-base openssl directfb"

PR = "${INC_PR}.2"

# We don't have vdpau headers in OE and it creates crosscompile badness
EXTRA_OECONF_append = " --disable-vdpau --enable-sdl"
