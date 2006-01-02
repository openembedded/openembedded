# freeze finds all the bitbake files used by the stuff
# currently built in ${TMPDIR}/work and writes those
# files into frozen-bbfiles.conf, then it writes the
# directories containing the files into frozen-packages.conf
#
# The two files define (just) the BBFILES variable.
#
# The path names in the BBFILES variable are of the form:
#
# ${PKGDIR}/packages/directory/bbfile.bb
# ${PKGDIR}/packages/directory/*.bb
#
# as appropriate, directory is the sub-directory of 'packages'.
#
DESCRIPTION = "Freeze the bitbake files in the build"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "console/networking"
PRIORITY = "optional"
LICENSE = "MIT"
PR = "r1"

INHIBIT_DEFAULT_DEPS = "1"
PATCH_DEPENDS = ""
ALLOW_EMPTY = 1
PACKAGES = ""

SRC_URI = "file://freeze"

do_configure() {
}
do_compile() {
}
do_install() {
}
do_stage() {
}

do_build[nostamp] = 1
do_build() {
	# export FROZEN_DIR=<place to write conf files>
	# export PKGDIR=<location of openembedded package source>
	# export DISTRO=<distro being frozen>
	# freeze {directories}
	set -x
	if test -d "${PKGDIR}/packages"
	then
		FROZEN_DIR="${FROZEN_DIR}" PKGDIR="${PKGDIR}" DISTRO="${DISTRO}" \
			sh "${WORKDIR}/freeze" "${TMPDIR}/work"
	else
		oenote "\$PKGDIR/packages ($PKGDIR/packages) not found"
		oefatal "\$PKGDIR must be defined for freeze to work"
	fi
	set +x
}
