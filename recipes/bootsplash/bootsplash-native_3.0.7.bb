# bootsplash-native OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

require bootsplash_${PV}.bb

DEPENDS += "jpeg-native"

inherit native
S="${WORKDIR}/bootsplash-${PV}"

do_compile() {
	oe_runmake splash
}

do_stage() {
	install -d ${STAGING_BINDIR}
	install -m 0755 Utilities/splash ${STAGING_BINDIR}/splash
}

SRC_URI[md5sum] = "d7c7cdab692fb2edc5cf5ebb554f20a1"
SRC_URI[sha256sum] = "9b20c37f2ae2247354b580e080bf0c3b650d3e63bf39c3d5573ef3b9c75fe0f0"
