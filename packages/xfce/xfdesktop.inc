# xfdesktop OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="xfce4 Desktop Background Manager"
SECTION = "x11/base"
DEPENDS = "virtual/libx11 libxfcegui4 libxfce4mcs libxml2 xfce4-panel"

inherit xfce
PACKAGES += "xfdesktop-backdrops ${PN}-mcs-plugins"

FILES_xfdesktop-backdrops="${datadir}/xfce4/backdrops/*"
FILES_${PN}-mcs-plugins += "${libdir}/xfce4/mcs-plugins/*.so"
FILES_${PN} += "${libdir}/xfce4/panel-plugins/*.so"
FILES_${PN}-dbg += "/usr/libexec/xfce4/panel-plugins/.debug"
