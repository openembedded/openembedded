DESCRIPTION = "Simulates any 2 of: DG, CDI for VOR1, CDI for VOR2, ADF, RMI \
while you drag an NDB, 2 VORs and an airplane around in an overhead view."
SECTION = "opie/applications"
LICENSE = "GPL"
APPTYPE = "binary"
APPDESKTOP = "../Qtopia/opt/QtPalmtop/apps/Applications"

inherit opie

SRC_URI = "http://www.Vanille.de/mirror/insttrain-${PV}.tgz \
           file://gcc3.patch;patch=1"
S = "${WORKDIR}/insttrain-${PV}/src"

QMAKE_PROFILES = "rmi.pro"

do_install() {
	install -d ${D}${palmtopdir}/pics/
	install -m 0644 ../Qtopia/opt/QtPalmtop/pics/*.png ${D}${palmtopdir}/pics/
}


SRC_URI[md5sum] = "2cec5b79969d0fc64c510edfe7113319"
SRC_URI[sha256sum] = "2dd29e066dece7062cb30daeedad7e5baa0b5cb993c67ba700ebacd6e0212487"
