DESCRIPTION = "Common files for the OpenMoko framework"
SECTION = "openmoko/base"
PV = "0.0+svnr${SRCREV}"
PR = "r6"

inherit openmoko2

SRC_URI = "${OPENMOKO_MIRROR}/src/target/${OPENMOKO_RELEASE}/artwork;module=pixmaps;proto=http"
S = "${WORKDIR}"

ALLOW_EMPTY = "1"

dirs = "pixmaps"

do_install() {
	:
}

PACKAGE_ARCH = "all"
FILES_${PN} = "${datadir}"
