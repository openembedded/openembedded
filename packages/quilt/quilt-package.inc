require quilt.inc 

RDEPENDS_${PN} += "patch diffstat bzip2 util-linux"

SRC_URI += "file://aclocal.patch;patch=1"

inherit autotools gettext

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
