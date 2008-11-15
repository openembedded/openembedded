require findutils.inc

SRC_URI += "file://mkinstalldirs.patch;patch=1"

EXTRA_OECONF += " ac_cv_path_SORT=/usr/bin/sort "

pkg_postinst_${PN} () {
	for i in find xargs; do update-alternatives --install ${bindir}/$i $i $i.${PN} 100; done
}

pkg_prerm_${PN} () {
	for i in find xargs; do update-alternatives --remove $i $i.${PN}; done
}
