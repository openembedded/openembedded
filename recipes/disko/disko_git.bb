DESCRIPTION = "Disko is an application framework, that can be used to develop GUI applications for embedded devices. It is closely connected to the DirectFB"
LICENSE = "GPL"
SRCREV = "f52597b8d5d584811cbe8f9e0bf25ea372526953"
PV = "1.6.1+gitr${SRCREV}"
PR = "r0"

DEFAULT_PREFERENCE = "-1"

require disko.inc

DEPENDS += "taglib directfb virtual/libx11 hal libxv libxxf86vm"

SRC_URI = "git://www.diskohq.org/disko.git;protocol=git \
	   file://pkgconfig.patch;patch=1 \
	  "

S = "${WORKDIR}/git"

do_compile() {
	${STAGING_BINDIR_NATIVE}/scons ${PARALLEL_MAKE} graphics=all prefix=${prefix}/ || \
        oefatal "scons build execution failed."
}
