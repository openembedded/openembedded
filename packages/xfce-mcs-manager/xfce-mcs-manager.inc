# xfce-mcs-manager OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="XFCE4 Settings manager."
DEPENDS="libxfcegui4 libxfce4mcs"
SECTION = "x11"

inherit xfce 

do_stage() {
	install -d ${STAGING_INCDIR}/xfce4
	install -d ${STAGING_INCDIR}/xfce4/xfce-mcs-manager
	install -m 644 xfce-mcs-manager/manager-plugin.h ${STAGING_INCDIR}/xfce4/xfce-mcs-manager
}

# xfce-mcs-manager.pc uses ${libdir} to indicate where the mcs plugins live
# the standard pkgconfig mangling was confusing us.  Mangling is not required
# for this particular .pc, so the following will suffice:

do_stage_append () {
	install -d ${PKG_CONFIG_PATH}
	install -m 0644 ${S}/xfce-mcs-manager/xfce-mcs-manager.pc ${PKG_CONFIG_PATH}/xfce-mcs-manager.pc
}
