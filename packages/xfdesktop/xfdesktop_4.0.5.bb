# xfdesktop OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="xfce4 Desktop Background Manager"
SECTION = "x11/base"

PACKAGES="xfdesktop xfdesktop-backdrops xfdesktop-mcs-plugins ${PN}-doc"

FILES_xfdesktop-mcs-plugins="${libdir}/xfce4/mcs-plugins/*.so"
FILES_xfdesktop-backdrops="${datadir}/xfce4/backdrops/"

DEPENDS="x11 libxfcegui4 libxfce4mcs libxml2"
inherit xfce

# Get rid of the (for now) useless internationalization menus
# In the future, we would copy over the desired internationalization

do_install() {
	oe_runmake DESTDIR=${D} install
	rm -rf ${D}${sysconfdir}/xfce4/menu.xml.*
}
