DESCRIPTION = "Irrlicht 3D rendering engine "
LICENSE = "zlib"
DEPENDS = "virtual/libx11 libxxf86vm virtual/egl"

SRCREV = "2409"
PV = "1.6+svnr${SRCPV}"

SRC_URI = "svn://irrlicht.svn.sourceforge.net/svnroot/irrlicht/branches;module=ogl-es;proto=https \
           file://irrlicht_beagle.diff;patch=1;pnum=0 \
          "

TARGET_CC_ARCH += "${LDFLAGS}"

S = "${WORKDIR}/ogl-es"

do_compile(){
	cd ${WORKDIR}/ogl-es/source/Irrlicht
	oe_runmake
	cd ${WORKDIR}/ogl-es/examples
	oe_runmake
}

EXTRA_OEMAKE = -I${WORKDIR}/egl-es/include

do_stage() {
	install ${S}/lib/Linux/libIrrlicht.a ${STAGING_LIBDIR}
}

do_install() {
	install -d ${D}${datadir}/irrlicht/bin
	install -d ${D}${libdir}
	install ${S}/lib/Linux/libIrrlicht.a ${D}${libdir}
	cp -a ${S}/bin/Linux ${D}${datadir}/irrlicht/bin/
	mkdir ${D}${datadir}/irrlicht/media
	cp ${S}/media/* ${D}${datadir}/irrlicht/media/
	find ${D} -name ".svn" | xargs rm -rf
}

FILES_${PN} = "${datadir}/irrlicht/"
FILES_${PN}-dbg += "${datadir}/irrlicht/bin/Linux/.debug"
FILES_${PN} += "${libdir}/"

