require clutter.inc

PR = "${INC_PR}.0"

SRC_URI = "http://source.clutter-project.org/sources/clutter/1.0/clutter-${PV}.tar.bz2 \
           ${INC_SRC_URI} \
          "

# recommended for --clutter-debug / --cogl-debug params
BASE_CONF += " --enable-debug"

do_compile_prepend() {
	rebuild_shader_sources ${S}/clutter/cogl/cogl/driver/gles
	# align test data location
	for full_name in $(find ${S}/tests/data -name *.png -o -name *.json) ; do
		data_name=${full_name##*/}
		for i in $(find ${S}/tests -name *.c -o -name *.json) ; do
			sed -i -e s:${data_name}:${datadir}/${PN}-tests/${data_name}:g $i
		done
	done
}

do_install() {
	autotools_do_install
	install_tests
}

SRC_URI[md5sum] = "bf48e85291cba33f3f149f4eefe759f0"
SRC_URI[sha256sum] = "6fb98dc4d16a3a98be734cf0a6cc4f8d8179800603c3e41011c414eeaf1f456b"
