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
