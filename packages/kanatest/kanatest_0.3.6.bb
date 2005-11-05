PR = "r0"

SRC_URI = "http://clay.ll.pl/download/${PN}-${PV}.tar.gz file://${PN}.desktop"

include kanatest.inc

CFLAGS += "-D_GNU_SOURCE"

