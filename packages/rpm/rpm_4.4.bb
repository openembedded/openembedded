DESCRIPTION = "The RPM Package Manager."
HOMEPAGE = "http://rpm.org/"
LICENSE = "LGPL GPL"
MAINTAINER = "Chris Larson <kergoth@handhelds.org>"
# NOTE: currently rpm doesn't support using an external popt,
# file, or virtual/db.  FIXME: patch it to support that.
# DEPENDS = "virtual/db popt file zlib"
DEPENDS = "zlib"
PR = "r1"

SRC_URI = "ftp://ftp.jbj.org/pub/rpm-4.4.x/rpm-4.4-1.src.rpm \
	   file://fix_mypath.patch;patch=1 \
	   file://cross_libpaths.patch;patch=1"
TARBALL = "${WORKDIR}/rpm-4.4.tar.gz"

inherit autotools gettext

acpaths = ""
# NOTE: currently BROKEN because its internal build of 'file' tries
# to run the binary it builds.  Either switch to an external build,
# or depend on our file-native and make it call that.
BROKEN = "1"
EXTRA_OECONF = "--without-python \
		--without-apidocs \
		--without-selinux \
		--without-lua \
		--without-dmalloc \
		--without-efence"

python unpack_again () {
	import bb, os
	os.chdir(bb.data.getVar('WORKDIR', d, 1) or '')
	if not oe_unpack_file(bb.data.expand('${TARBALL}', d), d):
		raise bb.build.FuncFailed(bb.data.expand("Unable to unpack ${TARBALL}", d))
}

python do_unpack () {
	bb.build.exec_func('base_do_unpack', d)
	bb.build.exec_func('unpack_again', d)
}

do_configure () {
	touch db3/configure.ac
	autotools_do_configure
}
