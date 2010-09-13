# xfwm4 OE build file

DESCRIPTION="Xfce4 Window Manager"
SECTION = "x11/wm"
PR = "r1"

inherit xfce46 update-alternatives

FILES_${PN} += "${datadir}/xfwm4/defaults ${datadir}/xfwm4/themes/default.keys/*"

DEPENDS = "startup-notification virtual/libx11 libxpm libxfce4util libxfcegui4 libwnck"
RDEPENDS_${PN} = "xfwm4-theme-default"

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

SRC_URI[md5sum] = "3e6c0c54b028b6ea60e865e55ecdf3f8"
SRC_URI[sha256sum] = "212819ee03c24635f79d50930284c422469e22489952d0b286e6fe5af2155828"
