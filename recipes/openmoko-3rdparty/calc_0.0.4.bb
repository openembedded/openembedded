DESCRIPTION = "A simple calculator which is elementary-themed"
HOMEPAGE = "http://github.com/spaetz/calc"
AUTHOR = "Sebastian Spaeth <Sebastian@SSpaeth.de>"
LICENSE  = "MIT"
RDEPENDS = "python-elementary python python-edbus"
SECTION = "x11/application"
PR = "r0"


SRC_URI = "git://github.com/spaetz/calc.git;protocol=http;branch=master;tag=${PV}"
S = "${WORKDIR}/git"

do_install(){
        install -d ${D}${datadir}/applications
        install -m 0644 ${S}/data/elementary-calculator.desktop ${D}${datadir}/applications/
        install -d ${D}${datadir}/pixmaps
        install -m 0644 ${S}/data/calculator.png ${D}${datadir}/pixmaps/
        install -d ${D}${bindir}
        install -m 0744 ${S}/calc ${D}${bindir}/
}

FILES_${PN} += "${prefix}/share/pixmaps"
FILES_${PN} += "${prefix}/share/applications"
