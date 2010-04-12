DESCRIPTION = "Mahjongg"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Mario Weilguni, Port by Rober Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Mahjongg.html"


SRC_URI = "http://handhelds.org/~zecke/oe_packages/mahjongg_V1.0.0.tar.gz \
           file://Makefile.patch;patch=1 \
	   file://mahjongg.patch;patch=1"


PV = "1.0.0"
S = "${WORKDIR}/mahjongg_V${PV}"

APPNAME = "mahjongg"
APPTYPE = "binary"
APPDESKTOP = "${S}"


do_compile_prepend() {
	oe_runmake -C images
	oe_runmake -C layouts
	oe_runmake -C tools
}


do_install () {
	install -d ${D}${palmtopdir}/pics/${APPNAME}/
	install -m 0644 ${S}/*.png ${D}${palmtopdir}/pics/${APPNAME}/

}

inherit opie

SRC_URI[md5sum] = "83587af02f53eb222242d0d84380735a"
SRC_URI[sha256sum] = "a059a2b0f438140a3bb1e30f410a28863eec61ebbb90c925209c7a473a89b76b"
