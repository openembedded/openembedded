SECTION = "x11/utils"
# xffm OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="XFCE4 File Manager"

inherit xfce
SRC_URI += " file://link.patch;patch=1"

DEPENDS="dbh gtk+ libxml2 libxfcegui4 libxfce4mcs xfce-mcs-manager libxfce4util"

PACKAGES = "xffm xffm-dev ${PN}-doc xffm-mcs-plugins"

FILES_xffm-mcs-plugins="${libdir}/xfce4/mcs-plugins/*.so"
