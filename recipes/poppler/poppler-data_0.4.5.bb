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

SRC_URI[md5sum] = "448dd7c5077570e340340706cef931aa"
SRC_URI[sha256sum] = "3190bc457bafe4b158f79a08e8a3f1824031ec12acefc359e68e0f04da0f70fd"
