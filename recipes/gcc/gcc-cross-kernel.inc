# Cut-down gcc for kernel builds
# Only installs ${TARGET_PREFIX}gcc-${PV}, not ${TARGET_PREFIX}gcc.

DEPENDS += "gcc-cross"

PROVIDES = "virtual/${TARGET_PREFIX}gcc-${PV}"

do_compile () {
	# This compiler is only for the kernel.  Don't bother running fixincludes.
	mkdir -p gcc
	touch gcc/stmp-fixinc
	oe_runmake
}

do_install () {
	cd gcc
	oe_runmake 'DESTDIR=${D}' installdirs install-common install-headers install-libgcc
	install -d ${D}${STAGING_BINDIR}
	install -m 0755 xgcc ${D}${STAGING_BINDIR}/${TARGET_PREFIX}gcc-${PV}
}
