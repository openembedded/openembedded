DESCRIPTION = "Portable C library for multiline text editing"
HOMEPAGE = "http://projects.gnome.org/gtksourceview/"
LICENSE = "LGPL"
DEPENDS = "gtk+ libgnomeprint"
PR = "r1"
PNAME = "gtksourceview"

S = "${WORKDIR}/${PNAME}-${PV}"

inherit gnome pkgconfig

# overrule SRC_URI from gnome.conf
SRC_URI = "${GNOME_MIRROR}/${PNAME}/${@gnome_verdir("${PV}")}/${PNAME}-${PV}.tar.bz2"

do_stage() {
autotools_stage_all
}

FILES_${PN} += " ${datadir}/gtksourceview-2.0"

