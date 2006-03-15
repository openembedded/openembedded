DESCRIPTION = "Vexed levels for qpe-vexed"
SECTION = "opie/games"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL"
AUTHOR = "The Vexed Development Team"
HOMEPAGE = "http://vexed.sourceforge.net/"
PACKAGE_ARCH = "all"
PR = "r2"

SRC_URI = "http://ewi546.ewi.utwente.nl/mirror/hrw-oe-sources/vexed-levelpacks-20060109.tar.gz"

S = "${WORKDIR}"

do_install () {
	install -d ${D}${palmtopdir}/etc/qpe-vexed

	for level in ${WORKDIR}/levelpacks/*.ini;
	do
	    install -m 0664 "$level" "${D}${palmtopdir}/etc/qpe-vexed/`basename "$level" .ini`.lvl";
	done
}

FILES_${PN} = "${palmtopdir}/etc/qpe-vexed/*.lvl"

