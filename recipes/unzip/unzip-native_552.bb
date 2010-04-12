SECTION = "console/utils"
inherit native
require unzip_${PV}.bb

do_stage() {
	install -d ${STAGING_BINDIR}
	install unzip ${STAGING_BINDIR}
}

SRC_URI[md5sum] = "9d23919999d6eac9217d1f41472034a9"
SRC_URI[sha256sum] = "145d95e2ef1ef9add2e3c97d1340907e33ab8749eb1235372e7f0b7af600a8e9"
