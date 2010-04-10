# xfce-mcs-manager OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see COPYING.MIT)

DESCRIPTION="XFCE4 Settings manager."
DEPENDS="libxfcegui4 libxfce4mcs intltool-native"
SECTION = "x11"
PR = "r1"

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
	install -d ${PKG_CONFIG_DIR}
	sed -e 's:^includedir=.*:includedir="/usr/include":;' ${S}/xfce-mcs-manager/xfce-mcs-manager.pc >${PKG_CONFIG_DIR}/xfce-mcs-manager.pc
}

SRC_URI[md5sum] = "876a4b5d582de8fdc01457df2e7e1339"
SRC_URI[sha256sum] = "65531403c4b24f1be031e57a935b9a464661c47764cb913888aa86ed03ecb268"
