DESCRIPTION = "GTK theme engine Smooth"
SECTION = "x11/base"
PRIORITY = "optional"
LICENSE = "LGPL"
DEPENDS = "gtk+"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/smooth-engine/${PN}-${PV}.tar.gz"

inherit autotools pkgconfig

python populate_packages_prepend() {
	import os.path

	engines_ver = ['gtk-2.0/', gtkbinver_find(d), '/engines']

	engines_root = os.path.join(bb.data.getVar('libdir', d, 1), ''.join(engines_ver))
	themes_root = os.path.join(bb.data.getVar('datadir', d, 1), "themes")

	do_split_packages(d, engines_root, '^lib(.*)\.so$', 'gtk-engine-%s', 'GTK %s theme engine', extra_depends='')
	do_split_packages(d, themes_root, '(.*)', 'gtk-theme-%s', 'GTK theme %s', allow_dirs=True, extra_depends='')
}

SRC_URI[md5sum] = "7b4aebf85040b357124de926807dc22a"
SRC_URI[sha256sum] = "cb2b353839a7f1dcd8f93a6cb32b5c54a6fe560dee432585edb2f5eebe526c50"
