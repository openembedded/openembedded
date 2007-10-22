DESCRIPTION = "The Openobex project is an open source implementation of the \
Object Exchange (OBEX) protocol."
HOMEPAGE = "http://openobex.triq.net"
SECTION = "libs"
PROVIDES = "openobex-apps"
DEPENDS = "libusb bluez-libs"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/openobex/openobex-${PV}.tar.gz \
           file://disable-cable-test.patch;patch=1 \
           file://libusb_crosscompile_check.patch;patch=1"

inherit autotools binconfig pkgconfig

EXTRA_OECONF = "--enable-apps --enable-syslog --enable-dump \
                --with-usb=${STAGING_LIBDIR}/.. --with-bluez=${STAGING_LIBDIR}/.."

do_stage() {
	autotools_stage_all
}

# how to stop shlibrename from renaming -apps?
PACKAGES += "openobex-apps"
FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev += "${bindir}/openobex-config"
FILES_${PN}-apps = "${bindir}/*"
DEBIAN_NOAUTONAME_${PN}-apps = "1"
