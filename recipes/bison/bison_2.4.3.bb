require bison.inc

PR = "${INC_PR}.0"

#SRC_URI = "${GNU_MIRROR}/bison/bison-${PV}.tar.gz"

# >> bison-2.3-r0: /usr/lib/liby.a
# That one is a special case: it wants to stay in the main bison package,
# since bison itself is a development tool.  I'm not sure why it is a
# static-only library; that might be an error.

FILES_${PN} += "${libdir}/liby.a"

SRC_URI[md5sum] = "ea45c778b36bdc7a720096819e292a73"
SRC_URI[sha256sum] = "6b17be5e63ff6667c83f6ef0423befe0ba23d4bc554c4c33b02ce5bb65179b16"
