SECTION = "console/utils"
DESCRIPTION = "GPS data converter"
DEPENDS = "expat"
HOMEPAGE = "http://gpsbabel.sf.net"
LICENSE = "GPL"
MAINTAINER = "Patrick Ohly <patrick.ohly@gmx.de>"

SRC_URI = "${SOURCEFORGE_MIRROR}/gpsbabel/gpsbabel-${PV}.tar.gz"

inherit autotools pkgconfig

do_compile () {
        oe_runmake EXTRA_CFLAGS="-I${STAGING_INCDIR} -L${STAGING_LIBDIR}" INHIBIT_USB=-DNO_USB LIBUSB=
}

do_install () {
        install -d ${D}${bindir}
        install -m 0744 gpsbabel ${D}${bindir}
}
