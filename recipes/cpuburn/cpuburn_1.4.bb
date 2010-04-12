# cpuburn OE build file
# Copyright (C) 2006, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

DESCRIPTION="CPU testing utilities in optimized assembler for maximum loading P6, K7, K6, P5 chips"
HOMEPAGE="http://pages.sbcglobal.net/redelm/"
LICENSE="GPL"

SRC_URI="http://pages.sbcglobal.net/redelm/${PN}_1_4_tar.gz \
	file://gcc_CC.patch;patch=1"

python do_unpack () {
	bb.build.exec_func('base_do_unpack', d)
	bb.build.exec_func('cpuburn_do_unpack', d)
}

cpuburn_do_unpack () {
	tar xvf ${PN}_1_4_tar
}

do_install () {
	oe_runmake install DESTDIR=${D}
}



SRC_URI[md5sum] = "f9bb5ff68afb6ccfca11718c90bcab68"
SRC_URI[sha256sum] = "1b2a1672f455545a28d0f038737e792e8c3b97789f2029f765847fc2a807244a"
