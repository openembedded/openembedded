SECTION = "x11/libs"
# libxfce4util OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="Basic utility library for Xfce4"
DEPENDS="glib-2.0"

inherit xfce pkgconfig

do_stage() {
	install -d ${STAGING_INCDIR}/xfce4
	install -d ${STAGING_INCDIR}/xfce4/libxfce4util
	install -m 644 libxfce4util/debug.h ${STAGING_INCDIR}/xfce4/libxfce4util
	install -m 644 libxfce4util/i18n.h ${STAGING_INCDIR}/xfce4/libxfce4util
	install -m 644 libxfce4util/libxfce4util.h ${STAGING_INCDIR}/xfce4/libxfce4util
	install -m 644 libxfce4util/libxfce4util-config.h ${STAGING_INCDIR}/xfce4/libxfce4util
	install -m 644 libxfce4util/utf8.h ${STAGING_INCDIR}/xfce4/libxfce4util
	install -m 644 libxfce4util/util.h ${STAGING_INCDIR}/xfce4/libxfce4util	

	oe_soinstall libxfce4util/.libs/libxfce4util.so.1.0.0 ${STAGING_LIBDIR}/
	ln -sf ./libxfce4util.so.1.0.0 ${STAGING_LIBDIR}/libxfce4util.so
}
