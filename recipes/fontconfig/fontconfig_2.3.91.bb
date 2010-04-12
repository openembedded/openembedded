require fontconfig.inc

DEPENDS += "fontconfig-native"

SRC_URI += "file://fc-glyphname.patch;patch=1 \
           file://fc-lang.patch;patch=1 \
           file://one-j-too-many.patch;patch=1 \
           file://local.conf"

PR = "r4"

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


SRC_URI[md5sum] = "098a36ec53ec893f6511712ec4010d38"
SRC_URI[sha256sum] = "a906c3193de44e5a8d93174bb86e91f39e415f92ad9319b318fd3a46a2ad9b35"
