DESCRIPTION = "GTK theme engines"
SECTION = "x11/base"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "gtk+"
PR = "r1"

RDEPENDS_gtk-theme-redmond = "gtk-engine-redmond95"
RDEPENDS_gtk-theme-metal = "gtk-engine-metal"
RDEPENDS_gtk-theme-mist = "gtk-engine-mist"
RDEPENDS_gtk-theme-crux = "gtk-engine-crux-engine"
RDEPENDS_gtk-theme-lighthouseblue = "gtk-engine-lighthouseblue"
RDEPENDS_gtk-theme-thinice = "gtk-engine-thinice"
RDEPENDS_gtk-theme-industrial = "gtk-engine-industrial"

SRC_URI = "${GNOME_MIRROR}/${PN}/2.6/${PN}-${PV}.tar.bz2"

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

SRC_URI[md5sum] = "28469a797ba1e6aaa3f7eea4c9f5f9b7"
SRC_URI[sha256sum] = "0d7b79b2a369d99f155e85f3f01fca9efb1a5059b5c4406357686a7d8bbfe0d3"
