SECTION = "libs"
require zlib_${PV}.bb
ZLIB_EXTRA = ""
inherit native

DEPENDS = "libtool-native"
FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/zlib-${PV}', '${FILE_DIRNAME}/zlib', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"


# darwin hacks
ZLIB_SHARED_build-darwin ="libz.1.2.3.dylib"
do_compile_build-darwin() {
    unset LDSHARED
    ./configure --prefix=${prefix} --exec_prefix=${exec_prefix} --shared --libdir=${libdir} --includedir=${includedir}
    oe_runmake
}
