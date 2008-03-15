# This kernel compiler is required by the Freecom FSG-3 machine
# Please talk to Rod Whitby before considering removing this file.

DEFAULT_PREFERENCE = "-1"

# cut-down gcc for kernel builds
# only installs ${TARGET_PREFIX}gcc-${PV}, not ${TARGET_PREFIX}gcc.

require gcc-cross-initial_csl-arm-2005q3.bb

PROVIDES = "virtual/${TARGET_PREFIX}gcc-${PV}"

SRC_URI += "file://gcc-3.4.4-makefile-fix.patch;patch=1"

do_install () {
	:
}

do_stage () {
	cd gcc
	oe_runmake install-common install-headers install-libgcc
	install -m 0755 xgcc ${CROSS_DIR}/bin/${TARGET_PREFIX}gcc-${PV}
}

