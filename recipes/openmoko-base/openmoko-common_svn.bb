DESCRIPTION = "Common files for the Openmoko distribution"
SECTION = "openmoko/base"
PV = "0.0+svnr${SRCPV}"
PR = "r1"

inherit openmoko-base

SRC_URI = "${OPENMOKO_MIRROR}/src/target/${OPENMOKO_RELEASE}/artwork;module=images;proto=http"
S = "${WORKDIR}"

dirs = "images/pixmaps"

do_install() {
	find ${WORKDIR} -name ".svn" | xargs rm -rf
	install -d ${D}${datadir}/openmoko/
	for i in ${dirs}; do
		cp -fpPR ${S}/$i ${D}${datadir}/openmoko/
	done
}

FILES_${PN} = "${datadir}"
