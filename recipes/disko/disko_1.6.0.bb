DESCRIPTION = "Disko is an application framework, that can be used to develop GUI applications for embedded devices. It is closely connected to the DirectFB"
LICENSE = "LGPL"
PR = "r0"

require disko.inc

DEPENDS += "taglib directfb virtual/libx11 hal libxv libxxf86vm"

SRC_URI = "http://www.diskohq.com/repository/ubuntu/pool/${PN}_${PV}.tar.bz2  \
	   file://pkgconfig.patch \
	  "

do_compile() {
        ${STAGING_BINDIR_NATIVE}/scons ${PARALLEL_MAKE} graphics=all prefix=${prefix}/ || \
        oefatal "scons build execution failed."
}
SRC_URI[md5sum] = "9725e3d692492188b4c74e38884501b9"
SRC_URI[sha256sum] = "6553d69dc4968f38840f408b6e75ece5f575a816ff8c2df76cccb6d966a836b7"

#SRC_URI[md5sum] = "c63bad58524501e367af9842f510b458"
#SRC_URI[sha256sum] = "fe578299be4031d0c2454ff4fd3b3034e332260b9695687adf27a776a61eb2e4"
