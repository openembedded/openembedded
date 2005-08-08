DESCRIPTION = "Epeg is a small library for handling thumbnails."
SECTION = "e/libs"
LICENSE = "MIT"
DEPENDS = "jpeg"
HOMEPAGE = "http://www.enlightenment.org"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"

SRC_URI = "http://enlightenment.freedesktop.org/files/epeg-${PV}.tar.gz"
S = "${WORKDIR}/epeg-${PV}"

inherit autotools pkgconfig binconfig

headers = "Epeg.h"

do_stage() {
    for i in ${headers}; do
        install -m 0644 ${S}/src/lib/$i ${STAGING_INCDIR}/
    done
    oe_libinstall -C src/lib libepeg ${STAGING_LIBDIR}/
}

PACKAGES = "epeg-dev epeg-doc epeg"
FILES_${PN}-dev += "${bindir}/epeg-config ${bindir}/epeg"
