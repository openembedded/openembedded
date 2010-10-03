DESCRIPTION = "evopedia is an offline Wikipedia viewer "
AUTHOR = "Christian Reitwießner"
HOMEPAGE = "http://www.reitwiessner.de/openmoko/evopedia.html"
PRIORITY = "optional"
LICENSE = "GPL"
RRECOMMENDS_${PN} = "midori"
RRECOMMENDS_${PN}_shr = "eve"

PV = "0.4.0+gitr${SRCPV}"

SRC_URI = "git://gitorious.org/evopedia/evopedia.git;protocol=git;branch=master"

SRCREV = "f5d159c75106680a8b39137ad100d7e3a531f0b2"
S = "${WORKDIR}/git"

inherit qt4x11

EXTRA_QMAKEVARS_PRE += " PREFIX=/usr"

FILES_${PN}-dbg += "${bindir}/.debug"

do_install() {
       oe_runmake install INSTALL_ROOT=${D}
}
