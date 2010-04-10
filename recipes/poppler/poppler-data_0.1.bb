DESCRIPTION = "Poppler is a PDF rendering library based on the xpdf-3.0 code base."
LICENSE = "Adobe"
PR = "r1"

SRC_URI = "http://poppler.freedesktop.org/${PN}-${PV}.tar.gz"

do_compile() {
}

do_install() {
	oe_runmake install DESTDIR=${D}
}

FILES_${PN} += "${datadir}"
PACKAGE_ARCH = "all"


SRC_URI[md5sum] = "5c700eb06dda9dafec09cd85225e34d4"
SRC_URI[sha256sum] = "6bd37c49ab4b22c67ab457c531f841968a3acdebbf9361acea7d7275c903dbc5"
