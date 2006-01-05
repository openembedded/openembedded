# nautilus OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

inherit gnome
LICENSE="GPL"

DEPENDS="librsvg eel esound gnome-desktop"

EXTRA_OECONF = "--disable-gtk-doc"

PACKAGES += "libnautilus"

FILES_${PN} = "/usr/bin/* /usr/libexec/* /usr/lib/bonobo/* /usr/share/* /etc/*"
FILES_libnautilus = "/usr/lib/*.so*"

do_stage() {
autotools_stage_all
}
