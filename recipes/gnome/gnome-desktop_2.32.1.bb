DESCRIPTION = "GNOME library for reading .desktop files"
SECTION = "x11/gnome"
LICENSE = "GPL"
DEPENDS = "gnome-common libgnomeui gnome-doc-utils gnome-vfs libxrandr"

inherit gnome pkgconfig

SRC_URI[archive.md5sum] = "5c80d628a240eb9d9ff78913b31f2f67"
SRC_URI[archive.sha256sum] = "55cbecf67efe1fa1e57ac966520a7c46d799c8ba3c652a1219f60cafccb3739d"

do_install_append() {
	sed  -i 's:#!.*/usr/bin/python:#!/usr/bin/python:' ${D}${bindir}/gnome-about
}

FILES_${PN} += "${datadir}/gnome-about ${datadir}/libgnome-desktop"
