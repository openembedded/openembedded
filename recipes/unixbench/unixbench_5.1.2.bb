DESCRIPTION = "Unix benchmark suite"
DEPENDS = "virtual/libgl"
RSUGGESTS_${PN} = "perl"

SRC_URI = "http://byte-unixbench.googlecode.com/files/${P}.tar.gz"

EXTRA_OEMAKE = "-j1 'CC=${CC}' 'CFLAGS=-DTIME -Wall -pedantic -ansi ${CFLAGS} ${LDFLAGS}'"

FILES_${PN} = "${prefix}/src/unixbench-${PV}"
FILES_${PN}-dbg = "${prefix}/src/unixbench-${PV}/pgms/.debug"

do_install () {
        install -d ${D}${prefix}/src
        cp -pPR ${S} ${D}${prefix}/src/
}

SRC_URI[md5sum] = "10edef9af6ad29770437d0b39828218d"
SRC_URI[sha256sum] = "1172d9c7777e67e477b421856b70406ba18a497480db27e4d79eb104435f8d90"
