DESCRIPTION = "\
PAM authentication library for Linux.  \
Linux-PAM (Pluggable Authentication Modules for Linux) is a \
library that enables the local system administrator to choose \
how individual applications authenticate users. For an \
overview of the Linux-PAM library see the Linux-PAM System \
Administrators' Guide."
HOMEPAGE = "http://kernel.org/pub/linux/libs/pam"
SECTION = "libs"
PRIORITY = "optional"
LICENSE = "GPLv2"

DEPENDS = "flex flex-native"

PR = "r2"

# The project is actually called Linux-PAM but that gives
# a bad OE package name because of the upper case characters
pn = "Linux-PAM"
p = "${pn}-${PV}"
S = "${WORKDIR}/${p}"

SRC_URI = "${KERNELORG_MIRROR}/pub/linux/libs/pam/library/${p}.tar.bz2 \
           file://pam-nodocs.patch;patch=1 "

inherit autotools

LEAD_SONAME = "libpam.so.*"

# maintain the pam default layout
EXTRA_OECONF += " --includedir=${includedir}/security"

PACKAGES_DYNAMIC += " pam-plugin-*"
python populate_packages_prepend () {
	import os.path

	pam_libdir    = bb.data.expand('${libdir}/security', d)
	pam_libdirdebug = bb.data.expand('${libdir}/security/.debug', d)
	pam_filterdir = bb.data.expand('${libdir}/security/pam_filter', d)
	do_split_packages(d, pam_libdir, '^pam(.*)\.so$', 'pam-plugin%s', 'PAM plugin for %s', extra_depends='')
	do_split_packages(d, pam_libdir, '^pam(.*)\.la$', 'pam-plugin%s-dev', 'PAM plugin for %s dev', extra_depends='')
	if os.path.exists(pam_libdirdebug):
		do_split_packages(d, pam_libdirdebug, '^pam(.*)\.so$', 'pam-plugin%s-dbg', 'PAM plugin for %s debugging symbols', extra_depends='')
	do_split_packages(d, pam_filterdir, '^(.*)$', 'pam-filter-%s', 'PAM filter for %s', extra_depends='')
}


do_stage() {
	autotools_stage_all
}
