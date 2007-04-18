LICENSE = "GPL"
SECTION = "x11/gnome"
PR = "r1"
DESCRIPTION = "GNOME library for reading .desktop files"
inherit gnome pkgconfig

DEPENDS = "gnome-common gnome-doc-utils libgnomeui"

SRC_URI += "file://scrollkeeper.patch;patch=1"

EXTRA_OECONF = "--disable-scrollkeeper"
EXTRA_AUTORECONF = "-I ${STAGING_DIR}/${HOST_SYS}/share/aclocal/gnome2-macros"

do_configure_prepend () {
	cp ${STAGING_DIR}/${HOST_SYS}/share/gnome-common/data/omf.make ${S}
}

FILES_${PN} += "${datadir}/gnome-about"


do_stage () {
	autotools_stage_all
}
