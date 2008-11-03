# ica-bin OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DEPENDS = "virtual/libx11 libxaw rpm2cpio-native fakeroot-native"

HOMEPAGE="www.citrix.com/download/"

SRC_URI="ftp://download2.citrix.com/FILES/en/products/Linux10/ICAClient-10.6-1.i386.rpm"

S="${WORKDIR}"
FILES_${PN} += "/"
FILES_${PN}-dbg += "/usr/lib/ICAClient/.debug"

do_configure() {
	rpm2cpio ${DL_DIR}/ICAClient-${PV}-1.i386.rpm | fakeroot cpio -i --make-directories
}

DDIR="${D}/usr/lib/ICAClient"

do_install () {
	for file in `find usr/lib/ICAClient/ -type d`; do
		install -d ${D}/$file
	done

	for file in `find usr/lib/ICAClient/ -type f`; do
		install $file ${D}/$file
	done
}
