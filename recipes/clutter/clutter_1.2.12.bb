require clutter.inc

PR = "${INC_PR}.1"

SRC_URI = "http://source.clutter-project.org/sources/clutter/1.2/clutter-${PV}.tar.bz2 \
           file://workaround-broken-mipmaps.patch \
           ${INC_SRC_URI} \
          "

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

SRC_URI[md5sum] = "76f70e765adcf7146be1ceb50bafa14f"
SRC_URI[sha256sum] = "4582e6579897374d1f8ce51daa330311ebb90033fad95d5f076c1e9392b4ae68"
