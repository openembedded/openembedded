# xfce-mixer-plugin OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see COPYING.MIT)

DESCRIPTION="XFCE panel mixer plugin"
SECTION = "x11"

DEPENDS="xfce4-panel"
inherit xfce

FILES_${PN}-dev += "${libdir}/xfce4/modules/libxfce4mixer.so"
FILES_${PN}-dbg += "${libexecdir}/xfce4/panel-plugins/.debug/"

SRC_URI[md5sum] = "c21cb5680f135dc86e5f0a6f9473003a"
SRC_URI[sha256sum] = "b390241dfddbc10ae1b870d1326a7675b9ac99e13c89326ba2accea3bfecc47a"
