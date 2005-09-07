include gcc_csl-arm.bb

SRC_URI += "file://15342.patch;patch=1 file://gcc-3.4.0-arm-lib1asm.patch;patch=1 file://no-libfloat.patch;patch=1"

PR = "r3"

CVSDATE = "20050416"
OVERRIDES_append = ":${TARGET_ARCH}-${TARGET_OS}"
DEFAULT_PREFERENCE_arm-linux = "-1"
DEFAULT_PREFERENCE_arm-linuxeabi = "1"

