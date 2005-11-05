# xfce-utils OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="XFCE4 Utilities"
DEPENDS="x11 libxfcegui4 xfce-mcs-manager"
inherit xfce

FILES_${PN} += " /usr/share/xfce4/AUTHORS \
        /usr/share/xfce4/BSD \
        /usr/share/xfce4/COPYING \
        /usr/share/xfce4/GPL \
	/usr/share/xfce4/INFO \
        /usr/share/xfce4/LGPL \
        /usr/share/xfce4/AUTHORS.html \
        /usr/share/xfce4/BSD.html \
        /usr/share/xfce4/COPYING.html \
        /usr/share/xfce4/GPL.html \
	/usr/share/xfce4/INFO.html \
        /usr/share/xfce4/LGPL.html"

# NOTE:  This package takes a --with-browser for the default browser
# NOTE:  Works with gdm also gtkhtml
