SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libogg"
DESCRIPTION = "tremor is a fixed point implementation of the vorbis codec."
LICENSE = "BSD"
SRCDATE = "${PV}"
PR = "r1"

# tremor makes heavy use of non-thumb-compatible inline asm.
ARM_INSTRUCTION_SET = "arm"

SRC_URI = "svn://svn.xiph.org/trunk;module=Tremor;rev=4573;proto=http"

S = "${WORKDIR}/Tremor"

inherit autotools

EXTRA_OECONF=" --enable-shared --disable-rpath  "

do_stage() {
    autotools_stage_all
}
