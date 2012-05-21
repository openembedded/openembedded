# bonnie OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="Tests large file IO and creation/deletion of small files."
LICENSE="GPLv2"

PR = "r1"

SRC_URI="http://www.coker.com.au/bonnie++/${BPN}-${PV}.tgz \
	 file://gcc-4.3-fixes.patch"

inherit autotools

EXES="bonnie++ zcav"
SCRIPTS="bon_csv2html bon_csv2txt"

PACKAGES += "bonnie-scripts"

FILES_${PN} = "/sbin"
FILES_bonnie-scripts="/bin"

S="${WORKDIR}/${BPN}-${PV}"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install () {
	install -d ${D}/bin
	install -d ${D}/sbin

	install -m 0755 ${EXES} ${D}/sbin
	install -m 0755 ${SCRIPTS} ${D}/bin
}
