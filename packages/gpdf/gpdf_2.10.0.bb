LICENSE = "GPL"
SECTION = "x11/utils"
PR = "r0"

inherit gnome

DEPENDS = "gtk+ libgnomeui libbonoboui gnome-vfs gconf gettext libglade \
	libgnomeprint libgnomeprintui gnome-common"

EXTRA_OECONF = "--disable-schemas-install"

do_configure_prepend () {
	cp ${STAGING_DIR}/${HOST_SYS}/share/gnome-common/data/omf.make ${S}/help
}
