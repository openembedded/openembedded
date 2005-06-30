DESCRIPTION = "The Kate Text Editor for Opie"
SECTION = "opie/applications"
PRIORITY = "optional"
MAINTAINER = "Team Opie <opie@handhelds.org>"
LICENSE = "GPL"
DEPENDS = "libqtaux2"
APPNAME = "tinykate"


S = "${WORKDIR}/tinykate"

inherit opie

EXTRA_QMAKEVARS_POST += " LIBS+=-L.."
PARALLEL_MAKE = ""

# FILES plugins/application/libkate.so* bin/kate apps/Applications/tinykate.desktop pics/tinykate lib/libtinykate.so*
do_install() {
	install -d ${D}${palmtopdir}/lib/
	oe_soinstall libkate.so.1.0.0 ${D}${palmtopdir}/lib/
        install -d ${D}${palmtopdir}/pics/${APPNAME}/
        install -m 0644 ${WORKDIR}/pics/${APPNAME}/*.png ${D}${palmtopdir}/pics/${APPNAME}/
	install -d ${D}${palmtopdir}/share/${APPNAME}/syntax/
	install -m 0644 ${WORKDIR}/share/${APPNAME}/syntax/*.* ${D}${palmtopdir}/share/${APPNAME}/syntax/
}

PACKAGES = " \
	opie-tinykate-syntax-commondev \
	opie-tinykate-syntax-documentation \
	opie-tinykate-syntax-misc \
	opie-tinykate-syntax-miscdev \
	opie-tinykate-syntax-unix \
	opie-tinykate-syntax-web \
	opie-tinykate "


FILES_opie-tinykate-syntax-commondev = " ${palmtopdir}/share/tinykate/syntax/c.xml ${palmtopdir}/share/tinykate/syntax/cpp.xml ${palmtopdir}/share/tinykate/syntax/gnuassembler.xml ${palmtopdir}/share/tinykate/syntax/kbasic.xml ${palmtopdir}/share/tinykate/syntax/pascal.xml ${palmtopdir}/share/tinykate/syntax/perl.xml ${palmtopdir}/share/tinykate/syntax/php.xml ${palmtopdir}/share/tinykate/syntax/python.xml ${palmtopdir}/share/tinykate/syntax/ruby.xml ${palmtopdir}/share/tinykate/syntax/sql.xml ${palmtopdir}/share/tinykate/syntax/tcl.xml ${palmtopdir}/share/tinykate/syntax/xml.xml ${palmtopdir}/share/tinykate/syntax/xmldebug.xml ${palmtopdir}/share/tinykate/syntax/java.xml"
FILES_opie-tinykate-syntax-documentation = " ${palmtopdir}/share/tinykate/syntax/latex.xml ${palmtopdir}/share/tinykate/syntax/postscript.xml ${palmtopdir}/share/tinykate/syntax/sgml.xml"
FILES_opie-tinykate-syntax-misc = " ${palmtopdir}/share/tinykate/syntax/idconsole.xml ${palmtopdir}/share/tinykate/syntax/matlab.xml ${palmtopdir}/share/tinykate/syntax/verilog.xml ${palmtopdir}/share/tinykate/syntax/vhdl.xml"
FILES_opie-tinykate-syntax-miscdev = " ${palmtopdir}/share/tinykate/syntax/ada.xml ${palmtopdir}/share/tinykate/syntax/eiffel.xml ${palmtopdir}/share/tinykate/syntax/ferite.xml ${palmtopdir}/share/tinykate/syntax/fortran.xml ${palmtopdir}/share/tinykate/syntax/haskell.xml ${palmtopdir}/share/tinykate/syntax/literate-haskell.xml ${palmtopdir}/share/tinykate/syntax/objectivec.xml ${palmtopdir}/share/tinykate/syntax/sather.xml ${palmtopdir}/share/tinykate/syntax/scheme.xml"
FILES_opie-tinykate-syntax-unix = " ${palmtopdir}/share/tinykate/syntax/cs.xml ${palmtopdir}/share/tinykate/syntax/bash.xml ${palmtopdir}/share/tinykate/syntax/changelog.xml ${palmtopdir}/share/tinykate/syntax/desktop.xml ${palmtopdir}/share/tinykate/syntax/diff.xml ${palmtopdir}/share/tinykate/syntax/mab.xml ${palmtopdir}/share/tinykate/syntax/makefile.xml ${palmtopdir}/share/tinykate/syntax/rpmspec.xml ${palmtopdir}/share/tinykate/syntax/sml.xml ${palmtopdir}/share/tinykate/syntax/winehq.xml"
FILES_opie-tinykate-syntax-web = " ${palmtopdir}/share/tinykate/syntax/css.xml ${palmtopdir}/share/tinykate/syntax/html.xml ${palmtopdir}/share/tinykate/syntax/javascript.xml"
