DESCRIPTION = "A python application that backs up one directory to \
another, possibly over a network. It combines the best features of a \
mirror and an incremental backup. The target directory ends up a copy \
of the source directory, but extra reverse diffs are stored in a \
special subdirectory of that target directory, so you can still \
recover files lost some time ago. It is also able to preserve \
subdirectories, hard links, dev files, permissions, uid/gid \
ownership, modification times, extended attributes, acls, and \
resource forks."
HOMEPAGE = "http://www.nongnu.org/rdiff-backup/"
SECTION = "network"
LICENSE = "GPL"
DEPENDS = "librsync"
RDEPENDS_${PN} = "zlib python-re python-io python-lang python-datetime \
		  python-pickle python-shell python-compression python-unixadmin \
		  python-netclient"

SRC_URI = "http://savannah.nongnu.org/download/rdiff-backup/rdiff-backup-${PV}.tar.gz"

inherit distutils

#
# Without this the python interpreter path points to the staging area.
#
do_compile() {
	BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
	  ${STAGING_BINDIR}/python setup.py build --executable=${bindir}/python || \
	  oefatal "python setup.py build execution failed."
}

#
# The default do_install sets install-data to ${D}/${datadir} which
# ends up with documentation in /usr/share/share/... instead of
# /usr/share/... Modify the install data directory here to get it
# into the correct place.
#
do_install() {
	BUILD_SYS=${BUILD_SYS} HOST_SYS=${HOST_SYS} \
	  ${STAGING_BINDIR}/python setup.py install --prefix=${D}/${prefix} --install-data=${D}/${prefix} || \
	  oefatal "python setup.py install execution failed."
}
