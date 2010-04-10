require ../bash/bash.inc
PR = "r1"

RCONFLICTS = "bash"
RREPLACES = "bash"

SRC_URI = "${GNU_MIRROR}/bash/bash-${PV}.tar.gz \
           file://001-005.patch;patch=1 \
           file://006-add_internal_libcpwd_functions.patch;patch=1"

S = "${WORKDIR}/bash-${PV}"

EXTRA_OECONF += "--enable-static-link --without-bash-malloc"

#HOST_SYS = "${BUILD_SYS}"
#CONFIG_SITE = ""

do_configure () {
    export CPP="gcc -E"
    export CC=gcc
    export AS=as
    export LD=ld
    export CXX=g++ 
    export AR=ar
    export OBJCOPY=objcopy 
    export OBJDUMP=objdump 
    export RANLIB=ranlib 
    export NM=nm 
    export STRIP=strip
    export CFLAGS="-fexpensive-optimizations -fomit-frame-pointer -frename-registers -Os"
    export CXXFLAGS="-fexpensive-optimizations -fomit-frame-pointer -frename-registers -Os -fpermissive -fvisibility-inlines-hidden"
    oe_runconf
}

SRC_URI[md5sum] = "00bfa16d58e034e3c2aa27f390390d30"
SRC_URI[sha256sum] = "26c99025b59e30779300b68adb764f824974d267a4d7cc1b347d14a2393f9fb4"
