# libxfcegui4 OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see COPYING.MIT)

DESCRIPTION = "XFCE Widget library and X Window System interaction"
DEPENDS = "libxfce4util dbh libxml2 gtk+"
SECTION = "x11/libs"

inherit xfce

do_stage() {
autotools_stage_all
}

FILES_${PN} += "${libdir}/xfce4/modules ${datadir}/xfce4/mime ${datadir}/icons/hicolor"
