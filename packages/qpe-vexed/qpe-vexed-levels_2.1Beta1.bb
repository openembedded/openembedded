DESCRIPTION = "Vexed levels for qpe-vexed"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL"
AUTHOR = "The Vexed Development Team"
HOMEPAGE = "http://vexed.sourceforge.net/"

SRC_URI = "${SOURCEFORGE_MIRROR}/vexed/vexed21Beta1.zip"

S = "${WORKDIR}"

do_install () {
	install -d ${D}${palmtopdir}/etc/qpe-vexed

	cd ${WORKDIR}
	for level in *.pdb
	do
	    cp "$level" "`basename "$level" .pdb`.lvl"
	done

	install -m 0644 ${WORKDIR}/*.lvl ${D}${palmtopdir}/etc/qpe-vexed/
}

FILES_${PN} = "${palmtopdir}/etc/qpe-vexed/*.lvl"

