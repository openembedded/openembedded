DESCRIPTION = "vpx Multi-Format Codec SDK"
LICENSE = "BSD"

INC_PR = "r5"

SRC_URI = "git://review.webmproject.org/libvpx.git;protocol=git;tag=v${PV}"
S = "${WORKDIR}/git"

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
do_configure() {
	${S}/configure ${CONFIGUREOPTS}
}
do_compile() {
	oe_runmake
}
do_install() {
	oe_runmake install DESTDIR=${D}
}

