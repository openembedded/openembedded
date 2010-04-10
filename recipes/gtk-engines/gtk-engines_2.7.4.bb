LICENSE = "GPL"
SECTION = "x11/base"
DESCRIPTION = "GTK theme engines"
DEPENDS = "gtk+ cairo"

RDEPENDS_gtk-theme-redmond = "gtk-engine-redmond95"
RDEPENDS_gtk-theme-metal = "gtk-engine-metal"
RDEPENDS_gtk-theme-mist = "gtk-engine-mist"
RDEPENDS_gtk-theme-crux = "gtk-engine-crux-engine"
RDEPENDS_gtk-theme-lighthouseblue = "gtk-engine-lighthouseblue"
RDEPENDS_gtk-theme-thinice = "gtk-engine-thinice"
RDEPENDS_gtk-theme-industrial = "gtk-engine-industrial"
RDEPENDS_gtk-theme-clearlooks = "gtk-engine-clearlooks"

SRC_URI = "${GNOME_MIRROR}/${PN}/2.7/${P}.tar.bz2"

inherit autotools pkgconfig gtk-binver

PACKAGES_DYNAMIC = "gtk-engine-* gtk-theme-*"

python populate_packages_prepend() {
	import os.path

	engines_ver = ['gtk-2.0/', gtkbinver_find(d), '/engines']

	engines_root = os.path.join(bb.data.getVar('libdir', d, 1), ''.join(engines_ver))
	themes_root = os.path.join(bb.data.getVar('datadir', d, 1), "themes")

	do_split_packages(d, engines_root, '^lib(.*)\.so$', 'gtk-engine-%s', 'GTK %s theme engine', extra_depends='')
	do_split_packages(d, themes_root, '(.*)', 'gtk-theme-%s', 'GTK theme %s', allow_dirs=True, extra_depends='')
}


SRC_URI[md5sum] = "b0f27c0f6d5f610ca445a3d82d5779da"
SRC_URI[sha256sum] = "0a40b43898a898e60bca29ed023034e362467573de52f5e841079c02528cc76c"
