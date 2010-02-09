require flex.inc
PR = "r5"

SRC_URI = "${SOURCEFORGE_MIRROR}/flex/flex-${PV}.tar.bz2 \
           file://flex-lvalue.diff;patch=1 \
           file://fix-gen.patch;patch=1 \
           file://include.patch;patch=1"

do_stage() {
	oe_libinstall -a libfl ${STAGING_LIBDIR}
}

