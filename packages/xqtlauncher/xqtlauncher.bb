DESCRIPTION = "xqtlauncher integrates X/Qt2 nicely into opie. You can launch applications with it from opies menue"
HOMEPAGE = "http://angstrom-distribution.org/"
LICENSE = "GPL"
PR = "r0"

RDEPENDS = "xqt2 xorg-minimal-fonts"

SRC_URI = "file://dot.directory \
	file://startxqt \
	file://startxqt-wrapper \
	file://xqtlauncher "
        
do_install() {
	cd ${WORKDIR}
	install -d ${D}${bindir}
	install -m 0755 startxqt startxqt-wrapper xqtlauncher ${D}${bindir}
	install -d ${D}${palmtopdir}/apps/XQt2/
	install -m 0644 dot.directory ${D}${palmtopdir}/apps/XQt2
}

FILES_${PN} += "${palmtopdir}/apps/XQt2 \
	${palmtopdir}/apps/XQt2/.directory "
