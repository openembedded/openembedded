# xfce-mixer-plugin OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see COPYING.MIT)

DESCRIPTION="XFCE panel mixer plugin"
SECTION = "x11"

DEPENDS="xfce4-panel"
inherit xfce

FILES_${PN}-dev += "${libdir}/xfce4/modules/libxfce4mixer.so"
FILES_${PN}-dbg += "${libexecdir}/xfce4/panel-plugins/.debug/"
