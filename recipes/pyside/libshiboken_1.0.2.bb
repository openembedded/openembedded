require shiboken.inc

RDEPENDS_${PN} = "python-core"
PR = "${INC_PR}.0"

SRC_URI += " \
 file://FindQt4.cmake \
 file://MacroPushRequiredVars.cmake \
 file://fix-cmake-include-path.patch \
 file://fix-shiboken-cmake-config.patch \
"

SRC_URI[md5sum] = "585aa365811575ec3b48d59ca007f6ae"
SRC_URI[sha256sum] = "eb3eea79945a62ed2a7282b8b99d3b8011f021465bdea6a3aad9399fa52bd5fe"

do_configure_prepend() {
	cp ${WORKDIR}/MacroPushRequiredVars.cmake ${S}/cmake/Modules/MacroPushRequiredVars.cmake
	cp ${WORKDIR}/FindQt4.cmake ${S}/cmake/Modules/FindQt4.cmake
}

do_install_prepend() {
	# Fixup generated *.cmake and *.pc files for wrong paths
	for i in `find ${S}/data -name "*.cmake" -type f` ; do \
		sed -i -e 's:${STAGING_BINDIR_NATIVE}:${bindir}:g' \
			-e 's:${STAGING_INCDIR}:${includedir}:g' \
			-e 's:${STAGING_LIBDIR}:${libdir}:g' \
			$i
	done
	# We need do this here a second time (pkgconfig.bbclass already replaces the -L.. and
	# -I .. ones) as there are additional variables for python in the pkgconfig file
	for i in `find ${S}/data -name "*.pc" -type f` ; do \
		sed -i -e 's:${STAGING_BINDIR_NATIVE}:${bindir}:g' \
			-e 's:${STAGING_INCDIR}:${includedir}:g' \
			-e 's:${STAGING_LIBDIR}:${libdir}:g' \
			$i
	done
}

inherit cmake pkgconfig

FILES_${PN}-dev += "${libdir}/cmake/"
