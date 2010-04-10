DESCRIPTION = "Disko is an application framework, that can be used to develop GUI applications for embedded devices. It is closely connected to the DirectFB"
LICENSE = "LGPL"
PR = "r0"

require disko.inc

DEPENDS += "taglib directfb virtual/libx11 hal libxv libxxf86vm"

SRC_URI = "http://www.diskohq.org/downloads/${PN}-${PV}.tar.gz \
	   file://pkgconfig.patch;patch=1 \
	  "

do_compile() {
        ${STAGING_BINDIR_NATIVE}/scons ${PARALLEL_MAKE} graphics=all prefix=${prefix}/ || \
        oefatal "scons build execution failed."
}

SRC_URI[md5sum] = "c63bad58524501e367af9842f510b458"
SRC_URI[sha256sum] = "fe578299be4031d0c2454ff4fd3b3034e332260b9695687adf27a776a61eb2e4"
