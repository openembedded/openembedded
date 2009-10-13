DESCRIPTION = "Disko is an application framework, that can be used to develop GUI applications for embedded devices. It is closely connected to the DirectFB"
LICENSE = "GPL"
PV = "1.6.0+gitr${SRCREV}"
PR = "r0"

require disko.inc

DEPENDS += "taglib directfb virtual/libx11 hal libxv libxxf86vm"

SRC_URI = "git://www.diskohq.org/disko.git;protocol=git \
	   file://linkpath.patch;patch=1 \
	   file://pkgconfig.patch;patch=1 \
	  "

SRCREV = "2aa9912fc32fcf24574e5053201e967dd59bceca"

S = "${WORKDIR}/git"

do_compile() {
	${STAGING_BINDIR_NATIVE}/scons ${PARALLEL_MAKE} graphics=all PREFIX=${prefix} prefix=${prefix} || \
        oefatal "scons build execution failed."
}
