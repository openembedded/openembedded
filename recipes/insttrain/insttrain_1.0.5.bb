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

