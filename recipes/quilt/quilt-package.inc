require quilt.inc

RDEPENDS_${PN} += "bash patch diffstat bzip2 util-linux"

SRC_URI += "file://aclocal.patch"

inherit autotools gettext

EXTRA_OECONF = " \
ac_cv_path_BASH=/bin/bash \
ac_cv_path_DIFF=${bindir}/diff \
ac_cv_path_DIFFSTAT=${bindir}/diffstat \
ac_cv_path_FIND=${bindir}/find \
ac_cv_path_PATCH=${bindir}/patch \
ac_cv_path_PERL=${bindir}/perl \
"

do_install () {
	oe_runmake 'BUILD_ROOT=${D}' install

	# Remove the compat symlinks
	rm -rf "${D}"/usr/share/quilt/compat
}

PACKAGES += "guards guards-doc"
FILES_${PN} = "${sysconfdir} ${datadir}/quilt \
	       ${bindir}/quilt ${libdir}/quilt"
FILES_guards = "${bindir}/guards"
FILES_${PN}-doc = "${mandir}/man1/quilt.1 ${docdir}/${P}"
FILES_guards-doc = "${mandir}/man1/guards.1"
