# nautilus OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

inherit gnome
LICENSE="GPL"

DEPENDS = "librsvg libexif eel esound gnome-desktop"

EXTRA_OECONF = "--disable-gtk-doc"

PACKAGES += "libnautilus"

FILES_${PN} += "${datadir}/icons ${datadir}/mime /usr/libexec/ "
FILES_libnautilus = "/usr/lib/*.so*"
FILES_${PN}-dbg += "/usr/libexec/.debug"

do_stage() {
	autotools_stage_all
}
