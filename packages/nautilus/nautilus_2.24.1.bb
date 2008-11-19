# nautilus OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

PR = "r1"

inherit gnome
LICENSE="GPL"

DEPENDS = "librsvg libexif eel esound gnome-desktop"
RRECOMMENDS = "shared-mime-info"

EXTRA_OECONF = "--disable-gtk-doc"

PACKAGES += "nautilus-mime-data libnautilus"

FILES_${PN} += "${datadir}/icons  /usr/libexec/ "
FILES_libnautilus = "/usr/lib/*.so*"
FILES_${PN}-dbg += "/usr/libexec/.debug"

# This conflicts with shared-mime-info
FILES_nautilus-mime-data += "${datadir}/mime"

do_stage() {
	autotools_stage_all
}
