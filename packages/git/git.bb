SECTION = "console/utils"
LICENSE = "GPL"
DESCRIPTION = "The git revision control system used by the Linux kernel developers"
DEPENDS = "openssl curl"
MAINTAINER = "Richard Purdie <rpurdie@rpsys.net>"

PKGDATE = "${@time.strftime('%Y-%m-%d',time.gmtime())}"

SRC_URI = "http://www.codemonkey.org.uk/projects/git-snapshots/git/git-${PKGDATE}.tar.gz"

S = "${WORKDIR}/git-snapshot-${DATE}"

FILES_${PN} += "${datadir}/git-core"

do_install () {
	oe_runmake install prefix=${D} bindir=${D}${bindir} \
		template_dir=${D}${datadir}/git-core/templates \
		GIT_PYTHON_DIR=${D}${datadir}/git-core/python
}

