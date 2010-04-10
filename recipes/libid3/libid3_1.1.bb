DESCRIPTION = "libID3 is a small C library to parse ID3 tags. \
It uses as little memory as possible, and has both DOM- and SAX-like models."
SECTION = "libs/multimedia"
LICENSE = "LGPL"

SRC_URI = "http://download.tangent.org/libid3-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
    autotools_stage_all
}


SRC_URI[md5sum] = "e089e8c8c7276373db0a856c508bd8f9"
SRC_URI[sha256sum] = "117831ba06b255ede3cc318278108d19db972b6365c3d80d374d8f888f834c98"
