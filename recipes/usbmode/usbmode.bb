DESCRIPTION = "Freerunner USB Mode Control Program"
RDEPENDS += "python python-pygtk"
LICENSE = "GPL"
HOMEPAGE = http://techiem2.net/index.php?/archives/10-Freerunner-USB-Mode-Control-Program.html"
SECTION = "x11/games"
PV = "1.0"

SRC_URI = "\
	http://www.techiem2.net/files/usbmode.tar.gz \
"

S = "${WORKDIR}"

do_install() {
	install -d ${D}${bindir}
	install -d ${D}${datadir}/applications
	install -m 0644 ${WORKDIR}/usbmode.desktop ${D}${datadir}/applications
	install -m 0755 ${S}/usbmode.py ${D}${bindir}/usbmode.py
}

FILES_${PN} = "${bindir}/usbmode.py ${datadir}/applications/usbmode.desktop"

