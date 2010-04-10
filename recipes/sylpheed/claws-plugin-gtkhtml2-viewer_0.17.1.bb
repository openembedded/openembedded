SECTION = "x11/network"
DESCRIPTION = "Mail user agent plugins"
DEPENDS = "claws-mail gtkhtml2 curl"
LICENSE = "GPL"
PR = "r0"

SRC_URI = "http://www.claws-mail.org/downloads/plugins/gtkhtml2_viewer-${PV}.tar.gz"

inherit autotools pkgconfig

S = "${WORKDIR}/gtkhtml2_viewer-${PV}"

do_configure() {
    gnu-configize
    libtoolize --force
    oe_runconf
}

FILES_${PN} = "${libdir}/claws-mail/plugins/*.so"


SRC_URI[md5sum] = "db9d27569903cf09c89c1e57765d3dcc"
SRC_URI[sha256sum] = "aae832e99a04e49c55b0493684aeb4484dda48b5d9010c6980626dc62d6b6fdc"
