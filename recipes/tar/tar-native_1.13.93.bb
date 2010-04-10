require tar_${PV}.bb
inherit native

do_stage() {
	install -m 755 src/tar ${STAGING_BINDIR}
}

do_install() {
	true
}

SRC_URI[md5sum] = "71bfeab35c9935631fc133f9d272b041"
SRC_URI[sha256sum] = "0ef70273b6a54357c7823ed1f11015523f5cc5fe16df097e0b5300ae725c44e1"
