DESCRIPTION = "vpx Multi-Format Codec SDK"
LICENSE = "VP8"

PR = "r3"

SRC_URI = "http://webm.googlecode.com/files/libvpx-${PV}.tar.bz2"

SRC_URI[md5sum] = "9eb8e818d2f3263623c258fe66924082"
SRC_URI[sha256sum] = "a0096ac6859cfb61cf06dd9bc0a79a3333a4ec389ba311911d84df8ff2a1b9dc"

inherit autotools

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
	oe_runmake install
	install -d ${D}${prefix}
	cp -r ${S}/vpx-vp8-nopost-nodocs*${PV}/* ${D}${prefix}/
	install -d ${D}${includedir}/vpx
	mv ${D}${includedir}/*.h ${D}${includedir}/vpx
}

