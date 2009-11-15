DESCRIPTION = "ioquake3 (or ioq3 for short,) aims to build upon id Software's Quake 3 source code release. "
DEPENDS = "virtual/libsdl"
LICENSE = "GPLv2"

PV = "1.34+svnr${SRCPV}"
SRCREV="1470"
SRC_URI = "svn://svn.icculus.org/quake3/;module=trunk"

S = "${WORKDIR}/trunk"

export COMPILE_PLATFORM = "linux"
export COMPILE_ARCH = "${TARGET_ARCH}"
export USE_OPENAL=0

do_install() {
	install -d ${D}/${bindir}
	install -d ${D}/${datadir}/games/quake3/baseq3
	install -m 0755 ${S}/build/release-${COMPILE_PLATFORM}-${COMPILE_ARCH}/*.${COMPILE_ARCH} ${D}/${bindir}
	cp -pPR ${S}/build/release-${COMPILE_PLATFORM}-${COMPILE_ARCH}/baseq3/*.so ${D}/${datadir}/games/quake3/baseq3/
}


FILES_${PN}-dbg += "${datadir}/games/quake3/baseq3/.debug"
FILES_${PN} += "${datadir}/games/quake3/baseq3/"
