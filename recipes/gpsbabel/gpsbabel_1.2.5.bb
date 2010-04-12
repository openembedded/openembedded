SECTION = "console/utils"
DESCRIPTION = "GPS data converter"
DEPENDS = "expat virtual/libusb0"
HOMEPAGE = "http://gpsbabel.sf.net"
LICENSE = "GPL"

PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/gpsbabel/gpsbabel-${PV}.tar.gz"

inherit autotools pkgconfig

do_compile () {
        oe_runmake EXTRA_CFLAGS="-I${STAGING_INCDIR} -L${STAGING_LIBDIR}" 
}

do_install () {
        install -d ${D}${bindir}
        install -m 0744 gpsbabel ${D}${bindir}
}

SRC_URI[md5sum] = "cf9f349fec33760c8026c9b12c6f7a9d"
SRC_URI[sha256sum] = "539d5c703799b12f5785286a689fd16f5fe957c2eaf460360e79f5f51d8c132e"
