DESCRIPTION = "Pairs"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Rober Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Pairs.html"

SRC_URI = "http://handhelds.org/~zecke/oe_packages/pairs_V1.1.1.tar.gz \
           file://pairs.patch;patch=1"

PV = "1.1.1"
S = "${WORKDIR}/pairs_V${PV}"

APPNAME = "pairs"
APPTYPE = "binary"
APPDESKTOP = "${S}"

do_compile_prepend() {
	oe_runmake -C images
}


do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/

}


inherit opie



SRC_URI[md5sum] = "399e794dde87508b4214f1312cd79d06"
SRC_URI[sha256sum] = "7526d8de006817e5c6bc79826f810a15490611dcbd2d4fb9d8e9b9991c7ed506"
