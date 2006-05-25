DESCRIPTION = "libusb is a library to provide userspace \
access to USB devices."
HOMEPAGE = "http://libusb.sf.net"
SECTION = "libs"
LICENSE = "LGPL"
PR = "r0"

SRC_URI = "${SOURCEFORGE_MIRROR}/libusb/libusb-${PV}.tar.gz"
S = "${WORKDIR}/libusb-${PV}"

inherit autotools pkgconfig

PARALLEL_MAKE = ""
EXTRA_OECONF = "--disable-build-docs"

do_stage() {
	oe_libinstall -a -so libusb ${STAGING_LIBDIR}

        install -d ${STAGING_BINDIR}
	install -m 755 ${S}/libusb-config ${STAGING_BINDIR}
	# can we get rid of that? wouldn't a sed statement do as well?
	perl -pi -e 's:\-L${libdir} :-L${STAGING_LIBDIR} :' ${STAGING_BINDIR}/libusb-config

        install -d ${STAGING_INCDIR}/
        for X in usb.h
        do
                install -m 0644 ${S}/$X ${STAGING_INCDIR}/$X
        done
}

