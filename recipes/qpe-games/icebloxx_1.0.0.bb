DESCRIPTION = "IceBloxx"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Robert Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-IceBloxx.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/icebloxx_V1.0.0.tar.gz \
           file://Makefile.patch;patch=1 \
	   file://icebloxx.patch;patch=1"

PV = "1.0.0"
S = "${WORKDIR}/icebloxx_V${PV}"

APPNAME = "icebloxx"
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

SRC_URI[md5sum] = "f134dc7324525cd41aa0096072a25449"
SRC_URI[sha256sum] = "13a3c3dc16eb6aaa3a5854a80633f4b047a9396cfb92a30c910b460492fe8f26"
