# libxfce4util OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION = "Basic utility library for Xfce4"
SECTION = "x11/libs"
LICENSE = "GPL"
DEPENDS = "glib-2.0"

# | checking whether putenv() implementation is broken... configure: error: cannot run test program while cross compiling
BROKEN = "1"

# Fixed on i386/i486/i586/i686 - needs to be confirmed on other platforms

BROKEN_i386="0"
BROKEN_i486="0"
BROKEN_i586="0"
BROKEN_i686="0"

inherit xfce pkgconfig

XFCE_HEADERS="debug.h utf8.h xfce-generics.h   xfce-resource.h \
		   i18n.h util.h xfce-kiosk.h libxfce4util-config.h  \
		   xfce-desktopentry.h xfce-miscutils.h libxfce4util.h \
		   xfce-fileutils.h xfce-rc.h"

do_stage() {
	install -d ${STAGING_LIBDIR} ${STAGING_INCDIR}/xfce4/libxfce4util
	for file in ${XFCE_HEADERS}; do 
		install -m 644 libxfce4util/$file ${STAGING_INCDIR}/xfce4/libxfce4util
	done

	oe_libinstall -C libxfce4util -so libxfce4util ${STAGING_LIBDIR}
}
