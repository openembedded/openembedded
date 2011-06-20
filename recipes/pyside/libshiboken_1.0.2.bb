require shiboken.inc

DEPENDS += "python"
RDEPENDS_${PN} = "python-core"
PR = "${INC_PR}.1"

inherit cmake pkgconfig python-dir

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

STAGING_LIBDIR_NATIVE = ${STAGING_DIR}/${BUILD_SYS}${prefix}/lib
STAGING_INCDIR_NATIVE = ${STAGING_DIR}/${BUILD_SYS}${prefix}/include

# NOTE: This needs to be appended to do_configure as pkgconfig.bbclass uses
# do_install_prepend for it's fixups and we need to run before it!
do_configure_append() {
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
			-e 's:${STAGING_INCDIR_NATIVE}:${includedir}:g' \
			-e 's:${STAGING_LIBDIR_NATIVE}:${libdir}:g' \
			-e 's:-lshiboken:-lshiboken-${PYTHON_DIR}:g' \
			$i
	done
}

FILES_${PN}-dev += "${libdir}/cmake/ ${libdir}/pkgconfig"
