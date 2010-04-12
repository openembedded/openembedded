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

inherit autotools pkgconfig 

do_stage() {
	autotools_stage_all
}



SRC_URI[md5sum] = "a01cbe39a48579ba92582ff75a5e37c2"
SRC_URI[sha256sum] = "a832819915838b364dd19f7f5d8d632b7d0493d8a19e2d011f9b5a3f2e8cf266"
