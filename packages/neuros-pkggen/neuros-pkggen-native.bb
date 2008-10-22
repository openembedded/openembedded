DESCRIPTION = "Tool to generate ready to flash .pkg files for neuros machines"
LICENSE = "GPLv2"
PR = "r3"

inherit native

SRC_URI = "file://Makefile \
           file://Makefile.rules \
           file://config \
           file://crc32.c \
           file://package.c \
           file://package.h \
           file://readme \
           file://zlib.h \
"

do_compile_prepend() {
	( cd ${WORKDIR} ; cp Makefile  Makefile.rules  config  crc32.c  package.c  package.h  readme  zlib.h ${S} ) 
}

do_stage() {
	install -m 0755 packet_osd2 ${STAGING_BINDIR_NATIVE}
}


