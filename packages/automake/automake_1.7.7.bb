SRC_URI = "${GNU_MIRROR}/automake/automake-${PV}.tar.bz2 \
	${@['file://path_prog_fixes.patch;patch=1', ''][bb.data.inherits_class('native', d)]}"
DESCRIPTION = "A tool for automatically generating Makefiles."
SECTION = "devel"
LICENSE = "GPL"
PR = "r7"
inherit autotools

FILES_${PN} += "${datadir}/automake* ${datadir}/aclocal*"

include automake.inc

do_install () {
	oe_runmake 'DESTDIR=${D}' install
	install -d ${D}${datadir}
	if [ ! -e ${D}${datadir}/aclocal ]; then
		ln -sf aclocal-1.7 ${D}${datadir}/aclocal
	fi
	if [ ! -e ${D}${datadir}/automake ]; then
		ln -sf automake-1.7 ${D}${datadir}/automake
	fi
}
