DESCRIPTIONS = "API Specification for freesmartphone.org"
AUTHOR = "Michael 'Mickey' Lauer"
HOMEPAGE = "http://docs.freesmartphone.org"
LICENSE = "BSD"
SECTION = "devel/specifications"
PV = "0.0.1-gitr${SRCREV}"
PR = "r2"

SRC_URI = "${FREESMARTPHONE_GIT}/specs.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

do_compile() {
	make xml
}

do_stage() {
	install -d "${STAGING_DATADIR}/fso-specs"
	install -m 0644 xml/* "${STAGING_DATADIR}/fso-specs"
}

FILE_${PN}-dev += "${datadir}/fso-specs"
