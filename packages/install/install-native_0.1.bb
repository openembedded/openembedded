# This package uses the GNU autotools install-sh script to implement
# a target-capable 'install' command.
DESCRIPTION = "Target install command"
MAINTAINER = "John Bowler <jbowler@acm.org>"
SECTION = "devel"
PRIORITY = "optional"
LICENSE = "MIT"
INHIBIT_DEFAULT_DEPS = "1"
PR = "r1"

SRC_URI = "file://install-sh"

PACKAGES = ""
S = "${WORKDIR}"

do_stage() {
	# When the install command is executed 'STRIP' is defined correctly in
	# the environment
	rm -f ${STAGING_BINDIR}/install-sh
	cp install-sh ${STAGING_BINDIR}/install-sh
	chmod 755 ${STAGING_BINDIR}/install-sh
	rm -f ${STAGING_BINDIR}/install
	echo '#!/bin/sh' >${STAGING_BINDIR}/install
	echo 'STRIPPROG="$STRIP" exec sh "${STAGING_BINDIR}/install-sh" "$@"' >>${STAGING_BINDIR}/install
	chmod 755 ${STAGING_BINDIR}/install
}
