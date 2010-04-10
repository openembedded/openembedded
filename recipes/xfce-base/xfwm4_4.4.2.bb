# xfwm4 OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see COPYING.MIT)

DESCRIPTION="XFCE4 Window Manager"
SECTION = "x11/wm"
inherit xfce update-alternatives

FILES_${PN} += "${datadir}/xfwm4/defaults ${datadir}/xfwm4/themes/default.keys/*"

DEPENDS = "startup-notification virtual/libx11 libxpm libxfce4util libxfcegui4 libxfce4mcs xfce-mcs-manager"
RDEPENDS = "xfwm4-theme-default"


EXTRA_OECONF += " --enable-startup-notification"

PACKAGES_DYNAMIC += "xfwm4-theme-*"

python populate_packages_prepend () {
	themedir = bb.data.expand('${datadir}/themes', d)
	do_split_packages(d, themedir, '^(.*)', 'xfwm4-theme-%s', 'XFWM4 theme %s', allow_dirs=True)
}

PACKAGES += " ${PN}-mcs-plugins"

FILES_${PN}-mcs-plugins += "${libdir}/xfce4/mcs-plugins/*.so"

ALTERNATIVE_PATH = "${bindir}/xfce4-session"
ALTERNATIVE_NAME = "x-window-manager"
ALTERNATIVE_LINK = "${bindir}/x-window-manager"
ALTERNATIVE_PRIORITY = "10"

SRC_URI[md5sum] = "21da77e50b07e72bba784bf3418ca067"
SRC_URI[sha256sum] = "710120122bc4acaaecdb0646656c5aa92f1d44c4c81d1a6775688abab04cca0a"
