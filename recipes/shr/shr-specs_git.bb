DESCRIPTION = "The SHR DBus API Specification"
HOMEPAGE = "http://shr-project.org/"
LICENSE = "BSD"
SECTION = "devel/specifications"
SRCREV = "d8f0dc85f1a7a6c0c6d24755f3770a55229621ae"
PV = "0.0.0+gitr${SRCREV}"
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


