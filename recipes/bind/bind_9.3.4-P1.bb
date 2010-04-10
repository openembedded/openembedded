DESCRIPTION = "ISC Internet Domain Name Server"
SECTION = "console/network"
HOMEPAGE = "http://www.isc.org/sw/bind/"
LICENSE = "BSD"
PR = "r0"

DEPENDS = "openssl"

SRC_URI = "ftp://ftp.isc.org/isc/bind9/9.3.4-P1/bind-9.3.4-P1.tar.gz \
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

SRC_URI[md5sum] = "51007c8f185cd5a9b2e57f70073bf25b"
SRC_URI[sha256sum] = "f5cf38954e9b973cda204ff13cfd6d433ac307a8e5c4e7f6d978483becda842c"
