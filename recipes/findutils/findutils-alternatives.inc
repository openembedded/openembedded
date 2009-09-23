do_install_append() {
	cd ${D}${bindir} && mv find find.findutils
	cd ${D}${bindir} && mv xargs xargs.findutils
}

pkg_postinst_${PN} () {
        for i in find xargs; do update-alternatives --install ${bindir}/$i $i $i.${PN} 100; done
}

pkg_prerm_${PN} () {
        for i in find xargs; do update-alternatives --remove $i $i.${PN}; done
}
