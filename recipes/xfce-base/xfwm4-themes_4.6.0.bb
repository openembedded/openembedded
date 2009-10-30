# xfwm4-themes OE build file

DESCRIPTION="Xfce4 Window Manager Themes"
SECTION = "x11/wm"
PR = "r2"

DEPENDS = "xfwm4 libglade libxml2"
RDEPENDS = "xfwm4 libglade libxml2"

inherit xfce46

SRC_URI = "http://mocha.xfce.org/archive/src/art/xfwm4-themes/4.6/xfwm4-themes-${PV}.tar.bz2"

# No ${PN} for this one 
PACKAGES=""

PACKAGES_DYNAMIC = "xfwm4-theme-*"

python populate_packages_prepend () {
	themedir = bb.data.expand('${datadir}/xfwm4/themes', d)
	do_split_packages(d, themedir, '^(.*)', 'xfwm4-theme-%s', 'XFWM4 theme %s', allow_dirs=True)
}
