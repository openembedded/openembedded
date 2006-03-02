# xfwm4 OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="XFCE4 Window Manager"
SECTION = "x11/wm"
inherit xfce


FILES_${PN} += "${datadir}/xfwm4/defaults ${datadir}/xfwm4/themes/default.keys/*"

DEPENDS="startup-notification libx11 libxpm libxfce4util libxfcegui4 libxfce4mcs xfce-mcs-manager"


EXTRA_OECONF += " --enable-startup-notification"

PACKAGES_DYNAMIC = "xfwm4-theme-*"

python populate_packages_prepend () {
	themedir = bb.data.expand('${datadir}/themes', d)
	do_split_packages(d, themedir, '^(.*)', 'xfwm4-theme-%s', 'XFWM4 theme %s', allow_dirs=True)
}
