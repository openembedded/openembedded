DESCRIPTION = "Clutter graphics library"
HOMEPAGE = "http://www.clutter-project.org/"
LICENSE = "LGPLv2.1"

INC_SRC_URI = "file://sample.desktop \
               file://test-conformance-run \
              "

PARALLEL_MAKE = ""

STDDEPENDS = "virtual/libx11 gtk-doc-native pango glib-2.0 libxfixes gtk+"
BASE_CONF = "--disable-introspection --disable-gtk-doc ${@get_clutter_fpu_setting(bb, d)} --enable-conformance "

DEPENDS = "${STDDEPENDS} virtual/libgl"
EXTRA_OECONF = "${BASE_CONF} --with-flavour=glx"

DEPENDS_zylonite = "${STDDEPENDS} libgles-zylonite tslib"
EXTRA_OECONF_zylonite = "${BASE_CONF} --with-flavour=eglnative"
PACKAGE_ARCH_zylonite = "${MACHINE_ARCH}"
LDFLAGS_append_zylonite = " -lnws -lstdc++ "

DEPENDS_mx31litekit = "${STDDEPENDS} libgles-mx31 tslib"
EXTRA_OECONF_mx31litekit = "${BASE_CONF} --with-flavour=eglnative"
PACKAGE_ARCH_mx31litekit = "${MACHINE_ARCH}"
LDFLAGS_append_mx31litekit = " -lpvrNULLWSEGL -lstdc++ "

DEPENDS_armv7a = "${STDDEPENDS} libgles-omap3 tslib"
EXTRA_OECONF_armv7a = "${BASE_CONF} --with-flavour=eglx --with-gles=2.0"
PACKAGE_ARCH_armv7a = "${MACHINE_ARCH}"

DEPENDS_omap-3430ldp = "${STDDEPENDS} libgles-omap3 tslib"
EXTRA_OECONF_omap-3430ldp = "${BASE_CONF} --with-flavour=eglx"
PACKAGE_ARCH_omap-3430ldp = "${MACHINE_ARCH}"

DEPENDS_omap-3430sdp = "${STDDEPENDS} libgles-omap3 tslib"
EXTRA_OECONF_omap-3430sdp = "${BASE_CONF} --with-flavour=eglx"
PACKAGE_ARCH_omap-3430sdp = "${MACHINE_ARCH}"

DEPENDS_mx31ads = "${STDDEPENDS} libgles-mx31 tslib"
EXTRA_OECONF_mx31ads = "${BASE_CONF} --with-flavour=eglnative"
PACKAGE_ARCH_mx31ads = "${MACHINE_ARCH}"
LDFLAGS_append_mx31ads = " -lpvrNULLWSEGL -lstdc++ "

DEPENDS_pcm043 = "${STDDEPENDS} libgles-mx31 tslib"
EXTRA_OECONF_pcm043 = "${BASE_CONF} --with-flavour=eglnative"
PACKAGE_ARCH_pcm043 = "${MACHINE_ARCH}"
LDFLAGS_append_pcm043 = " -lpvrNULLWSEGL -lstdc++ "

INC_PR = "r3"

inherit autotools pkgconfig gtk-doc

PACKAGES =+ "${PN}-tests"
FILES_${PN}-tests = "${bindir}/test-* \
                     ${datadir}/applications/test-* \
                     ${datadir}/${PN}-tests"

# cally is part of clutter since 1.3.8 (c0f753d108b7a2ad23dbf5a5b596f80175442927)
PACKAGES =+ "${PN}-cally-examples"
FILES_${PN}-cally-examples = "${bindir}/cally-*-example"

require clutter-common.inc

do_configure_prepend() {
	glib-gettextize --force --copy || true
	# Fix up some weirdness in the docs
	copy_gtk_doc_make

	# Fix up 'Requires' entries in *.pc.in to prevent from "NOTE: couldn't find pkgconfig module '${requires}' in any package"
	for i in $(find ${S} -name '*.pc.in') ; do
		sed -i s:'${requires}':'@CLUTTER_REQUIRES@':g $i
	done
	
	make_all_execs_installable
}

# helper to (re)build shader source files from *.glsl	
rebuild_shader_sources() {
	if [ $# = 1 ] && [ $1 ] &&  [ -d $1 ] ; then
		glespath=$1
		for i in ${glespath}/*.glsl ; do 
			# *.h
			sh ${glespath}/stringify.sh -h $i > "${i%.glsl}.h"
			# *.c
			sh ${glespath}/stringify.sh $i > "${i%.glsl}.c"
		done
	else
		echo Warning: "clutter.inc::rebuild_shader_sources: called with invalid parameter ${1}!"
	fi
}

# tests are not prepared for installation - some helpers
install_tests() {
	install -m 755 -d ${D}${bindir}/
	install -m 755 -d ${D}${datadir}/applications

	# conformance tests script
	install -m 0755 ${WORKDIR}/test-conformance-run ${D}${bindir}

	# interactive tests desktop entries
	for i in ${S}/tests/interactive/*.o ; do 
		test_path=`echo ${i} | sed -e 's:\.o::' -e 's:test_interactive-::'`
		test_name=`echo ${test_path} | sed 's:.*/::'`
		if [ -e ${test_path} ] ; then 
			sed -e s:NAME:${test_name}: \
			    -e "s:EXEC:${bindir}/test-interactive ${test_name}:" \
			     ${WORKDIR}/sample.desktop > ${D}${datadir}/applications/${test_name}.desktop
		fi
	done

	# test data
	install -m 755 -d ${D}${datadir}/${PN}-tests
	for i in $(find ${S}/tests/data -name *.png -o -name *.json ) ; do
		install -m 0755 ${i} ${D}${datadir}/${PN}-tests/
	done
}
