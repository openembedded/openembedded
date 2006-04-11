include gcc_csl-arm.bb

PV = "3.4.4+csl-arm-${SRCDATE}"
BINV = "3.4.4"

SRC_URI += "file://15342.patch;patch=1 file://gcc-3.4.0-arm-lib1asm.patch;patch=1 file://no-libfloat.patch;patch=1"

PR = "r0"

DEFAULT_PREFERENCE = "-1"
