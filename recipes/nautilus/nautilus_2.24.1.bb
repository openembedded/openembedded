# nautilus OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

PR = "r4"

inherit gnome
LICENSE="GPL"

DEPENDS += " tracker librsvg libexif eel esound gnome-desktop"

EXTRA_OECONF = " --disable-gtk-doc  --disable-update-mimedb "

PACKAGES += " libnautilus"

FILES_${PN} += "${datadir}/icons  /usr/libexec/ "
FILES_libnautilus = "/usr/lib/*.so*"
FILES_${PN}-dbg += "/usr/libexec/.debug"

do_stage() {
	autotools_stage_all
}

SRC_URI[archive.md5sum] = "ccb5497397dfba46569b6dd1d2f41cef"
SRC_URI[archive.sha256sum] = "48f1d25af102d216fdc2ebcd6396ffce963558c119b88730dc02fb1c158fcc4c"
