DESCRIPTION = "This is a modified version of the icecc-create-env script in order to\
make it work with OE."
SECTION = "base"
PRIORITY = "optional"
LICENSE = "GPL"

DEPENDS = ""
INHIBIT_DEFAULT_DEPS = "1"


inherit native


SRC_URI = "http://www.digital-opsis.com/openembedded/icecc-create-env-${PV}.tar.gz"

S = "${WORKDIR}/icecc-create-env-${PV}"

do_stage() {
	install -d ${STAGING_DIR}/ice
	install -m 0755 ${WORKDIR}/icecc-create-env ${STAGING_DIR}/ice/icecc-create-env
}

SRC_URI[md5sum] = "641ec45fe377529c7fd914f77b11b44f"
SRC_URI[sha256sum] = "9ff8360375432a7a5c476cc6d55b3fdea9d6f3edc080d295a60421d8f47b1834"
