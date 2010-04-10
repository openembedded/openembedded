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
	cp ${STAGING_DATADIR}/gnome-common/data/omf.make ${S}
}

SRC_URI[archive.md5sum] = "130baf0910aec9c0c5afad8007da90de"
SRC_URI[archive.sha256sum] = "e5a0f289969d070f4f10f25fb77efdf693805177b07d4eb2dbfe9fe91c2fdab0"
