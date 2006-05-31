# ica-bin OE build file
# Copyright (C) 2004-2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DEPENDS="libx11 libxaw rpm2cpio-native"

MAINTAINER = "Raymond Danks <info-linux@geode.amd.com>"
HOMEPAGE="www.citrix.com/download/"

SRC_URI="file://${DL_DIR}/ICAClient-8.0-1.i386.rpm" 

S="${WORKDIR}"
PACKAGES= "${PN}"
FILES_${PN} = "/"

python ica_do_fetch() {
	import os
	def dowarn(str,d):
		out = bb.data.expand(str, d)
		bb.note(out)
	
	file = bb.data.getVar('A', d)
	basen = os.path.basename(file)	

	if not os.path.exists(file):
		dowarn('You need to perform the following steps to build this package:',d)
		dowarn('Sign up at ${HOMEPAGE}',d)
		dowarn('- Download %s and place it in ${DL_DIR}' % basen,d)
		dowarn('- make this package again',d)
		raise bb.build.FuncFailed('Package not downloaded')
}

python do_fetch() {
	bb.build.exec_func('ica_do_fetch', d)
	bb.build.exec_func('base_do_fetch', d)
}

do_unpack() {
	rpm2cpio.pl ${A} | cpio -i --make-directories
}

do_compile() {
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
