SECTION = "devel"
# cut-down gcc for kernel builds
# only installs ${TARGET_PREFIX}gcc-${PV}, not ${TARGET_PREFIX}gcc.

include gcc-cross-initial_${PV}.bb

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
