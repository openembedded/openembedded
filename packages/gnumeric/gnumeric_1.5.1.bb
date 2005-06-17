LICENSE = GPL
SECTION = "x11/utils"
PR = "r0"
S = "${WORKDIR}/gnumeric-${PV}"
DEPENDS = "libgsf gtk+ libxml2 goffice libglade libart-lgpl intltool-native libgnomecanvas libgnomeprint libgnomeprintui"
DESCRIPTION = "Gnumeric spreadsheet for GNOME"

inherit gnome flow-lossage

EXTRA_OEMAKE_prepend = ' ORBIT_IDL=`which orbit-idl-2` '

python populate_packages_prepend () {
	gnumeric_libdir = bb.data.expand('${libdir}/gnumeric/${PV}/plugins', d)

	do_split_packages(d, gnumeric_libdir, '(.*)', 'gnumeric-plugin-%s', 'Gnumeric plugin for %s', allow_dirs=True)
}
