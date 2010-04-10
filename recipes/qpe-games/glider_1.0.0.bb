DESCRIPTION = "Glider"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Robert Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Glider.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/glider_V1.0.0.tar.gz \
           file://Makefile.patch;patch=1 \
	   file://glider.patch;patch=1"

PV = "1.0.0"
S = "${WORKDIR}/glider_V${PV}"

APPNAME = "glider"
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

SRC_URI[md5sum] = "78fe56143bab9a7df232fa15e35a54a6"
SRC_URI[sha256sum] = "972da0f1c35df459b99b24f5bbed5ddec150b714540e2254b6b37035117167ed"
