# xfce-mcs-plugins OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="Common XFCE4 configuration plugins."
SECTION = "x11"

PACKAGES="${PN}"
FILES_${PN}="${libdir}/xfce4/mcs-plugins/*.so ${datadir}/xfce4/doc/C"

DEPENDS="libxfcegui4 xfce-mcs-manager gtk+"
inherit xfce
