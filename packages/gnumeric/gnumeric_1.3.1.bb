LICENSE = "GPL"
SECTION = "x11/utils"
PR = "r3"
S = "${WORKDIR}/gnumeric-${PV}"
DEPENDS = "libgsf gtk+ libxml2 libglade libart-lgpl intltool-native libgnomecanvas libgnomeprint libgnomeprintui"
DESCRIPTION = "Gnumeric spreadsheet for GNOME"

inherit gnome flow-lossage

SRC_URI += 'file://workbook-control-gui-priv.h.patch;patch=1'

EXTRA_OEMAKE_prepend = ' ORBIT_IDL=`which orbit-idl-2` '

PACKAGES_DYNAMIC = "gnumeric-plugin-*"

python populate_packages_prepend () {
	gnumeric_libdir = bb.data.expand('${libdir}/gnumeric/${PV}/plugins', d)

	do_split_packages(d, gnumeric_libdir, '(.*)', 'gnumeric-plugin-%s', 'Gnumeric plugin for %s', allow_dirs=True)
}
