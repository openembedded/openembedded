# unfreeze undoes the work of freeze by making the frozen
# configuration fails empty (they just contain a comment).
#
DESCRIPTION = "Unfreeze the bitbake files in the build"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "console/networking"
PRIORITY = "optional"
LICENSE = "MIT"
PR = "r1"

INHIBIT_DEFAULT_DEPS = "1"
PATCH_DEPENDS = ""
ALLOW_EMPTY = 1
PACKAGES = ""

SRC_URI = "file://unfreeze"

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
	# unfreeze
	set -x
	# this is a sanity check:
	if test -d "${PKGDIR}/packages"
	then
		FROZEN_DIR="${FROZEN_DIR}" DISTRO="${DISTRO}" sh "${WORKDIR}/unfreeze"
	else
		oenote "\$PKGDIR/packages ($PKGDIR/packages) not found"
		oefatal "\$PKGDIR must be defined for freeze/unfreeze to work"
	fi
	set +x
}
