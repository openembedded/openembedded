DESCRIPTION = "Fish Amusement"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Robert Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Fish.html"



SRC_URI = "http://handhelds.org/~zecke/oe_packages/fish_V1.1.0.tar.gz \
           file://Makefile.patch;patch=1 \
           file://fish.patch;patch=1"

PV = "1.1.0"
S = "${WORKDIR}/fish_V${PV}"

APPNAME = "fish"
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

SRC_URI[md5sum] = "78770f1abce09fbbaa0a46ce8ccc607f"
SRC_URI[sha256sum] = "9d13db38c065d70f48ce70580c7d8cd940d923192c04bc3cb356cc98879b5788"
