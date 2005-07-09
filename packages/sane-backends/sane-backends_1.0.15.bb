MAINTAINER="Oyvind Repvik <nail@nslu2-linux.org>"
DESCRIPTION="Scanner drivers for SANE"
PR="r1"
DEPENDS="jpeg libusb"

SRC_URI="ftp://ftp.sane-project.org/pub/sane/sane-backends-${PV}/sane-backends-${PV}.tar.gz \
	file://sane-plustek.patch;patch=1\
	file://Makefile.in.patch;patch=1"
	
EXTRA_OECONF="--prefix=/usr --sysconfdir=/etc --disable-translations"

inherit autotools

do_install_append() {
	install -m 755 "${S}/tools/.libs/sane-find-scanner" "${D}/${bindir}"
}

PACKAGES = "libsane saned sane-utils"

FILES_libsane = "/usr/lib/sane/*.so.* /usr/lib/lib*.so.* /etc"
PKG_libsane = "libsane"
RCONFLICTS = "sane-backends"
RRECOMMENDS_libsane = "saned sane-utils"

RDEPENDS_saned = "libsane"
FILES_saned = "/usr/sbin/saned"

RDEPENDS_sane-utils = "libsane"
FILES_sane-utils = "/usr/bin"


