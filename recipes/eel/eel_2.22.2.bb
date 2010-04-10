# eel OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

inherit gnome
PR = "r2"

LICENSE="GPL"

SRC_URI += "file://eel-no-strftime.patch;patch=1"

DEPENDS = "gnome-vfs gnome-desktop gnome-menus libgnomeui virtual/gail"
EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "f0dc46f4bc6a772da9e149c0018a8b09"
SRC_URI[archive.sha256sum] = "e91e576ed22e5ba9a930d4292e3dbec4fe4ec7276029d82188cc91db117e21d4"
