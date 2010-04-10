# eel OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

inherit gnome
PR = "r2"

LICENSE="GPL"
SRC_URI += "file://configure.patch;patch=1"

DEPENDS = "gnome-vfs gnome-desktop gnome-menus libgnomeui virtual/gail"
EXTRA_OECONF = "--disable-gtk-doc"


do_stage() {
autotools_stage_all
}

SRC_URI[archive.md5sum] = "d78cd3e33c656a62b5bf1f8d0b8d271f"
SRC_URI[archive.sha256sum] = "df6c696f84bc9c2af12f3715f2703060ab1692a918fb221ea0403212c03e0b73"
