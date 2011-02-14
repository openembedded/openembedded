require clutter.inc

STDDEPENDS += "json-glib"

PR = "${INC_PR}.1"

SRC_URI = "http://source.clutter-project.org/sources/clutter/1.4/clutter-${PV}.tar.bz2 \
           file://test-conformance-fix.patch \
           file://fix-lib-location.patch \
           ${INC_SRC_URI} \
          "

SRC_URI[md5sum] = "5a3c6d8414d4e286aba0a936f344c9b1"
SRC_URI[sha256sum] = "92fd67acce5105c933e54ad0c87d0f5ace1202fd0f87949cb49a3759e6e38892"

# recommended for --clutter-debug / --cogl-debug params
BASE_CONF += " --enable-debug"

do_configure_prepend() {
	# align the test data location *.c (V1.2 uses macro ASSETS_DIR for path in *.c)
	for i in $(find ${S}/tests -name Makefile.am) ; do
		sed -i -e 's:$(top_srcdir)/tests/data:${datadir}/${PN}-tests:g' $i
	done
}

do_compile_prepend() {
	rebuild_shader_sources ${S}/clutter/cogl/cogl/driver/gles
	# align test data location *.json
	for full_name in $(find ${S}/tests/data -name *.png -o -name *.json) ; do
		data_name=${full_name##*/}
		for i in $(find ${S}/tests -name *.json) ; do
			sed -i -e s:${data_name}:${datadir}/${PN}-tests/${data_name}:g $i
		done
	done
}

do_install() {
	autotools_do_install
	install_tests
}

