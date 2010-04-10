DESCRIPTION = "ISC Internet Domain Name Server"
SECTION = "console/network"
HOMEPAGE = "http://www.isc.org/sw/bind/"
LICENSE = "BSD"
PR = "r0"

DEPENDS = "openssl"

SRC_URI = "ftp://ftp.isc.org/isc/bind9/${PV}/${PN}-${PV}.tar.gz \
	   file://conf.patch;patch=1 \
	   file://configure.in.patch;patch=1 \
	   "

EXTRA_OECONF = " --enable-ipv6=no --with-randomdev=/dev/random --disable-threads --sysconfdir=/etc/bind --localstatedir=/var --prefix=/usr --disable-devpoll --disable-epoll"
inherit autotools update-rc.d

INITSCRIPT_NAME = "bind"
INITSCRIPT_PARAMS = "defaults"

PARALLEL_MAKE = ""

PACKAGES_prepend = "${PN}-utils "
FILES_${PN}-utils = "${bindir}/host ${bindir}/dig ${bindir}/nslookup"
FILES_${PN}-dev += "${bindir}/isc-config.h"

do_install_append() {
	install -d "${D}/etc/bind"
	install -d "${D}/etc/init.d"
	install -m 644 ${S}/conf/* "${D}/etc/bind"
	install -m 755 "${S}/init.d" "${D}/etc/init.d/bind"
}

CONFFILES_${PN} = " \
	${sysconfdir}/bind/named.conf \
	${sysconfdir}/bind/named.conf.local \
	${sysconfdir}/bind/named.conf.options \
	${sysconfdir}/bind/db.0 \
	${sysconfdir}/bind/db.127 \
	${sysconfdir}/bind/db.empty \
	${sysconfdir}/bind/db.local \
	${sysconfdir}/bind/db.root \
	"

SRC_URI[md5sum] = "58ea86efa5d20ffc282ef2e1690dc484"
SRC_URI[sha256sum] = "275f4d19b8af8bbc93eda9d8532c21d32cd30195db82f15f10916c02416f9f03"
