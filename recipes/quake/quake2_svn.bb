DESCRIPTION = "Icculus.org quake2 engine"
LICENSE = "GPL"

DEPENDS = "libsdl-x11 libxxf86dga" 

SRCREV = "205"
PV = "0.16.1+svnr${SRCPV}"
PR = "r1"

SRC_URI = "svn://svn.icculus.org/quake2/;module=trunk \
           file://quake2-arm.patch;patch=1"

S = "${WORKDIR}/trunk"

export BUILD_SDLQUAKE2=YES
export OSTYPE=Linux
export ARCH=${TARGET_ARCH}
export BASE_CFLAGS="${TARGET_CC_ARCH} ${LDFLAGS} -Wall -pipe -Dstricmp=strcasecmp"
export OPT_CFLAGS="-O3 -ffast-math -funroll-loops -fomit-frame-pointer -fexpensive-optimizations"

do_compile() {
	sed -i -e s:=gcc:=${TARGET_PREFIX}gcc:g Makefile
	oe_runmake -e
}	

do_install() {
	install -d ${D}/${bindir}
	echo -e "#!/bin/sh \ncd ${libdir}/quake2 && ./quake2 \$@ \n" > ${D}/${bindir}/quake2

	( cd ${S}/debug${TARGET_ARCH} ; ln -sf game$(uname -m | sed -e s/i.86/i386/ -e s/sun4u/sparc/ -e s/sparc64/sparc/ -e s/arm.*/arm/ -e s/sa110/arm/ -e s/alpha/axp/).so game${TARGET_ARCH}.so ) 
	install -d ${D}/${libdir}/quake2/baseq2/ctf
	install -m 0755 ${S}/debug${TARGET_ARCH}/game${TARGET_ARCH}.so ${D}/${libdir}/quake2/baseq2
	install -m 0755 ${S}/debug${TARGET_ARCH}/ref*.so ${D}/${libdir}/quake2
	install -m 0755 ${S}/debug${TARGET_ARCH}/ctf/*.so ${D}/${libdir}/quake2/baseq2/ctf
	install -m 0755 ${S}/debug${TARGET_ARCH}/quake2 ${D}/${libdir}/quake2
}

FILES_${PN} += "${libdir}"
FILES_${PN}-dbg += "${libdir}/quake2/baseq2/.debug ${libdir}/quake2/baseq2/ctf/.debug"

