DESCRIPTION = "Qt Widget Extension for Technical Applications"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPL"
DEPENDS = "virtual/libqte2"
PR = "r2"

SRC_URI = "${SOURCEFORGE_MIRROR}/qwt/qwt-${PV}.tgz \
          file://qt2-fix.patch;patch=1"

inherit palmtop

EXTRA_QMAKEVARS_POST += "LIBS-=qpe"

do_stage() {
	oe_libinstall -so -C lib libqwt ${STAGING_LIBDIR}
	cp -pPR include/* ${STAGING_INCDIR}
}

do_install() {
	install -d ${D}${libdir} \
		   ${D}${includedir}
	oe_libinstall -so -C lib libqwt ${D}${libdir}
	cp -pPR include/* ${D}${includedir}
}

FILES_${PN} = "${libdir}"


SRC_URI[md5sum] = "142b10ab27e837c3c4603cf9a7e9343b"
SRC_URI[sha256sum] = "3b6db68d53441119dced27e5bad26ec087294cb9d878d37bcea61e1f1e4849a1"
