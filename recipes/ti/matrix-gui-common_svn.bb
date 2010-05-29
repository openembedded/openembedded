DESCRIPTION = "Common files for all versions of Matrix GUI"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrix_gui/"
LICENSE = "BSD"
SECTION = "multimedia"
PRIORITY = "optional"

SRCREV = "58"
PV = "1.0"
PR = "r1+svnr${SRCPV}"

#Checkout the project repository to get access to the scripts and data
#files.
SRC_URI = "svn://gforge.ti.com/svn/matrix_gui/;module=trunk;proto=https;user=anonymous;pswd='' \
    file://browser \
"

S = "${WORKDIR}/trunk"

MATRIX_EXTRA_BINS = " \
    memInfo \
    networkSettings \
    runOGLES2Coverflow \
    runOGLES2Shaders \
    runOGLESChameleonMan \
    runOGLESVase \
    setopp1 \
    setopp2 \
    setopp3 \
    setopp4 \
    standby \
    sysSettings \
    taskInfo \
"

do_install() {
    install -d ${D}/${bindir}
    for i in ${MATRIX_EXTRA_BINS}; do
        install -m 0755 ${S}/bin/${i} ${D}/${bindir}
    done
    install -m 0755 ${WORKDIR}/browser ${D}/${bindir}
    install -d ${D}/${datadir}/matrix/html
    install -m 0644 ${S}/*.html ${D}/${datadir}/matrix/html/
    install -d ${D}/${datadir}/matrix/images
    install -m 0644 ${S}/images/*.png ${D}/${datadir}/matrix/images/
}

FILES_${PN} += "${datadir}/matrix/*"
