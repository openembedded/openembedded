# libxfce4util OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

include ${PN}.inc

MACROS="m4/X11.m4 m4/debug.m4 m4/depends.m4 m4/i18n.m4"
FILES_${PN}-dev += " ${datadir}/xfce4/m4"

do_stage() {
	install -d ${STAGING_DATADIR}/aclocal/
	install -m 0644 ${MACROS} ${STAGING_DATADIR}/aclocal/
}
