DESCRIPTION = "Zad - GUI"
HOMEPAGE = "http://neo1973-germany.de/wiki/Zad"
AUTHOR = "M. Dietrich"
SECTION = "python/ui"
LICENSE = "GPL"
PV = "0.0.0+gitr${SRCREV}"
PR = "r0"

SRC_URI = "${FREESMARTPHONE_GIT}/pyneo.git;protocol=git;branch=master"
S = "${WORKDIR}/git/pyneog"

do_compile() {
	:
}

do_install() {
	find . -name ".svn"|xargs rm -rf
	install -d ${D}${datadir}/pyneog
	for i in media *.py; do
		cp -a $i ${D}${datadir}/pyneog/
	done

	install -d ${D}${sysconfdir}/X11/Xsession.d/
	install -m 0755 80pyneog ${D}${sysconfdir}/X11/Xsession.d/
}

FILES_${PN} = "${datadir} ${bindir} ${sysconfdir}"

RCONFLICTS = "openmoko-session2"
RREPlACES = "openmoko-session2"
RDEPENDS = "task-python-efl"
PACKAGE_ARCH = "${MACHINE_ARCH}"
