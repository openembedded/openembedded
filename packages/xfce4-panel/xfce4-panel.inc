# xfce4-panel OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "XFCE4 Panel"
SECTION = "x11"
DEPENDS = "startup-notification x11 libxfcegui4 libxfce4mcs xfce-mcs-manager libxml2"

inherit pkgconfig xfce

EXTRA_OECONF += " --enable-startup-notification"


do_stage() {
autotools_stage_all
}

do_install() {
    oe_runmake DESTDIR=${D} install
}

PACKAGES += "${PN}-plugins ${PN}-mcs-plugins"
FILES_${PN}-plugins += "${libdir}/xfce4/panel-plugins/*.so*"
FILES_${PN}-mcs-plugins += "${libdir}/xfce4/mcs-plugins/"
