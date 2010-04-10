require librtaudio_${PV}.bb

inherit autotools

EXTRA_OECONF = "--with-alsa --with-oss"
EXTRA_OEMAKE = "-e"
export CC = "${CXX}"
CFLAGS += "-I${S}"
export LIBRARY = "-lasound -lpthread ${LDFLAGS}"

do_compile() {
	oe_runmake -C tests
}

do_stage() {
	:
}

do_install() {
	install -d ${D}${bindir}
	for binary in `find tests -perm 0755 -type f`
	do
		install -m 0755 $binary ${D}${bindir}
        done
}


SRC_URI[md5sum] = "5b60500bc9605d2409b71124e48aa929"
SRC_URI[sha256sum] = "59cc003bab753335b3ce14a908e663ea782514b3531dc7030379ff753ef1a78c"
