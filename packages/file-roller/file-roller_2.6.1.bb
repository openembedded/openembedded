# file-roller OE build file
# Copyright (C) 2005, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

LICENSE="GPL"
HOMEPAGE="http://fileroller.sourceforge.net/"
SRC_URI="http://ftp.gnome.org/pub/gnome/sources/${PN}/2.6/file-roller-${PV}.tar.gz"

DEPENDS="gtk+ libgnomeui gnome-common gnome-vfs libglade libbonoboui"

inherit autotools

do_configure_prepend () {
	cp ${STAGING_DIR}/${HOST_SYS}/share/gnome-common/data/omf.make ${S}
}
