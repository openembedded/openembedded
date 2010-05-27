# libxfce4util OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see COPYING.MIT)

DESCRIPTION = "Basic utility library for Xfce4"
SECTION = "x11/libs"
LICENSE = "GPL"
DEPENDS = "glib-2.0 xfce4-dev-tools"

PR = "r1"

inherit xfce pkgconfig

MACROS="m4/X11.m4 m4/debug.m4 m4/depends.m4 m4/i18n.m4"

FILES_${PN}-dev += " ${datadir}/xfce4/m4"

SRC_URI[md5sum] = "261e7a5df039493ad746e0c359211092"
SRC_URI[sha256sum] = "f717dcdb4d8ee8f967ed0882e82aad06abe66c32481b9954737273312c937a6d"
