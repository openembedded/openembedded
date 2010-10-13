DESCRIPTION = "A module player based on libmikmod."
HOMEPAGE = "http://mikmod.raphnet.net"
SECTION = "console/multimedia"
LICENSE = "GPL"
DEPENDS = "ncurses libmikmod"
PR = "r4"

SRC_URI = "http://mikmod.raphnet.net/files/mikmod-${PV}.tar.bz2 \
           file://m4.patch"

SRC_URI[md5sum] = "006378681d520fa8ee1dacca965bbd3c"
SRC_URI[sha256sum] = "0e760acb85584ea3e828989c5588f827f0dd845d3dd6948e2aea12bb6278651d"

inherit autotools

do_configure_append() {
	for i in $(find ${S} -name "Makefile") ; do
		sed -i -e s:-L${libdir}::g $i
	done
}
