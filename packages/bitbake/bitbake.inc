DESCRIPTION = "BitBake is a simple tool for the execution of tasks. It is \
derived from Portage, which is the package management system used by the \
Gentoo Linux distribution. It is most commonly used to build packages, as it \
can easily use its rudimentary inheritence to abstract common operations, such \
as fetching sources, unpacking them, patching them, compiling them, and so on. \
It is the basis of the OpenEmbedded project, which is being used for \
Angstrom and a number of other embedded Linux distributions."
HOMEPAGE = "http://developer.berlios.de/projects/bitbake/"
LICENSE = "GPL MIT"
SECTION = "devel"
SUMMARY = "BitBake build tool"
RDEPENDS += "python-shell python-lang python-textutils python-pickle python-crypt python-netclient"

# crypt for md5
# netclient for tinderclient.bbclass

# We don't need a toolchain...
INHIBIT_DEFAULT_DEPS = "1"

inherit distutils

FILES_${PN} += "${datadir}/bitbake"
