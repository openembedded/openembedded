DESCRIPTION = "Tools for ethernet bridging."
LICENSE = "GPL"
SECTION = "console/network"
SRC_URI = "${SOURCEFORGE_MIRROR}/bridge/bridge-utils-${PV}.tgz \
	   file://failout.patch;patch=1"
S = "${WORKDIR}/bridge-utils-${PV}"

# The default sourceforge mirror does not yet have this package, and
# sourceforge redirects on the file missing so wget doesn't realize it failed.
# Force our own default here, since its known to have it.
PREMIRRORS_prepend () {
	${SOURCEFORGE_MIRROR}	http://unc.dl.sourceforge.net/sourceforge
}

inherit autotools

EXTRA_OECONF = "--with-linux-headers=${STAGING_INCDIR}"
