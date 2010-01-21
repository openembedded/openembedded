DESCRIPTION = "A dead simple calculator. It's advantage is that it's elementary-themed"
HOMEPAGE = "http://github.com/spaetz/calc"
AUTHOR = "Sebastian Spaeth <Sebastian@SSpaeth.de>"
SHR_RELEASE ?= "shr"
LICENSE  = "MIT"
RDEPENDS = "python-elementary python python-edbus"
SECTION = "x11/application"
SRCREV ?= "1c17792094eb"
PV = "0.0.1+gitr${SRCREV}"
PR = "r1"

DEFAULT_PREFERENCE = "-1"

SRC_URI = "git://github.com/spaetz/calc.git;protocol=http;branch=master"
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
