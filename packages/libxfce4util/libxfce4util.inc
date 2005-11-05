# libxfce4util OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "Basic utility library for Xfce4"
SECTION = "x11/libs"
LICENSE = "GPL"
DEPENDS = "glib-2.0"

inherit xfce pkgconfig

XFCE_HEADERS="debug.h utf8.h xfce-generics.h   xfce-resource.h \
		   i18n.h util.h xfce-kiosk.h libxfce4util-config.h  \
		   xfce-desktopentry.h xfce-miscutils.h libxfce4util.h \
		   xfce-fileutils.h xfce-rc.h"

MACROS="m4/X11.m4 m4/debug.m4 m4/depends.m4 m4/i18n.m4"

do_stage() {
	install -d ${STAGING_LIBDIR} ${STAGING_INCDIR}/libxfce4util
	for file in ${XFCE_HEADERS}; do 
		install -m 644 libxfce4util/$file ${STAGING_INCDIR}/libxfce4util
	done

	oe_libinstall -C libxfce4util -so libxfce4util ${STAGING_LIBDIR}

        install -d ${STAGING_DATADIR}/aclocal/
        install -m 0644 ${MACROS} ${STAGING_DATADIR}/aclocal/
}

FILES_${PN}-dev += " ${datadir}/xfce4/m4"
