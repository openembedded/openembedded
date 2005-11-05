# xfwm4-themes OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="XFCE4 Window Manager Themes"
SECTION = "x11/wm"

inherit xfce

# No ${PN} for this one 
PACKAGES=""

python populate_packages_prepend () {
	themedir = bb.data.expand('${datadir}/xfwm4/themes', d)
	do_split_packages(d, themedir, '^(.*)', 'xfwm4-theme-%s', 'XFWM4 theme %s', allow_dirs=True)
}
