# xfce-mcs-manager OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see COPYING.MIT)

DESCRIPTION="XFCE4 Settings manager."
DEPENDS="libxfcegui4 libxfce4mcs intltool-native"
SECTION = "x11"
PR = "r2"

inherit xfce 

do_stage() {
	autotools_stage_all
}


do_stage_append () {
	install -d ${PKG_CONFIG_DIR}
	sed -e 's:^includedir=.*:includedir="/usr/include":;' ${S}/xfce-mcs-manager/xfce-mcs-manager.pc >${PKG_CONFIG_DIR}/xfce-mcs-manager.pc
}
