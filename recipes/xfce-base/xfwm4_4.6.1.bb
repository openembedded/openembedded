# xfwm4 OE build file

DESCRIPTION="XFCE4 Window Manager"
SECTION = "x11/wm"
PR = "r1"

inherit xfce46 update-alternatives

FILES_${PN} += "${datadir}/xfwm4/defaults ${datadir}/xfwm4/themes/default.keys/*"

DEPENDS = "startup-notification virtual/libx11 libxpm libxfce4util libxfcegui4"
RDEPENDS = "xfwm4-theme-default"

EXTRA_OECONF += " --enable-startup-notification"

PACKAGES_DYNAMIC += "xfwm4-theme-*"

python populate_packages_prepend () {
	themedir = bb.data.expand('${datadir}/themes', d)
	do_split_packages(d, themedir, '^(.*)', 'xfwm4-theme-%s', 'XFWM4 theme %s', allow_dirs=True)
}

ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PATH = "${bindir}/xfce4-session"
ALTERNATIVE_PRIORITY = "30"

FILES_${PN}-dbg += "${libexecdir}/xfce4/xfwm4/.debug/*"

SRC_URI[md5sum] = "538ff2554a23bf877d336e573884da9a"
SRC_URI[sha256sum] = "0a808d19a7ddf1f5271d0b7009a5d0dc919562a85afab4071df060f51e9ee9ed"
