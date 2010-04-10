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

SRC_URI[md5sum] = "799a4869138c605126e8e71d58189bfd"
SRC_URI[sha256sum] = "622c2585f61666d9c46841829ba141e86861c73bd9041a3a73452d1c8df5ee91"
