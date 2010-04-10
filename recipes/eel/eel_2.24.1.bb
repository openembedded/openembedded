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

SRC_URI[archive.md5sum] = "b591df36af8f1b23dd175be33b5de073"
SRC_URI[archive.sha256sum] = "32cde7b589b49f439d82f76b6456983d36de7d20688f7c6ac2fdae4ce354e629"
