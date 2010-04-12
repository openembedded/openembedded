require genext2fs_${PV}.bb
inherit native

do_stage () {
	install -m 0755 genext2fs ${STAGING_BINDIR}/
}

do_install () {
	:
}

SRC_URI[md5sum] = "b7b6361bcce2cedff1ae437fadafe53b"
SRC_URI[sha256sum] = "404dbbfa7a86a6c3de8225c8da254d026b17fd288e05cec4df2cc7e1f4feecfc"
