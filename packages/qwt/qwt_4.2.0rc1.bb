DESCRIPTION = "Qt Widget Extension for Technical Applications"
SECTION = "libs"
PRIORITY = "optional"
MAINTAINER = "Michael 'Mickey' Lauer <mickey@Vanille.de>"
LICENSE = "GPL"
DEPENDS = "virtual/libqte2"
PR = "r1"

SRC_URI = "${SOURCEFORGE_MIRROR}/qwt/qwt-${PV}.tgz \
          file://qt2-fix.patch;patch=1"

inherit qmake

EXTRA_QMAKEVARS_POST = "CONFIG-=thread"

do_stage() {
	oe_libinstall -so -C lib libqwt ${STAGING_LIBDIR}
	cp -a include/* ${STAGING_INCDIR}
}

do_install() {
	install -d ${D}${libdir} \
		   ${D}${includedir}
	oe_libinstall -so -C lib libqwt ${D}${libdir}
	cp -a include/* ${D}${includedir}
}

