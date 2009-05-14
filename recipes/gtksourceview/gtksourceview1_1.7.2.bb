LICENSE = "GPL"

PNAME = "gtksourceview"

DEPENDS = "gtk+ libgnomeprint"

S = "${WORKDIR}/${PNAME}-${PV}"

inherit gnome pkgconfig

# overrule SRC_URI from gnome.conf
SRC_URI = "${GNOME_MIRROR}/${PNAME}/${@gnome_verdir("${PV}")}/${PNAME}-${PV}.tar.bz2"

do_stage() {
autotools_stage_all
}
