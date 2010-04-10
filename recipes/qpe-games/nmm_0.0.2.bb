DESCRIPTION = "Nime Mens Morris"
SECTION = "opie/games"
PRIORITY = "optional"
LICENSE = "GPL"
AUTHOR = "Dirk Farin, Port by Rober Ernst"
HOMEPAGE = "http://www.linux-solutions.at/projects/zaurus/games-Nine-Mens-Morris.html"

SRC_URI = "http://handhelds.org/~zecke/oe_packages/nmm_V0.0.2.tar.gz \
           file://Makefile.patch;patch=1 \
	   file://nmm.patch;patch=1"

PV = "0.0.2"
S = "${WORKDIR}/nmm_V${PV}"

APPNAME = "nmm"
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


SRC_URI[md5sum] = "af4c4ad64196f26a245c385a234f462f"
SRC_URI[sha256sum] = "5d6c456b30318cc05b19915aa601ea4c2cf46ddf43a39e33948dea6280ac5395"
