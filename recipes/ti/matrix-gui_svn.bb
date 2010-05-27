DESCRIPTION = "Matrix GUI for Qt X11"
HOMEPAGE = "https://gforge.ti.com/gf/project/matrix_gui/"
LICENSE = "BSD"
SECTION = "multimedia"
PRIORITY = "optional"

SRCREV = "58"
PV = "1.0"
PR = "r12+svnr${SRCPV}"

SRC_URI = "svn://gforge.ti.com/svn/matrix_gui/;module=trunk;proto=https;user=anonymous;pswd='' \
    file://0001-Disable-cursor-override-for-X11.patch;patch=1 \
	file://init \
"

S = "${WORKDIR}/trunk"

inherit qt4x11

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
	install -m 0755 ${S}/matrix_gui ${D}/${bindir}
	for i in ${MATRIX_EXTRA_BINS}; do
		install -m 0755 ${S}/bin/${i} ${D}/${bindir}
	done
	install -d ${D}/${datadir}/matrix/html
	install -m 0644 ${S}/*.html ${D}/${datadir}/matrix/html/
	install -d ${D}/${datadir}/matrix/images
	install -m 0644 ${S}/images/*.png ${D}/${datadir}/matrix/images/
	install -d ${D}${sysconfdir}/init.d/
	install -c -m 0755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/matrix-gui
}

FILES_${PN} += "${datadir}/matrix/*"
