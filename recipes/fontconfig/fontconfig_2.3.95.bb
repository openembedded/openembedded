require fontconfig.inc

SRC_URI += "file://one-j-too-many.patch;patch=1"

PR = "r3"

do_stage () {
	oe_libinstall -so -a -C src libfontconfig ${STAGING_LIBDIR}
	install -d ${STAGING_INCDIR}/fontconfig
	for i in ${S}/fontconfig/*.h; do install -m 0644 $i ${STAGING_INCDIR}/fontconfig/; done
}

do_install () {
	autotools_do_install
}


SRC_URI[md5sum] = "6860be35882f6d34636d52345efd5944"
SRC_URI[sha256sum] = "3c0901c0df62e5588370cbab13cd847e056c6a4d36fb69faa303d8edd5b41c09"
