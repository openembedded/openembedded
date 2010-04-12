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


SRC_URI[md5sum] = "6e64304b91cfea887558154d465bb752"
SRC_URI[sha256sum] = "9d1eb5813a7d3e7907da4e6a69c93f4689c49a2ed8320c35ce4570f63448f2d0"
