DESCRIPTION = "Matrix GUI for Qt Embedded"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrix_gui/"
LICENSE = "BSD"
SECTION = "multimedia"
PRIORITY = "optional"

INC_PR = "r23"

COMPATIBLE_MACHINE = "(dm365|omapl138|omap3|ti816x|ti814x)"

PLATFORM_dm365-evm = "dm365"
PLATFORM_dm368-evm = "dm368"
PLATFORM_omapl138 = "omapl138"
PLATFORM_omap3evm = "omap3530"
PLATFORM_dm37x-evm = "dm3730"
PLATFORM_am37x-evm = "am3715"
PLATFORM_beagleboard = "am3715"
PLATFORM_ti816x = "ti816x"
PLATFORM_ti814x = "ti814x"
PLATFORM_am180x-evm = "am180x"
PLATFORM_am181x-evm = "am181x"
PLATFORM_am3517-evm = "am3517"

SRC_URI = "svn://gforge.ti.com/svn/matrix_gui/;module=trunk;proto=https;user=anonymous;pswd='' "

S = "${WORKDIR}/trunk"

INITSCRIPT_NAME = "matrix-gui-e"
INITSCRIPT_PARAMS = "defaults 99"
#INITSCRIPT_PARAMS = "start 99 3 . stop 99 3 ."

CXXFLAGS_omapl138_append = " -DPlatform_omapl138 "
CXXFLAGS_dm365_append = " -DPlatform_dm365 "
PACKAGE_ARCH = ${MACHINE_ARCH}

inherit qt4e update-rc.d

do_install() {
	install -d ${D}/${bindir}
	install -m 0755 ${S}/matrix_gui ${D}/${bindir}/matrix_guiE
	install -d ${D}${sysconfdir}/init.d/
	install -c -m 0755 ${S}/${PLATFORM}/etc/init ${D}${sysconfdir}/init.d/matrix-gui-e

}

RRECOMMENDS_${PN} = "qt4-embedded-plugin-mousedriver-tslib qt4-embedded-fonts"
RDEPENDS_${PN} += "matrix-gui-common"
