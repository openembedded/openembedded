require gst-plugins.inc

SRC_URI += "file://0001-opencv-update-to-opencv-2.2-api-for-cvHaarDetectObje.patch"

SRC_URI[archive.md5sum] = "f501336ab1d18d2565f47c36ce653a82"
SRC_URI[archive.sha256sum] = "422badacbda37ac33cb446c6751dabcd0b223c308dbb01024a34ded682fa47e3"

DEPENDS += "opencv orc-native orc libcdaudio gst-plugins-base openssl directfb libmodplug librsvg"

PR = "${INC_PR}.0"

# We don't have vdpau headers in OE and it creates crosscompile badness.
# Also, mpeg2enc and mplex from mjpegtools don't build, because of AC_TRY_RUN.
EXTRA_OECONF += " \
        --disable-mpeg2enc \
        --disable-mplex \
        --disable-vdpau \
"
