SECTION = "console/network"
DESCRIPTION="A user-mode PPPoE client and server suite for Linux"
HOMEPAGE="http://www.roaringpenguin.com/"
MAINTAINER = "Bruno Randolf <bruno.randolf@4g-systems.biz>"
LICENSE="GPLv2"

SRC_URI="http://www.roaringpenguin.com/penguin/pppoe/${P}.tar.gz \
	file://rp-pppoe-3.5_configure_in_cross.diff;patch=1;pnum=2 \
	file://rp-pppoe-3.5_libevent_makefile_cross.diff;patch=1;pnum=2 \
	file://rp-pppoe-3.5_no_strip.diff;patch=1;pnum=2"
DEPENDS="ppp"

S = "${WORKDIR}/${P}/src"

inherit autotools

do_install() {
	oe_runmake -C ${S} RPM_INSTALL_ROOT=${D} docdir=${docdir} install
}
