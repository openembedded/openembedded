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
