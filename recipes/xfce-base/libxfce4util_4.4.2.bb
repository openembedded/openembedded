# libxfce4util OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see COPYING.MIT)

DESCRIPTION = "Basic utility library for Xfce4"
SECTION = "x11/libs"
LICENSE = "GPL"
DEPENDS = "glib-2.0 xfce4-dev-tools"

inherit xfce pkgconfig

MACROS="m4/X11.m4 m4/debug.m4 m4/depends.m4 m4/i18n.m4"

do_stage() {
	install -d ${STAGING_LIBDIR} ${STAGING_INCDIR}/libxfce4util
	# The line below expands to the list of headers that native makefile
	# would install.  Complain and/or fix if it's not portable enough
	for file in  $(eval $(make -n -C libxfce4util install|grep "^list='[^.]\\+.h"|cut -d\; -f1); echo $list); do 
		install -m 644 libxfce4util/$file ${STAGING_INCDIR}/libxfce4util
	done

	oe_libinstall -C libxfce4util -so libxfce4util ${STAGING_LIBDIR}

}

FILES_${PN}-dev += " ${datadir}/xfce4/m4"

SRC_URI[md5sum] = "261e7a5df039493ad746e0c359211092"
SRC_URI[sha256sum] = "f717dcdb4d8ee8f967ed0882e82aad06abe66c32481b9954737273312c937a6d"
