require fontconfig.inc

DEPENDS += "fontconfig-native"

SRC_URI += "file://fc-glyphname.patch;patch=1 \
           file://fc-lang.patch;patch=1 \
	   file://local.conf"
PR = "r9"

do_stage () {
	oe_libinstall -so -a -C src libfontconfig ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/fontconfig
	for i in ${S}/fontconfig/*.h; do install -m 0644 $i ${STAGING_INCDIR}/fontconfig/; done
}

do_install () {
	autotools_do_install

	install -d ${D}/etc/fonts/
	install -m 0644 ${WORKDIR}/local.conf ${D}/etc/fonts/
}

