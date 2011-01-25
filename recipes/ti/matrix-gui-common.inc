DESCRIPTION = "Common files for all versions of Matrix GUI"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrix_gui/"
LICENSE = "BSD"
SECTION = "multimedia"
PRIORITY = "optional"

INC_PR = "r7"

COMPATIBLE_MACHINE = "(dm365|omapl138|omap3|ti816x)"

PLATFORM_dm365 = "dm365"
PLATFORM_omapl138 = "omapl138"
PLATFORM_omap3evm = "omap3530"
PLATFORM_dm37x-evm = "dm3730"
PLATFORM_am37x-evm = "am3715"
PLATFORM_beagleboard = "am3715"
PLATFORM_ti816x = "ti816x"
PLATFORM_am180x-evm = "am180x"
PLATFORM_am181x-evm = "am181x"
PLATFORM_am3517-evm = "am3517"

#Checkout the project repository to get access to the scripts and data
#files.
SRC_URI = "svn://gforge.ti.com/svn/matrix_gui/;module=trunk;proto=https;user=anonymous;pswd='' "

S = "${WORKDIR}/trunk"

PACKAGE_ARCH = ${MACHINE_ARCH}

do_install() {
    install -d ${D}/${bindir}
    install -m 0755 ${S}/${PLATFORM}/bin/* ${D}/${bindir}/
    install -d ${D}/${datadir}/matrix/html
    install -m 0644 ${S}/${PLATFORM}/html/* ${D}/${datadir}/matrix/html
    install -d ${D}/${datadir}/matrix/images
    install -m 0644 ${S}/images/*.png ${D}/${datadir}/matrix/images/
    install -m 0644 ${S}/images/*.svg ${D}/${datadir}/matrix/images/

}

FILES_${PN} += "${datadir}/matrix/*"
