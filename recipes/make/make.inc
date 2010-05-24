DESCRIPTION = "GNU Make examines the timestamps on a set of \
interdependent files, and, if necessary, issues commands \
to bring them up-to-date."
HOMEPAGE = "http://www.gnu.org/software/make/"
SECTION = "devel"
LICENSE = "GPL"

SRC_URI = "${GNU_MIRROR}/make/make-${PV}.tar.bz2 \
           file://SCCS.patch"

inherit autotools

do_configure_prepend() {
	if [ "${TARGET_OS}" = "linux-uclibc" -o "${TARGET_OS}" = "linux-uclibceabi" ]; then
		export make_cv_sys_gnu_glob="no" 
		export GLOBINC=-I`pwd`/glob
		export GLOBLIB=glob/libglob.a
	fi
}
