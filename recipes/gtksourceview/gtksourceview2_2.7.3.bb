DESCRIPTION = "Portable C library for multiline text editing"
HOMEPAGE = "http://projects.gnome.org/gtksourceview/"
LICENSE = "LGPL"
DEPENDS = "gtk+ libgnomeprint"

PR = "r1"

PNAME = "gtksourceview"

S = "${WORKDIR}/${PNAME}-${PV}"

inherit gnome pkgconfig lib_package

# overrule SRC_URI from gnome.conf
SRC_URI = "${GNOME_MIRROR}/${PNAME}/${@gnome_verdir("${PV}")}/${PNAME}-${PV}.tar.bz2"

do_configure_prepend() {
	sed -i -e s:docs::g ${S}/Makefile.am
}

do_stage() {
	autotools_stage_all
}

FILES_${PN} += " ${datadir}/gtksourceview-2.0"


SRC_URI[md5sum] = "ea30aecfbd55ebf40c6cf5a0f254f9ba"
SRC_URI[sha256sum] = "bf4c6285683a70addedd3ae6b9d4b450d928be497834272c4cd705471333f1ec"
