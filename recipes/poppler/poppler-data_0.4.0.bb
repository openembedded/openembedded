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


SRC_URI[md5sum] = "6975bf8e9ea2cfb42b9ecdbcc257cf57"
SRC_URI[sha256sum] = "5caf7e10b7b0c6a4e1e753af09be52224e88bb8fbcb47794ad72b99b9e24b109"
