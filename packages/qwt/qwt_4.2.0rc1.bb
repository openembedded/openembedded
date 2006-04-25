DESCRIPTION = "Qt Widget Extension for Technical Applications"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
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

