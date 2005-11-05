SECTION = "x11/utils"
# xffm OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="XFCE4 File Manager"

inherit xfce

DEPENDS="dbh gtk+ libxml2 libxfcegui4 libxfce4mcs xfce-mcs-manager libxfce4util"

FILES_${PN} += "/usr/lib/xfce4/xffm/*so*"
