# eel OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

inherit gnome
PR = "r0"

LICENSE="GPL"

SRC_URI += "file://eel-no-strftime.patch;patch=1"

DEPENDS = "gnome-vfs gnome-desktop gnome-menus libgnomeui virtual/gail"
EXTRA_OECONF = "--disable-gtk-doc"

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "dfa105ccabd53efe4166dcfac75e2393"
SRC_URI[archive.sha256sum] = "11ad07d8d371f9165fab6cc5462f59cd253f9cc835d77a54330fecafe9c0a555"
