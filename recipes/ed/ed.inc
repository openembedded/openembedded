DESCRIPTION = "GNU ed is a line-oriented text editor"
HOMEPAGE = "http://www.gnu.org/software/ed/"
INC_PR = "1"

CONFIGUREOPTS = "\
    '--srcdir=${S}' \
    '--prefix=${prefix}' \
    '--exec-prefix=${exec_prefix}' \
    '--bindir=${bindir}' \
    '--datadir=${datadir}' \
    '--infodir=${infodir}' \
    '--sysconfdir=${sysconfdir}' \
    'CC=${CC}' \
    'CPPFLAGS=${CPPFLAGS}' \
    'CXXFLAGS=${CXXFLAGS}' \
    'LDFLAGS=${LDFLAGS}' \
"
EXTRA_OEMAKE = ""

B = "${S}/obj"
do_configure () {
    ${S}/configure ${CONFIGUREOPTS}
}

do_install () {
    oe_runmake 'DESTDIR=${D}' install
}

BBCLASSEXTEND += "native nativesdk"
