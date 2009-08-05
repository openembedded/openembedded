DESCRIPTION = "The Openobex project is an open source implementation of the \
Object Exchange (OBEX) protocol."
HOMEPAGE = "http://openobex.triq.net"
SECTION = "libs"
PROVIDES = "openobex-apps"
DEPENDS = "virtual/libusb0 bluez-libs"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "http://www.kernel.org/pub/linux/bluetooth/openobex-${PV}.tar.gz \
           file://disable-cable-test.patch;patch=1 \
           file://libusb_crosscompile_check.patch;patch=1"

inherit autotools_stage binconfig pkgconfig

EXTRA_OECONF = "--enable-apps --enable-syslog --enable-dump \
                --with-usb=${STAGING_LIBDIR}/.. --with-bluez=${STAGING_LIBDIR}/.."

do_stage_append() {
	install -d ${STAGING_DATADIR}/aclocal
	install -m 0644 ${S}/openobex.m4 ${STAGING_DATADIR}/aclocal
}

PACKAGES += "openobex-apps"
FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}/openobex-config"
FILES_${PN}-apps = "${bindir}/*"
DEBIAN_NOAUTONAME_${PN}-apps = "1"
