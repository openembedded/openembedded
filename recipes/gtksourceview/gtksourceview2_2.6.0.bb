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


SRC_URI[md5sum] = "dd065ab2e96e51aade949249c5556439"
SRC_URI[sha256sum] = "92ddd976721e26377eaa59fea07707a0caa85eb874500868c1e6fdd9a21fe0dd"
