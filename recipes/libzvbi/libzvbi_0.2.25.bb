DESCRIPTION = "The Zapping VBI library, in short ZVBI, provides functions to \
capture and decode VBI data. It is written in plain ANSI C with few dependencies \
on other tools and libraries."
HOMEPAGE = "http://zapping.sourceforge.net/ZVBI/index.html"
LICENSE = "GPL"
SECTION = "libs/multimedia"
DEPENDS = "libpng"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/zapping/zvbi-${PV}.tar.bz2"
S = "${WORKDIR}/zvbi-${PV}"

EXTRA_OECONF = "--without-x"

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}


SRC_URI[md5sum] = "b63c626baf1fc385df04d88bc9628a4a"
SRC_URI[sha256sum] = "fa85c35ae5694e6b1ce0dee920c1ecb93698b66c35717368143560930aedbc13"
