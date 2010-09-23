DESCRIPTION = "vpx Multi-Format Codec SDK"
LICENSE = "BSD"

INC_PR = "r4"

SRC_URI = "http://webm.googlecode.com/files/libvpx-${PV}.tar.bz2"

inherit autotools

CFLAGS += "-fPIC"

export CC
export LD = "${CC}"

VPXTARGET_armv5te = "armv5te-linux-gcc"
VPXTARGET_armv6 = "armv6-linux-gcc"
VPXTARGET_armv7a = "armv7-linux-gcc"
VPXTARGET ?= "generic-gnu"

CONFIGUREOPTS = " \
          --target=${VPXTARGET} \
          --enable-vp8 \
          --enable-libs \
          --disable-install-docs \
"

do_install() {
	oe_runmake install DESTDIR=${D}
}

