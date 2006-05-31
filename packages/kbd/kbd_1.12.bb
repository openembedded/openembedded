# kbd OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"

SRC_URI="http://ftp.debian.org/debian/pool/main/k/kbd/kbd_1.12.orig.tar.gz"

FILES_${PN} += " /usr/share/consolefonts/drdos8x16.psfu.gz"

do_configure() {
	ARCH=${TARGET_ARCH} ./configure
}

do_compile() {
	make CC="${CC}" CFLAGS="${CFLAGS}"
}

do_install() {
	make DESTDIR=${D} install
}
