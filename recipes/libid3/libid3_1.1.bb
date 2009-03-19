DESCRIPTION = "libID3 is a small C library to parse ID3 tags. \
It uses as little memory as possible, and has both DOM- and SAX-like models."
SECTION = "libs/multimedia"
LICENSE = "LGPL"

SRC_URI = "http://download.tangent.org/libid3-${PV}.tar.gz"

inherit autotools pkgconfig

do_stage() {
    autotools_stage_all
}

