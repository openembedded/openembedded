SRC_URI = "http://www.angstrom-distribution.org/unstable/sources/xkbd-${PV}-CVS.tar.gz \
           file://libtool-lossage.patch \
	   file://fix-equalsign.patch \
	   file://fix-circumkey.patch \
	   file://add-default-common-slides.patch \
	   file://differentiate-desktop-name.patch \
	   file://xkbd-0.8.15-fix-geometry.patch \
	   file://xkbd.png"
LICENSE = "GPL"
PR = "r5"

SECTION = "x11"
DEPENDS = "libxpm libxtst libxft"

inherit autotools

do_install_append() {
	install -d ${D}${datadir}/pixmaps
	install -m 0644 ${WORKDIR}/xkbd.png ${D}${datadir}/pixmaps/
}


SRC_URI[md5sum] = "56271e79da101bbc31e5384a9499853d"
SRC_URI[sha256sum] = "04bc9f6ea423f7fbd9150767cef6a1bc5c70c545eeb923539a93a549905457de"
