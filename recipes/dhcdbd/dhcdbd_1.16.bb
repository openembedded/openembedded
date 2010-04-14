DESCRIPTION = "DBus-enabled dhcp client"
HOMEPAGE = "http://people.redhat.com/jvdias/dhcdbd/"
SECTION = "net"
LICENSE = "GPL"
DEPENDS = "dbus"

SRC_URI = "https://fedorahosted.org/releases/d/h/dhcdbd/dhcdbd-${PV}.tar.gz \
           file://dhcdbd-1.14-pkgconfig_dbus.patch;patch=1 \
           file://dhcdbd"

do_compile() {
	CC=${TARGET_SYS}-gcc DESTDIR=${prefix} make
}

do_install() {
	DESTDIR=${D} make install
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/dhcdbd ${D}/etc/init.d/
}

FILES_${PN} += "${sysconfdir} ${datadir}/dbus-1 ${base_sbindir}/*"

SRC_URI[md5sum] = "002e9d7d85a2f0e6261b6bf501c53a3e"
SRC_URI[sha256sum] = "f399428e0e191233b4dcead88afbe78a26cc16bd9a47e305f6dd3299e011ef18"
