SECTION = "base"
LICENSE = "GPL"
DESCRIPTION = "Allows you to set-up and manipulate the Linux console."

SRC_URI = "${SOURCEFORGE_MIRROR}/lct/console-tools-${PV}.tar.gz \
           file://codepage.patch;patch=1 \
           file://configure.patch;patch=1 \
           file://compile.patch;patch=1 \
           file://config/*.m4"

export SUBDIRS = "fontfiletools vttools kbdtools screenfonttools contrib \
		  examples po intl compat"

acpaths = "-I config"
do_configure_prepend () {
	mkdir -p config
	cp ${WORKDIR}/config/*.m4 config/
}

do_compile () {
	oe_runmake -C lib
	oe_runmake 'SUBDIRS=${SUBDIRS}'
}

inherit autotools 
