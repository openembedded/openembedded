require gcc_${PV}.bb

PR = "r1"

FILESPATH = "${@base_set_filespath([ '${FILE_DIRNAME}/gcc-4.1.2', '${FILE_DIRNAME}/gcc', '${FILE_DIRNAME}/files', '${FILE_DIRNAME}' ], d)}"

SRC_URI = "http://www.angstrom-distribution.org/unstable/sources/gcc-4.1.2-atmel.1.1.0.tar.gz \
#           file://100-uclibc-conf.patch;patch=1 \
#           file://200-uclibc-locale.patch;patch=1 \
#           file://300-libstdc++-pic.patch;patch=1 \
           file://301-missing-execinfo_h.patch;patch=1 \
           file://302-c99-snprintf.patch;patch=1 \
           file://303-c99-complex-ugly-hack.patch;patch=1 \
           file://304-index_macro.patch;patch=1 \
           file://602-sdk-libstdc++-includes.patch;patch=1 \
           file://gcc41-configure.in.patch;patch=1 \
           file://ldflags.patch;patch=1 \
           file://zecke-xgcc-cpp.patch;patch=1 \
           file://cache-amnesia.patch;patch=1 \
	   "

do_compile_prepend() {
ln -sf ${S}/libstdc++-v3/config/os/uclibc/ ${S}/libstdc++-v3/config/os/uclibc-linux 
}
