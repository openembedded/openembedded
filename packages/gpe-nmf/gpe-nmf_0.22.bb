require gpe-nmf.inc

RDEPENDS += "gst-plugin-decodebin"
RRECOMMENDS += "gst-plugin-ivorbis gst-plugin-tcp"
PR = "r3"

SRC_URI += " file://playlist-segfault.patch;patch=1;pnum=0 \
             file://fix-includepath.patch;patch=1"

do_compile() {
        oe_runmake PREFIX=${prefix} GST_VERSION="0.8"
}
