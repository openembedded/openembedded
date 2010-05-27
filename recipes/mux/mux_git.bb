DESCRIPTION = "GTK+ widgets for moblin"
SRC_URI = "git://git.moblin.org/${PN}.git;protocol=git"
LICENSE = "LGPLv2.1"
SRCREV = "72460e890dbb15edbf7dc193116be0dcf9794a8b"
PV = "0.0+git${SRCREV}"
PR = "r0"

LICENSE = "LGPLv2.1"

S = "${WORKDIR}/git"

DEPENDS = "gtk+"

inherit autotools_stage
