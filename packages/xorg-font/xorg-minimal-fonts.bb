HOMEPAGE = "http://www.x.org"
SECTION = "x11/fonts"
LICENSE = "MIT-X"

PR = "r1"

SRC_URI = "file://misc"

do_install() {
	install -d ${D}/${datadir}/fonts/X11/misc
	install -m 0644 ${WORKDIR}/misc/* ${D}/${datadir}/fonts/X11/misc/
	install -d ${D}/${libdir}/X11
	ln -sf ${datadir}/fonts/X11/ ${D}/${libdir}/X11/fonts -s

}

PACKAGE_ARCH = "all"
FILES_${PN} = "${libdir}/X11/ ${datadir}/fonts/X11/"
