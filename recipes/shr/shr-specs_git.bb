DESCRIPTION = "The SHR DBus API Specification"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "BSD"
SECTION = "devel/specifications"
SRCREV = "53ad1e858eb85eeb3d7c32e7402e93264072e347"
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


