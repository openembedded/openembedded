DESCRIPTION = "Convert Gnome or KDE menus to e17 menus"
DEPENDS = "e virtual/ecore virtual/evas eet engrave"
LICENSE = "GPL"
HOMEPAGE = "http://sourceforge.net/projects/e17genmenu"
PR = "r0"

inherit e

SECTION = "e/utils"

SRC_URI = "${SOURCEFORGE_MIRROR}/e17genmenu/e17genmenu-2.0.2.tar.gz"

do_configure_prepend() {
	find -type f | xargs sed -i 's:share/icons/%s/48x48/apps:share/pixmaps:'
	find -type f | xargs sed -i 's:share/icons/hicolor/48x48/apps:share/pixmaps:'
	find -type f | xargs sed -i 's:%s/share/pixmaps", GNOME_PREFIX, theme:%s/share/pixmaps", GNOME_PREFIX:'
}
