# eel OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

inherit gnome

LICENSE="GPL"
SRC_URI += "file://configure.patch;patch=1"

DEPENDS = "gnome-vfs gnome-menus libgnomeui gail"
EXTRA_OECONF = "--disable-gtk-doc"


do_stage() {
autotools_stage_all
}
