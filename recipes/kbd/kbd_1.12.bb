# kbd OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)


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

SRC_URI[md5sum] = "7892c7010512a9bc6697a295c921da25"
SRC_URI[sha256sum] = "f3bc6747dba7d1a35cd125ca0bd4649f88704be211cf7e47d36b43c7f44ce803"
