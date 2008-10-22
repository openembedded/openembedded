DESCRIPTION = "Froot is a game like frozen bubbles"
SECTION = "opie/games"
APPNAME = "froot"
APPTYPE = "binary"
APPDESKTOP = "${S}"
LICENSE = "GPL"
PR = "r2"

SRC_URI = "http://www.cs.unc.edu/~scheuerm/froot/froot-${PV}.tar.gz"
S = "${WORKDIR}/froot-${PV}"

inherit opie

do_install() {
    install -d ${D}${palmtopdir}/help/html
    install -d ${D}${palmtopdir}/pics/froot
    install -m 0644 Froot.png ${D}${palmtopdir}/pics/
    install -m 0644 help/html/froot.html ${D}${palmtopdir}/help/html/
    install -m 0644 pics/froot/*.png ${D}${palmtopdir}/pics/froot/
}
