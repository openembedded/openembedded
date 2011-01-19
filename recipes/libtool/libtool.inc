DESCRIPTION = "Generic library support script \
This is GNU libtool, a generic library support script.  Libtool hides \
the complexity of generating special library types (such as shared \
libraries) behind a consistent interface."
HOMEPAGE = "http://www.gnu.org/software/libtool/libtool.html"
LICENSE = "GPLv2+"
SECTION = "devel"

INC_PR = "r28"

FILESPATHPKG=. "libtool-${PV}:"

# this SRC_URI is mainly for libtool 2.4 but all older
# versions override SRC_URI so its a safe thing and at same
# time it gives us more control over 2.4 recipes

SRC_URI = "${GNU_MIRROR}/libtool/libtool-${PV}.tar.gz \
           file://trailingslash.patch \
	   file://prefix-manpage-fix.patch \
	   file://rename-with-sysroot.patch \
	   file://resolve-sysroot.patch \
	   file://use-sysroot-in-libpath.patch \
	   file://fix-final-rpath.patch \
          "
do_configure_prepend () {
	if ${@['true', 'false'][bb.data.inherits_class('native', d) or bb.data.inherits_class('sdk', d) or (bb.data.getVar('PN', d, 1) == 'libtool-cross')]}
	then
		export ac_cv_path_SED="${ac_cv_path_SED=${base_bindir}/sed}"
		export ac_cv_path_GREP="${ac_cv_path_GREP=${base_bindir}/grep}"
		export ac_cv_path_EGREP="${ac_cv_path_EGREP=${base_bindir}/grep -E}"
		export ac_cv_path_FGREP="${ac_cv_path_FGREP=${base_bindir}/grep -F}"
	fi
}
do_compile_prepend () {
        # Sometimes this file doesn't get rebuilt, force the issue
        rm -f ${S}/libltdl/config/ltmain.sh
        make libltdl/config/ltmain.sh
}

inherit autotools
EXTRA_AUTORECONF = "--exclude=libtoolize"
