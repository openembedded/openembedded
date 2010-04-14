SECTION = "console/network"
DESCRIPTION="A user-mode PPPoE client and server suite for Linux"
HOMEPAGE="http://www.roaringpenguin.com/"
LICENSE="GPLv2"

SRC_URI="http://www.roaringpenguin.com/penguin/pppoe/${P}.tar.gz \
	file://rp-pppoe-3.5_configure_in_cross.diff;patch=1;pnum=2 \
	file://rp-pppoe-3.5_libevent_makefile_cross.diff;patch=1;pnum=2 \
	file://rp-pppoe-3.5_no_strip.diff;patch=1;pnum=2"

SRC_URI[md5sum] = "97972f8f8f6a3ab9b7070333a6a29c4b"
SRC_URI[sha256sum] = "f7d200b13a4bd75e623b88e3d762afc5b11a0dffa11b4b16b93f4ffb284b9cbc"

DEPENDS="ppp"

S = "${WORKDIR}/${P}/src"

inherit autotools

do_install() {
	oe_runmake -C ${S} RPM_INSTALL_ROOT=${D} docdir=${docdir} install
}
