# Version 5 of the Berkeley DB from Oracle
#
# At present this package only installs the DB code
# itself (shared libraries, .a in the dev package),
# documentation and headers.
#
# The headers have the same names as those as v3
# of the DB, only one version can be used *for dev*
# at once - DB3 and DB5 both be installed on the
# same system at the same time if really necessary.


DESCRIPTION = "Berkeley DB v5."
HOMEPAGE = "http://www.oracle.com/technology/products/berkeley-db/db/index.html"
SECTION = "libs"
LICENSE = "BSD"
VIRTUAL_NAME ?= "virtual/db"
CONFLICTS = "db3 db4"

SRC_URI = "ftp://ftp.freebsd.org/pub/FreeBSD/distfiles/bdb/db-${PV}.tar.gz"

inherit autotools_base

# Put virtual/db in any appropriate provider of a
# relational database, use it as a dependency in
# place of a specific db and use:
#
# PREFERRED_PROVIDER_virtual/db
#
# to select the correct db in the build (distro) .conf
PROVIDES += "${VIRTUAL_NAME}"

# bitbake isn't quite clever enough to deal with db,
# the distribution sits in the expected directory, but all
# the builds must occur from a sub-directory.  The following
# persuades bitbake to go to the right place
S = "${WORKDIR}/db-${PV}/dist"
B = "${WORKDIR}/db-${PV}/build_unix"

# The executables go in a separate package - typically there
# is no need to install these unless doing real database
# management on the system.
PACKAGES += " ${PN}-bin"

# Package contents
FILES_${PN} = "${libdir}/libdb-${PVM}${SOLIBSDEV}"
FILES_${PN}-bin = "${bindir}/*"
# The dev package has the .so link (as in db3) and the .a's -
# it is therefore incompatible (cannot be installed at the
# same time) as the db3 package

EXTRA_OECONF = "${DB5_CONFIG}"

# Override the MUTEX setting here, the POSIX library is
# the default - "POSIX/pthreads/library".
# Don't ignore the nice SWP instruction on the ARM:
# These enable the ARM assembler mutex code, this won't
# work with thumb compilation...
ARM_MUTEX = "--with-mutex=ARM/gcc-assembly"
MUTEX = ""
MUTEX_arm = "${ARM_MUTEX}"
MUTEX_armeb = "${ARM_MUTEX}"
EXTRA_OECONF += "${MUTEX}"

# Cancel the site stuff - it's set for db3 and destroys the
# configure.
CONFIG_SITE = ""

do_install_append() {
	# The docs end up in /usr/docs - not right.
	if test -d "${D}/${prefix}/docs"
	then
		mkdir -p "${D}/${datadir}"
		test ! -d "${D}/${docdir}" || rm -rf "${D}/${docdir}"
		mv "${D}/${prefix}/docs" "${D}/${docdir}"
	fi
}
