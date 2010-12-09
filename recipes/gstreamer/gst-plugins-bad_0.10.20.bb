require gst-plugins.inc

SRC_URI[archive.md5sum] = "7c84766f6d24f41ba90c3f6141012ab8"
SRC_URI[archive.sha256sum] = "1031dff866df976a957f34039addbab4c0753406299a275f4cf1780e1dbe2a90"

DEPENDS += "orc-native orc libcdaudio gst-plugins-base openssl directfb libmodplug librsvg"

PR = "${INC_PR}.2"

# We don't have vdpau headers in OE and it creates crosscompile badness.
# Also, mpeg2enc and mplex from mjpegtools don't build, because of AC_TRY_RUN.
EXTRA_OECONF += " \
        --disable-mpeg2enc \
        --disable-mplex \
        --disable-vdpau \
"
