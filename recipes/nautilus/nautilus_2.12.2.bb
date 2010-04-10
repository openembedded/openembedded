# nautilus OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

inherit gnome
LICENSE="GPL"

DEPENDS="librsvg libexif eel esound gnome-desktop"

EXTRA_OECONF = "--disable-gtk-doc"

PACKAGES += "libnautilus"

FILES_${PN} = "/usr/bin/* /usr/libexec/* /usr/lib/bonobo/* /usr/share/* /etc/*"
FILES_libnautilus = "/usr/lib/*.so*"

do_stage() {
autotools_stage_all
}

SRC_URI[archive.md5sum] = "1c1304e458eda551da11ed8c52b1faa2"
SRC_URI[archive.sha256sum] = "9b1a11fde474d0bc0891afeef912aaa01bf8189e453bb555b2977f60f98d5455"
