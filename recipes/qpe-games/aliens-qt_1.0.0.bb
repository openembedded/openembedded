DESCRIPTION = "Alien ShootOut"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Bill Kendrick"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Aliens.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/aliens_V1.0.0.tar.gz \
	   file://Makefile.patch;patch=1 \
           file://aliens.patch;patch=1"

PV = "1.0.0"
S = "${WORKDIR}/aliens_V${PV}"

APPNAME = "aliens"
APPTYPE = "binary"
APPDESKTOP = "${S}"

do_compile_prepend () {
	oe_runmake -C images
}

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/

}

inherit opie


SRC_URI[md5sum] = "9d7cde75aecf4b85478c0e47343d4293"
SRC_URI[sha256sum] = "0aa0084a74f912f4002f1c40a815ce62ac13331ec84787a954d8bea06e1c96c5"
