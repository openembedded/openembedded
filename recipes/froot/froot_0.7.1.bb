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

SRC_URI[md5sum] = "ac310580a6a54b692b977e11a0e80242"
SRC_URI[sha256sum] = "210a55754c4ff0fa4143c22334a22bb2768f0c8ded2f6efa60144ea1b0abed6a"
