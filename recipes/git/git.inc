DESCRIPTION = "The git revision control system used by the Linux kernel developers"
SECTION = "console/utils"
LICENSE = "GPL"

SRC_URI = "http://www.kernel.org/pub/software/scm/git/git-${PV}.tar.bz2"

S = "${WORKDIR}/git-${PV}"

inherit autotools

EXTRA_OEMAKE = "NO_TCLTK=1"

do_install () {
	oe_runmake install DESTDIR="${D}" bindir=${bindir} \
		template_dir=${datadir}/git-core/templates \
		GIT_PYTHON_DIR=${datadir}/git-core/python
}

FILES_${PN} += "${datadir}/git-core"
