# xfwm4-themes OE build file

SECTION = "x11/wm"
PR = "r3"

DEPENDS = "xfwm4 libglade libxml2"
RDEPENDS = "xfwm4 libglade libxml2"

inherit xfce46

SRC_URI = "http://mocha.xfce.org/archive/src/art/xfwm4-themes/4.6/xfwm4-themes-${PV}.tar.bz2"

PACKAGES_DYNAMIC = "xfwm4-theme-*"

python populate_packages_prepend () {
	themedir = bb.data.expand('${datadir}/themes', d)
	do_split_packages(d, themedir, '^(.*)', 'xfwm4-theme-%s', 'Xfce4 Window Manager theme - %s', allow_dirs=True)

	metapkg = "xfwm4-themes"
	bb.data.setVar('ALLOW_EMPTY_' + metapkg, "1", d)
	bb.data.setVar('FILES_' + metapkg, "", d)
	blacklist = [ 'xfwm4-themes', 'xfwm4-themes-dev', 'xfwm4-themes-doc', 'xfwm4-themes-dbg', 'xfwm4-themes-static', 'xfwm4-themes-locale' ]
	recipe_rdepends = bb.data.getVar('RDEPENDS', d, 1).split()
	metapkg_rdepends = []
	packages = bb.data.getVar('PACKAGES', d, 1).split()
	for pkg in packages[1:]:
		if not pkg in blacklist and not pkg in metapkg_rdepends:
			bb.data.setVar('RDEPENDS_' + pkg, ' '.join(recipe_rdepends), d)
			metapkg_rdepends.append(pkg)
	metapkg_rdepends.extend(recipe_rdepends)
	bb.data.setVar('RDEPENDS_' + metapkg, ' '.join(metapkg_rdepends), d)
	bb.data.setVar('DESCRIPTION_' + metapkg, 'Xfce4 Window Manager extra themes - Meta package', d)
}
