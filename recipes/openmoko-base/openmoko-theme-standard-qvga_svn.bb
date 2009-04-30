DESCRIPTION = "Standard Gtk+ theme for the Openmoko distribution, qvga version"
SECTION = "openmoko/base"
PV = "0.0+svnr${SRCPV}"
PR = "r0"

inherit openmoko-base

SRC_URI = "${OPENMOKO_MIRROR}/src/target/${OPENMOKO_RELEASE}/artwork;module=themes;proto=http"
S = "${WORKDIR}"

dirs = "themes/openmoko-standard-qvga"

do_install() {
	find ${WORKDIR} -name ".svn" | xargs rm -rf
	install -d ${D}${datadir}/themes/
	for i in ${dirs}; do
		cp -fpPR ${WORKDIR}/$i ${D}${datadir}/themes/
	done
	
	install -d ${D}${sysconfdir}/gtk-2.0
	echo 'include "${datadir}/themes/openmoko-standard-qvga/gtk-2.0/gtkrc"' >> ${D}${sysconfdir}/gtk-2.0/gtkrc
}

PACKAGE_ARCH = "all"
FILES_${PN} = "${datadir} ${sysconfdir}"
