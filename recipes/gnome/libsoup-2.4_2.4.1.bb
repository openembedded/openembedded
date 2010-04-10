DESCRIPTION = "An HTTP library implementation in C"
SECTION = "x11/gnome/libs"
LICENSE = "GPL"
DEPENDS = "glib-2.0 gnutls libxml2"

inherit gnome

SRC_URI = "${GNOME_MIRROR}/libsoup/${@gnome_verdir("${PV}")}/libsoup-${PV}.tar.bz2"
S = "${WORKDIR}/libsoup-${PV}"

AUTOTOOLS_STAGE_PKGCONFIG = "1"

do_stage() {
	autotools_stage_all
}

FILES_${PN} = "${libdir}/lib*.so.*"
FILES_${PN}-dev = "${includedir}/ ${libdir}/"
FILES_${PN}-doc = "${datadir}/"

SRC_URI[md5sum] = "d0fc91ccb9da401e9e40d2f4612bdac9"
SRC_URI[sha256sum] = "774094746748fb0c8985210de0994accdc7095c222fba42c5623e2137443b6cd"
