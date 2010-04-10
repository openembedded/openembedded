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

SRC_URI[archive.md5sum] = "b2f65d5b01399a5d3daca5f3ba280f9b"
SRC_URI[archive.sha256sum] = "14ddc03f05f6116c2d0545ef264f6dc5a9064ba321cba94547b02911fa5bd440"
