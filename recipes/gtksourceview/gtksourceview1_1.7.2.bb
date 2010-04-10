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

SRC_URI[md5sum] = "a56ea78c74fe93a604357d7c555af0e5"
SRC_URI[sha256sum] = "38c238ec57bf22023bbc50f70ecbaee8c06b817b9e11f1a3a0ae7faf95cc1f26"
