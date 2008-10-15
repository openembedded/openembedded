# xfce-mcs-manager OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see COPYING.MIT)

DESCRIPTION="XFCE4 Settings manager."
DEPENDS="libxfcegui4 libxfce4mcs intltool-native"
SECTION = "x11"
FILE_PR = "r2"

inherit xfce 

do_stage() {
	autotools_stage_all
}


