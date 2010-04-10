# xfwm4-themes OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see COPYING.MIT)

DESCRIPTION="XFCE4 Window Manager Themes"
SECTION = "x11/wm"

inherit xfce

# No ${PN} for this one 
PACKAGES=""

PACKAGES_DYNAMIC = "xfwm4-theme-*"

python populate_packages_prepend () {
	themedir = bb.data.expand('${datadir}/xfwm4/themes', d)
	do_split_packages(d, themedir, '^(.*)', 'xfwm4-theme-%s', 'XFWM4 theme %s', allow_dirs=True)
}

SRC_URI[md5sum] = "fbea3ef7eec87fd669958f9cf597bfb8"
SRC_URI[sha256sum] = "d6f6052ec9bdc2a048dd34a79248ee56abd903055adc0d89d04715eb17ac1dc0"
