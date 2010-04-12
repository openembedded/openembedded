# xfce-utils OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see COPYING.MIT)

DESCRIPTION="XFCE4 Utilities"
DEPENDS = "virtual/libx11 libxfcegui4 xfce-mcs-manager"
inherit xfce

FILES_${PN} += " \ 
        ${bindir}/* \
        ${datadir}/dbus-1/* \
        ${datadir}/xfce4/AUTHORS \
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
        ${datadir}/xfce4/LGPL.html"

PACKAGES =+ "${PN}-mcs-plugins"
FILES_${PN}-mcs-plugins = "${libdir}/xfce4/mcs-plugins/"

# NOTE:  This package takes a --with-browser for the default browser
# NOTE:  Works with gdm also gtkhtml

SRC_URI[md5sum] = "119dd3f1daedfa41e3be89bad8997336"
SRC_URI[sha256sum] = "eba910fb99598e09fa4c41c4ab405216a2b59a837a3ab058656360ec2324314c"
