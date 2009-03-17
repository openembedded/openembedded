DESCRIPTION = "DBus-enabled dhcp client"
HOMEPAGE = "http://people.redhat.com/jvdias/dhcdbd/"
SECTION = "net"
LICENSE = "GPL"
DEPENDS = "dbus"

SRC_URI = "https://fedorahosted.org/releases/d/h/dhcdbd/dhcdbd-${PV}.tar.bz2 \
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
