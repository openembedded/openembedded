SECTION = "x11/libs"
# libxfce4mcs OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="Settings management library used by most XFce 4 modules"
DEPENDS="libxfce4util"

inherit xfce pkgconfig

do_stage() {
	install -d ${STAGING_INCDIR}/xfce4
	install -d ${STAGING_INCDIR}/xfce4/libxfce4mcs
	    
	install -m 644 libxfce4mcs/mcs-common.h ${STAGING_INCDIR}/xfce4/libxfce4mcs
	install -m 644 libxfce4mcs/mcs-client.h ${STAGING_INCDIR}/xfce4/libxfce4mcs
	install -m 644 libxfce4mcs/mcs-manager.h ${STAGING_INCDIR}/xfce4/libxfce4mcs    
	
	oe_soinstall libxfce4mcs/.libs/libxfce4mcs-manager.so.1.0.1 ${STAGING_LIBDIR}/
	oe_soinstall libxfce4mcs/.libs/libxfce4mcs-client.so.1.0.1 ${STAGING_LIBDIR}/
}
