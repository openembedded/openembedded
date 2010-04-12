require grep_${PV}.bb
inherit native

S = "${WORKDIR}/grep-${PV}"

do_stage () {
	install -d ${STAGING_BINDIR}
	install -m 755 src/grep ${STAGING_BINDIR}
	install -m 755 src/egrep ${STAGING_BINDIR}
	install -m 755 src/fgrep ${STAGING_BINDIR}
}

FILESDIR = "${@os.path.dirname(bb.data.getVar('FILE',d,1))}/grep-${PV}"

SRC_URI[md5sum] = "ddd99e2d5d4f4611357e31e97f080cf2"
SRC_URI[sha256sum] = "fca0532a4b58021863b6673dc65b275f3e34cafd3b327dcf47da265af359778a"
