# libxfce4mcs OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="Settings management library used by most XFce 4 modules"
DEPENDS="libxfce4util"
SECTION = "x11/libs"

inherit xfce pkgconfig

do_stage() {
	install -d ${STAGING_INCDIR}/xfce4/libxfce4mcs
	    
	install -m 644 libxfce4mcs/mcs-common.h ${STAGING_INCDIR}/xfce4/libxfce4mcs
	install -m 644 libxfce4mcs/mcs-client.h ${STAGING_INCDIR}/xfce4/libxfce4mcs
	install -m 644 libxfce4mcs/mcs-manager.h ${STAGING_INCDIR}/xfce4/libxfce4mcs    
	oe_libinstall -C libxfce4mcs -so libxfce4mcs-manager ${STAGING_LIBDIR}	
	oe_libinstall -C libxfce4mcs -so libxfce4mcs-client ${STAGING_LIBDIR}	
}
