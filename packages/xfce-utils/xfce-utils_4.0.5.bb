# xfce-mcs-plugins OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

PR="r1"

DESCRIPTION="XFCE4 Utilities"
SECTION = "x11/utils"

PACKAGES="xfce-utils xfce-utils-mcs-plugins"

FILES_xfce-utils-mcs-plugins="${libdir}/xfce4/mcs-plugins/*.so"
FILES_${PN} += " ${datadir}/xfce4/AUTHORS \
        ${datadir}/xfce4/BSD \
        ${datadir}/xfce4/COPYING \
        ${datadir}/xfce4/GPL \
	${datadir}/xfce4/INFO \
        ${datadir}/xfce4/LGPL \
        ${datadir}/xfce4/AUTHORS.html \
        ${datadir}/xfce4/BSD.html \
        ${datadir}/xfce4/COPYING.html \
        ${datadir}/xfce4/GPL.html \
	${datadir}/xfce4/INFO.html \
        ${datadir}/xfce4/LGPL.html \
	${datadir}/xfce4/doc/C"

DEPENDS="x11 libxfcegui4 xfce-mcs-manager"
inherit xfce

# NOTE:  This package takes a --with-browser for the default browser
# NOTE:  Works with gdm also gtkhtml
