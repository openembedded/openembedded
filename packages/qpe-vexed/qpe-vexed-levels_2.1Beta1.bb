DESCRIPTION = "Vexed levels for qpe-vexed"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL"
AUTHOR = "The Vexed Development Team"
HOMEPAGE = "http://vexed.sourceforge.net/"
PACKAGE_ARCH = "all"
PR = "r1"

SRC_URI = "cvs://anonymous@cvs.sourceforge.net/cvsroot/vexed/;module=vexed/levelpacks"

S = "${WORKDIR}"

do_install () {
	install -d ${D}${palmtopdir}/etc/qpe-vexed

	for level in ${WORKDIR}/levelpacks/*.ini;
	do
	    install -m 0664 "$level" "${D}${palmtopdir}/etc/qpe-vexed/`basename "$level" .ini`.lvl";
	done
}

FILES_${PN} = "${palmtopdir}/etc/qpe-vexed/*.lvl"

