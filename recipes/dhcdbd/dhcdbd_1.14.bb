DESCRIPTION = "DBus-enabled dhcp client"
HOMEPAGE = "http://people.redhat.com/jvdias/dhcdbd/"
SECTION = "net"
LICENSE = "GPL"
DEPENDS = "dbus"

PR = "r1"

SRC_URI = "https://fedorahosted.org/releases/d/h/dhcdbd/dhcdbd-${PV}.tar.bz2 \
           file://dhcdbd-1.14-pkgconfig_dbus.patch;patch=1 \
           file://dbus-api-fix.patch;patch=1 \
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

SRC_URI[md5sum] = "1180dee7a51a4384d55768650634cf93"
SRC_URI[sha256sum] = "e5facfcab28377d32fd4c70aa1fe0820d3dba4abdfc48bd15eda712c8815e505"
