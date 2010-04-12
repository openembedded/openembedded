SECTION = "base"
PR = "r1"
require fakechroot_${PV}.bb
inherit native

S = "${WORKDIR}/fakechroot-${PV}"

EXTRA_OECONF = " --program-prefix="

do_stage_append () {
    oe_libinstall -so libfakechroot ${STAGING_LIBDIR}/libfakechroot/
}

SRC_URI[md5sum] = "b885951b98f4316f9686699e9853513d"
SRC_URI[sha256sum] = "990cd830ea362ba2cb88ca7b59cd3f4d115a054621450b5cf211cadebed23ee0"
