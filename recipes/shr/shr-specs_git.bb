DESCRIPTION = "The SHR DBus API Specification"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "BSD"
SECTION = "devel/specifications"
SRCREV = "161a4186a2f53976add7033fd39c8056797d68f7"
PV = "0.0.0+gitr${SRCPV}"
PR = "r0"

SRC_URI = "git://git.shr-project.org/repo/shr-specs.git;protocol=http;branch=master"
S = "${WORKDIR}/git"

do_compile() {
	make xml
}

do_stage() {
	install -d "${STAGING_DATADIR}/shr-specs"
	install -m 0644 xml/* "${STAGING_DATADIR}/shr-specs"
}

FILE_${PN}-dev += "${datadir}/shr-specs"


