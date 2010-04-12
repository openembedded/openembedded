DESCRIPTION = "openbox Window Manager"
SECTION = "x11/wm"
DEPENDS = ""

SRC_URI = "http://icculus.org/openbox/releases/openbox-${PV}.tar.gz"

inherit autotools update-alternatives

EXTRA_OECONF += "--with-plugins=none"

PACKAGES += "lxde-icon-theme"
FILES_${PN} += "${datadir}/lxde/ ${datadir}/lxpanel ${datadir}/xsessions"
FILES_lxde-icon-theme = "${datadir}/icons"

PACKAGES_DYNAMIC += "${PN}-theme-*"

python populate_packages_prepend() {
	theme_dir = bb.data.expand('${datadir}/themes/', d)
	theme_name = bb.data.expand('${PN}-theme-%s', d)
	do_split_packages(d, theme_dir, '(.*)', theme_name, '${PN} theme for %s', extra_depends='', allow_dirs=True)
}

ALTERNATIVE_PATH = "${bindir}/openbox"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "10"

SRC_URI[md5sum] = "9e7589e90519bc6ac2f4656ea6869439"
SRC_URI[sha256sum] = "d11f2137a0fe1de6c36c999d29523ad68c05f22c5935ce8628a8cab7a2e4b000"
