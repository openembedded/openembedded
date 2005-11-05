# gcalctool OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

LICENSE = "GPL"
SECTION = "x11/utils"

inherit gnome

DEPENDS = "gnome-common gtk+ libgnomeui"

EXTRA_OECONF = "--disable-schemas-install"

SRC_URI += "file://noscrollkeeper.patch;patch=1"

do_configure_prepend () {
	cp ${STAGING_DIR}/${HOST_SYS}/share/gnome-common/data/omf.make ${S}
}
