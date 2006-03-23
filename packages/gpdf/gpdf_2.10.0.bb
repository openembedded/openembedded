LICENSE = "GPL"
SECTION = "x11/utils"
PR = "r0"

inherit gnome

SRC_URI_append = " file://gpdf-2.10.0-gcc4-2.patch;patch=1"

DEPENDS = "gtk+ libgnomeui libbonoboui gnome-vfs gconf gettext libglade \
	libgnomeprint libgnomeprintui gnome-common"

EXTRA_OECONF = "--disable-schemas-install"

do_configure_prepend () {
	cp ${STAGING_DIR}/${HOST_SYS}/share/gnome-common/data/omf.make ${S}/help
}
