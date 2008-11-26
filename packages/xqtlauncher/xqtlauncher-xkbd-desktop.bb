DESCRIPTION = "xqtlauncher integrates X/Qt2 nicely into opie. You can launch applications with it from opies menue"
HOMEPAGE = "http://angstrom-distribution.org/"
LICENSE = "GPL"
PR = "r0"

RDEPENDS = "xkbd xqtlauncher"

SRC_URI = "file://xkbd.desktop"
        
do_install() {
	cd ${WORKDIR}
	install -d ${D}${bindir}
	install -d ${D}${palmtopdir}/apps/XQt2/
	install -m 0644 xkbd.desktop ${D}${palmtopdir}/apps/XQt2
	ln -sf   ${bindir}/xqtlauncher  ${D}${bindir}/runxkbd
}

FILES_${PN} += "${palmtopdir}/apps/XQt2 \
	${palmtopdir}/apps/XQt2/xkbd.desktop "
