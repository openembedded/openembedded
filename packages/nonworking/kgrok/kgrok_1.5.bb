DESCRIPTION = "Palmtop Data Manager \
KGrok is a shared flatfile database visualization engine. Simple application \
scripts turn it into a phone list, todo list, notepad, and others. Encryption \
optionally secures personal data."
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Marcin Juszkiewicz <openembedded@hrw.one.pl>"
LICENSE = "GPL"
AUTHOR = "Thomas Driemeyer <thomas@bitrot.de>"
HOMEPAGE = "http://www.bitrot.de/pda_kgrok.html"
APPNAME = "kgrok"
APPTYPE = "binary"
APPDESKTOP = "${S}/apps/KGrok"

SRC_URI = "ftp://ftp.bitrot.de/pub/kgrok/kgrok-src_1.5.tar.gz \
           file://parser_yacc.* \
           file://mediabutton.patch;patch=1"
S = "${WORKDIR}/src/"

inherit opie

EXTRA_QMAKEVARS_POST += "DEFINES+=ORDER_DCBA YACCSOURCES= SOURCES+=parser_yacc.cpp"
QMAKE_PROFILES = "src.pro"

do_configure_prepend() {
	cd ${S} && qmake -project
}

do_compile_prepend() {
	install -m 0655 ${WORKDIR}/parser_yacc.* ${S}
}

do_install () {
	install -d ${D}/${palmtopdir}/pics/
	install -m 0644 src/temtor.png ${D}/${palmtopdir}/pics/
}

