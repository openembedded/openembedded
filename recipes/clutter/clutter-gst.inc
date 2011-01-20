DESCRIPTION = "Clutter GStreamer integration library"
HOMEPAGE = "http://www.clutter-project.org/"
LICENSE = "LGPLv2.1"

INC_PR = "r2"

DEPENDS = "clutter gstreamer gst-plugins-base"

require clutter-common.inc

inherit autotools pkgconfig

EXTRA_OECONF = "--disable-introspection"

align_examples_data_location() {
	for full_name in $(find ${S}/examples -name *.png) ; do
		data_name=${full_name##*/}
		for i in $(find ${S}/examples -name *.c) ; do
			sed -i -e s:${data_name}:${datadir}/${PN}-examples/${data_name}:g $i
		done
	done
}

do_configure_prepend() {
	copy_gtk_doc_make
	make_all_execs_installable
	align_examples_data_location
}

do_install_append () {
	install -m 755 -d ${D}${datadir}/${PN}-examples
	for i in $(find ${S}/examples -name *.png) ; do
		install -m 755 ${i} ${D}${datadir}/${PN}-examples
	done
}

PACKAGES =+ "${PN}-examples"
FILES_${PN}-examples = "${bindir}/video-* ${datadir}/${PN}-examples"

PACKAGES =+ "${PN}-tests"
FILES_${PN}-tests = "${bindir}/test-*"


