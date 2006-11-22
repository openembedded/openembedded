SECTION = "console/utils"
LICENSE = "GPL"
DESCRIPTION = "The git revision control system used by the Linux kernel developers"
DEPENDS = "openssl curl"
RDEPENDS = "perl \
	    perl-module-file-path \
	    "

PR = "r2"

def get_git_pkgdate(d):
    import bb
    srcdate = bb.data.getVar('SRCDATE', d, 1)
    return "-".join([srcdate[0:4], srcdate[4:6], srcdate[6:8]])

PKGDATE = "${@get_git_pkgdate(d)}"

SRC_URI = "http://www.codemonkey.org.uk/projects/git-snapshots/git/git-${PKGDATE}.tar.gz"
PV = "1.4.3.5+snapshot${PKGDATE}"

S = "${WORKDIR}/git-${PKGDATE}"

FILES_${PN} += "${datadir}/git-core"

do_install () {
	oe_runmake install prefix=${D} bindir=${D}${bindir} \
		template_dir=${D}${datadir}/git-core/templates \
		GIT_PYTHON_DIR=${D}${datadir}/git-core/python
}

