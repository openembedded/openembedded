DESCRIPTIONS = "API Specification for freesmartphone.org"
AUTHOR = "Mickey Lauer"

PV = "0.0.1-gitr${SRCREV}"

SRC_URI = "git://git.freesmartphone.org/specs.git;protocol=git;branch=master"
S = "${WORKDIR}/git"

do_compile() {
	     make xml
}

do_stage() {
	   mkdir -p "${STAGING_DATADIR}/fso-specs"
	   cp xml/* "${STAGING_DATADIR}/fso-specs/"
}

FILE_${PN}-dev = "${datadir}/fso-specs"
