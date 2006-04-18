# bonnie OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="Tests large file IO and creation/deletion of small files."
LICENSE="GPL"
MAINTAINER = "Raymond Danks <raymondd@ia.amd.com>"


SRC_URI="${SOURCEFORGE_MIRROR}/bonnie/${PN}-${PV}.tgz"

inherit autotools

EXES="bonnie++ zcav"
SCRIPTS="bon_csv2html bon_csv2txt"

FILES_${PN} = "/bin /sbin"
S="${WORKDIR}/${PN}-${PV}"

do_install () {
	install -d ${D}/bin
	install -d ${D}/sbin

	install -m 0755 ${EXES} ${D}/sbin
	install -m 0755 ${SCRIPTS} ${D}/bin
}
