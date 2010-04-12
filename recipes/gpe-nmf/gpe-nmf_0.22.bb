require gpe-nmf.inc

RDEPENDS += "gst-plugin-decodebin"
RRECOMMENDS += "gst-plugin-ivorbis gst-plugin-tcp"
PR = "r3"

SRC_URI += " file://playlist-segfault.patch;patch=1;pnum=0 \
             file://fix-includepath.patch;patch=1"

do_compile() {
        oe_runmake PREFIX=${prefix} GST_VERSION="0.8"
}

SRC_URI[md5sum] = "c19ffe9fc19508c4b4fe82d322e926e2"
SRC_URI[sha256sum] = "5ec530b1b0dc1b68d455106cf5b40e82bbda92448171a56c13b939e06701ac21"
