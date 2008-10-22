DESCRIPTION = "The X MultiMedia System"
HOMEPAGE = "http://www.xmms.org/"
LICENSE = "GPL"
SECTION = "x11/multimedia"
# TODO add esd
DEPENDS = "gtk+-1.2 libvorbis mikmod alsa-lib libsm esound"

SRC_URI = "http://www.xmms.org/files/1.2.x/xmms-${PV}.tar.bz2 \
           file://gcc4.patch;patch=1 \
           file://xmms-config-dequote.patch;patch=1 \
	   file://acinclude.m4 \
           file://xmms.sh"
PR = "r3"

RRECOMMENDS_${PN} = "xmms-plugin-output-oss xmms-plugin-output-alsa \
                    xmms-mad xmms-tremor"

inherit autotools binconfig

# TODO enable esd
EXTRA_OECONF = "--disable-opengl --disable-esd \
                --with-vorbis-includes=${STAGING_INCDIR} \
                --with-ogg-includes=${STAGING_INCDIR} \
                --with-vorbis-libraries=${STAGING_LIBDIR} \
                --with-ogg-libraries=${STAGING_LIBDIR}"

do_configure_prepend() {
	cp ${WORKDIR}/acinclude.m4 ${S}
	rm ${S}/libxmms/acinclude.m4 || true
	for i in $(find . -name "Makefile*") ; do
		sed -i -e 's:MKINSTALLDIRS = @MKINSTALLDIRS@:MKINSTALLDIRS = @mkdir_p@:g' \ 
	           -e 's:$(SHELL) $(MKINSTALLDIRS):$(MKINSTALLDIRS):g' $i
	done
}

do_install_append() {
	install -m 0755 ${WORKDIR}/xmms.sh ${D}${bindir}
	install -d ${D}${datadir}/applications
	install xmms/xmms.desktop ${D}${datadir}/applications
	sed -i "s/Exec=xmms/Exec=xmms.sh/" ${D}${datadir}/applications/xmms.desktop
	install -d ${D}${datadir}/pixmaps
	install xmms/xmms_mini.xpm ${D}${datadir}/pixmaps
}

PACKAGES_DYNAMIC = "xmms-plugin-effect-* xmms-plugin-general-* \
                    xmms-plugin-input-* xmms-plugin-output-* \
		    xmms-plugin-visualisation-*"

python populate_packages_prepend () {
	import os.path

	xmms_libdir = bb.data.expand('${libdir}/xmms', d)
	effects_root = os.path.join(xmms_libdir, 'Effect')
	general_root = os.path.join(xmms_libdir, 'General')
	input_root = os.path.join(xmms_libdir, 'Input')
	output_root = os.path.join(xmms_libdir, 'Output')
	visualisation_root = os.path.join(xmms_libdir, 'Visualization')

	do_split_packages(d, effects_root, '^lib(.*)\.so$', 'xmms-plugin-effect-%s', 'XMMS Effect plugin for %s')
	do_split_packages(d, general_root, '^lib(.*)\.so$', 'xmms-plugin-general-%s', 'XMMS General plugin for %s')
	do_split_packages(d, input_root, '^lib(.*)\.so$', 'xmms-plugin-input-%s', 'XMMS Input plugin for %s')
	do_split_packages(d, output_root, '^lib(.*)\.so$', 'xmms-plugin-output-%s', 'XMMS Output plugin for %s')
	do_split_packages(d, visualisation_root, '^lib(.*)\.so$', 'xmms-plugin-visualization-%s', 'XMMS Visualization plugin for %s')
}

do_stage() {
	autotools_stage_all
}

FILES_${PN} = "${bindir}/xmms ${bindir}/xmms.sh ${libdir}/libxmms*.so.* \
               ${datadir}/applications/xmms.desktop \
	       ${datadir}/pixmaps/xmms_mini.xpm"
