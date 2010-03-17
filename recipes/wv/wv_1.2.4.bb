DESCRIPTION = "Programs for accessing Microsoft Word documents"
HOMEPAGE = "http://wvware.sourceforge.net/"
LICENSE = "GPLv2"
DEPENDS = "libgsf glib-2.0"
PR = "r4"

SRC_URI = "${SOURCEFORGE_MIRROR}/wvware/wv-${PV}.tar.gz;name=src \
           file://pkgconfig.patch;patch=1"
SRC_URI[src.md5sum] = "c1861c560491f121e12917fa76970ac5"
SRC_URI[src.sha256sum] = "673109910e22d4cf94cc8be4dcb9a0c41b5fbdb1736d4b7bdc7778894d57c2d6"


inherit autotools pkgconfig

S = "${WORKDIR}/${PN}-${PV}"

EXTRA_OECONF = ""

do_stage () {
	autotools_stage_all
}

do_compile () {
	oe_runmake -f GNUmakefile 
}
