DESCRIPTION = "HTML rendering/editing library"
SECTION = "x11/libs"
PRIORITY = "optional"
LICENSE = "GPL"

inherit gnome

S = "${WORKDIR}/gtkhtml-${PV}"

EXTRA_OECONF = "--disable-gtk-doc"

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
        find ${S} -name Makefile | xargs sed -i s:'-I${prefix}/include':'-I.':g
}
