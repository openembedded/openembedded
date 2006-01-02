include librtaudio_${PV}.bb

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

