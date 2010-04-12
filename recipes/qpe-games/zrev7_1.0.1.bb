DESCRIPTION = "Reversi"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Mario Weilguni"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-ZRev7.html"
PR = "r1"

SRC_URI = "http://handhelds.org/~zecke/oe_packages/zrev7_V1.0.1.tar.gz \
           file://zrev.patch;patch=1"
S = "${WORKDIR}/zrev7_V${PV}"

APPNAME = "zrev7"
APPTYPE = "binary"
APPDESKTOP = "${S}"

inherit opie

do_compile_prepend() {
	oe_runmake -C images
}

do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
}

SRC_URI[md5sum] = "fa339990ee78b0fd1bad994f0b35764c"
SRC_URI[sha256sum] = "bc3487bf3927f7e3ea46cef770724d20e820883f4173eb7f8a1332c51d9b6431"
