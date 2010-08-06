DESCRIPTION = "GSM Audio Library"
SECTION = "libs"
PRIORITY = "optional"
#DEPENDS = ""
LICENSE = "libgsm"

PR = "r2"

SRC_URI = "http://user.cs.tu-berlin.de/~jutta/gsm/gsm-${PV}.tar.gz \
	   file://01_makefile.patch \
           file://02_cplusplus.patch \
           file://03_config.patch \
           file://04_includes.patch \
           file://05_compiler_warnings.patch \
	  "

S = "${WORKDIR}/gsm-1.0-pl12/"

CFLAGS += "-c -g -fPIC -Wall -D_GNU_SOURCE -D_REENTRANT -DNeedFunctionPrototypes=1 -DWAV49 -I./inc"

PARALLEL_MAKE = ""

do_compile() {
	unset LD
	oe_runmake CCFLAGS="${CFLAGS}"
}

do_install() {
	oe_libinstall -a -C lib libgsm ${D}${libdir}
        oe_libinstall -so -C lib libgsm ${D}${libdir}
        install -d ${D}${includedir}/gsm
        install -m 0644 ${S}/inc/gsm.h ${D}${includedir}/gsm/
	cd ${D}${includedir}
	ln -s gsm/gsm.h gsm.h
}

SRC_URI[md5sum] = "8909828c601e82e842e6a0ceade60a4e"
SRC_URI[sha256sum] = "dde4e62e4ce35af29a15d26beca2fc0f98c0219553927453425cda01f16e4de4"
