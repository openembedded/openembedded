# tsclient OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

PR ="r1"

DESCRIPTION="Terminal Server Client (tsclient) is a frontend for rdesktop and other remote desktop tools"
HOMEPAGE="http://www.gnomepro.com/tsclient/"
LICENSE="GPL"

SRC_URI="http://www.gnomepro.com/tsclient/tsclient-${PV}.tar.gz \
	 file://fixes.patch;patch=1"

DEPENDS="gtk+ intltool-native"

inherit autotools

EXTRA_OECONF=" --without-applet --without-ica"

FILES_${PN}="${bindir}  \
	${datadir}/pixmaps/tsclient/banner-en.png \
	${datadir}/pixmaps/tsclient/computer.png \
	${datadir}/pixmaps/tsclient/perform.png \
	${datadir}/pixmaps/tsclient/size.png \
	${datadir}/pixmaps/tsclient/tsclient.png \
	${datadir}/pixmaps/tsclient/colors.png \
	${datadir}/pixmaps/tsclient/keyboard.png \
	${datadir}/pixmaps/tsclient/program.png \
	${datadir}/pixmaps/tsclient/sound.png"

SRC_URI[md5sum] = "748aada74e9e096467a9d553538df885"
SRC_URI[sha256sum] = "da12dc1257ffb9dd3f9acfc53c7f420b234738a67ffbbe0e9dd96e18d04ebad0"
