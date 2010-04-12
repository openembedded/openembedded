# file-roller OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

LICENSE="GPL"
HOMEPAGE="http://fileroller.sourceforge.net/"
SRC_URI="http://ftp.gnome.org/pub/gnome/sources/${PN}/2.6/file-roller-${PV}.tar.gz"

DEPENDS="gtk+ libgnomeui gnome-common gnome-vfs libglade libbonoboui"

inherit autotools

do_configure_prepend () {
	cp ${STAGING_DATADIR}/gnome-common/data/omf.make ${S}
}

SRC_URI[md5sum] = "68a1b645b2e44227f7aca604fd42f8d1"
SRC_URI[sha256sum] = "21e68eeb291ab5a9f4d618f2985c16c26cdfeb0f0f37d3b88550446678dab30a"
