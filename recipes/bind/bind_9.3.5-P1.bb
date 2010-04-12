DESCRIPTION = "ISC Internet Domain Name Server"
SECTION = "console/network"
HOMEPAGE = "http://www.isc.org/sw/bind/"
LICENSE = "BSD"
PR = "r0"

DEPENDS = "openssl"

SRC_URI = "ftp://ftp.isc.org/isc/bind9/9.3.5-P1/bind-9.3.5-P1.tar.gz \
	   file://conf.patch;patch=1 \
	   file://configure.in.patch;patch=1 \
	   file://so_bsdcompat.patch;patch=1 \
	   "

EXTRA_OECONF = " --enable-ipv6=no --with-randomdev=/dev/random --disable-threads --sysconfdir=/etc/bind --localstatedir=/var --prefix=/usr"
inherit autotools update-rc.d

INITSCRIPT_NAME = "bind"
INITSCRIPT_PARAMS = "defaults"

do_install_append() {
	rm "${D}/usr/bin/nslookup"
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

SRC_URI[md5sum] = "1446984f552b18a0ff7db63971a0cb5a"
SRC_URI[sha256sum] = "8bd6b53f5a2c5f0332aaba9a51ef3d7fc55c60f906f0c506e11b6600ed82a90b"
