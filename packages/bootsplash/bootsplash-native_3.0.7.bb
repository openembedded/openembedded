# bootsplash-native OE build file
# Copyright (C) 2004, Advanced Micro Devices, Inc.  All Rights Reserved
# Released under the MIT license (see packages/COPYING)

include bootsplash_${PV}.bb

inherit native
S="${WORKDIR}/bootsplash-${PV}"

do_compile() {
	oe_runmake -C Utilities splash
}

do_stage() {
	install -d ${STAGING_BINDIR}
	install -m 0755 Utilities/splash ${STAGING_BINDIR}/splash
}
