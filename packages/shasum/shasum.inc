SUMMARY = "A simple tool to create sha256 hashes from a file"
LICENSE = "LGPL"

S = "${WORKDIR}"


SRC_URI = "file://main.c         \
           file://mhash_sha256.h \
           file://sha256.c "


do_configure() {
    :
}

do_compile() {
    $CC $CFLAGS $CPPFLAGS -o sha256sum main.c sha256.c
}
