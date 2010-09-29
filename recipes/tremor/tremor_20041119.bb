SECTION = "libs"
PRIORITY = "optional"
DEPENDS = "libogg"
DESCRIPTION = "tremor is a fixed point implementation of the vorbis codec."
LICENSE = "BSD"
SRCDATE = "${PV}"
PR = "r2"

# tremor makes heavy use of non-thumb-compatible inline asm.
ARM_INSTRUCTION_SET = "arm"

PROVIDES += "libvorbisidec"

SRC_URI = "svn://svn.xiph.org/trunk;module=Tremor;rev=4573;proto=http \
	file://pkgconfig.patch"

S = "${WORKDIR}/Tremor"

inherit autotools pkgconfig

EXTRA_OECONF=" --enable-shared --disable-rpath  "

