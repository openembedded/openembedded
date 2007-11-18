LICENSE = "GPL"
SECTION = "x11/gnome"
PR = "r2"
DESCRIPTION = "GNOME library for reading .desktop files"
inherit gnome pkgconfig

DEPENDS = "gnome-common gnome-doc-utils gnome-vfs libgnomeui"

SRC_URI += "file://scrollkeeper.patch;patch=1 \
            file://no-desktop-docs.patch;patch=1;pnum=0"

EXTRA_OECONF = "--disable-scrollkeeper"

do_configure_prepend () {
	cp ${STAGING_DATADIR}/gnome-common/data/omf.make ${S}
}

FILES_${PN} += "${datadir}/gnome-about"


do_stage () {
	autotools_stage_all
}
