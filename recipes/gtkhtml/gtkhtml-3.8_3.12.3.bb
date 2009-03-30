DESCRIPTION = "HTML rendering/editing library"
SECTION = "x11/libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+ gail libbonoboui libgnomeprintui libgnomeui"

SRC_URI = "${GNOME_MIRROR}/gtkhtml/3.12/gtkhtml-${PV}.tar.bz2 \
           file://60_glib-2.15-g-gnuc-function.patch;patch=1"

S = "${WORKDIR}/gtkhtml-${PV}"

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-gtk-doc"

ORBIT_IDL = "${STAGING_BINDIR_NATIVE}/orbit-idl-2"

do_configure_append() {
        find ${S} -name Makefile | xargs sed -i s:'-I$(includedir)':'-I.':g
        find ${S} -name Makefile | xargs sed -i s:'-I${prefix}/include':'-I.':g
        find ${S} -name Makefile | xargs sed -i 's|ORBIT_IDL =.*|ORBIT_IDL = ${ORBIT_IDL}|'
}

do_stage() {
	autotools_stage_all
}

FILES_${PN} += "${datadir}/gtkhtml-3.8"

