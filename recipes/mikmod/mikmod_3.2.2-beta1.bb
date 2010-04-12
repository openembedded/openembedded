DESCRIPTION = "A module player based on libmikmod."
SECTION = "console/multimedia"
HOMEPAGE = "http://mikmod.raphnet.net"
DEPENDS = "ncurses libmikmod"
PR = "r1"
LICENSE = "GPL"
SRC_URI = "http://mikmod.raphnet.net/files/mikmod-${PV}.tar.bz2 \
           file://m4.patch;patch=1"

inherit autotools

LDFLAGS_append = " -lm"

SRC_URI[md5sum] = "006378681d520fa8ee1dacca965bbd3c"
SRC_URI[sha256sum] = "0e760acb85584ea3e828989c5588f827f0dd845d3dd6948e2aea12bb6278651d"
