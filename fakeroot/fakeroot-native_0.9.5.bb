SECTION = "base"
include fakeroot_${PV}.bb
inherit native

S = ${WORKDIR}/fakeroot-${PV}

EXTRA_OECONF = "--program-prefix= "

do_stage_append () {
    oe_libinstall -so libfakeroot ${STAGING_LIBDIR}/libfakeroot/
}
