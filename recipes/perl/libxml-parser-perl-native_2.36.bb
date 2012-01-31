DESCRIPTION = "XML::Parser - A perl module for parsing XML documents"
SECTION = "libs"
LICENSE = "Artistic|GPLv1+"
DEPENDS += "expat expat-native"
PR= "r4"

SRC_URI = "http://www.cpan.org/modules/by-module/XML/XML-Parser-${PV}.tar.gz"

S = "${WORKDIR}/XML-Parser-${PV}"

EXTRA_CPANFLAGS = "EXPATLIBPATH=${STAGING_LIBDIR} EXPATINCPATH=${STAGING_INCDIR}"

inherit cpan
inherit native

do_compile() {
	export LIBC="$(find ${STAGING_DIR_TARGET}/lib -name 'libc-*.so')"
	cpan_do_compile
}
# 	cpan_do_compile	|| echo expected failure

do_compile_virtclass-native (){
	cpan_do_compile
}

FILES_${PN} = "${PERLLIBDIRS}/auto/XML/Parser/Expat/* \
                ${PERLLIBDIRS}/XML"

BBCLASSEXTEND="native"

SRC_URI[md5sum] = "1b868962b658bd87e1563ecd56498ded"
SRC_URI[sha256sum] = "9fd529867402456bd826fe0e5588d35b3a2e27e586a2fd838d1352b71c2ed73f"
