DEPENDS_append = " update-rc.d"
RDEPENDS_append = " update-rc.d"

INIT_D_DIR = "${sysconfdir}/init.d"

updatercd_postinst() {
if test "x$D" != "x"; then
	D="-r $D"
else
	D="-s"
fi
update-rc.d $D ${INITSCRIPT_NAME} ${INITSCRIPT_PARAMS}
}

updatercd_postrm() {
if test "x$D" != "x"; then
	D="-r $D"
else
	${INIT_D_DIR}/${INITSCRIPT_NAME} stop
fi
update-rc.d $D ${INITSCRIPT_NAME} remove
}

python __anonymous() {
	if bb.data.getVar('INITSCRIPT_NAME', d) == None:
		raise bb.build.FuncFailed, "%s inherits update-rc.d but doesn't set INITSCRIPT_NAME" % bb.data.getVar('FILE', d)
	if bb.data.getVar('INITSCRIPT_PARAMS', d) == None:
		raise bb.build.FuncFailed, "%s inherits update-rc.d but doesn't set INITSCRIPT_PARAMS" % bb.data.getVar('FILE', d)
}

python populate_packages_prepend () {
	pkg = bb.data.getVar('PN', d, 1)
	packages = (bb.data.getVar('PACKAGES', d, 1) or "").split()
	if not pkg in packages:
		pkg = packages[0]
	bb.debug(1, 'adding update-rc.d calls to postinst/postrm for %s' % pkg)
	postinst = bb.data.getVar('pkg_postinst_%s' % pkg, d, 1) or bb.data.getVar('pkg_postinst', d, 1)
	if not postinst:
		postinst = '#!/bin/sh\n'
	postinst += bb.data.getVar('updatercd_postinst', d, 1)
	bb.data.setVar('pkg_postinst_%s' % pkg, postinst, d)
	postrm = bb.data.getVar('pkg_postrm_%s' % pkg, d, 1) or bb.data.getVar('pkg_postrm', d, 1)
	if not postrm:
		postrm = '#!/bin/sh\n'
	postrm += bb.data.getVar('updatercd_postrm', d, 1)
	bb.data.setVar('pkg_postrm_%s' % pkg, postrm, d)
}
