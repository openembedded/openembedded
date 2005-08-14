SECTION = "x11/multimedia"
# totem OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="A GTK2 based media player"
HOMEPAGE="http://www.hadess.net/totem.php3"
LICENSE="GPL"

SRC_URI="http://ftp.acc.umu.se/pub/GNOME/sources/totem/0.99/totem-${PV}.tar.gz \
	file://include.patch;patch=1 \
	file://omf.patch;patch=1"

DEPENDS="gtk+ libglade gnome-vfs gconf libxine-x11 libgnomeui"
RDEPENDS += " libgnomeui"

inherit autotools

EXTRA_OECONF="--disable-schemas-install --disable-nvtv --enable-gtk --disable-debug --disable-gstreamer --disable-mozilla"

#SELECTED_OPTIMIZATION="-O0 -g"
LDFLAGS_append = " -Wl,--export-dynamic"

pkg_postinst_totem() {
#!/bin/sh
if [ -n "$D"  ]; then exit 1; fi; 
SOURCE=`gconftool-2 --get-default-source`
GCONF_CONFIG_SOURCE=$SOURCE gconftool-2 --makefile-install-rule \
/etc/gconf/schemas/totem.schemas > /dev/null
}
