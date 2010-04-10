DEPENDS = "openssl"
RPEDENDS = ""
DESCRIPTION = "ISC Internet Domain Name Server"
PR = "r1"

SRC_URI = "ftp://ftp.isc.org/isc/bind9/9.3.1/bind-9.3.1.tar.gz \
           file://lib_dns_Makefile.in.patch;patch=1 \
	   file://configure.in.patch;patch=1 \
	   file://conf.patch;patch=1 \
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

CONFFILES_${PN} = "${sysconfdir}/bind/named.conf ${sysconfdir}/bind/named.conf.local ${sysconfdir}/bind/named.conf.options ${sysconfdir}/bind/db.0 ${sysconfdir}/bind/db.127 ${sysconfdir}/bind/db.empty ${sysconfdir}/bind/db.local ${sysconfdir}/bind/db.root"

SRC_URI[md5sum] = "9ff3204eea27184ea0722f37e43fc95d"
SRC_URI[sha256sum] = "9a9411115338d2554f2e99bc676c2e9a381a8d649bf9bd9c0b2ffa2cf74b563c"
