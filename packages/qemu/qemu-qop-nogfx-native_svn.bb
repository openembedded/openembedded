LICENSE = "GPL"
PV = "0.8.0+svn${SRCDATE}"
PROVIDES = "qemu-native"

SRC_URI = "svn://nowt.dyndns.org/svn/qemu;module=trunk;proto=https \
           file://configure.patch;patch=1 \
           file://trunk_nodocs.patch;patch=1"
           
S = "${WORKDIR}/trunk"

inherit autotools native

EXTRA_OECONF = "--disable-gcc-check --target-list=arm-user,arm-softmmu --disable-gfx-check"

prefix = "${STAGING_DIR}/${BUILD_SYS}"

# tested to work with gcc4 for arm target only
# this is purely for others to test, not intended to be used as a replacement for the real qemu
