DESCRIPTION = "Disko is an application framework, that can be used to develop GUI applications for embedded devices. It is closely connected to the DirectFB"
LICENSE = "GPL"
PV = "1.1.5+gitr${SRCREV}"
PR = "r0"

DEPENDS = "sqlite3 libpng jpeg curl alsa-lib taglib directfb libxml2 virtual/libx11 libsigc++-2.0 hal \
	   libxv libxxf86vm"

SRC_URI = "git://www.diskohq.org/disko.git;protocol=git \
	   file://header.patch;patch=1 \
           file://pkgconfig.patch;patch=1 \
	  "
SRCREV = "bf29da8c0060a2b4f0f9593524ca71aa1adfbc0c"

S = "${WORKDIR}/git"

inherit scons pkgconfig

do_compile() {
	${STAGING_BINDIR_NATIVE}/scons ${PARALLEL_MAKE} graphics=all PREFIX=${prefix} prefix=${prefix} || \
        oefatal "scons build execution failed."
}
