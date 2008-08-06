HOMEPAGE = "http://www.x.org"
SECTION = "x11/fonts"
LICENSE = "MIT-X"

SRC_URI = "file://misc"

do_install() {
	install -d ${D}/${datadir}/fonts/X11/misc
	install -m 0644 ${WORKDIR}/misc/* ${D}/${datadir}/fonts/X11/misc/
}

PACKAGE_ARCH = "all"
FILES_${PN} = "${datadir}/fonts/X11/"
