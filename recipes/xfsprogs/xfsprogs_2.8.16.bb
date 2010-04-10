DESCRIPTION = "XFS Filesystem Utilities"
HOMEPAGE = "http://oss.sgi.com/projects/xfs"
LICENSE = "GPL"
SECTION = "base"
PR = "r2"
DEPENDS = "util-linux-ng"

SRC_URI = "http://slackware.osuosl.org/slackware-12.0/source/a/xfsprogs/xfsprogs_2.8.16-1.tar.gz"

PARALLEL_MAKE = ""
inherit autotools
EXTRA_OECONF = "--enable-gettext=no"

do_configure () {
	export LIBTOOL="${STAGING_BINDIR_NATIVE}/${HOST_SYS}-libtool"
	export DEBUG="-DNDEBUG"
	oe_runconf
}

do_install () {
	export DIST_ROOT=${D}
	oe_runmake install
}


SRC_URI[md5sum] = "632c7745f884dc5e6fd707a18971aca3"
SRC_URI[sha256sum] = "b3195456c99ab66103fd235ab410d6f3e6a56f2bdb7fb31d9d3789f2d453ec3f"
