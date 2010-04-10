LICENSE = "GPL"
SECTION = "x11/base"
DESCRIPTION = "GTK theme engines"
DEPENDS = "gtk+ cairo"

PR = "r1"

RDEPENDS_gtk-theme-redmond = "gtk-engine-redmond95"
RDEPENDS_gtk-theme-metal = "gtk-engine-metal"
RDEPENDS_gtk-theme-mist = "gtk-engine-mist"
RDEPENDS_gtk-theme-crux = "gtk-engine-crux-engine"
RDEPENDS_gtk-theme-lighthouseblue = "gtk-engine-lighthouseblue"
RDEPENDS_gtk-theme-thinice = "gtk-engine-thinice"
RDEPENDS_gtk-theme-industrial = "gtk-engine-industrial"
RDEPENDS_gtk-theme-clearlooks = "gtk-engine-clearlooks"

RREPLACES_gtk-theme-clearlooks = "gpe-theme-clearlooks"

inherit gnome  gtk-binver

PACKAGES_DYNAMIC = "gtk-engine-* gtk-theme-*"

python populate_packages_prepend() {
	import os.path

	engines_ver = ['gtk-2.0/', gtkbinver_find(d), '/engines']

	engines_root = os.path.join(bb.data.getVar('libdir', d, 1), ''.join(engines_ver))
	themes_root = os.path.join(bb.data.getVar('datadir', d, 1), "themes")

	do_split_packages(d, engines_root, '^lib(.*)\.so$', 'gtk-engine-%s', 'GTK %s theme engine', extra_depends='')
	do_split_packages(d, themes_root, '(.*)', 'gtk-theme-%s', 'GTK theme %s', allow_dirs=True, extra_depends='')
}


SRC_URI[archive.md5sum] = "5dc748cfb0587bb412adc49b666fb6f8"
SRC_URI[archive.sha256sum] = "d7e2672fcf80f5c35d481c24e0ab5b7d0f6526dcc3d8821ab76468c1816dc3bc"
